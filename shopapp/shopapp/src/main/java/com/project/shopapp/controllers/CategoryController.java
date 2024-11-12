package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
//@Validated
public class CategoryController {
    // Hiện tất cả các categories
    @GetMapping("") // http://localhost:8088/api/v1/categories?page=1&limit=10
    public ResponseEntity<String> getAllCategories(
        @RequestParam("page")   int page,
        @RequestParam("limit")  int limit
    ){
        return ResponseEntity.ok(String.format("Đây là getAllCategories, page = %d, limit = %d  ", page, limit));
    }
    @PostMapping("")
    // Nếu tham số truyền vào là 1 object thì sao ? => data transfer object = request object
    public ResponseEntity<?> insertCategory(
            @Valid @RequestBody  CategoryDTO categoryDTO,
            BindingResult result
    ){
        // check null không có dữ liệu
        if(result.hasErrors()){
            List<String> errMessages =  result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessages);
        }
        return ResponseEntity.ok("Thêm mới Category" + categoryDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable long id){
        return ResponseEntity.ok("Cập nhật Category with id = " + id );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id){
        return ResponseEntity.ok("Xóa Category with id = " + id );
    }
}
