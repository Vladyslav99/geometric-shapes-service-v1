package com.testtask.geometricshapesservicev1.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class RectangleCalculationRequest extends ShapeCalculationRequest {

    @Positive(message = "must be not empty and greater than 0")
    private double sideA;

    @Positive(message = "must be not empty and greater than 0")
    private double sideB;

    public RectangleCalculationRequest(ShapeType shapeType, double sideA, double sideB) {
        super(shapeType);
        this.sideA = sideA;
        this.sideB = sideB;
    }
}
