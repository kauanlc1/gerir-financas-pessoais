package org.example.controller;

import org.example.exceptions.CategoryExistingException;
import org.example.exceptions.CategoryNotFoundException;
import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            categoryService.save(category);
            String descricaoCategoria = category.getName();
            return ResponseEntity.ok("Categoria '" + descricaoCategoria + "' registrada com sucesso.");
        } catch (CategoryExistingException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao registrar a categoria " + category.getName(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCategory(@PathVariable(value = "id") Long id) {
        try {
            categoryService.deleteById(id);
            return ResponseEntity.ok("Categoria removida com sucesso.");
        } catch (CategoryNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao remover a categoria.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
