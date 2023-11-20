package com.senacre.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.senacre.ecommerce.Model.Order;
import com.senacre.ecommerce.Model.Repositories.OrderRepository;
import com.senacre.ecommerce.Service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderRepository oderRepository;

    @Autowired
    private OrderService service;

     @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    //Listar os pedidos
    @GetMapping("/lista")
    public ModelAndView listarPedidos() {
       List<Order> order = this.oderRepository.findAll();
       ModelAndView mv = new ModelAndView("/product/lista-pedidos");
       mv.addObject("orders", order);
       return mv;
    }
    
    //Método para criar um novo pedido
    @PostMapping("/novo-pedido")
	public String novoPedido(@Validated Order order, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/";
		}	
		oderRepository.save(order);
		attributes.addFlashAttribute("mensagem", "Pedido realizado com sucesso!");
		return "redirect:/";
	}
    
}
