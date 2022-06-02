package my.local.project.controller;

import my.local.project.model.Abonement;
import my.local.project.service.AbonementService;
import my.local.project.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AbonementController {

    private final ClientService clientService;
    private final AbonementService abonementService;

    public AbonementController(ClientService clientService, AbonementService abonementService) {
        this.clientService = clientService;
        this.abonementService = abonementService;
    }

    @GetMapping("/abonements")
    public String getAllAbonements(Model model){
        List<Abonement> abonements = abonementService.findAllAbonements();
        model.addAttribute("abonements", abonements);
        return "abonement-list";
    }

    @GetMapping("/abonement-create")
    public String createAbonementForm(Abonement abonement, Model model) {
        model.addAttribute("Client", clientService.findAllClients());
        return "abonement-create";
    }

    @PostMapping("/abonement-create")
    public String createAbonement(Abonement abonement) {
        abonementService.saveAbonement(abonement);
        return "redirect:/abonements";

    }

    @GetMapping("abonement-delete/{ID}")
    public String deleteAbonement(@PathVariable("ID") Long ID) {
        abonementService.deleteAbonement(ID);
        return "redirect:/abonements";
    }

    @GetMapping("/abonement-update/{ID}")
    public String updateAbonementForm(@PathVariable("ID") Long ID, Model model) {
        Abonement abonement = abonementService.findAbonementById(ID);
        model.addAttribute("abonement", abonement);
        return "abonement-update";
    }
    @PostMapping("/abonement-update")
    public String updateAbonement(Abonement abonement){
        abonementService.saveAbonement(abonement);
        return "redirect:/abonements";
    }



}
