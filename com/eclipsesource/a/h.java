package com.eclipsesource.a;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

public abstract class h implements Serializable {
    @Deprecated
    public static final h abw = a.abw;
    @Deprecated
    public static final h abx = a.abx;
    @Deprecated
    public static final h aby = a.aby;

    abstract void a(i iVar);

    h() {
    }

    public boolean isObject() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public e hV() {
        throw new UnsupportedOperationException("Not an object: " + toString());
    }

    public b hQ() {
        throw new UnsupportedOperationException("Not an array: " + toString());
    }

    public int hS() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public long hT() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public double hU() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public String ie() {
        throw new UnsupportedOperationException("Not a string: " + toString());
    }

    public boolean hR() {
        throw new UnsupportedOperationException("Not a boolean: " + toString());
    }

    public String toString() {
        return a(l.ace);
    }

    private String a(l lVar) {
        Writer stringWriter = new StringWriter();
        if (lVar == null) {
            try {
                throw new NullPointerException("config is null");
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        Writer mVar = new m(stringWriter);
        a(lVar.a(mVar));
        mVar.flush();
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
