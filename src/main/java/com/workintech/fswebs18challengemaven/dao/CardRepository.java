package com.workintech.fswebs18challengemaven.dao;

import com.workintech.fswebs18challengemaven.entity.Card;

import java.util.List;

public interface CardRepository {

    List<Card> findAll();

    List<Card> findByValue(Integer value);

    List<Card> findByColor(String color);

    List<Card> findByType(String type);

    Card save(Card card);

    Card update(Card card);

    Card remove(Long id);
}
