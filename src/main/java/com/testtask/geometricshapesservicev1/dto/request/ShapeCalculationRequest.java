package com.testtask.geometricshapesservicev1.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "shapeType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SquareCalculationRequest.class, name = "SQUARE"),
        @JsonSubTypes.Type(value = RectangleCalculationRequest.class, name = "RECTANGLE"),
        @JsonSubTypes.Type(value = TriangleCalculationRequest.class, name = "TRIANGLE"),
        @JsonSubTypes.Type(value = CircleCalculationRequest.class, name = "CIRCLE")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShapeCalculationRequest {

    @NotNull
    private ShapeType shapeType;

}
