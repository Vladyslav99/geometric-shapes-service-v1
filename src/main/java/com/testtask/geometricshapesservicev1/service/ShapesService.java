package com.testtask.geometricshapesservicev1.service;

import com.testtask.geometricshapesservicev1.dto.request.ShapeCalculationRequest;
import com.testtask.geometricshapesservicev1.dto.response.ShapeCalculationResponse;

public interface ShapesService {

    ShapeCalculationResponse calculate(ShapeCalculationRequest request);

}
