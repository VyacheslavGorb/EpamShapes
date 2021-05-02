package edu.gorb.shape.repository.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.EllipseSpecification;

public class EllipseMinWidthSpecification implements EllipseSpecification {
    private final double minWidth;

    public EllipseMinWidthSpecification(double minWidth) {
        this.minWidth = minWidth;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double width = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());
        return width > minWidth;
    }
}
