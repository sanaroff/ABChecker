package my.local.project.controller;

import my.local.project.model.Event;
import my.local.project.model.Status;
import my.local.project.service.ClientService;
import my.local.project.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serial;
import java.util.List;

@Controller
class EventController implements IController<Event> {

	@Autowired
	private EventService eventService;
	@Autowired
	private ClientService clientService;

	@Override
	@GetMapping(value="/allevents")
	public String findAll(Model model) {
		List<Event> events = eventService.findAll();
		model.addAttribute(events);
		return "event-list";
	}

	@Override
	public String findById(Long ID, Model model) {
		return null;
	}

	@Override
	public String createForm(Event event, Model model) {
		return null;
	}

	@GetMapping("/client/{id}/event-create")
	public String createForm(@PathVariable Long id, Event event, Model model) {
		model.addAttribute("clientId", id);
		System.out.println("model attribute: " + model.getAttribute("clientId"));
		model.addAttribute("Status", Status.values());
		return "event-create";
	}

	@PostMapping("/client/{id}/event-create")
	public String create(@PathVariable ("id") Long id, Event event) {
		eventService.save(event);
		return "redirect:/client/{id}";
	}

	@Override
	public String create(Event event) {
		return null;
	}

	@Override
	public String delete(Long ID) {
		return null;
	}

	@Override
	public String updateForm(Long ID, Model model) {
		return null;
	}

	@Override
	public String update(Event event) {
		return null;
	}

	@GetMapping(value="/client/{id}/events")
	public String findByClient(@PathVariable ("id") Long id, Model model){
		List<Event> eventsByClient = eventService.findByClient(id);
		model.addAttribute(eventsByClient);
		return "event-list";
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	static class BadDateFormatException extends RuntimeException {
		@Serial
		private static final long serialVersionUID = 1L;

		public BadDateFormatException(String dateString) {
			super(dateString);
		}
	}
}