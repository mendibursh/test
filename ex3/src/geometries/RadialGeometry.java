package geometries;

abstract public class RadialGeometry extends Geometry {
	private double _radius;

	public RadialGeometry(double radius) {
		super();
		if (radius == 0) throw new IllegalArgumentException("radius cannot be 0");
		_radius = radius;
	}
	
	public RadialGeometry(RadialGeometry other) {
		if (other == null) throw new IllegalArgumentException("radial geometry cannot be null");
		this._radius = other._radius;
	}

	public double radius() {
		return _radius;
	}
	
}
