package com.projectFridge.projectFridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectFridge.projectFridge.entity.Food;
import com.projectFridge.projectFridge.repository.IFoodRepository;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
	@Autowired
	private IFoodRepository repository;
	
	@PostMapping
    public Food createFood(@RequestBody Food food) {
        return repository.save(food);
    }
	
	@GetMapping
    public List<Food> getFood() {
        return repository.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Food> buscarAlimento(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food updatedFood) {
        return repository.findById(id)
                .map(food -> {
                    food.setName(updatedFood.getName());
                    food.setQuantity(updatedFood.getQuantity());
                    food.setExpirationDate(updatedFood.getExpirationDate());
                    return ResponseEntity.ok(repository.save(food));
                })
                .orElse(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }	
}
