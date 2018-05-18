package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Coordinate;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {

	Point_3D _center;
	
	public Sphere(double radius, Point_3D center) {
		super(radius);
		if (center == null) throw new IllegalArgumentException("center cannot be null");
		_center = center;
	}
	
	public Point_3D center() {
		return _center;
	}

	@Override
	Vector getNormal(Point_3D other) {
		if(other == null) throw new IllegalArgumentException("point canno be null");
		if (other.equals(_center)) throw new IllegalArgumentException("point must be different then the center");

		return new Vector(_center.subtract(other)).normalize();
	}
	
	@Override
	public List<Point_3D> findIntersections(Ray ray){
		List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
		Vector u = center().subtract(ray.p0());
		double tm = ray.direction().dotProduct(u).coordinate();
		double d = Math.sqrt(Math.pow(u.length().coordinate(), 2) - Math.pow(tm, 2));
		if(d > super.radius()) return intersectionsList;
		double th = Math.sqrt(Math.pow(super.radius(), 2) - Math.pow(d, 2));
		if(new Coordinate(th) == Coordinate.ZERO) {
			intersectionsList.add(ray.p0().add(ray.direction().scale(tm)));
		}
		else {
			intersectionsList.add(ray.p0().add(ray.direction().scale(tm+th)));
			intersectionsList.add(ray.p0().add(ray.direction().scale(tm-th)));
		}
		return intersectionsList;
	}
}
