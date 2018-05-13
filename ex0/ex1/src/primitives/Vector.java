package primitives;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

public class Vector {

	private Point3D _head;
	
	public Vector(Point3D p) {
		if (Point3D.ZERO.equals(p))
			throw new IllegalArgumentException("Zero vector is invalid");
		_head = new Point3D(p);
	}
	
	public Vector(double x, double y,double z) {
		_head = new Point3D(x,y,z);
		if (Point3D.ZERO.equals(_head))
			throw new IllegalArgumentException("Zero vector is invalid");
	}
	
	public Vector(Vector other) {
		_head = new Point3D(other._head);
	}
	
	public Point3D get_vec() {
		return _head;
	}


	// Adding vector to other vector 
	public Vector add(Vector other){
		double newX = _head.getX().add(other._head.getX()).get();
		double newY = _head.getY().add(other._head.getY()).get();
		double newZ = _head.getZ().add(other._head.getZ()).get();
		return new Vector(newX,newY,newZ);
	}
	
	public Vector subtract(Vector other) {
		double newX = _head.getX().subtract(other._head.getX()).get();
		double newY = _head.getY().subtract(other._head.getY()).get();
		double newZ = _head.getZ().subtract(other._head.getZ()).get();
		return new Vector(newX,newY,newZ);
	}
	
	// multiple vector by scalar 
	public Vector Scalar (double num) {
		double newX = _head.getX().get() * num;
		double newY = _head.getY().get() * num;
		double newZ = _head.getZ().get() * num;
		return new Vector(newX, newY, newZ);
	}
	
	// 
	public double dotProduct (Vector two){
		double x = _head.getX().get() * two._head.getX().get();
		double y = _head.getY().get() * two._head.getY().get();
		double z = _head.getZ().get() * two._head.getZ().get();
		return x + y + z ;
	}
	
	public Vector crossProduct (Vector two){
		double x = _head.getY().get() * two._head.getZ().get() - _head.getZ().get() * two._head.getY().get() ;
		double y = _head.getZ().get() * two._head.getX().get() - _head.getX().get() * two._head.getZ().get();
		double z = _head.getX().get() * two._head.getY().get() - _head.getY().get() * two._head.getX().get();
		return new Vector(x, y, z);
	}

	
	public Vector normalize(){
		 //if (_vec.getX().get()  == 0.0||_vec.getY().get()  == 0.0 ||_vec.getZ().get() == 0.0) {
			//throw new Exception("divide by zero");
		
		try {
			double x = _head.getX().get() / this.length();
			double y = _head.getY().get() / this.length();
			double z = _head.getZ().get() / this.length();
			this._head = new Point3D(x, y, z);
			return this;		
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	
		
	public double length() 
    {
		double x = _head.getX().get();
		double y = _head.getY().get();
		double z = _head.getZ().get();
		return Math.sqrt((x*x) + (y*y) + (z*z));
    }
	/**
	 * @param obj
	 * @author mendi bursh
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!(obj instanceof Vector))
			return false;
		Vector oth = (Vector)obj;
		return this._head.equals(oth._head);
	}
	
	@Override
	public String toString() {
		return _head.toString();
	}
	
}
