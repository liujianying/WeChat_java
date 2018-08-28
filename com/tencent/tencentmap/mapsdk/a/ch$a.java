package com.tencent.tencentmap.mapsdk.a;

import java.util.Map;
import java.util.Set;

public class ch$a {
    private final int a;
    private boolean b = false;
    private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
    private String d = "http://jrlt.beacon.qq.com/analytics/upload";
    private Map<String, String> e = null;
    private Set<String> f = null;
    private Set<String> g = null;

    public ch$a(int i) {
        this.a = i;
    }

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final String b() {
        if (ct.b) {
            return this.d;
        }
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final Map<String, String> c() {
        return this.e;
    }

    public final void a(Map<String, String> map) {
        this.e = map;
    }

    public final Set<String> d() {
        return this.f;
    }

    public final void a(Set<String> set) {
        this.f = set;
    }

    public final int e() {
        return this.a;
    }

    public final Set<String> f() {
        return this.g;
    }

    public final void b(Set<String> set) {
        this.g = set;
    }
}
