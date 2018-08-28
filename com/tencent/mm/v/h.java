package com.tencent.mm.v;

import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class h extends JSONObject implements c {
    private final c dph;

    public h() {
        this.dph = g.Dc();
    }

    public h(c cVar) {
        Assert.assertNotNull(cVar);
        this.dph = cVar;
    }

    public h(Map map) {
        this.dph = g.n(map);
    }

    public h(String str) {
        this.dph = g.fV(str);
    }

    public final int length() {
        return this.dph.length();
    }

    private h q(String str, boolean z) {
        this.dph.p(str, z);
        return this;
    }

    private h c(String str, double d) {
        this.dph.b(fP(str), d);
        return this;
    }

    private h E(String str, int i) {
        this.dph.D(fP(str), i);
        return this;
    }

    private h k(String str, long j) {
        this.dph.j(fP(str), j);
        return this;
    }

    private h n(String str, Object obj) {
        this.dph.l(str, obj);
        return this;
    }

    private h o(String str, Object obj) {
        this.dph.m(str, obj);
        return this;
    }

    public final String fP(String str) {
        return this.dph.fP(str);
    }

    public final Object remove(String str) {
        return this.dph.remove(str);
    }

    public final boolean isNull(String str) {
        return this.dph.isNull(str);
    }

    public final boolean has(String str) {
        return this.dph.has(str);
    }

    public final Object get(String str) {
        return this.dph.get(str);
    }

    public final Object opt(String str) {
        return this.dph.opt(str);
    }

    public final boolean getBoolean(String str) {
        return this.dph.getBoolean(str);
    }

    public final boolean optBoolean(String str) {
        return this.dph.optBoolean(str, false);
    }

    public final boolean optBoolean(String str, boolean z) {
        return this.dph.optBoolean(str, z);
    }

    public final double getDouble(String str) {
        return this.dph.getDouble(str);
    }

    public final double optDouble(String str) {
        return this.dph.optDouble(str, Double.NaN);
    }

    public final double optDouble(String str, double d) {
        return this.dph.optDouble(str, d);
    }

    public final int getInt(String str) {
        return this.dph.getInt(str);
    }

    public final int optInt(String str) {
        return this.dph.optInt(str, 0);
    }

    public final int optInt(String str, int i) {
        return this.dph.optInt(str, i);
    }

    public final long getLong(String str) {
        return this.dph.getLong(str);
    }

    public final long optLong(String str) {
        return this.dph.optLong(str, 0);
    }

    public final long optLong(String str, long j) {
        return this.dph.optLong(str, j);
    }

    public final String getString(String str) {
        return this.dph.getString(str);
    }

    public final String optString(String str) {
        return this.dph.optString(str, "");
    }

    public final String optString(String str, String str2) {
        return this.dph.optString(str);
    }

    private e fX(String str) {
        a fQ = this.dph.fQ(str);
        if (fQ == null) {
            return null;
        }
        return new e(fQ);
    }

    private e fY(String str) {
        a fR = this.dph.fR(str);
        if (fR == null) {
            return null;
        }
        return new e(fR);
    }

    private h fZ(String str) {
        c fS = this.dph.fS(str);
        if (fS == null) {
            return null;
        }
        return new h(fS);
    }

    private h ga(String str) {
        c fT = this.dph.fT(str);
        if (fT == null) {
            return null;
        }
        return new h(fT);
    }

    public final Iterator<String> keys() {
        return this.dph.keys();
    }

    public final String toString() {
        return this.dph.toString();
    }
}
