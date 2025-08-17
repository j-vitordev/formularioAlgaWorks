package com.formulario.algaworks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("pessoas/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Pessoa pessoa = LISTA_PESSOAS.get(id);
        model.addAttribute("pessoa", pessoa);
        model.addAttribute("id", id); // importante: mandar também o índice
        return "editar";
    }

    @PostMapping("/pessoas/atualizar/{id}")
    public String atualizar(@PathVariable int id, Pessoa pessoa){
        LISTA_PESSOAS.set(id, pessoa); // substitui a pessoa antiga pela editada
        return "redirect:/";
    }

    @GetMapping("/pessoas/excluir/{id}")
    public String excluir(@PathVariable int id) {
        LISTA_PESSOAS.remove(id);
        return "redirect:/";
    }


}
