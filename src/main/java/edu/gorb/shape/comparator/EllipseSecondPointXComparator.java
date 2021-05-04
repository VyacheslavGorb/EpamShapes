package edu.gorb.shape.comparator;

import edu.gorb.shape.entity.Ellipse;

import java.util.Comparator;

public class EllipseSecondPointXComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        int result = 0;
        double secondPointX1 = o1.getSecondPoint().getX();
        double secondPointX2 = o2.getSecondPoint().getX();
        if (secondPointX1 - secondPointX2 < 0) {
            result = -1;
        } else if (secondPointX1 - secondPointX2 > 0) {
            result = 1;
        }
        return result;
    }
}
