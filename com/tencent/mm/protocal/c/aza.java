package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aza extends bhd {
    public String jPg;
    public String jQb;
    public String jSv;
    public String rEf;
    public aw rmQ;
    public String rsw;
    public String rsx;
    public String rsy;
    public String rsz;
    public String sbN;
    public String sbO;
    public String sbP;
    public String sbQ;
    public String sbR;

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
            if (this.sbN != null) {
                aVar.g(3, this.sbN);
            }
            if (this.rEf != null) {
                aVar.g(4, this.rEf);
            }
            if (this.rsw != null) {
                aVar.g(5, this.rsw);
            }
            if (this.sbO != null) {
                aVar.g(6, this.sbO);
            }
            if (this.rsx != null) {
                aVar.g(7, this.rsx);
            }
            if (this.rsy != null) {
                aVar.g(8, this.rsy);
            }
            if (this.rsz != null) {
                aVar.g(9, this.rsz);
            }
            if (this.sbP != null) {
                aVar.g(10, this.sbP);
            }
            if (this.rmQ != null) {
                aVar.fV(11, this.rmQ.boi());
                this.rmQ.a(aVar);
            }
            if (this.sbQ != null) {
                aVar.g(12, this.sbQ);
            }
            if (this.jPg != null) {
                aVar.g(13, this.jPg);
            }
            if (this.jSv != null) {
                aVar.g(14, this.jSv);
            }
            if (this.sbR == null) {
                return 0;
            }
            aVar.g(15, this.sbR);
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
            if (this.sbN != null) {
                fS += f.a.a.b.b.a.h(3, this.sbN);
            }
            if (this.rEf != null) {
                fS += f.a.a.b.b.a.h(4, this.rEf);
            }
            if (this.rsw != null) {
                fS += f.a.a.b.b.a.h(5, this.rsw);
            }
            if (this.sbO != null) {
                fS += f.a.a.b.b.a.h(6, this.sbO);
            }
            if (this.rsx != null) {
                fS += f.a.a.b.b.a.h(7, this.rsx);
            }
            if (this.rsy != null) {
                fS += f.a.a.b.b.a.h(8, this.rsy);
            }
            if (this.rsz != null) {
                fS += f.a.a.b.b.a.h(9, this.rsz);
            }
            if (this.sbP != null) {
                fS += f.a.a.b.b.a.h(10, this.sbP);
            }
            if (this.rmQ != null) {
                fS += f.a.a.a.fS(11, this.rmQ.boi());
            }
            if (this.sbQ != null) {
                fS += f.a.a.b.b.a.h(12, this.sbQ);
            }
            if (this.jPg != null) {
                fS += f.a.a.b.b.a.h(13, this.jPg);
            }
            if (this.jSv != null) {
                fS += f.a.a.b.b.a.h(14, this.jSv);
            }
            if (this.sbR != null) {
                fS += f.a.a.b.b.a.h(15, this.sbR);
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
            aza aza = (aza) objArr[1];
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
                        aza.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aza.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aza.sbN = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aza.rEf = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aza.rsw = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aza.sbO = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aza.rsx = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aza.rsy = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aza.rsz = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aza.sbP = aVar3.vHC.readString();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, bhd.a(aVar4))) {
                        }
                        aza.rmQ = awVar;
                    }
                    return 0;
                case 12:
                    aza.sbQ = aVar3.vHC.readString();
                    return 0;
                case 13:
                    aza.jPg = aVar3.vHC.readString();
                    return 0;
                case 14:
                    aza.jSv = aVar3.vHC.readString();
                    return 0;
                case 15:
                    aza.sbR = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
