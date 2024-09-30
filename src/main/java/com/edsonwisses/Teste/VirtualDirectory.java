package com.edsonwisses.Teste;

import java.util.ArrayList;
import java.util.List;

public class VirtualDirectory {
    private String name;
    private List<VirtualFile> files;
    private List<VirtualDirectory> subDirectories;

    public VirtualDirectory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subDirectories = new ArrayList<>();
    }

    // Getters e Setters
    public String getName() { return name; }
    public List<VirtualFile> getFiles() { return files; }
    public List<VirtualDirectory> getSubDirectories() { return subDirectories; }

    // Métodos para adicionar arquivos e diretórios
    public void addFile(VirtualFile file) {
        files.add(file);
    }

    public void addSubDirectory(VirtualDirectory directory) {
        subDirectories.add(directory);
    }

    // Método para buscar subdiretório
    public VirtualDirectory getSubDirectory(String name) {
        for (VirtualDirectory dir : subDirectories) {
            if (dir.getName().equals(name)) {
                return dir;
            }
        }
        return null;
    }
}