package srikarao.mockito.tests.orderprocessing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import srikarao.mockito.tests.orderprocessing.bo.OrderBOImpl;
import srikarao.mockito.tests.orderprocessing.bo.exception.BOException;
import srikarao.mockito.tests.orderprocessing.dao.OrderDAO;
import srikarao.mockito.tests.orderprocessing.dto.Order;

class OrderBOImlpTest {
	
	@Mock
	OrderDAO orderDao;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() throws SQLException, BOException {
		OrderBOImpl orderBOImpl = new OrderBOImpl();
		Order order = new Order(1,"Created");
		orderBOImpl.setDao(orderDao);
		when(orderDao.create(order)).thenReturn(new Integer(1));
		
		boolean actual = orderBOImpl.placeOrder(order);
		assertEquals(true,actual);
		
		verify(orderDao).create(order);
	}

	@Test
	void test_read() throws SQLException, BOException {
		final OrderBOImpl orderBOImpl = new OrderBOImpl();
		
		orderBOImpl.setDao(orderDao);
		when(orderDao.read(1)).thenThrow(SQLException.class);
		
		assertThrows(BOException.class, () -> orderBOImpl.fetchOrder(1));
		
		verify(orderDao).read(0);
	}
}
 