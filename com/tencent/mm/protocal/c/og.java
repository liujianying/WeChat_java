package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class og extends bhd {
    public String hbL;
    public String jQb;
    public String jTx;
    public int rcd;
    public String rhq;
    public aw rmQ;
    public String rrC;
    public int rsA;
    public String rsB;
    public int rsC;
    public String rsD;
    public String rsw;
    public String rsx;
    public String rsy;
    public String rsz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            if (this.rsw != null) {
                aVar.g(3, this.rsw);
            }
            if (this.rhq != null) {
                aVar.g(4, this.rhq);
            }
            if (this.rsx != null) {
                aVar.g(5, this.rsx);
            }
            if (this.rsy != null) {
                aVar.g(6, this.rsy);
            }
            if (this.rsz != null) {
                aVar.g(7, this.rsz);
            }
            if (this.rrC != null) {
                aVar.g(8, this.rrC);
            }
            aVar.fT(9, this.rsA);
            if (this.rmQ != null) {
                aVar.fV(10, this.rmQ.boi());
                this.rmQ.a(aVar);
            }
            if (this.rsB != null) {
                aVar.g(11, this.rsB);
            }
            if (this.hbL != null) {
                aVar.g(12, this.hbL);
            }
            if (this.jTx != null) {
                aVar.g(13, this.jTx);
            }
            aVar.fT(14, this.rcd);
            aVar.fT(15, this.rsC);
            if (this.rsD == null) {
                return 0;
            }
            aVar.g(16, this.rsD);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(2, this.jQb);
            }
            if (this.rsw != null) {
                fS += f.a.a.b.b.a.h(3, this.rsw);
            }
            if (this.rhq != null) {
                fS += f.a.a.b.b.a.h(4, this.rhq);
            }
            if (this.rsx != null) {
                fS += f.a.a.b.b.a.h(5, this.rsx);
            }
            if (this.rsy != null) {
                fS += f.a.a.b.b.a.h(6, this.rsy);
            }
            if (this.rsz != null) {
                fS += f.a.a.b.b.a.h(7, this.rsz);
            }
            if (this.rrC != null) {
                fS += f.a.a.b.b.a.h(8, this.rrC);
            }
            fS += f.a.a.a.fQ(9, this.rsA);
            if (this.rmQ != null) {
                fS += f.a.a.a.fS(10, this.rmQ.boi());
            }
            if (this.rsB != null) {
                fS += f.a.a.b.b.a.h(11, this.rsB);
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(12, this.hbL);
            }
            if (this.jTx != null) {
                fS += f.a.a.b.b.a.h(13, this.jTx);
            }
            fS = (fS + f.a.a.a.fQ(14, this.rcd)) + f.a.a.a.fQ(15, this.rsC);
            if (this.rsD != null) {
                fS += f.a.a.b.b.a.h(16, this.rsD);
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
            og ogVar = (og) objArr[1];
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
                        ogVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ogVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ogVar.rsw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ogVar.rhq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ogVar.rsx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ogVar.rsy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ogVar.rsz = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ogVar.rrC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ogVar.rsA = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, bhd.a(aVar4))) {
                        }
                        ogVar.rmQ = awVar;
                    }
                    return 0;
                case 11:
                    ogVar.rsB = aVar3.vHC.readString();
                    return 0;
                case 12:
                    ogVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 13:
                    ogVar.jTx = aVar3.vHC.readString();
                    return 0;
                case 14:
                    ogVar.rcd = aVar3.vHC.rY();
                    return 0;
                case 15:
                    ogVar.rsC = aVar3.vHC.rY();
                    return 0;
                case 16:
                    ogVar.rsD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
