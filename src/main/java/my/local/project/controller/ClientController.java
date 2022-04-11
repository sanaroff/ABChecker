package my.local.project.controller;

import my.local.project.model.Client;
import my.local.project.model.Roles;
import my.local.project.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String findAllClients(Model model){
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client, Model model) {
        //model.addAttribute("client", new Client());
        model.addAttribute("Role", Roles.values());
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";

    }

    @GetMapping("client-delete/{ID}")
    public String deleteClient(@PathVariable("ID") Long ID) {
        clientService.deleteClient(ID);
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{ID}")
    public String updateClientForm(@PathVariable("ID") Long ID, Model model) {
        Client client = clientService.findClientByID(ID);
        model.addAttribute("clients", client);
        return "client-update";
    }
    @PostMapping("/client-update")
    public String updateClient(Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }


}
