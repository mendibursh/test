package elements;

import primitives.*;

public class Camera {

	private Point3D _p0;
	private Vector _vUp;
	private Vector _vTo;
	private Vector _vRight;

	public Camera(Point3D _p0, Vector _vUp, Vector _vTo) {

		if (_p0 == null || _vUp == null || _vTo == null)
			throw new IllegalArgumentException("point & vector cannot be null");
		if (!Coordinate.ZERO.equals(_vUp.dotProduct(_vTo)))
			throw new IllegalArgumentException("The vectors must be orthogonal");
		this._p0 = _p0;
		this._vUp = new Vector(_vUp).normalize();
		this._vTo = new Vector(_vTo).normalize();
		this._vRight = _vTo.crossProduct(_vUp).normalize();
	}

	public Ray constructorRay(int Nx, int Ny, int i, int j, double screenDstance, double screenWidth,
			double screenHight) {
		Point3D pc = _p0.add(_vTo.Scalar(screenDstance));
		double Ry = screenHight / Ny;
		double Rx = screenWidth / Nx;
		double pcX = ((double) Nx + 1) / 2;
		double pcY = ((double) Ny + 1) / 2;

		Point3D Pij = pc;
		if (pcX != i)
			Pij = Pij.add(_vRight.Scalar((i - pcX) * Rx));
		if (pcY != j)
			Pij = Pij.add(_vUp.Scalar((pcY - j) * Ry));
		return new Ray(Pij.subtract((_p0)), _p0);
	}

	public Point3D p0() {
		return _p0;
	}

	public Vector vUp() {
		return _vUp;
	}

	public Vector vTo() {
		return _vTo;
	}

	public Vector vRight() {
		return _vRight;
	}

	@Override
	public String toString() {
		return "Camera [_p0=" + _p0 + ", _vUp=" + _vUp + ", _vTo=" + _vTo + ", _vRight=" + _vRight + "]";
	}

}
