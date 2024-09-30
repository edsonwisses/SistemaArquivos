package com.edsonwisses.Teste;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filesystem")
public class FileSystemController {

    private VirtualDirectory root;

    public FileSystemController() {
        this.root = new VirtualDirectory("root");
    }

    // Listar diretórios e arquivos no diretório atual
    @GetMapping("/list")
    public VirtualDirectory listFiles(@RequestParam(value = "path", defaultValue = "") String path) {
        VirtualDirectory currentDirectory = navigateToDirectory(path);
        return currentDirectory;
    }

    // Criar novo diretório
    @PostMapping("/directory")
    public String createDirectory(@RequestParam String path, @RequestParam String name) {
        VirtualDirectory currentDirectory = navigateToDirectory(path);
        currentDirectory.addSubDirectory(new VirtualDirectory(name));
        return "Diretório criado com sucesso!";
    }

    // Criar novo arquivo
    @PostMapping("/file")
    public String createFile(@RequestParam String path, @RequestParam String name, @RequestParam String content) {
        VirtualDirectory currentDirectory = navigateToDirectory(path);
        currentDirectory.addFile(new VirtualFile(name, content));
        return "Arquivo criado com sucesso!";
    }

    // Navegar até um diretório
    private VirtualDirectory navigateToDirectory(String path) {
        if (path.isEmpty() || path.equals("/")) {
            return root;
        }

        String[] directories = path.split("/");
        VirtualDirectory current = root;

        for (String dir : directories) {
            if (!dir.isEmpty()) {
                current = current.getSubDirectory(dir);
                if (current == null) {
                    throw new RuntimeException("Diretório não encontrado: " + dir);
                }
            }
        }

        return current;
    }
}
