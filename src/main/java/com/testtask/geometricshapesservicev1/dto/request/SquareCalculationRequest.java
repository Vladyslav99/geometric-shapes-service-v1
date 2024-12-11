package com.testtask.geometricshapesservicev1.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class SquareCalculationRequest extends ShapeCalculationRequest {

    @Positive(message = "must be not empty and greater than 0")
    private double side;

    public SquareCalculationRequest(ShapeType shapeType, double side) {
        super(shapeType);
        this.side = side;
    }
}
