package com.testtask.geometricshapesservicev1.service.impl;

import com.testtask.geometricshapesservicev1.dto.request.ShapeCalculationRequest;
import com.testtask.geometricshapesservicev1.dto.request.ShapeType;
import com.testtask.geometricshapesservicev1.dto.response.ShapeCalculationResponse;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import com.testtask.geometricshapesservicev1.service.ShapesService;

import java.util.Map;

public class ShapesServiceImpl implements ShapesService {

    private final Map<ShapeType, ShapeCalculator<ShapeCalculationRequest>> shapeCalculators;

    public ShapesServiceImpl(Map<ShapeType, ShapeCalculator<ShapeCalculationRequest>> shapeCalculators) {
        this.shapeCalculators = shapeCalculators;
    }

    @Override
    public ShapeCalculationResponse calculate(ShapeCalculationRequest request) {
        ShapeCalculator<ShapeCalculationRequest> calculator = getShapeCalculator(request.getShapeType());
        return new ShapeCalculationResponse(calculator.calculatePerimeter(request), calculator.calculateArea(request));
    }

    private ShapeCalculator<ShapeCalculationRequest> getShapeCalculator(ShapeType shapeType) {
        if (shapeCalculators.containsKey(shapeType)) {
            return shapeCalculators.get(shapeType);
        }

        throw new IllegalArgumentException("No ShapeCalculator found for shapeType " + shapeType.name());
    }
}
