package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzr extends bhd {
    public String jTu;
    public int rxG;
    public long rxH;
    public String seC;
    public int sef;
    public long suO;
    public cas svJ;
    public int svK;

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
            if (this.jTu != null) {
                aVar.g(6, this.jTu);
            }
            if (this.svJ != null) {
                aVar.fV(8, this.svJ.boi());
                this.svJ.a(aVar);
            }
            aVar.fT(9, this.svK);
            aVar.T(10, this.suO);
            aVar.fT(11, this.sef);
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
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(6, this.jTu);
            }
            if (this.svJ != null) {
                fS += f.a.a.a.fS(8, this.svJ.boi());
            }
            return ((fS + f.a.a.a.fQ(9, this.svK)) + f.a.a.a.S(10, this.suO)) + f.a.a.a.fQ(11, this.sef);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
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
            bzr bzr = (bzr) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bzr.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bzr.seC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bzr.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bzr.rxH = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bzr.jTu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, bhd.a(aVar4))) {
                        }
                        bzr.svJ = cas;
                    }
                    return 0;
                case 9:
                    bzr.svK = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bzr.suO = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    bzr.sef = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
