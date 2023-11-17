package com.store.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.demo.entity.Account;
import com.store.demo.entity.Product;
import com.store.demo.service.AccountService;
import com.store.demo.service.ProductService;
import com.store.demo.DAO.AccountDAO;
import com.store.demo.DAO.ProductDAO;


@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	AccountService accountService;
	@Autowired
	ProductDAO pdao;
	@Autowired
	AccountDAO adao;
	@RequestMapping("/Gear/index")
	public String list(Model model, @RequestParam("cid")Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items",list);	
		}
		else{
			List<Product> list = productService.findAll();
			model.addAttribute("items",list);
		}
		return "Gear/index";
	}
	@RequestMapping("/Gear/ctsp/{id}")
	public String ctsp(Model model,@PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		System.out.println("tới đây vẫn chạy");
		model.addAttribute("item",item);
		return "Gear/ctsp";
	}
	@RequestMapping("/Gear/adminproduct")
	public String admin(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("items",list);
		return "Gear/adminproduct";
	}
	@GetMapping("/Gear/product-create")
	public String showCreateForm(Model model) {
	    // Create an empty Product object to bind with the form
	    Product product = new Product();
	    model.addAttribute("product", product);
	    return "Gear/product-create";
	}

    @PostMapping("/Gear/create")
    public String createProduct(@ModelAttribute("product") Product product) {
        // Add validation logic if needed
    	System.out.print(product.getName());
        productService.create(product); // Assuming you have a save method in the productService
        return "redirect:/Gear/product-create";
    }
    @RequestMapping("/Gear/product-edit/{id}")
	public String productedit(Model model,@PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		model.addAttribute("product",product);
		return "Gear/product-edit";
	}
    @PostMapping("/Gear/update/{id}")
    public String updateProduct(@ModelAttribute("product") Product  updateProduct,@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        Product productUpdate = product;
        productUpdate.setName((updateProduct).getName());
        productUpdate.setPrice((updateProduct).getPrice());
//        productUpdate.setCategory.((updateProduct).getCategory().getId());
        productUpdate.setBrand((updateProduct).getBrand());
        productService.update(productUpdate); // Assuming you have an update method in the productService
		System.out.println("tới đây vẫn chạy");
        return "redirect:/Gear/adminproduct"; // Redirect to the product list page
    }
    @GetMapping("/Gear/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
    	pdao.deleteById(id);
    	return  "redirect:/Gear/adminproduct";
    }
    @RequestMapping("/Gear/adminaccount")
    	public String adminaccount(Model model) {
    	List<Account> list = accountService.findAll();
		model.addAttribute("accounts",list);
    	return "Gear/adminaccount";
    }
    @GetMapping("/Gear/deleteaccount/{id}")
    public String deleteAcount(@PathVariable("id") String id) {
    	adao.deleteById(id);
    	return  "redirect:/Gear/adminaccount";
    }
//	@RequestMapping("/admin/home/index")
//	public String adminlist() {
//		return "redirect:/assets/product/index.html";
//	}
}
