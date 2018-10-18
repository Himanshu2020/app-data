package musipo.serviceblock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musipo.daoblock.ProductDAO;
import musipo.modelobj.Product;

@Service
public class ProductService {
	@Autowired
	ProductDAO pda;

	public List<Product> getProduct() {
		return pda.getAllProduct();

	}
	public Product createproduct(Product product) {
		return pda.createproduct(product);
	}

}
