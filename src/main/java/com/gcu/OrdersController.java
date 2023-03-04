package com.gcu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	private List<OrderModel> orders = new ArrayList<OrderModel>();
	
	public OrdersController(){
		orders.clear();
		orders.add(new OrderModel(0, "001", "Babe Ruth Home Run Ball", 150000.00f,1));
		orders.add(new OrderModel(1, "002", "Kobe Bryant Jersey", 500.00f,1));
		orders.add(new OrderModel(2, "003", "Tom Brady Retirement Dirt", 220000.00f,10));
		orders.add(new OrderModel(3, "004", "Julio Rodriguez Signed Jersey", 200.00f,3));
		orders.add(new OrderModel(4, "005", "Derek Jeter Bat", 1090.00f,5));
		orders.add(new OrderModel(5, "006", "Michael Jordan Bulls Jersey", 50000.00f,4));
		orders.add(new OrderModel(6, "007", "Pat Mahomes Helmet", 560.00f,4));
		orders.add(new OrderModel(7, "008", "Mariano Rivera Signed Baseball", 700.00f,6));
		orders.add(new OrderModel(8, "009", "Tiger Woods Signed Golf Goove", 100.00f,10));
		orders.add(new OrderModel(9, "010", "Joey Chesnut Shoe", 50.00f,2));
		orders.add(new OrderModel(10, "011", "Signed Ichio Jersey", 7000.00f,1));
	
	}

	@Autowired
	private OrdersBusinessServiceInterface ordersService;
	
	// @GetMapping("/")
	// public List<OrderModel> showAllOrders(Model model) {
	// 	return ordersService.getOrders();
	// }
	
	// @GetMapping("/{id}")
	// public OrderModel getOne(@PathVariable(name="id") int id) {
	// 	return ordersService.getById(id);
	// }
	
	// @GetMapping("/search/{searchterm}")
	// public List<OrderModel> searchOrders(@PathVariable(name="searchterm") String searchterm){
	// 	return ordersService.searchOrders(searchterm);
	// }
	
	/// start of milestone 3

	@GetMapping("/")
	public String index(Model model){
		// List<OrderModel> orders = ordersService.getOrders();
		model.addAttribute("orders", orders);
		return "orders";
	}

	@GetMapping("/{search}")
	public String SearchForOrder(@RequestParam(name="search", required=false) String search, Model model){

		List<OrderModel> filteredList = new ArrayList<OrderModel>();
		
		for(OrderModel o: orders){
			if(o.getProductName().contains(search)){
				filteredList.add(o);
			}
		}
		
		model.addAttribute("orders",filteredList);
		return "orders";
	}

	/** 
	// Search for specific order
	@GetMapping("/filter")
	public String searchOrders(Model model){
		model.addAttribute("SearchTerm", new SearchModel());
		return "filter";
	}

	@PostMapping("/processFilter")
	public String processEdit(String s, Model model){
		List<OrderModel> filteredList = new ArrayList<OrderModel>();
		
		for(OrderModel o: orders){
			if(o.getProductName().contains(s)){
				filteredList.add(o);
			}
		}
		
		model.addAttribute("orders",filteredList);
		return "filteredOrders";
	}
	**/

	// new order 
	@GetMapping("/new")
	public String newOrder(Model model){
		model.addAttribute("order", new OrderModel());
		return "newOrder";
	}
	
	// process new order
	@PostMapping("/processNew")
	public String processNew(OrderModel order){
		orders.add(order);
		return "redirect:/orders";
	}

	// edit 
	@GetMapping("/edit/{id}")
	public String editOrder(@PathVariable(value="id") Integer id, Model model){
		OrderModel order = orders.stream().filter(p ->p.getId() == id).findFirst().get();
		model.addAttribute("order", order);
		return "editOrder";
	}

	// process edit 
	@PostMapping("/processEdit")
	public String processEdit(OrderModel order){
		OrderModel orderToEdit = orders.stream().filter(p -> p.getId() == order.getId()).findFirst().get();
		orderToEdit.setId(order.getId());
		orderToEdit.setOrderNo(order.getOrderNo());		
		orderToEdit.setProductName(order.getProductName());
		orderToEdit.setPrice(order.getPrice());
		orderToEdit.setQuantity(order.getQuantity());
		return "redirect:/orders";
	}

	
	// @GetMapping("/search/{searchterm}")
	// public List<OrderModel> searchOrders(@PathVariable(name="searchterm") String searchterm){
	// 	return ordersService.searchOrders(searchterm);
	// }
	

	// delete 
	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable(value = "id")Integer id, Model model){
		OrderModel order = orders.stream().filter(p -> p.getId() == id).findFirst().get();
		orders.remove(order);
		return "redirect:/orders";

	}


	// end of milestone 3

	// @PostMapping("/")
	// public OrderModel addOrder(@RequestBody OrderModel addOrder) {
	// 	ordersService.addOne(addOrder);
	// 	return addOrder;
	// }
	
	// @DeleteMapping("/{id}")
	// public boolean deleteOrder(@PathVariable(name="id") int id) {
	// 	return ordersService.deleteOne(id);
	// }
	
	// @PutMapping("/edit/{id}")
	// public OrderModel updateOrder(@RequestBody OrderModel updateOrder) {
	// 	return ordersService.updateOne(updateOrder.getId(), updateOrder);
	// }
}
