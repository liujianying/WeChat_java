package com.eclipsesource.a;

final class g extends h {
    private final String string;

    g(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        this.string = str;
    }

    final void a(i iVar) {
        iVar.writeString(this.string);
    }

    public final boolean isString() {
        return true;
    }

    public final String ie() {
        return this.string;
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
        return this.string.equals(((g) obj).string);
    }
}
