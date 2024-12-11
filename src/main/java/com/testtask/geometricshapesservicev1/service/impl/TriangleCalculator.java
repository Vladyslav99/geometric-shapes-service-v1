package com.testtask.geometricshapesservicev1.service.impl;

import com.testtask.geometricshapesservicev1.annotation.Shape;
import com.testtask.geometricshapesservicev1.dto.request.ShapeType;
import com.testtask.geometricshapesservicev1.dto.request.TriangleCalculationRequest;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import org.springframework.stereotype.Component;

@Component
@Shape(ShapeType.TRIANGLE)
public class TriangleCalculator implements ShapeCalculator<TriangleCalculationRequest> {

    @Override
    public double calculatePerimeter(TriangleCalculationRequest request) {
        return request.getSideA() + request.getSideB() + request.getSideC();
    }

    @Override
    public double calculateArea(TriangleCalculationRequest request) {
        double perimeter = calculatePerimeter(request) / 2;
        return Math.sqrt(perimeter * (perimeter - request.getSideA()) * (perimeter - request.getSideB()) * (perimeter - request.getSideC()));
    }
}
