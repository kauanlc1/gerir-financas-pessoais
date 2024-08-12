package org.example.controller;

import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/rescue")
    public Optional<List<Category>> getAllCategoryes() {
        return Optional.ofNullable(categoryService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCategory(@RequestBody Category category) {
            categoryService.save(category);
            String descricaoCategoria = category.getName();
            return ResponseEntity.ok("Categoria '" + descricaoCategoria + "' registrada com sucesso.");
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeCategory(@PathVariable(value = "id") Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Categoria removida com sucesso.");
    }
}
