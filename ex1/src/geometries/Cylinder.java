package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder extends RadialGeometry {
	
	private	Point3D _axisPoint;
	private	Vector _axisDirection;
	
	public Cylinder(Point3D axisPoint, Vector axisDirection, double _Radios) {
		super(_Radios);
		_axisPoint = new Point3D(axisPoint);
		_axisDirection = new Vector(axisDirection);
	}

	public Point3D get_axisPoint() {
		return _axisPoint;
	}

	public Vector get_axisDirection() {
		return _axisDirection;
	}
	
	
	@Override
	public Vector getNormal(Point3D other) {
		
		if(other == null) throw new IllegalArgumentException("point canno be null");
		Vector a = new Point3D(other).subtract(_axisPoint);
	    //	a.Scalar(a.dotProduct(get_axisDirection())/ get_axisDirection().length())
		Vector c = new Vector(a);
		
		return get_axisPoint().subtract(c.get_vec());
	}

}
