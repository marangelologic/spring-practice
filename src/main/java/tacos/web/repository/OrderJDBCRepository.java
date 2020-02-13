package tacos.web.repository;

import tacos.domain.Order;

public interface OrderJDBCRepository {
	Order save(Order order);

}
