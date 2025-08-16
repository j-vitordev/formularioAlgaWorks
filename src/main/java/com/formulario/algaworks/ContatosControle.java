package com.formulario.algaworks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ContatosControle {

    private static final ArrayList<Pessoa> LISTA_PESSOAS = new ArrayList<>();

    static {
        LISTA_PESSOAS.add(new Pessoa("Vitor", 29));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pessoas", LISTA_PESSOAS);
        model.addAttribute("pessoa", new Pessoa());
        return "index";
    }

    @PostMapping("/pessoas")
    public String salvar(Pessoa pessoa){
        LISTA_PESSOAS.add(pessoa);
        return "redirect:/";
    }
}
