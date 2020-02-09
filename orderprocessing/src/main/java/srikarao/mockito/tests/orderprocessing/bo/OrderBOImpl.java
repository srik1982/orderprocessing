package srikarao.mockito.tests.orderprocessing.bo;

import java.sql.SQLException;

import srikarao.mockito.tests.orderprocessing.bo.exception.BOException;
import srikarao.mockito.tests.orderprocessing.dao.OrderDAO;
import srikarao.mockito.tests.orderprocessing.dto.Order;

public class OrderBOImpl implements OrderBO {
	
	private OrderDAO dao;
	
	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
	
	public boolean placeOrder(Order order) throws BOException {
		int result = 0;
		try {
			result = dao.create(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result == 1;
	}

	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("cancelled");
			int result = dao.update(order);
			return result == 1;			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Order fetchOrder(int id) throws BOException {
		try {
			return dao.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BOException(e);
		}
	}

}
