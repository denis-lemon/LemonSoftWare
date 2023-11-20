package com.senacre.ecommerce.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.senacre.ecommerce.Model.Product;
import com.senacre.ecommerce.Model.Repositories.ProductRepository;
import com.senacre.ecommerce.Service.ProductService;

import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

   @Autowired
    private ProductService service;

     @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping("/lista")
    public ModelAndView listarProdutos() {
       List<Product> produtos = this.productRepository.findAll();
       ModelAndView mv = new ModelAndView("/product/lista-produtos");
       mv.addObject("produtos", produtos);

       return mv;
    }

    @GetMapping("/novo")
	public String criarProduto() {
		return "/product/novo-produto";
	}
    //Cria um novo produto
    @PostMapping("/salvar")
	public String salvarProduto(@Validated Product product, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/product/novo-produto";
		}	
		productRepository.save(product);
		attributes.addFlashAttribute("mensagem", "Produto Cadastrado com sucesso!");
		return "redirect:/products/lista";
	}

    //Edita produtos existentes
    @GetMapping("/editar/{id}")
	public String editarProduct(@PathVariable("id") long id, Model model) {
		Optional<Product> productVelho = productRepository.findById(id);
		if (!productVelho.isPresent()) {
            throw new IllegalArgumentException("Produto inválido:" + id);
        } 
		Product product = productVelho.get();
	    model.addAttribute("product", product);
	    return "/user/alterar-produto";
	}
	
	@PostMapping("/editar/{id}")
	public String editarProduct(@PathVariable("id") long id, 
			@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
	    	product.setId(id);
	        return "/";
	    }
	    productRepository.save(product);
	    return "redirect:/";
	}
    
}
