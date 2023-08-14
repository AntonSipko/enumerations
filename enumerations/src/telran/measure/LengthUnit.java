package telran.measure;

public enum LengthUnit {
	MM(1),CM(10),IN(25.4f),FT(304.8f),M(1000),KM(1_000_000);
	float value;
	LengthUnit(float nMmeters){
		value=nMmeters;
	}
	public float getValue() {
		return value;
	}
	public Length between(Length length1, Length length2) {
        if (length1.unit != length2.unit) {
            length2 = length2.convert(length1.unit);
        }

        float lengthDifference = Math.abs(length1.amount - length2.amount);
        return new Length(length1.unit, lengthDifference);
    }

}
