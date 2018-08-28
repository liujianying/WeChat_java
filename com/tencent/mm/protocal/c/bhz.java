package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bhz extends a {
    public String siM;
    public boolean siN;

    public final /* synthetic */ a aG(byte[] bArr) {
        f.a.a.a.a aVar = new f.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cJS();
            }
        }
        return this;
    }

    protected final /* bridge */ /* synthetic */ a boj() {
        return this;
    }

    public final bhz VO(String str) {
        this.siM = str;
        this.siN = true;
        return this;
    }

    public final String toString() {
        return this.siM;
    }

    public final int boi() {
        int i = 0;
        if (this.siN) {
            i = f.a.a.b.b.a.h(1, this.siM) + 0;
        }
        return i + 0;
    }

    public final byte[] toByteArray() {
        return super.toByteArray();
    }

    public final void a(f.a.a.c.a aVar) {
        if (this.siN) {
            aVar.g(1, this.siM);
        }
    }

    public final boolean a(f.a.a.a.a aVar, a aVar2, int i) {
        bhz bhz = (bhz) aVar2;
        switch (i) {
            case 1:
                bhz.VO(aVar.vHC.readString());
                return true;
            default:
                return false;
        }
    }
}
