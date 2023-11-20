package com.senacre.ecommerce.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.senacre.ecommerce.carrinhodecompra.CarrinhoCompra;

@Controller
public class HomeController {

    @GetMapping("/")
    public String principal(){
        return "index";
    }

    @GetMapping("/bem-vindo")
    public String index() {
        return "Login";
    }
    @GetMapping("/checkout")
    public String CheckoutPage(Model model) {
        List<CarrinhoCompra> carrinhotItems = cartService.getCartItems();
        double totalPrice = cartService.getTotalPrice();

        model.addAttribute("cartItems", carrinhotItems);
        model.addAttribute("totalPrice", totalPrice);
    }    
}
