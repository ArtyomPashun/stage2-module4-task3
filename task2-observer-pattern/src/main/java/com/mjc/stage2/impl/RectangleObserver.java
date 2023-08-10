package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {

    RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();

    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        rectangleWarehouse.put(rectangle.getId(), new RectangleValues(findRectanglePerimeter(rectangle), findRectangleSquare(rectangle)));

    }

    public double findRectanglePerimeter(Rectangle rectangle) {
        return (rectangle.getSideA() + rectangle.getSideB()) * 2;
    }

    public double findRectangleSquare(Rectangle rectangle) {
        return rectangle.getSideA() * rectangle.getSideB();
    }
}
