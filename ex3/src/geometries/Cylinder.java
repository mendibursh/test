package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends RadialGeometry {

	private Ray _axisRay;
//	private double _height;
	
	public Cylinder(double radius, Ray ray) {
		super(radius);
		if (ray == null) throw new IllegalArgumentException("ray cannot be null");
//		if (height <= 0) throw new IllegalArgumentException("height cannot be => 0");
		_axisRay = ray;
//		_height = height;
	}

	public Ray ray() {
		return _axisRay;
	}

//	public double height() {
//		return _height;
//	}

	@Override
	Vector getNormal(Point_3D other) {
		if(other == null) throw new IllegalArgumentException("point canno be null");
		Vector vecToPoint = other.subtract(_axisRay.p0()); // create vector to the point
		return new Vector(_axisRay.direction().scale( // find the projection of this vector on the ray-vector
				vecToPoint.dotProduct(_axisRay.direction())
				.coordinate()*(1/Math.pow(_axisRay.length().coordinate(), 2))))
				.subtract(vecToPoint). //subtract this vector from the projection vector
				normalize(); // normalize the result
	}

	@Override
	public List<Point_3D> findIntersections(Ray ray){
		return new ArrayList<Point_3D>();
	}
}
