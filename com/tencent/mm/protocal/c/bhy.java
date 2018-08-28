package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class bhy extends a {
    public int siI;
    private boolean siJ;
    public b siK;
    public boolean siL;

    private bhy CR(int i) {
        this.siI = i;
        this.siJ = true;
        return this;
    }

    public final bhy bq(byte[] bArr) {
        b bi = b.bi(bArr);
        b(bi);
        CR(bi.lR.length);
        return this;
    }

    public final bhy S(byte[] bArr, int i) {
        b t = b.t(bArr, 0, i);
        b(t);
        CR(t.lR.length);
        return this;
    }

    public final bhy b(b bVar) {
        if (bVar == null) {
            bq(null);
        }
        this.siK = bVar;
        this.siL = true;
        CR(this.siK.lR.length);
        return this;
    }

    public final String toString() {
        Object stringBuilder = new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("iLen = ").append(this.siI).append("   ").toString();
        if (this.siL) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.siK).append("   ").toString();
        }
        return new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
    }

    private bhy cgw() {
        if (this.siJ) {
            return this;
        }
        throw new f.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.siJ);
    }

    public final int boi() {
        int fQ = f.a.a.a.fQ(1, this.siI) + 0;
        if (this.siL) {
            fQ += f.a.a.a.a(2, this.siK);
        }
        return fQ + 0;
    }

    public final byte[] toByteArray() {
        cgw();
        return super.toByteArray();
    }

    public final void a(f.a.a.c.a aVar) {
        aVar.fT(1, this.siI);
        if (this.siL) {
            aVar.b(2, this.siK);
        }
    }

    public final boolean a(f.a.a.a.a aVar, a aVar2, int i) {
        bhy bhy = (bhy) aVar2;
        switch (i) {
            case 1:
                bhy.CR(aVar.vHC.rY());
                return true;
            case 2:
                bhy.b(aVar.cJR());
                return true;
            default:
                return false;
        }
    }

    /* renamed from: br */
    public final bhy aG(byte[] bArr) {
        f.a.a.a.a aVar = new f.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cJS();
            }
        }
        return cgw();
    }
}
