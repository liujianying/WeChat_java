package com.eclipsesource.a;

final class d extends h {
    private final String string;

    d(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        this.string = str;
    }

    public final String toString() {
        return this.string;
    }

    final void a(i iVar) {
        iVar.aa(this.string);
    }

    public final boolean isNumber() {
        return true;
    }

    public final int hS() {
        return Integer.parseInt(this.string, 10);
    }

    public final long hT() {
        return Long.parseLong(this.string, 10);
    }

    public final double hU() {
        return Double.parseDouble(this.string);
    }

    public final int hashCode() {
        return this.string.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.string.equals(((d) obj).string);
    }
}
