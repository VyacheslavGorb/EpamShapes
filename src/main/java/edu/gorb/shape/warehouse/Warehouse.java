package edu.gorb.shape.warehouse;

import edu.gorb.shape.exception.EllipseException;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse INSTANCE = new Warehouse();
    private final Map<Long, EllipseParameter> ellipseMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance(){
        return INSTANCE;
    }

    public void putParameters(long id, double area, double perimeter) {
        var data = new EllipseParameter();
        data.setArea(area);
        data.setPerimeter(perimeter);
        INSTANCE.ellipseMap.put(id, data);
    }

    public EllipseParameter getParameters(long id) throws EllipseException {
        EllipseParameter data = INSTANCE.ellipseMap.get(id);
        if(data == null){
            throw new EllipseException("No such element in warehouse");
        }
        return new EllipseParameter(data);
    }

    public void updateParameters(long id, double area, double perimeter) throws EllipseException {
        var data = ellipseMap.get(id);
        if(data == null){
            throw new EllipseException("No such element in warehouse");
        }
        data.setArea(area);
        data.setPerimeter(perimeter);
    }

    public boolean containsKey(Long key) {
        return ellipseMap.containsKey(key);
    }
}
