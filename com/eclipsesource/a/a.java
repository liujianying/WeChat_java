package com.eclipsesource.a;

public final class a {
    public static final h abw = new c("null");
    public static final h abx = new c("true");
    public static final h aby = new c("false");

    public static h bX(int i) {
        return new d(Integer.toString(i, 10));
    }

    public static h k(long j) {
        return new d(Long.toString(j, 10));
    }

    public static h R(float f) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            return new d(V(Float.toString(f)));
        }
        throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
    }

    public static h l(double d) {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return new d(V(Double.toString(d)));
        }
        throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
    }

    public static h T(String str) {
        return str == null ? abw : new g(str);
    }

    public static h ac(boolean z) {
        return z ? abx : aby;
    }

    public static h U(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        try {
            f fVar = new f(str);
            fVar.ia();
            fVar.hZ();
            h hW = fVar.hW();
            fVar.hZ();
            if (fVar.id()) {
                return hW;
            }
            throw fVar.Y("Unexpected character");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String V(String str) {
        if (str.endsWith(".0")) {
            return str.substring(0, str.length() - 2);
        }
        return str;
    }
}
