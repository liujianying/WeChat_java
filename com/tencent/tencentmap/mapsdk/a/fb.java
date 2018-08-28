package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class fb implements ew {
    private boolean a = false;
    private boolean b = false;
    private boolean c = true;
    private String d = null;
    private int[] e = null;
    private String f = "";
    private String g = null;
    private boolean h = true;
    private boolean i = true;
    private Map j = new HashMap();
    private byte[] k = null;
    private long l = 0;
    private int m = 32768;
    private int n = 10000;
    private int o = 10000;
    private int p = 3;
    private boolean q = true;
    private List r = new ArrayList();
    private volatile boolean s = false;
    private String t = "";

    public fb(String str, int[] iArr) {
        this.d = str;
        this.e = iArr;
        if (this.e == null || this.e[0] == -1) {
            this.f = this.d;
        } else {
            this.f = this.d + ":" + this.e[0];
        }
        this.t = fz.b(this.d);
    }

    public final String a() {
        return this.t;
    }

    public final void a(int i) {
        if (i > 5120 && i < 2097152) {
            this.m = i;
        }
    }

    public final void a(long j) {
        this.l = j;
    }

    public final void a(fd fdVar) {
        this.r.add(fdVar);
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.j.put(str, str2);
        }
    }

    public final void a(Map map) {
        this.j.putAll(map);
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final void a(byte[] bArr) {
        this.k = bArr;
    }

    public final void b(int i) {
        if (i > 6000 && i < 60000) {
            this.n = i;
        }
    }

    public final void b(String str) {
    }

    public final void b(boolean z) {
        this.b = z;
    }

    public final boolean b() {
        return this.a;
    }

    public final String c() {
        return this.d;
    }

    public final void c(int i) {
    }

    public final void d(int i) {
        if (i >= 0 && i <= 8) {
            this.p = i;
        }
    }

    public final int[] d() {
        return this.e;
    }

    public final String e() {
        return this.g;
    }

    public final boolean f() {
        return this.h;
    }

    public final Map g() {
        Map hashMap = new HashMap();
        hashMap.putAll(this.j);
        return hashMap;
    }

    public final byte[] h() {
        return this.k;
    }

    public final int i() {
        return this.m;
    }

    public final int j() {
        return this.p;
    }

    public final boolean k() {
        return this.q;
    }

    public final boolean l() {
        return this.s;
    }

    public final boolean m() {
        return this.i;
    }

    public final String n() {
        return this.f;
    }

    public final int o() {
        return this.o;
    }

    public final boolean p() {
        return this.b;
    }

    public final long q() {
        return this.l;
    }

    public final boolean r() {
        return this.c;
    }
}
