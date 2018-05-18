package primitives;

public class Coordinate {
	
	//fields
	private double  _coordinate;
	private static final int ACCURCY = -20;
	public static final Coordinate ZERO = new Coordinate(0);

	//constructors
	public Coordinate(double coord) {
		_coordinate = (getExp(coord) < ACCURCY) ? 0.0 : coord;
	}
	
	public Coordinate(Coordinate other) {
		if (other == null) throw new IllegalArgumentException("coordinate cannot be null");
		_coordinate = other._coordinate;
	}
	
	// getters
	public double coordinate() {
		return _coordinate;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null) return false;
	    if (!(obj instanceof Coordinate)) return false;
   	    Coordinate other = (Coordinate)obj;
	    return (subtract(other._coordinate) == 0.0);
	}

	@Override
	public String toString() {
		return "" + _coordinate;
	}
	
	
	private int getExp(double num) {
	    return (int)((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
	}
	
	
	private double subtract(double other) {
		double result = _coordinate - other;
		int resultExp = getExp(result);
		if (resultExp < ACCURCY) return 0.0;
		int thisExp = getExp(_coordinate);
		if ((resultExp - thisExp) < ACCURCY) return _coordinate;
		return result;
	}
	
	private double add(double other) {
		double result = _coordinate + other;
		int resultExp = (int)((Double.doubleToRawLongBits(result) >> 52) & 0x7FFL);
		if (Math.abs(resultExp) < ACCURCY) return 0.0;
		int thisExp = (int)((Double.doubleToRawLongBits(_coordinate) >> 52) & 0x7FFL);
		if (Math.abs(thisExp - resultExp) < ACCURCY) return _coordinate;
		return result;
	}

	public Coordinate subtract(Coordinate other) {
		return new Coordinate(subtract(other._coordinate));
	}
	
	public Coordinate add(Coordinate other) {
		return new Coordinate(add(other._coordinate));
	}
	
	public Coordinate scale(double scalar) {
		return new Coordinate(_coordinate * scalar);
	}
	
	public Coordinate multi(Coordinate other) {
		return new Coordinate(scale(other._coordinate));
	}
	
	
}
