package edu.gorb.shape.validator;

import edu.gorb.shape.entity.Point;

public class EllipseParameterValidator {
    public boolean areValidParameters(Point firstPoint, Point secondPoint){
        if (firstPoint == null || secondPoint == null){
            return false;
        }
        return firstPoint.getX() != secondPoint.getX()
                && firstPoint.getY() != secondPoint.getY();
    }
}
