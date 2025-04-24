package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    //Thêm mới 1 order detail
    @PostMapping
    public ResponseEntity<?> createOrderDetail(
            @Valid
            @RequestBody
            OrderDetailDTO newOrderDetail
    ) {
        return ResponseEntity.ok("Create Order Detail here");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(
            @Valid
            @PathVariable("id")
            Long id
    ) {
        return ResponseEntity.ok("getOrderDetail with id:" + id);
    }

    // chi tiết đơn hàng (lấy ra danh sách order details của 1 order detail của 1 đơn hàng nào đó)
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetails(
            @Valid
            @PathVariable("orderId")
            Long orderId
    ) {
//        List<OrderDetail> orderDetails = orderDetailService.getOrderDetails(orderId);
        return ResponseEntity.ok("getOrderDetail with orderId: " + orderId);
    }

    // Sửa đơn hàng
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @Valid @PathVariable("id") Long id,
            @RequestBody OrderDetailDTO newOrderDetailData
    ) {
        return ResponseEntity.ok("updateOrderDetail with id: " + id + ",newOrderDetailData: " + newOrderDetailData);
    }

    // xóa đơn hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(
            @Valid @PathVariable("id") Long id
    ) {
        return ResponseEntity.noContent().build();
    }

}
