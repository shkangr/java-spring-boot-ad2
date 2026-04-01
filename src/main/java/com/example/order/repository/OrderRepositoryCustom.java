package com.example.order.repository;

import com.example.order.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryCustom {

    Optional<Order> findWithMemberById(Long orderId);

    Optional<Order> findWithAllById(Long orderId);

    List<Order> findAllWithMemberAndOrderItems();

    List<Order> findAllByMemberIdWithMember(Long memberId);

    /**
     * Paginated order list
     * - fetch join Member (ToOne: safe with pagination)
     * - OrderItems + Product loaded via batch_fetch_size (ToMany: unsafe with pagination)
     */
    Page<Order> findAllWithMember(Pageable pageable);
}
