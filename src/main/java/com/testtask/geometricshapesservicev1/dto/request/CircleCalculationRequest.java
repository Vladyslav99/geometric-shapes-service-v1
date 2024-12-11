package com.testtask.geometricshapesservicev1.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class CircleCalculationRequest extends ShapeCalculationRequest {

    @Positive(message = "must be not empty and greater than 0")
    private double radius;

    public CircleCalculationRequest(ShapeType shapeType, double radius) {
        super(shapeType);
        this.radius = radius;
    }
}
