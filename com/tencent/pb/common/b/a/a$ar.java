package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ar extends e {
    private static volatile a$ar[] veG;
    public int veH;
    public int veI;
    public byte[] veJ;

    public static a$ar[] cEy() {
        if (veG == null) {
            synchronized (c.bfO) {
                if (veG == null) {
                    veG = new a$ar[0];
                }
            }
        }
        return veG;
    }

    public a$ar() {
        this.veH = 0;
        this.veI = 0;
        this.veJ = g.bfW;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.veH != 0) {
            bVar.aE(1, this.veH);
        }
        if (this.veI != 0) {
            bVar.aE(2, this.veI);
        }
        if (!Arrays.equals(this.veJ, g.bfW)) {
            bVar.b(3, this.veJ);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.veH != 0) {
            sl += b.aG(1, this.veH);
        }
        if (this.veI != 0) {
            sl += b.aG(2, this.veI);
        }
        if (Arrays.equals(this.veJ, g.bfW)) {
            return sl;
        }
        return sl + b.c(3, this.veJ);
    }
}
