package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point_3D;
import primitives.Ray;
import primitives.Vector;

public class Geometries extends Geometry {

	List<Geometry> _geometries = new ArrayList<Geometry>();
	
	@Override
	Vector getNormal(Point_3D other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point_3D> findIntersections(Ray ray) {
		List<Point_3D> interList = new ArrayList<Point_3D>();
		for(Geometry shape: _geometries) {
			shape.findIntersections(ray).forEach((p)->interList.add(p));
		}
		return interList;
	}
}
