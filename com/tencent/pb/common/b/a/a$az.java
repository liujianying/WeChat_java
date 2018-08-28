package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$az extends e {
    private static volatile a$az[] vfS;
    public int timestamp;
    public int vfT;
    public int vfU;
    public int vfV;
    public int vfW;

    public static a$az[] cEC() {
        if (vfS == null) {
            synchronized (c.bfO) {
                if (vfS == null) {
                    vfS = new a$az[0];
                }
            }
        }
        return vfS;
    }

    public a$az() {
        this.timestamp = 0;
        this.vfT = 0;
        this.vfU = 0;
        this.vfV = 0;
        this.vfW = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.timestamp != 0) {
            bVar.aE(1, this.timestamp);
        }
        if (this.vfT != 0) {
            bVar.aE(2, this.vfT);
        }
        if (this.vfU != 0) {
            bVar.aE(3, this.vfU);
        }
        if (this.vfV != 0) {
            bVar.aE(4, this.vfV);
        }
        if (this.vfW != 0) {
            bVar.aE(5, this.vfW);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.timestamp != 0) {
            sl += b.aG(1, this.timestamp);
        }
        if (this.vfT != 0) {
            sl += b.aG(2, this.vfT);
        }
        if (this.vfU != 0) {
            sl += b.aG(3, this.vfU);
        }
        if (this.vfV != 0) {
            sl += b.aG(4, this.vfV);
        }
        if (this.vfW != 0) {
            return sl + b.aG(5, this.vfW);
        }
        return sl;
    }
}
