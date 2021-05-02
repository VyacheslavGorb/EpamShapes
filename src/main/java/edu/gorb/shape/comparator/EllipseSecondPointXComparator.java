package edu.gorb.shape.comparator;

import edu.gorb.shape.entity.Ellipse;

import java.util.Comparator;

public class EllipseSecondPointXComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        int result = 0;
        double firstPointX1 = o1.getFirstPoint().getX();
        double firstPointX2 = o2.getFirstPoint().getX();
        if (firstPointX1 - firstPointX2 < 0) {
            result = -1;
        } else if (firstPointX1 - firstPointX2 > 0) {
            result = 1;
        }
        return result;
    }
}
