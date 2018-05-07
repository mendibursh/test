package geometries;

import primitives.Point3D;
import primitives.Vector;

abstract public class Geometry {

		public Geometry() {
			// TODO Auto-generated constructor stub
		}
		
		public Geometry(Geometry Other){
			
		}
		
		abstract public Vector GetNormal(Point3D _other);
		
		
}
