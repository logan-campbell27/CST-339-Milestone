package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.gcu.model.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface {

	private List<OrderModel> orders = new ArrayList<OrderModel>();

	public OrdersFakeDAO() {
		orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "001", "Sky diving", 1500.00f,1));
		orders.add(new OrderModel(1L, "002", "Run with the bulls", 120.00f,5));
		orders.add(new OrderModel(2L, "003", "Orbit the moon", 220000.00f,3));
		orders.add(new OrderModel(3L, "004", "Get dinner out", 15.00f,1));
		orders.add(new OrderModel(4L, "005", "Go to the pool", 10.00f,1));
		orders.add(new OrderModel(5L, "006", "Zip line", 130.00f,3));
		orders.add(new OrderModel(6L, "007", "Go backpacking", 560.00f,4));
		orders.add(new OrderModel(7L, "008", "Go on vacation", 700.00f,6));
		orders.add(new OrderModel(8L, "009", "Visit New York", 100.00f,10));
		orders.add(new OrderModel(9L, "010", "Go camping", 50.00f,2));
		orders.add(new OrderModel(10L, "011", "Travel the world", 7000.00f,1));
	}
	
	
	@Override
	public OrderModel getById(int id) {
		// TODO Auto-generated method stub
		return orders.stream()
				.filter(order->order.getId() == id)
				.findFirst()
				.get();
	}

	@Override
	public List<OrderModel> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		// TODO Auto-generated method stub
		List<OrderModel> foundItems = orders
				.stream()
				.filter(order -> order.getProductName().toLowerCase()
						.contains(searchTerm.toString().toLowerCase()))
				.collect(Collectors.toList());
		System.out.println("Searched for products containing "+searchTerm+" and found "+foundItems.size()+" items");
		return foundItems;
	}

	@Override
	public int addOne(OrderModel newOrder) {
		// TODO Auto-generated method stub
		boolean success = orders.add(newOrder);
		
		System.out.println("I added one item. Now there are "+orders.size()+" items in the list");
		if(success) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteOne(long id) {
		// TODO Auto-generated method stub
		orders.removeIf(order -> order.getId() == id);
		
		System.out.println("I removed one item, now there is "+orders.size()+" items");
		return true;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		// TODO Auto-generated method stub
		
		orders.stream().forEach(order->{
			if(order.getId() == idToUpdate) {
				order.setOrderNo(updateOrder.getOrderNo());
				order.setPrice(updateOrder.getPrice());
				order.setProductName(updateOrder.getProductName());
				order.setQuantity(updateOrder.getQuantity());
				System.out.println("Updated order "+updateOrder);
			}
		});
		
		
		if(idToUpdate>orders.size() || idToUpdate < 0) {
			System.out.println("Invalid id");
			return null;
		}
		System.out.println("You asked me to update order "+idToUpdate+" the updated order is "+updateOrder.toString());
		return updateOrder;
	}

}
