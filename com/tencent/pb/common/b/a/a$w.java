package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$w extends e {
    private static volatile a$w[] vdX;
    public String vdY;
    public String vdZ;

    public static a$w[] cEv() {
        if (vdX == null) {
            synchronized (c.bfO) {
                if (vdX == null) {
                    vdX = new a$w[0];
                }
            }
        }
        return vdX;
    }

    public a$w() {
        this.vdY = "";
        this.vdZ = "";
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (!this.vdY.equals("")) {
            bVar.g(1, this.vdY);
        }
        if (!this.vdZ.equals("")) {
            bVar.g(2, this.vdZ);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (!this.vdY.equals("")) {
            sl += b.h(1, this.vdY);
        }
        if (this.vdZ.equals("")) {
            return sl;
        }
        return sl + b.h(2, this.vdZ);
    }
}
