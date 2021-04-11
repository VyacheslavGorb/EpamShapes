package edu.gorb.shape.comparator;

import edu.gorb.shape.entity.Ellipse;

import java.util.Comparator;

public class IdComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        int result = 0;
        if (o1.getEllipseId() - o2.getEllipseId() < 0) {
            result = -1;
        } else if (o1.getEllipseId() - o2.getEllipseId() > 0) {
            result = 1;
        }
        return result;
    }
}
