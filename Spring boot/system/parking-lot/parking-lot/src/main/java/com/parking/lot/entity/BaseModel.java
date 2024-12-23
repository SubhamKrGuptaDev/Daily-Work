package com.parking.lot.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class BaseModel {
    private UUID id;
}
