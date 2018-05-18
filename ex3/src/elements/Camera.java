package elements;

import primitives.*;

public class Camera {

		private Point_3D _p0;
		private Vector _vUp;
		private Vector _vTo;
		private Vector _vRight;
		
		public Camera(Point_3D p0, Vector vUp, Vector vTo) {
			if(p0 == null || vUp == null || vTo == null) throw new IllegalArgumentException("point & vector cannot be null");
			if(vUp.crossProduct(vTo).length() == Coordinate.ZERO) throw new IllegalArgumentException("vUp & vTo needs to be in different directions");
			_p0 = p0;
			_vUp = vUp.normalize();
			_vTo = vTo.normalize();
			_vRight = vTo.crossProduct(vUp).normalize();
		}
		
		public Ray constructorRay(int Nx, int Ny, int i, int j, double screenDstance, double screenWidth,
				double screenHight) {
			
			Point_3D pc = _p0.add(_vTo.scale(screenDstance));
			double Ry = screenHight / Ny;
			double Rx = screenWidth / Nx;
			double pcX = ((double) Nx +1)/2;
			double pcY = ((double) Ny +1)/2;

			Point_3D Pij = pc;;
			if(pcX != i)
				Pij = Pij.add(_vRight.scale((i - pcX)* Rx));
			if(pcY != j)
				Pij = Pij.add(_vUp.scale((pcY - j) * Ry));
			return new Ray(Pij.subtract(_p0).normalize(), _p0);
		}

		public Point_3D p0() {
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
