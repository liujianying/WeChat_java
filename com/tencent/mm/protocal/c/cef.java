package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cef extends a {
    public long szl;
    public long szm;
    public String szn;
    public LinkedList<ceg> szo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int S;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.szn == null) {
                throw new b("Not all required fields were included: TotalMsg");
            }
            aVar.T(1, this.szm);
            aVar.T(2, this.szl);
            if (this.szn != null) {
                aVar.g(3, this.szn);
            }
            aVar.d(4, 8, this.szo);
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.szm) + 0) + f.a.a.a.S(2, this.szl);
            if (this.szn != null) {
                S += f.a.a.b.b.a.h(3, this.szn);
            }
            return S + f.a.a.a.c(4, 8, this.szo);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.szo.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.szn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TotalMsg");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cef cef = (cef) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cef.szm = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    cef.szl = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    cef.szn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ceg ceg = new ceg();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ceg.a(aVar4, ceg, a.a(aVar4))) {
                        }
                        cef.szo.add(ceg);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
