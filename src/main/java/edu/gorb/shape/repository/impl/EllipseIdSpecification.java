package edu.gorb.shape.repository.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.EllipseSpecification;

public class EllipseIdSpecification implements EllipseSpecification {
    private final long id;

    public EllipseIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ellipse.getEllipseId() == id;
    }
}
