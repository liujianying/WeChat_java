package com.tencent.tinker.c.a.c;

import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;

final class a$a {
    final /* synthetic */ a vrA;
    private final b vrC;

    public a$a(a aVar, b bVar) {
        this.vrA = aVar;
        this.vrC = bVar;
    }

    private void a(m mVar) {
        int i = 0;
        switch (mVar.cGC()) {
            case 0:
                l.a(this.vrC, 0, (long) mVar.readByte());
                return;
            case 2:
                l.a(this.vrC, 2, (long) mVar.readShort());
                return;
            case 3:
                l.b(this.vrC, 3, (long) mVar.readChar());
                return;
            case 4:
                l.a(this.vrC, 4, (long) mVar.readInt());
                return;
            case 6:
                l.a(this.vrC, 6, mVar.readLong());
                return;
            case 16:
                l.c(this.vrC, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                return;
            case 17:
                l.c(this.vrC, 17, Double.doubleToLongBits(mVar.readDouble()));
                return;
            case 23:
                l.b(this.vrC, 23, (long) this.vrA.HU(mVar.cGG()));
                return;
            case 24:
                l.b(this.vrC, 24, (long) this.vrA.HV(mVar.cGH()));
                return;
            case 25:
                l.b(this.vrC, 25, (long) this.vrA.HX(mVar.cGI()));
                return;
            case 26:
                l.b(this.vrC, 26, (long) this.vrA.HY(mVar.cGK()));
                return;
            case 27:
                l.b(this.vrC, 27, (long) this.vrA.HX(mVar.cGJ()));
                return;
            case 28:
                fO(28, 0);
                c(mVar);
                return;
            case 29:
                fO(29, 0);
                b(mVar);
                return;
            case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                mVar.cGL();
                fO(30, 0);
                return;
            case 31:
                if (mVar.readBoolean()) {
                    i = 1;
                }
                fO(31, i);
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(mVar.cGC()));
        }
    }

    public final void b(m mVar) {
        int cGE = mVar.cGE();
        o.a(this.vrC, this.vrA.HV(mVar.vpc));
        o.a(this.vrC, cGE);
        for (int i = 0; i < cGE; i++) {
            o.a(this.vrC, this.vrA.HU(mVar.cGF()));
            a(mVar);
        }
    }

    public final void c(m mVar) {
        int cGD = mVar.cGD();
        o.a(this.vrC, cGD);
        for (int i = 0; i < cGD; i++) {
            a(mVar);
        }
    }

    private void fO(int i, int i2) {
        this.vrC.writeByte((i2 << 5) | i);
    }
}
