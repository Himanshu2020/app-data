package musipo.serviceblock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musipo.daoblock.OrderDao;
import musipo.modelobj.orders;

@Service
public class OrderService {
	@Autowired
	OrderDao odr;

	public List<orders> getorder() {
		return odr.getAll();

	}

	public orders creteorder(orders order) {
		return odr.createorder(order);

	}

}
