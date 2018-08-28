package com.eclipsesource.a;

final class c extends h {
    private final boolean abC;
    private final boolean abD;
    private final boolean abE;
    private final String value;

    c(String str) {
        this.value = str;
        this.abC = "null".equals(str);
        this.abD = "true".equals(str);
        this.abE = "false".equals(str);
    }

    final void a(i iVar) {
        iVar.Z(this.value);
    }

    public final String toString() {
        return this.value;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final boolean isBoolean() {
        return this.abD || this.abE;
    }

    public final boolean hR() {
        return this.abC ? super.hR() : this.abD;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.value.equals(((c) obj).value);
    }
}
