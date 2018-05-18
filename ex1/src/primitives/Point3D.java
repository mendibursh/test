package primitives;

public class Point3D extends Point2D {
	private Coordinate _z;

	public static final Point3D ZERO = new Point3D(0, 0, 0);

	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x, y);
		if (z == null)
			throw new IllegalArgumentException("coordinate cannot be null");
		_z = new Coordinate(z);
	}

	public Point3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}

	public Point3D(Point3D other) {
		super(other);
		_z = new Coordinate(other._z);
	}

	public Point3D add(Vector other) {
		double newX = this.getX().add(other.get_vec().getX()).get();
		double newY = this.getY().add(other.get_vec().getY()).get();
		double newZ = this.getZ().add(other.get_vec().getZ()).get();
		return new Point3D(newX, newY, newZ);
	}

	public Vector subtract(Point3D other) {
		double newX = this.getX().subtract(other.getX()).get();
		double newY = this.getY().subtract(other.getY()).get();
		double newZ = this.getZ().subtract(other.getZ()).get();
		return new Vector(newX, newY, newZ);
	}

	// public Vector Subtract(Point3D other) {}

	public double distance(Point3D other) {
		double x = this.getX().get() - other.getX().get();
		double y = this.getY().get() - other.getY().get();
		double z = this.getZ().get() - other.getZ().get();
		return Math.sqrt(x * x + y * y + z * z);
	}

	public Coordinate getZ() {
		return _z;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof Point3D))
			return false;
		Point3D oth = (Point3D) obj;
		return super.equals(oth) && _z.equals(oth._z);
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + _z + ")";
	}
}
