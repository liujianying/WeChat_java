package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class xr extends a {
    public hs rDx;
    public LinkedList<hu> riM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rDx != null) {
                aVar.fV(1, this.rDx.boi());
                this.rDx.a(aVar);
            }
            aVar.d(2, 8, this.riM);
            return 0;
        } else if (i == 1) {
            if (this.rDx != null) {
                fS = f.a.a.a.fS(1, this.rDx.boi()) + 0;
            } else {
                fS = 0;
            }
            return fS + f.a.a.a.c(2, 8, this.riM);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.riM.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            xr xrVar = (xr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        hs hsVar = new hs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hsVar.a(aVar4, hsVar, a.a(aVar4))) {
                        }
                        xrVar.rDx = hsVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        hu huVar = new hu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = huVar.a(aVar4, huVar, a.a(aVar4))) {
                        }
                        xrVar.riM.add(huVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
