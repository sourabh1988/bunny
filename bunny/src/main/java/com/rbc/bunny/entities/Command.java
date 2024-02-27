package com.rbc.bunny.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Command {
    @Id
    private String cmd;
    private String baseUrl;
    private String formatHelp;
    private String description;

    public String build(String param) {
        return baseUrl + param;
    }
}
