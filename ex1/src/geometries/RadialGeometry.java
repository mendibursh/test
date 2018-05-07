package geometries;

import primitives.Point3D;
import primitives.Vector;

public class RadialGeometry extends Geometry {

	private double _radius;
	
	public RadialGeometry(double _Num) {
		// TODO Auto-generated constructor stub
		this._radius = _Num;
	}
	public RadialGeometry(RadialGeometry Other) {
		this._radius = Other._radius;
	}
	
	public double getRadius() {
		return _radius;
	}
	
	@Override
	public Vector GetNormal(Point3D _other) {
		// TODO Auto-generated method stub
		return null;
	}
}
