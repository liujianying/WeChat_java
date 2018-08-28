package com.tencent.mm.v;

import junit.framework.Assert;
import org.json.JSONArray;

public final class e extends JSONArray implements a {
    private final a dpe;

    public e() {
        this.dpe = g.Dd();
    }

    e(a aVar) {
        Assert.assertNotNull(aVar);
        this.dpe = aVar;
    }

    public final int length() {
        return this.dpe.length();
    }

    private e br(boolean z) {
        this.dpe.bq(z);
        return this;
    }

    private e p(double d) {
        this.dpe.o(d);
        return this;
    }

    private e gA(int i) {
        this.dpe.gv(i);
        return this;
    }

    private e aP(long j) {
        this.dpe.aO(j);
        return this;
    }

    private e aC(Object obj) {
        this.dpe.aB(obj);
        return this;
    }

    public final boolean isNull(int i) {
        return this.dpe.isNull(i);
    }

    public final Object get(int i) {
        return this.dpe.get(i);
    }

    public final Object opt(int i) {
        return this.dpe.opt(i);
    }

    public final Object remove(int i) {
        return this.dpe.remove(i);
    }

    public final boolean getBoolean(int i) {
        return this.dpe.getBoolean(i);
    }

    public final boolean optBoolean(int i) {
        return this.dpe.optBoolean(i);
    }

    public final boolean optBoolean(int i, boolean z) {
        return this.dpe.optBoolean(i, z);
    }

    public final double getDouble(int i) {
        return this.dpe.getDouble(i);
    }

    public final double optDouble(int i) {
        return this.dpe.optDouble(i);
    }

    public final double optDouble(int i, double d) {
        return this.dpe.optDouble(i, d);
    }

    public final int getInt(int i) {
        return this.dpe.getInt(i);
    }

    public final int optInt(int i) {
        return this.dpe.optInt(i);
    }

    public final int optInt(int i, int i2) {
        return this.dpe.optInt(i, i2);
    }

    public final long getLong(int i) {
        return this.dpe.getLong(i);
    }

    public final long optLong(int i) {
        return this.dpe.optLong(i);
    }

    public final long optLong(int i, long j) {
        return this.dpe.optLong(i, j);
    }

    public final String getString(int i) {
        return this.dpe.getString(i);
    }

    public final String optString(int i) {
        return this.dpe.optString(i);
    }

    public final String optString(int i, String str) {
        return this.dpe.optString(i, str);
    }

    private e gB(int i) {
        return new e(this.dpe.gw(i));
    }

    private e gC(int i) {
        return new e(this.dpe.gx(i));
    }

    private h gD(int i) {
        return new h(this.dpe.gy(i));
    }

    private h gE(int i) {
        return new h(this.dpe.gz(i));
    }
}
