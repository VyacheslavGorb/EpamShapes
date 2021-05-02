package edu.gorb.shape.repository.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.EllipseSpecification;

public class EllipseMaxWidthSpecification implements EllipseSpecification {
    private final double maxWidth;

    public EllipseMaxWidthSpecification(double maxWidth) {
        this.maxWidth = maxWidth;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double width = Math.abs(ellipse.getFirstPoint().getX() - ellipse.getSecondPoint().getX());
        return width < maxWidth;
    }
}
