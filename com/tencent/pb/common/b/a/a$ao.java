package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$ao extends e {
    private static volatile a$ao[] veC;
    public int fps;
    public int kpU;
    public int veD;
    public int veo;

    public static a$ao[] cEx() {
        if (veC == null) {
            synchronized (c.bfO) {
                if (veC == null) {
                    veC = new a$ao[0];
                }
            }
        }
        return veC;
    }

    public a$ao() {
        this.kpU = 0;
        this.veD = 0;
        this.fps = 0;
        this.veo = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.kpU != 0) {
            bVar.aE(1, this.kpU);
        }
        if (this.veD != 0) {
            bVar.aE(2, this.veD);
        }
        if (this.fps != 0) {
            bVar.aE(3, this.fps);
        }
        if (this.veo != 0) {
            bVar.aE(4, this.veo);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.kpU != 0) {
            sl += b.aG(1, this.kpU);
        }
        if (this.veD != 0) {
            sl += b.aG(2, this.veD);
        }
        if (this.fps != 0) {
            sl += b.aG(3, this.fps);
        }
        if (this.veo != 0) {
            return sl + b.aG(4, this.veo);
        }
        return sl;
    }
}
