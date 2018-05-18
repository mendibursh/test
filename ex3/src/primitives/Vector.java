package primitives;

public class Vector {

	private Point_3D _head;

	public Vector(Point_3D point) {
		if (point == null) throw new IllegalArgumentException("point cannot be null");
		if(point.x().equals(Coordinate.ZERO) &&
				point.y().equals(Coordinate.ZERO) &&
				point.z().equals(Coordinate.ZERO))
			throw new IllegalArgumentException("zero vector is illegal");
		_head = point;
	}

	public Vector(double x, double y, double z) {
		Point_3D point = new Point_3D(new Coordinate(x), new Coordinate(y), new Coordinate(z));
		if(point.x().equals(Coordinate.ZERO) &&
				point.y().equals(Coordinate.ZERO) &&
				point.z().equals(Coordinate.ZERO))
			throw new IllegalArgumentException("zero vector is illegal");
		_head = point;
	}
	
	public Vector(Vector other) {
		if(other == null) throw new IllegalArgumentException("vector cannot be null");
		_head = other._head;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Vector)) return false;
		Vector other = (Vector) obj;
		return _head.equals(other._head);
	}

	public Point_3D head() {
		return _head;
	}
	
	public Vector add(Vector other) {
		return new Vector(new Point_3D(_head.x().add(other._head.x()),
				_head.y().add(other._head.y()),
				_head.z().add(other._head.z())));
	}
	
	public Vector subtract(Vector other) {
		return new Vector(new Point_3D(_head.x().subtract(other._head.x()),
				_head.y().subtract(other._head.y()),
				_head.z().subtract(other._head.z())));	
	}
	
	public Vector scale(double scalar) {
		return new Vector(new Point_3D(_head.x().scale(scalar),
				_head.y().scale(scalar),
				_head.z().scale(scalar)));
	}
	
	public Coordinate dotProduct(Vector other) {
		return _head.x().multi(other._head.x()).
				add(_head.y().multi(other._head.y())).
				add(_head.z().multi(other._head.z()));
	}
	
	public Vector crossProduct (Vector other) {
		return new Vector(new Point_3D(
				_head.y().multi(other._head.z()).subtract(_head.z().multi(other._head.y())),
				_head.z().multi(other._head.x()).subtract(_head.x().multi(other._head.z())),
				_head.x().multi(other._head.y()).subtract(_head.y().multi(other._head.x()))));
	}

	public Coordinate length() {
		return new Coordinate(Math.sqrt(Math.pow(_head.x().coordinate(), 2) +
				Math.pow(_head.y().coordinate(), 2) +
				Math.pow(_head.z().coordinate(), 2)));	
	}
	
	public Vector normalize() {
		return new Vector(this).scale(1/length().coordinate());
	}

	@Override
	public String toString() {
		return "vector= " + head().toString();
	}
	
	
}
