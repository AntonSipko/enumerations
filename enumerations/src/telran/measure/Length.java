package telran.measure;

public class Length implements Comparable<Length> {
	float amount;
	LengthUnit unit;
	public Length(LengthUnit unit,float amount){
		this.amount=amount;
		this.unit=unit;
	}
	public boolean equals(Object o) {
		boolean res;
	    if (this == o) res= true;
	    if (o == null || getClass() != o.getClass()) res= false;
	    Length length = (Length) o;
	    if (this.unit != length.unit) {
	        length = length.convert(this.unit);
	    }
	    
	    return this.compareTo(length)==0;
	}
	public Length convert(LengthUnit targetUnit) {
		float convertedAmount;
		Length res;
		if(unit==this.unit) {
			res=this;
		}
		float convertedAmountInMmeters = amount * unit.getValue();
		float convertedAmountInTargetUnit = convertedAmountInMmeters / targetUnit.getValue();
		return new Length(targetUnit,convertedAmountInTargetUnit);
		
        
	}
	public String toString() {
		return amount +""+unit;
		
	}
	public float getAmount() {
		return this.amount;
	}
	public LengthUnit getUnit() {
		return this.unit;
	}
	@Override
	public int compareTo(Length o) {
		if (this.unit != o.unit) {
	        o = o.convert(this.unit);
	    }
	    
	    return Float.compare(this.amount, o.amount);
	}

}
