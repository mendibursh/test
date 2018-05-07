package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane extends Geometry {

	private Point3D _p;
	private Vector _normal;
	
	public Plane(Point3D one , Vector normal) {
		_p = new  Point3D(one);
		_normal = normal;
	}
	
	public Plane (Point3D p1, Point3D p2, Point3D p3) {
		Vector Vector1 = new Point3D(p1).subtractVec(p2);
		Vector Vector2 = new Point3D(p1).subtractVec(p3);
		this._p = new Point3D(p1);
		this._normal = new Vector(Vector1).CrossProduct(Vector1, Vector2);
	}
	
	public Point3D get_p() {
		return _p;
	}
	
	
	@Override
	public Vector GetNormal(Point3D _other) {	
		return _normal;
	}

	
}
