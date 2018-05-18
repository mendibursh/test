package primitives;

public class Ray extends Vector {
	
	//fields
	private Point_3D _p0;

	public Ray(Vector vector, Point_3D point) {
		super(vector.head());
		if(point == null) throw new IllegalArgumentException("point cannot be null");
		_p0 = point;
	}

	public Point_3D p0() {
		return _p0;
	}
	
	public Vector direction() {
		return new Vector(super.head());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof Ray)) return false;
		Ray other = (Ray) obj;
		return _p0.equals(other._p0);
	}

	@Override
	public String toString() {
		return super.toString().replaceFirst("]", "] point=" + _p0);
	}

	
	
	
}
