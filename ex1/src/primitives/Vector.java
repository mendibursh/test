package primitives;

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
		double newX = _head.getX().add(other.getX()).get();
		double newY = this.getY().add(other.getY()).get();
		double newZ = this.getZ().add(other.getZ()).get();
		return new Vector(newX,newY,newZ);
	}
	
	public Vector subtract(Vector other) {
		double newX = this.getX().subtract(other.getX()).get();
		double newY = this.getY().subtract(other.getY()).get();
		double newZ = this.getZ().subtract(other.getZ()).get();
		return new Vector(newX,newY,newZ);
	}
	
	// multiple vector by scalar 
	public Vector Scalar (double num) {
		double newX = this.getX().get() * num;
		double newY = this.getY().get() * num;
		double newZ = this.getZ().get() * num;
		return new Vector(newX, newY, newZ);
	}
	
	// 
	public double dotProduct (Vector two){
		double x = one.getX().get() * two.getX().get();
		double y = one.getY().get() * two.getY().get();
		double z = one.getZ().get() * two.getZ().get();
		return x + y + z ;
	}
	
	public Vector crossProduct (Vector two){
		double x = one.getY().get() * two.getZ().get() - one.getZ().get() * two.getY().get() ;
		double y = one.getZ().get() * two.getX().get() - one.getX().get() * two.getZ().get();
		double z = one.getX().get() * two.getY().get() - one.getY().get() * two.getX().get();
		return new Vector(x, y, z);
	}
	
	//  
	public double CalculteVec (Vector one) {
		double x = one.getX().get();
		double y = one.getY().get();
		double z = one.getZ().get();
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}
	
	public Vector normalize(){
		 //if (_vec.getX().get()  == 0.0||_vec.getY().get()  == 0.0 ||_vec.getZ().get() == 0.0) {
			//throw new Exception("divide by zero");
		
		try {
			double x = this.getX().get() / this.length();
			double y = this.getY().get() / this.length();
			double z = this.getZ().get() / this.length();
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
        return Math.sqrt(Math.pow(this.getX().get() , 2) + 
        		Math.pow(this.getY().get(), 2) + Math.pow(this.getZ().get(),2));
    }
	
	@Override
	public String toString() {
		return this._head.toString();
	}
	
}
