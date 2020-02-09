package srikarao.mockito.tests.orderprocessing.bo;

import srikarao.mockito.tests.orderprocessing.bo.exception.BOException;
import srikarao.mockito.tests.orderprocessing.dto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id) throws BOException;
	boolean deleteOrder(int id) throws BOException;
}
