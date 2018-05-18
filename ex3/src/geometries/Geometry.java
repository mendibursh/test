package geometries;

import primitives.Vector;

import java.util.List;

import primitives.Point_3D;
import primitives.Ray;

public abstract class Geometry {
	
	public Geometry() {
	
	}

	public Geometry(Geometry other) {
		
	}
	
	abstract Vector getNormal(Point_3D other);
	
	abstract List<Point_3D> findIntersections(Ray ray);
}
