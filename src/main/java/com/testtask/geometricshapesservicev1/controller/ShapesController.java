package com.testtask.geometricshapesservicev1.controller;

import com.testtask.geometricshapesservicev1.dto.request.ShapeCalculationRequest;
import com.testtask.geometricshapesservicev1.dto.response.ShapeCalculationResponse;
import com.testtask.geometricshapesservicev1.service.ShapesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shapes")
public class ShapesController {

    private final ShapesService shapesService;

    public ShapesController(ShapesService shapesService) {
        this.shapesService = shapesService;
    }

    @PostMapping
    public ShapeCalculationResponse calculate(@Valid @RequestBody ShapeCalculationRequest request) {
        return shapesService.calculate(request);
    }
}
