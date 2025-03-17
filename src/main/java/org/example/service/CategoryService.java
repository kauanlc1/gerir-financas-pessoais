package org.example.service;

import org.example.exceptions.CategoryExistingException;
import org.example.exceptions.CategoryNotFoundException;
import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public void save(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryExistingException("Categoria com o nome '" + category.getName() + "' já se encontra no sistema.");
        }
        categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("Categoria com ID " + id + " não encontrada.");
        }
        categoryRepository.deleteById(id);
    }
}
