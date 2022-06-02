package my.local.project.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


public interface IController <T> {

    String findAll(Model model);
    String findById(@PathVariable("ID") Long ID, Model model);
    String createForm(T t, Model model);
    String create(T t);
    String delete(@PathVariable("ID") Long ID);
    String updateForm(@PathVariable("ID") Long ID, Model model);
    String update(T t);
}
