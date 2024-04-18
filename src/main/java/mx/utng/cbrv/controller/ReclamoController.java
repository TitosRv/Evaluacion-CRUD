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
import mx.utng.cbrv.model.entity.Reclamo;
import mx.utng.cbrv.model.service.IReclamoService;

@Controller
@SessionAttributes("reclamo")
public class ReclamoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IReclamoService reclamoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/reclamo/list", "/reclamo", "/reclamo/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Reclamos");
    model.addAttribute("reclamos", reclamoService.list());
    return "rlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/reclamo/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Reclamos");
        model.addAttribute("reclamo", new Reclamo());
        return "rform";
    }

    @GetMapping("/reclamo/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Reclamo reclamo = null;
        if (id>0) {
            reclamo = reclamoService.getById(id);
        }else{
            return "redirect:rlist";
        }

        model.addAttribute("title", "Editar Reclamo");
        model.addAttribute("reclamo", reclamo);
        return "rform";
    }


    @PostMapping ("/reclamo/form")
    public String save(@Valid Reclamo reclamo, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de reclamo");
            return "rform";
        }

        reclamoService.save(reclamo);
        return "redirect:/reclamo/list";
    }

    @GetMapping("/reclamo/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            reclamoService.delete(id);
        }
        return "redirect:/reclamo/list";
    }

}

