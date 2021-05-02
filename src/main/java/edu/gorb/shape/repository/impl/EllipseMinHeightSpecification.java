package edu.gorb.shape.repository.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.EllipseSpecification;

public class EllipseMinHeightSpecification implements EllipseSpecification {
    private final double minHeight;

    public EllipseMinHeightSpecification(double minHeight) {
        this.minHeight = minHeight;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double height = Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());
        return height > minHeight;
    }
}
