package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Coordinate;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Triangle extends Plane {

	private Point_3D _p1;
	private Point_3D _p2;
	private Point_3D _p3;
	
	public Triangle(Point_3D p1,Point_3D p2,Point_3D p3) {
		super(p1, p2, p3);
		if(p1 == null || p2 == null || p3 == null)
			throw new IllegalArgumentException("points cannot be null");
		if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3))
			throw new IllegalArgumentException("points must be different");
		_p1 = p1;
		_p2 = p2;
		_p3 = p3;
	}
	
	public Point_3D p1() {
		return _p1;
	}

	public Point_3D p2() {
		return _p2;
	}

	public Point_3D p3() {
		return _p3;
	}
	
	@Override
	public Vector getNormal(Point_3D other) {
		return super.getNormal(other);
	}
	
	@Override
	public List<Point_3D> findIntersections(Ray ray){
		List<Point_3D> intersectionsListPlane = super.findIntersections(ray);
		if (intersectionsListPlane.isEmpty()) return intersectionsListPlane;
		Vector v = intersectionsListPlane.get(0).subtract(ray.p0());
		Vector v1 = p1().subtract(ray.p0());
		Vector v2 = p2().subtract(ray.p0());
		Vector v3 = p3().subtract(ray.p0());
		Vector n1 = v1.crossProduct(v2).normalize();
		Vector n2 = v2.crossProduct(v3).normalize();
		Vector n3 = v3.crossProduct(v1).normalize();
		Coordinate c1 = v.dotProduct(n1);
		Coordinate c2 = v.dotProduct(n2);
		Coordinate c3 = v.dotProduct(n3);
		if(c1 == Coordinate.ZERO || c2 == Coordinate.ZERO || c3 == Coordinate.ZERO) return new ArrayList<Point_3D>();
		if((c1.coordinate() > 0 && c2.coordinate() > 0 && c3.coordinate() > 0)||
				(c1.coordinate() < 0 && c2.coordinate() < 0 && c3.coordinate() < 0)) return intersectionsListPlane;
		return new ArrayList<Point_3D>();
	}
}
