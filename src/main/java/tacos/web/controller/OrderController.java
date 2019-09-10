package tacos.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.domain.Order;
import tacos.web.repository.OrderRepository;

@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;

	@GetMapping("/current")
	public String OrderForm() {
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {

		if (errors.hasErrors()) {
			return "orderForm";
		}

		orderRepo.save(order);
		sessionStatus.setComplete();
		return "redirect:/design";
	}

}
