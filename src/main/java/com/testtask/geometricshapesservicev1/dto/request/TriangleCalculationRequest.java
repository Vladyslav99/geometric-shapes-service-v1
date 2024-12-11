package com.testtask.geometricshapesservicev1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class TriangleCalculationRequest extends ShapeCalculationRequest {

    @Positive(message = "must be not empty and greater than 0")
    private double sideA;

    @Positive(message = "must be not empty and greater than 0")
    private double sideB;

    @Positive(message = "must be not empty and greater than 0")
    private double sideC;

    public TriangleCalculationRequest(ShapeType shapeType, double sideA, double sideB, double sideC) {
        super(shapeType);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
}
