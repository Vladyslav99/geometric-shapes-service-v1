package com.testtask.geometricshapesservicev1.config;

import com.testtask.geometricshapesservicev1.annotation.Shape;
import com.testtask.geometricshapesservicev1.dto.request.ShapeCalculationRequest;
import com.testtask.geometricshapesservicev1.dto.request.ShapeType;
import com.testtask.geometricshapesservicev1.service.ShapeCalculator;
import com.testtask.geometricshapesservicev1.service.ShapesService;
import com.testtask.geometricshapesservicev1.service.impl.ShapesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

@Configuration
public class ApplicationConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Map<ShapeType, ShapeCalculator<ShapeCalculationRequest>> shapeCalculators() {
        Map<ShapeType, ShapeCalculator<ShapeCalculationRequest>> shapeCalculators = new EnumMap<>(ShapeType.class);
        Collection<Object> beans = applicationContext.getBeansWithAnnotation(Shape.class).values();

        beans.forEach(bean -> {
            ShapeType type = bean.getClass().getAnnotation(Shape.class).value();

            if (shapeCalculators.containsKey(type)) {
                throw new IllegalArgumentException("Bean of type " + type.name() + " already exist");
            }

            if (bean instanceof ShapeCalculator) {
                shapeCalculators.put(type, (ShapeCalculator) bean);
            } else {
                throw new IllegalArgumentException("Wrong bean type " + bean.getClass() + " found. Expected ShapeCalculator");
            }
        });

        return shapeCalculators;
    }

    @Bean
    public ShapesService shapesService() {
        return new ShapesServiceImpl(shapeCalculators());
    }
}
