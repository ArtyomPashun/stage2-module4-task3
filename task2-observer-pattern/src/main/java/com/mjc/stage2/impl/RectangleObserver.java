package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

import java.util.function.Consumer;

public class RectangleObserver implements Observer {

    RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();

    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        Consumer <Rectangle> updateWarehouse = this::updateRectangleValues;
        updateWarehouse.accept(rectangle);

    }

    private void updateRectangleValues(Rectangle rectangle) {
        double square = rectangle.getSideA() * rectangle.getSideB();
        double perimeter = 2 * (rectangle.getSideA() + rectangle.getSideB());
        rectangleWarehouse.put(rectangle.getId(), new RectangleValues(square, perimeter));
    }
}
