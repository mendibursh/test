package geometries;


import primitives.Point3D;
import primitives.Vector;

public class Triangle extends Plane {
	 private Point3D _P1;
	 private Point3D _P2;
	 private Point3D _P3;
	 
	
	public Triangle(Point3D p1, Point3D p2 , Point3D p3) {
		super (p1 , p2, p3);
		this._P1 = new Point3D(p1);
		this._P2 = new Point3D(p2);
		this._P3 = new Point3D(p3);
	}
	
	public Point3D get_P1() {
		return _P1;
	}
	
	public Point3D get_P2() {
		return _P2;
	}
	
	public Point3D get_P3() {
		return _P3;
	}
	
}
