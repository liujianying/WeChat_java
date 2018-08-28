package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class cam extends bhd {
    public int rxG;
    public long rxH;
    public String seC;
    public long suO;
    public cas svJ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.svJ == null) {
                throw new b("Not all required fields were included: ReportData");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.seC != null) {
                aVar.g(2, this.seC);
            }
            aVar.fT(3, this.rxG);
            aVar.T(4, this.rxH);
            if (this.svJ != null) {
                aVar.fV(5, this.svJ.boi());
                this.svJ.a(aVar);
            }
            aVar.T(6, this.suO);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.seC != null) {
                fS += f.a.a.b.b.a.h(2, this.seC);
            }
            fS = (fS + f.a.a.a.fQ(3, this.rxG)) + f.a.a.a.S(4, this.rxH);
            if (this.svJ != null) {
                fS += f.a.a.a.fS(5, this.svJ.boi());
            }
            return fS + f.a.a.a.S(6, this.suO);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.svJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReportData");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cam cam = (cam) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        cam.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cam.seC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cam.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cam.rxH = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        cam.svJ = cas;
                    }
                    return 0;
                case 6:
                    cam.suO = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
