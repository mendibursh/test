package primitives;

public class Point_3D extends Point_2D {
	//fields
	private Coordinate _z;
	public static final Point_3D ZERO = new Point_3D(0,0,0);
	public Point_3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x,y);
		if (z == null) throw new IllegalArgumentException("coordinate cannot be null");
		_z = z;
	}
	
	public Point_3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}
	
	public Point_3D(Point_3D other) {
		super(other);
		if (other == null) throw new IllegalArgumentException("point cannot be null"); 
		_z = other._z;
	}
	
	public Coordinate z() {
		return _z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Point_3D)) return false;
		Point_3D other = (Point_3D)obj;
		return super.equals(other) && _z.equals(other._z);
	}
	@Override
	public String toString() {
		return super.toString().replaceFirst("]", ", z=" + _z + "]");
	}
	
	public Vector subtract(Point_3D other) {
		return new Vector(new Point_3D(
				x().subtract(other.x()),
				y().subtract(other.y()),
				z().subtract(other.z())));
	}

	public Point_3D add(Vector other) {
		return new Point_3D(x().add(other.head().x()),
				y().add(other.head().y()),
				z().add(other.head().z()));
	}
	
	public double distance(Point_3D other) {
		return Math.sqrt(Math.pow(x().subtract(other.x()).coordinate(), 2)
				+ Math.pow(y().subtract(other.y()).coordinate(), 2)
				+ Math.pow(z().subtract(other.z()).coordinate(), 2));
	}
}
