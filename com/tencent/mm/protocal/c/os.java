package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class os extends bhd {
    public String hbL;
    public String jQb;
    public String jTx;
    public String onE;
    public String onF;
    public int rcd;
    public String rhq;
    public aw rmQ;
    public String rrC;
    public int rsA;
    public int rsC;
    public String rsD;
    public int rsW;
    public int rsX;
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
            if (this.hbL != null) {
                aVar.g(11, this.hbL);
            }
            if (this.jTx != null) {
                aVar.g(12, this.jTx);
            }
            aVar.fT(13, this.rcd);
            aVar.fT(14, this.rsW);
            if (this.onE != null) {
                aVar.g(15, this.onE);
            }
            if (this.onF != null) {
                aVar.g(16, this.onF);
            }
            aVar.fT(17, this.rsX);
            aVar.fT(18, this.rsC);
            if (this.rsD == null) {
                return 0;
            }
            aVar.g(19, this.rsD);
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
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(11, this.hbL);
            }
            if (this.jTx != null) {
                fS += f.a.a.b.b.a.h(12, this.jTx);
            }
            fS = (fS + f.a.a.a.fQ(13, this.rcd)) + f.a.a.a.fQ(14, this.rsW);
            if (this.onE != null) {
                fS += f.a.a.b.b.a.h(15, this.onE);
            }
            if (this.onF != null) {
                fS += f.a.a.b.b.a.h(16, this.onF);
            }
            fS = (fS + f.a.a.a.fQ(17, this.rsX)) + f.a.a.a.fQ(18, this.rsC);
            if (this.rsD != null) {
                fS += f.a.a.b.b.a.h(19, this.rsD);
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
            os osVar = (os) objArr[1];
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
                        osVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    osVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    osVar.rsw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    osVar.rhq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    osVar.rsx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    osVar.rsy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    osVar.rsz = aVar3.vHC.readString();
                    return 0;
                case 8:
                    osVar.rrC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    osVar.rsA = aVar3.vHC.rY();
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
                        osVar.rmQ = awVar;
                    }
                    return 0;
                case 11:
                    osVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 12:
                    osVar.jTx = aVar3.vHC.readString();
                    return 0;
                case 13:
                    osVar.rcd = aVar3.vHC.rY();
                    return 0;
                case 14:
                    osVar.rsW = aVar3.vHC.rY();
                    return 0;
                case 15:
                    osVar.onE = aVar3.vHC.readString();
                    return 0;
                case 16:
                    osVar.onF = aVar3.vHC.readString();
                    return 0;
                case 17:
                    osVar.rsX = aVar3.vHC.rY();
                    return 0;
                case 18:
                    osVar.rsC = aVar3.vHC.rY();
                    return 0;
                case 19:
                    osVar.rsD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
