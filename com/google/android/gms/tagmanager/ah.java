package com.google.android.gms.tagmanager;

final class ah extends Number implements Comparable<ah> {
    private double bcC;
    private long bcD = 0;
    boolean bcE = true;

    private ah() {
    }

    private int a(ah ahVar) {
        return (this.bcE && ahVar.bcE) ? new Long(this.bcD).compareTo(Long.valueOf(ahVar.bcD)) : Double.compare(doubleValue(), ahVar.doubleValue());
    }

    public static ah rB() {
        return new ah();
    }

    public final byte byteValue() {
        return (byte) ((int) longValue());
    }

    public final double doubleValue() {
        return this.bcE ? (double) this.bcD : this.bcC;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ah) && a((ah) obj) == 0;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public final int intValue() {
        return (int) longValue();
    }

    public final long longValue() {
        return this.bcE ? this.bcD : (long) this.bcC;
    }

    public final short shortValue() {
        return (short) ((int) longValue());
    }

    public final String toString() {
        return this.bcE ? Long.toString(this.bcD) : Double.toString(this.bcC);
    }
}
