package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.models.Category;
import com.project.shopapp.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
//@Validated
//Dependency Injection
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("")
    // Nếu tham số truyền vào là 1 object thì sao ? => data transfer object = request object
    public ResponseEntity<?> createCategory(
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result
    ) {
        // check null không có dữ liệu
        if (result.hasErrors()) {
            List<String> errMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessages);
        }
        categoryService.createCategory(categoryDTO); // đẩy vào DB
        return ResponseEntity.ok("Thêm mới Category successfully" + categoryDTO);
    }

    // Hiện tất cả các categories
    @GetMapping("") // http://localhost:8088/api/v1/categories?page=1&limit=10
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        List<Category> categories = categoryService.getAllCategories(); // đẩy vào DB
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(
            @PathVariable long id,
            @Valid @RequestBody CategoryDTO categoryDTO
    ) {
        categoryService.updateCategory(id, categoryDTO);  // đẩy vào DB
        return ResponseEntity.ok("Cập nhật Category successfully " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Xóa Category with id = " + id + "successfully");
    }
}
