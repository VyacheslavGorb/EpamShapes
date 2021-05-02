package edu.gorb.shape.repository.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.EllipseSpecification;

public class EllipseMaxHeightSpecification implements EllipseSpecification {
    private final double maxHeight;

    public EllipseMaxHeightSpecification(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        double height = Math.abs(ellipse.getFirstPoint().getY() - ellipse.getSecondPoint().getY());
        return height < maxHeight;
    }
}
