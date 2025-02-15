package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "casino", schema = "casino")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Integer value;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;


    //save lemeden önce ve update lemeden önce card gereksinimlerini kontrol ediyor
    @PrePersist
    @PreUpdate
    private void validateCard() {
        if (value != null && type != null) {
            throw new IllegalArgumentException("A card cannot have a value and a type at the same time!");
        }
        if (type == Type.JOKER) {
            if (value != null || color != null) {
                throw new IllegalArgumentException("Value and color of JOKER must be null!");
            }
        }
    }
}
