package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.location.Location;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.tencentmap.mapsdk.a.ac.n;
import com.tencent.tencentmap.mapsdk.a.z.a;

public class mo extends ny {
    private mr a = null;
    private ns b = null;
    private nu c = null;
    private a d = null;
    private z e = null;
    private boolean f = false;
    private pa g = null;
    private os h = null;
    private n i = null;
    private pc j = new pc();
    private int k = Color.argb(102, 0, 163, b.CTRL_BYTE);
    private Location l = null;

    public mo(mr mrVar, ns nsVar, nu nuVar) {
        this.a = mrVar;
        this.b = nsVar;
        this.c = nuVar;
        this.d = f();
    }

    public void a() {
        c();
        this.a = null;
        this.b = null;
        this.c = null;
    }

    boolean b() {
        if (!this.f) {
            this.f = true;
            if (this.d == null) {
                this.d = f();
            }
            if (this.g != null) {
                this.g.b(true);
            }
            if (this.h != null) {
                this.h.a(true);
            }
            if (this.e != null) {
                this.e.a(this.d);
            }
        }
        return true;
    }

    void c() {
        if (this.g != null) {
            this.g.b(false);
            this.g.f();
            this.g = null;
        }
        if (this.h != null) {
            this.h.a(false);
            this.h.a();
            this.h = null;
        }
        if (this.f) {
            this.f = false;
            this.d = null;
            if (this.e != null) {
                this.e.a();
            }
        }
    }

    private a f() {
        return new 1(this);
    }

    Location d() {
        if (this.l == null) {
            return null;
        }
        return new Location(this.l);
    }

    boolean e() {
        return this.f;
    }
}
