package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.dao.CardRepository;
import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cards")
public class CardController {

    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> findByColor(@PathVariable("color") String color) {
        return cardRepository.findByColor(color);
    }

    @PostMapping
    public Card save(@RequestBody Card card) {
        CardValidation.checkId(card.getId());
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card) {
        CardValidation.checkId(card.getId());
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card remove(@PathVariable Long id) {
        return cardRepository.remove(id);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> findByValue(@PathVariable("value") Integer value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> findByType(@PathVariable("type") String type) {
        return cardRepository.findByType(type);
    }
}
