package com.jsp.shopaoquan.Controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.shopaoquan.Entity.MyFile;
import com.jsp.shopaoquan.Entity.customer;
import com.jsp.shopaoquan.Entity.orderr;
import com.jsp.shopaoquan.Entity.product;
import com.jsp.shopaoquan.Entity.type;
import com.jsp.shopaoquan.Service.TypeService;
import com.jsp.shopaoquan.Service.orderService;
import com.jsp.shopaoquan.Service.productService;

@Controller
public class adminController {
	@Autowired
	private productService productService;
	@Autowired
	private TypeService TypeService;
	@Autowired
	private orderService orderService;
	@RequestMapping("/admin")
	public String admin(HttpSession session, HttpServletRequest request) {
		customer cus = (customer)session.getAttribute("session");
		String file = request.getServletContext().getRealPath("/resources/img");
	
		if ( cus != null && cus.getName_customer().equals("admin")) {
			return "admin/admin";
		} else {
			return "redirect:/";
		}
	}
	@RequestMapping("/typeList")
	public String typeList(Model model) {
		List<type> type = TypeService.findAll();
		model.addAttribute("type", type);
		return "admin/typeList";
	}
	@RequestMapping("/productList")
	public String productList(Model model) {
		model.addAttribute("product", new product());
		List<product> list = productService.findAll();
		model.addAttribute("list", list);
		List<type> type = TypeService.findAll();
		model.addAttribute("type", type);
		return "admin/productList";
	}
	@RequestMapping("/productAdd")
	public String producAdd(Model model,HttpSession session ) {
		model.addAttribute("myFile", new MyFile());
		model.addAttribute("product", new product());
		List<type> type = TypeService.findAll();
		HashMap<Integer , String> listType = new HashMap<Integer , String>();
		for (type type2 : type) {
			listType.put(type2.getId_prd_type(), type2.getName_prd_type());
		}
		model.addAttribute("listType", listType);
		return "admin/productAdd";
	}
	@RequestMapping("/edit")
	public String editPrd(Model model, @RequestParam("id")String name) {
		
		product prd = productService.findByID(name);
		model.addAttribute("prd", prd);
		MyFile myFile = new MyFile();		
		model.addAttribute("myFile", myFile);
		return "admin/editPrd";
	}
	@RequestMapping("/add")
	public String add(@ModelAttribute("product")product prd, Model model, @RequestParam("descrip") String decrip,
			@RequestParam("name")String name, HttpServletRequest request,
						@RequestParam("price")float price,MyFile myFile) {
		String fileName ="";
		try {
			MultipartFile multipartFile = myFile.getMultipartFile();
			fileName = multipartFile.getOriginalFilename();
			String path = request.getServletContext().getRealPath("/resources/img/products");
			File file = new File(request.getServletContext().getRealPath("/resources/img/products"),fileName);
			System.out.println(path);
			multipartFile.transferTo(file);
			System.out.println(fileName);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(prd.getId_type());
		System.out.println(decrip);
		model.addAttribute("image",fileName);
		product newPrd = new product(name,price,fileName,prd.getId_type());
		productService.save(newPrd);
		return "redirect:/productList";
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute("prd")product prd, @ModelAttribute("myFile")MyFile myFile, HttpServletRequest request,
						@RequestParam("img")String img) {
		String fileName ="";
		System.out.println(prd.getName_Prd());
		System.out.println(img);
		System.out.println(prd.getPrice_Prd());
		
		try {
			MultipartFile multipartFile = myFile.getMultipartFile();
			fileName = multipartFile.getOriginalFilename();
			
			String path = request.getServletContext().getRealPath("/resources/img/products");
			File file = new File(request.getServletContext().getRealPath("/resources/img/products"),fileName);
			System.out.println(path);
			multipartFile.transferTo(file);
			prd.setImg_Prd(fileName);
			System.out.println(fileName);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (prd.getImg_Prd() == null)
		{
			prd.setImg_Prd(img);
		}

		productService.update(prd);
		return "redirect:/productList";
	}
	@RequestMapping(value="/productDelete" , method = RequestMethod.GET)
	public String deleteAdd(Model model , @RequestParam("id")String product) {
		product  prd = productService.findByID(product);
		productService.delete(prd); 
		System.out.println(product);
		return "redirect:/productList";
		
	}
	@RequestMapping("/sales")
	public String sales(Model model) {
		return "admin/sales";
	}
	@RequestMapping("/saleM")
	public String saleM(Model model,@RequestParam("month")int month) {
		List<orderr> list = orderService.findAll(month);
		model.addAttribute("list",list);
		return "admin/sales";
	}
	@RequestMapping("/saleQ")
	public String saleQ(Model model,@RequestParam("quarter")int quarter) {
		List<orderr> list = orderService.findQA(quarter);
		model.addAttribute("list",list);
		return "admin/sales";
	}
}
