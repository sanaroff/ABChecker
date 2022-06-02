package my.local.project;

import my.local.project.controller.ClientController;
import my.local.project.model.Client;
import my.local.project.model.Roles;
import my.local.project.repository.AbonementRepository;
import my.local.project.repository.ClientRepository;
import my.local.project.service.AbonementService;
import my.local.project.service.ClientService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ClientController.class)
@Import({AbonementService.class})
class AbcheckerApplicationTests {

	@Autowired
	private WebTestClient webClient;
	ApplicationContext context;


	@MockBean
	ClientService clientService;
	@MockBean
	ClientRepository clientRepository;
	@MockBean
	AbonementRepository abonementRepository;

	@Before
	public void setup() {
		this.webClient = WebTestClient
				.bindToApplicationContext(this.context)
				.configureClient()
				.build();
	}

	@Test
	public void clientGetTest() throws Exception {
		Client newClient = new Client();
		newClient.setEmail("test@test.te");
		newClient.setID(1010L);
		newClient.setPhone("555-777");
		newClient.setName("TestOV");
		newClient.setRole(Roles.CLIENT);
		Mockito.when(clientService.findClientByID(1010L)).thenReturn(newClient);
		webClient.post().uri("/clients")
				.exchange()
				.expectStatus().isOk();
	}
	@Test
	public void clientPostTest() throws Exception {
		Client newClient = new Client();
		newClient.setEmail("test@test.te");
		newClient.setID(1010L);
		newClient.setPhone("555-777");
		newClient.setName("TestOV");
		newClient.setRole(Roles.CLIENT);
		Mockito.when(clientService.saveClient(newClient)).thenReturn(newClient);
		webClient.post().uri("/client-create")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(newClient))
				.exchange()
				.expectStatus().isCreated();
		Mockito.verify(clientService, times(1)).saveClient(newClient);
	}
}
