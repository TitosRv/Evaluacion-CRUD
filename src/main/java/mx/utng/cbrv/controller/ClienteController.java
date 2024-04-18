package mx.utng.cbrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.cbrv.model.entity.Cliente;
import mx.utng.cbrv.model.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IClienteService clienteService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/cliente/list", "/cliente", "/cliente/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Cliente");
    model.addAttribute("clientes", clienteService.list());
    return "clist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/cliente/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Clientes");
        model.addAttribute("cliente", new Cliente());
        return "cform";
    }

    @GetMapping("/cliente/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Cliente cliente = null;
        if (id>0) {
            cliente = clienteService.getById(id);
        }else{
            return "redirect:clist";
        }

        model.addAttribute("title", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        return "cform";
    }


    @PostMapping ("/cliente/form")
    public String save(@Valid Cliente cliente, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de clientes");
            return "cform";
        }

        clienteService.save(cliente);
        return "redirect:/cliente/list";
    }

    @GetMapping("/cliente/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            clienteService.delete(id);
        }
        return "redirect:/cliente/list";
    }

}

