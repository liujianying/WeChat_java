package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class zq extends bhp {
    public int hwV;
    public String hwW;
    public int rFw;
    public String rFx;
    public String rFy;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            aVar.fT(4, this.rFw);
            if (this.rFx != null) {
                aVar.g(5, this.rFx);
            }
            if (this.rFy == null) {
                return 0;
            }
            aVar.g(6, this.rFy);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            fS += f.a.a.a.fQ(4, this.rFw);
            if (this.rFx != null) {
                fS += f.a.a.b.b.a.h(5, this.rFx);
            }
            if (this.rFy != null) {
                fS += f.a.a.b.b.a.h(6, this.rFy);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            zq zqVar = (zq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        zqVar.six = flVar;
                    }
                    return 0;
                case 2:
                    zqVar.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    zqVar.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    zqVar.rFw = aVar3.vHC.rY();
                    return 0;
                case 5:
                    zqVar.rFx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    zqVar.rFy = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
