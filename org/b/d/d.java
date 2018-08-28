package org.b.d;

public final class d implements Comparable<d> {
    final String aAL;
    final String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        int compareTo = this.aAL.compareTo(dVar.aAL);
        return compareTo != 0 ? compareTo : this.value.compareTo(dVar.value);
    }

    public d(String str, String str2) {
        this.aAL = str;
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.aAL.equals(this.aAL) && dVar.value.equals(this.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.aAL.hashCode() + this.value.hashCode();
    }
}
