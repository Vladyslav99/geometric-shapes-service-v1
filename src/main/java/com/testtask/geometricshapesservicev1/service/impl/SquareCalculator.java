package com.testtask.geometricshapesservicev1.service.impl;

import com.testtask.geometricshapesservicev1.annotation.Shape;
import com.testtask.geometricshapesservicev1.dto.request.ShapeType;
import com.testtask.geometricshapesservicev1.dto.request.SquareCalculationRequest;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import org.springframework.stereotype.Component;

@Component
@Shape(ShapeType.SQUARE)
public class SquareCalculator implements ShapeCalculator<SquareCalculationRequest> {

    @Override
    public double calculatePerimeter(SquareCalculationRequest request) {
        return 4 * request.getSide();
    }

    @Override
    public double calculateArea(SquareCalculationRequest request) {
        return request.getSide() * request.getSide();
    }
}
