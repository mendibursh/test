package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane extends Geometry {

	private Point3D _p;
	private Vector _normal;
	
	public Plane(Point3D one , Vector normal) {
		_p = new  Point3D(one);
		_normal = new Vector(normal).normalize();
	}
	
	public Plane (Point3D p1, Point3D p2, Point3D p3) {
		// if p1 is the same as p2 there will be an exception
		Vector Vector1 = new Point3D(p1).subtract(p2);
		// if p1 is the same as p3 there will be an exception
		Vector Vector2 = new Point3D(p1).subtract(p3);
		this._p = new Point3D(p1);
		// if p2 and p3 are the same or even if three points are on the same line
		// it will produce exception bcos of zero vector result
		this._normal = Vector1.crossProduct(Vector2).normalize();
	}
	
	public Point3D get_p() {
		return _p;
	}	
	
	@Override
	public Vector getNormal(Point3D _other) {	
		return _normal;
	}

	
}
