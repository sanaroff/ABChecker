package my.local.project.controller;

import lombok.extern.slf4j.Slf4j;
import my.local.project.model.Abonement;
import my.local.project.model.Client;
import my.local.project.model.Roles;
import my.local.project.service.AbonementService;
import my.local.project.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class ClientController {

    private final ClientService clientService;
    private final AbonementService abonementService;
    public ClientController(ClientService clientService, AbonementService abonementService) {
        this.clientService = clientService;
        this.abonementService = abonementService;
    }

    @GetMapping("/clients")
    public String findAllClients(Model model){
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client, Model model) {
        log.info("add client");
        model.addAttribute("Role", Roles.values());
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client) {
        log.info("client created");
        clientService.saveClient(client);
        return "redirect:/clients";

    }

    @GetMapping("client-delete/{ID}")
    public String deleteClient(@PathVariable("ID") Long ID) {
        log.info("client deleted");
        clientService.deleteClient(ID);
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{ID}")
    public String updateClientForm(@PathVariable("ID") Long ID, Model model) {
        log.info("client updated");
        Client client = clientService.findClientByID(ID);
        model.addAttribute("Role", Roles.values());
        model.addAttribute("clients", client);
        return "client-update";
    }

    @GetMapping("/client/{ID}")
    public String getClient(@PathVariable("ID") Long ID, Model model) {
        log.info("client");
        Client client = clientService.findClientByID(ID);
        model.addAttribute("Role", Roles.values());
        model.addAttribute("clients", client);
        return "client";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

//    @GetMapping("/abonements/{ID}")
    private String getAbonementsForClient(@PathVariable("ID") Long ID) {
         Client client =  clientService.findClientByID(ID);
         List<Abonement> abonements = abonementService.findAllAbonements()
                .stream()
                 .peek(abonement -> System.out.println(abonement.getClient()))
                 .peek(System.out::println)
                .filter(abonement -> abonement.getClient().equals(client.getName()))
                .toList();
         return "abonement-list";
    }
}
