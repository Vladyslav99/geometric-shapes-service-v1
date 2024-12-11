package com.testtask.geometricshapesservicev1.service.impl;

import com.testtask.geometricshapesservicev1.dto.request.*;
import com.testtask.geometricshapesservicev1.dto.response.ShapeCalculationResponse;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import com.testtask.geometricshapesservicev1.service.ShapesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ShapesServiceImplTest {

    static final double EPSILON = 0.000001;

    Map<ShapeType, ShapeCalculator<ShapeCalculationRequest>> shapeCalculators = new EnumMap<>(ShapeType.class);

    ShapesService testedInstance;

    @BeforeEach
    void setUp() {
        shapeCalculators.put(ShapeType.SQUARE, (ShapeCalculator) new SquareCalculator());
        shapeCalculators.put(ShapeType.RECTANGLE, (ShapeCalculator)  new RectangleCalculator());
        shapeCalculators.put(ShapeType.TRIANGLE, (ShapeCalculator)  new TriangleCalculator());
        shapeCalculators.put(ShapeType.CIRCLE, (ShapeCalculator)  new CircleCalculator());
        testedInstance = new ShapesServiceImpl(shapeCalculators);
    }

    @Test
    void shouldReturnValidCalculationResponseForSquare() {
        ShapeCalculationRequest request = new SquareCalculationRequest(ShapeType.SQUARE, 2.5);

        ShapeCalculationResponse actual = testedInstance.calculate(request);

        double expectedPerimeter = 10;
        double expectedArea = 6.25;
        assertThat(Math.abs(expectedPerimeter - actual.getPerimeter()) < EPSILON).isTrue();
        assertThat(Math.abs(expectedArea - actual.getArea()) < EPSILON).isTrue();
    }

    @Test
    void shouldReturnValidCalculationResponseForRectangle() {
        ShapeCalculationRequest request = new RectangleCalculationRequest(ShapeType.RECTANGLE, 2.5, 3.7);

        ShapeCalculationResponse actual = testedInstance.calculate(request);

        double expectedPerimeter = 12.4;
        double expectedArea = 9.25;
        assertThat(Math.abs(expectedPerimeter - actual.getPerimeter()) < EPSILON).isTrue();
        assertThat(Math.abs(expectedArea - actual.getArea()) < EPSILON).isTrue();
    }

    @Test
    void shouldReturnValidCalculationResponseForTriangle() {
        ShapeCalculationRequest request = new TriangleCalculationRequest(ShapeType.TRIANGLE, 3.5, 7.6, 4.5);

        ShapeCalculationResponse actual = testedInstance.calculate(request);

        double expectedPerimeter = 15.6;
        double expectedArea = 4.704933580827682;
        assertThat(Math.abs(expectedPerimeter - actual.getPerimeter()) < EPSILON).isTrue();
        assertThat(Math.abs(expectedArea - actual.getArea()) < EPSILON).isTrue();
    }

    @Test
    void shouldReturnValidCalculationResponseForCircle() {
        ShapeCalculationRequest request = new CircleCalculationRequest(ShapeType.CIRCLE, 2.3);

        ShapeCalculationResponse actual = testedInstance.calculate(request);

        double expectedPerimeter = 14.4513262065;
        double expectedArea = 52.2102072818;
        assertThat(Math.abs(expectedPerimeter - actual.getPerimeter()) < EPSILON).isTrue();
        assertThat(Math.abs(expectedArea - actual.getArea()) < EPSILON).isTrue();
    }

    @Test
    void shouldThrowExceptionWhenShapeCalculatorNotFound() {
        shapeCalculators.remove(ShapeType.CIRCLE);
        ShapeCalculationRequest request = new CircleCalculationRequest(ShapeType.CIRCLE, 2.3);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> testedInstance.calculate(request))
                .withMessage("No ShapeCalculator found for shapeType " + ShapeType.CIRCLE);
    }

}
