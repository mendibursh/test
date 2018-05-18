package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Coordinate;
import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry {
	
	private Point_3D _q0;
	private Vector _normal;
	
	public Plane(Point_3D point, Vector normalVector) {
		super();
		if (point == null || normalVector == null)
			throw new IllegalArgumentException("point & vector cannot be null");
		_q0 = point;
		_normal = normalVector;
	}
	
	public Plane(Point_3D p1, Point_3D p2, Point_3D p3) {
		super();
		if(p1 == null || p2 == null|| p3 == null) 
			throw new IllegalArgumentException("points cannot be null");
		if(new Vector(p2).crossProduct(new Vector(p3)).length() == Coordinate.ZERO)
			throw new IllegalArgumentException("p2 & p3 needs to be in different directions");
		_q0 = p1;
		_normal = new Vector(p2).crossProduct(new Vector(p3));
	}

	public Point_3D q0() {
		return _q0;
	}

	public Vector normal() {
		return _normal;
	}

	@Override
	public Vector getNormal(Point_3D other) {
		if(other == null) throw new IllegalArgumentException("point cannot be null");
		return new Vector(normal()).normalize();
	}
	
	@Override
	public List<Point_3D> findIntersections(Ray ray){
		List<Point_3D> intersectionsList = new ArrayList<Point_3D>();
		if (normal().dotProduct(ray.direction()) == Coordinate.ZERO) return intersectionsList ;
		double t = (normal().dotProduct(q0().subtract(ray.p0()))).coordinate()/(normal().dotProduct(ray.direction())).coordinate();
		if(t>0) {
			intersectionsList.add(ray.p0().add(ray.direction().scale(t)));
		}
		return intersectionsList ;
	}

}