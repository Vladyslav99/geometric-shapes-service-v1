package com.testtask.geometricshapesservicev1.service.impl;

import com.testtask.geometricshapesservicev1.annotation.Shape;
import com.testtask.geometricshapesservicev1.dto.request.CircleCalculationRequest;
import com.testtask.geometricshapesservicev1.dto.request.ShapeType;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import org.springframework.stereotype.Component;

@Component
@Shape(ShapeType.CIRCLE)
public class CircleCalculator implements ShapeCalculator<CircleCalculationRequest> {

    @Override
    public double calculatePerimeter(CircleCalculationRequest request) {
        return 2 * Math.PI * request.getRadius();
    }

    @Override
    public double calculateArea(CircleCalculationRequest request) {
        return Math.pow((Math.PI * request.getRadius()), 2);
    }
}
