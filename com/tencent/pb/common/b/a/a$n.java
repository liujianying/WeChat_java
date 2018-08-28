package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$n extends e {
    private static volatile a$n[] vdh;
    public byte[] bRS;
    public int vdi;
    public int vdj;

    public static a$n[] cEt() {
        if (vdh == null) {
            synchronized (c.bfO) {
                if (vdh == null) {
                    vdh = new a$n[0];
                }
            }
        }
        return vdh;
    }

    public a$n() {
        this.vdi = 0;
        this.bRS = g.bfW;
        this.vdj = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.vdi != 0) {
            bVar.aE(1, this.vdi);
        }
        if (!Arrays.equals(this.bRS, g.bfW)) {
            bVar.b(2, this.bRS);
        }
        if (this.vdj != 0) {
            bVar.aF(3, this.vdj);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.vdi != 0) {
            sl += b.aG(1, this.vdi);
        }
        if (!Arrays.equals(this.bRS, g.bfW)) {
            sl += b.c(2, this.bRS);
        }
        if (this.vdj != 0) {
            return sl + b.aH(3, this.vdj);
        }
        return sl;
    }
}
