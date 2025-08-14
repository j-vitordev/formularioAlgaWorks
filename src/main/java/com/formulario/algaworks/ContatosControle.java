package com.formulario.algaworks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ContatosControle {

    private static final ArrayList<Pessoa> LISTA_PESSOAS = new ArrayList<>();

    static {
        LISTA_PESSOAS.add(new Pessoa("Vitor",29));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
