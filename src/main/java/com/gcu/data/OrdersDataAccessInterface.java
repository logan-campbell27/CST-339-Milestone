package com.gcu.data;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersDataAccessInterface {
	public OrderModel getById(int id);
	public List<OrderModel> getOrders();
	public List<OrderModel> searchOrders(String searchTerm);
	public int addOne(OrderModel newOrder);
	public boolean deleteOne(long id);
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);
}
