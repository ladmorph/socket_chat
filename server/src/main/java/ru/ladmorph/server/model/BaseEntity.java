package ru.ladmorph.server.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * The base entity
 */
@Getter
@Setter
public abstract class BaseEntity {

    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
}
