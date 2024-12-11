package com.testtask.geometricshapesservicev1.annotation;

import com.testtask.geometricshapesservicev1.dto.request.ShapeType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Shape {

    ShapeType value();
}
