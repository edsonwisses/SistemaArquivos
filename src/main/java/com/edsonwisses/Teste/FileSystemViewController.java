package com.edsonwisses.Teste;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileSystemViewController {

    private final FileSystemController fileSystemController;

    public FileSystemViewController(FileSystemController fileSystemController) {
        this.fileSystemController = fileSystemController;
    }

    @GetMapping("/")
    public String index(Model model) {
        VirtualDirectory root = fileSystemController.listFiles("");
        model.addAttribute("directory", root);
        return "index";
    }
}