package com.eclipsesource.a;

public class e$b {
    private final h abL;
    private final String name;

    e$b(String str, h hVar) {
        this.name = str;
        this.abL = hVar;
    }

    public final int hashCode() {
        return ((this.name.hashCode() + 31) * 31) + this.abL.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e$b e_b = (e$b) obj;
        if (this.name.equals(e_b.name) && this.abL.equals(e_b.abL)) {
            return true;
        }
        return false;
    }
}
