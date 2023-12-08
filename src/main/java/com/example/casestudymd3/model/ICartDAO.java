package com.example.casestudymd3.model;

import java.util.List;

public interface ICartDAO {
    List<Cart> selectCart(String username);
    boolean deleteCart();
}
