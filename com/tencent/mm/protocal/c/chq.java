package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class chq extends a {
    public String sBH;
    public chl sBu;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sBu != null) {
                aVar.fV(1, this.sBu.boi());
                this.sBu.a(aVar);
            }
            if (this.sBH == null) {
                return 0;
            }
            aVar.g(2, this.sBH);
            return 0;
        } else if (i == 1) {
            if (this.sBu != null) {
                fS = f.a.a.a.fS(1, this.sBu.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sBH != null) {
                fS += f.a.a.b.b.a.h(2, this.sBH);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            chq chq = (chq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        chl chl = new chl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chl.a(aVar4, chl, a.a(aVar4))) {
                        }
                        chq.sBu = chl;
                    }
                    return 0;
                case 2:
                    chq.sBH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
