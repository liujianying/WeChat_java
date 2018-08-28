package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bia extends a {
    public int siO;
    private boolean siP;

    public final /* synthetic */ a aG(byte[] bArr) {
        f.a.a.a.a aVar = new f.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cJS();
            }
        }
        return cgx();
    }

    public final bia CS(int i) {
        this.siO = i;
        this.siP = true;
        return this;
    }

    public final String toString() {
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("uiVal = ").append(this.siO).append("   ").toString())).append(")").toString();
    }

    private bia cgx() {
        if (this.siP) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  uiVal:" + this.siP);
    }

    public final int boi() {
        return (f.a.a.a.fQ(1, this.siO) + 0) + 0;
    }

    public final byte[] toByteArray() {
        cgx();
        return super.toByteArray();
    }

    public final void a(f.a.a.c.a aVar) {
        aVar.fT(1, this.siO);
    }

    public final boolean a(f.a.a.a.a aVar, a aVar2, int i) {
        bia bia = (bia) aVar2;
        switch (i) {
            case 1:
                bia.CS(aVar.vHC.rY());
                return true;
            default:
                return false;
        }
    }
}
