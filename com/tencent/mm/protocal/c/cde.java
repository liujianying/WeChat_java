package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class cde extends bhd {
    public String bWm;
    public int syH;
    public String syL;
    public String syM;
    public String syS;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.bWm != null) {
                aVar.g(2, this.bWm);
            }
            aVar.fT(3, this.syH);
            if (this.syL != null) {
                aVar.g(99, this.syL);
            }
            if (this.syM != null) {
                aVar.g(100, this.syM);
            }
            if (this.syS == null) {
                return 0;
            }
            aVar.g(101, this.syS);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bWm != null) {
                fS += f.a.a.b.b.a.h(2, this.bWm);
            }
            fS += f.a.a.a.fQ(3, this.syH);
            if (this.syL != null) {
                fS += f.a.a.b.b.a.h(99, this.syL);
            }
            if (this.syM != null) {
                fS += f.a.a.b.b.a.h(100, this.syM);
            }
            if (this.syS != null) {
                fS += f.a.a.b.b.a.h(101, this.syS);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cde cde = (cde) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        cde.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cde.bWm = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cde.syH = aVar3.vHC.rY();
                    return 0;
                case 99:
                    cde.syL = aVar3.vHC.readString();
                    return 0;
                case 100:
                    cde.syM = aVar3.vHC.readString();
                    return 0;
                case 101:
                    cde.syS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
