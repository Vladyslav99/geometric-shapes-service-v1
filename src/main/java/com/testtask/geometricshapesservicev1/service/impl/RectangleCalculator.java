package com.testtask.geometricshapesservicev1.service.impl;

import com.testtask.geometricshapesservicev1.annotation.Shape;
import com.testtask.geometricshapesservicev1.dto.request.RectangleCalculationRequest;
import com.testtask.geometricshapesservicev1.dto.request.ShapeType;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import org.springframework.stereotype.Component;

@Component
@Shape(ShapeType.RECTANGLE)
public class RectangleCalculator implements ShapeCalculator<RectangleCalculationRequest> {

    @Override
    public double calculatePerimeter(RectangleCalculationRequest request) {
        return 2 * request.getSideA() + 2 * request.getSideB();
    }

    @Override
    public double calculateArea(RectangleCalculationRequest request) {
        return request.getSideA() * request.getSideB();
    }
}
