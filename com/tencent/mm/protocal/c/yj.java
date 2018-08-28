package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class yj extends bhd {
    public String jQb;
    public String jTB;
    public int otY;
    public int qZe;
    public String rEe;
    public String rEh;
    public String rEi;
    public int rEj;
    public String rEk;
    public String rhq;
    public aw rmQ;
    public String rrC;
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
            if (this.rEe != null) {
                aVar.g(9, this.rEe);
            }
            aVar.fT(10, this.qZe);
            if (this.jTB != null) {
                aVar.g(11, this.jTB);
            }
            if (this.rEh != null) {
                aVar.g(12, this.rEh);
            }
            if (this.rEi != null) {
                aVar.g(13, this.rEi);
            }
            if (this.rmQ != null) {
                aVar.fV(14, this.rmQ.boi());
                this.rmQ.a(aVar);
            }
            aVar.fT(15, this.otY);
            aVar.fT(16, this.rEj);
            if (this.rEk == null) {
                return 0;
            }
            aVar.g(17, this.rEk);
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
            if (this.rEe != null) {
                fS += f.a.a.b.b.a.h(9, this.rEe);
            }
            fS += f.a.a.a.fQ(10, this.qZe);
            if (this.jTB != null) {
                fS += f.a.a.b.b.a.h(11, this.jTB);
            }
            if (this.rEh != null) {
                fS += f.a.a.b.b.a.h(12, this.rEh);
            }
            if (this.rEi != null) {
                fS += f.a.a.b.b.a.h(13, this.rEi);
            }
            if (this.rmQ != null) {
                fS += f.a.a.a.fS(14, this.rmQ.boi());
            }
            fS = (fS + f.a.a.a.fQ(15, this.otY)) + f.a.a.a.fQ(16, this.rEj);
            if (this.rEk != null) {
                fS += f.a.a.b.b.a.h(17, this.rEk);
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
            yj yjVar = (yj) objArr[1];
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
                        yjVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    yjVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    yjVar.rsw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    yjVar.rhq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    yjVar.rsx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    yjVar.rsy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    yjVar.rsz = aVar3.vHC.readString();
                    return 0;
                case 8:
                    yjVar.rrC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    yjVar.rEe = aVar3.vHC.readString();
                    return 0;
                case 10:
                    yjVar.qZe = aVar3.vHC.rY();
                    return 0;
                case 11:
                    yjVar.jTB = aVar3.vHC.readString();
                    return 0;
                case 12:
                    yjVar.rEh = aVar3.vHC.readString();
                    return 0;
                case 13:
                    yjVar.rEi = aVar3.vHC.readString();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, bhd.a(aVar4))) {
                        }
                        yjVar.rmQ = awVar;
                    }
                    return 0;
                case 15:
                    yjVar.otY = aVar3.vHC.rY();
                    return 0;
                case 16:
                    yjVar.rEj = aVar3.vHC.rY();
                    return 0;
                case 17:
                    yjVar.rEk = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
