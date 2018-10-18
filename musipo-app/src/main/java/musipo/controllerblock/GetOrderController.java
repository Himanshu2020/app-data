package musipo.controllerblock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import musipo.modelobj.orders;
import musipo.serviceblock.OrderService;

@Controller
public class GetOrderController {
	@Autowired
	OrderService ods;

	@RequestMapping("/orderblock")
	@ResponseBody
	public List<orders> getOrder() {

		return ods.getorder();

	}

	@RequestMapping("/createorder")
	@ResponseBody
	public orders createorder(orders order) {
		return ods.creteorder(order);

	}
}
