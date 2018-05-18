package primitives;

public class Point_2D {
	private Coordinate _x;
	private Coordinate _y;
	
	public Point_2D(Coordinate x, Coordinate y) {
		if (x == null || y == null) throw new IllegalArgumentException("coordinates cannot be null");
		_x = x;
		_y = y;
	}
	
	public Point_2D(double x, double y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	
	public Point_2D(Point_2D other) {
		if(other == null) throw new IllegalArgumentException("point cannot be null");
		_x = other._x;
		_y = other._y;
	}

	//getters
	public Coordinate x() {
		return _x;
	}

	public Coordinate y() {
		return _y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Point_2D)) return false;
		Point_2D other = (Point_2D)obj;
		return _x.equals(other._x) && _y.equals(other._y);
	}

	@Override
	public String toString() {
		return "[x=" + _x + ", y=" + _y + "]";
	}
	
}

	

