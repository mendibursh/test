package primitives;

public class Ray {
	private Point3D _point;
	private Vector _direction;

	// ****** Constructors ********* //

	public Ray(Vector _direction, Point3D _point) {
		this._direction = new Vector(_direction);
		this._point = new Vector(_point).normalize();
	}

	/**
	 * 
	 * @param ray
	 */
	public Ray(Ray ray) {
		super(ray._direction);
		this._point = new Point3D(ray.getPoint());
	}

	// ****** Getters/Setters ********* //

	public Point3D getPoint() {
		return new Point3D(_point);
	}

	public Vector getDirection() {
		return new Vector(_direction);
	}

	@Override
	public String toString() {
		return "(" + _point + "," + _direction + ")";
	}

}
