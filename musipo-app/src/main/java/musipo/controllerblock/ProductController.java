package musipo.controllerblock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import musipo.modelobj.Product;
import musipo.serviceblock.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService pds;

	@RequestMapping("/productblock")
	@ResponseBody
	public List<Product> getProduct() {
		return pds.getProduct();

	}
	@RequestMapping("/createproduct")
	@ResponseBody
    public Product createproduct(Product product) {
		return pds.createproduct(product);
		
		
	}
}
