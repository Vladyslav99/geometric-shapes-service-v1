package com.testtask.geometricshapesservicev1.service;

import com.testtask.geometricshapesservicev1.dto.request.ShapeCalculationRequest;

public interface ShapeCalculator<T extends ShapeCalculationRequest> {

    double calculatePerimeter(T request);

    double calculateArea(T request);
}
