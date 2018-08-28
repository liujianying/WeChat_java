package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class hg extends bhd {
    public String hbL;
    public String iwP;
    public String reE;
    public String reS;
    public int rfe;
    public String rhA;
    public bhy rhB;
    public int rhC;
    public int rhD;
    public int rhE;
    public String rhF;
    public String rhu;
    public String rhv;
    public int rhw;
    public String rhx;
    public int rhy;
    public String rhz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            if (this.rhu != null) {
                aVar.g(3, this.rhu);
            }
            aVar.fT(4, this.rfe);
            if (this.rhv != null) {
                aVar.g(5, this.rhv);
            }
            aVar.fT(6, this.rhw);
            if (this.rhx != null) {
                aVar.g(7, this.rhx);
            }
            if (this.reE != null) {
                aVar.g(8, this.reE);
            }
            aVar.fT(9, this.rhy);
            if (this.rhz != null) {
                aVar.g(10, this.rhz);
            }
            if (this.rhA != null) {
                aVar.g(11, this.rhA);
            }
            if (this.rhB != null) {
                aVar.fV(12, this.rhB.boi());
                this.rhB.a(aVar);
            }
            if (this.iwP != null) {
                aVar.g(13, this.iwP);
            }
            aVar.fT(14, this.rhC);
            aVar.fT(15, this.rhD);
            if (this.reS != null) {
                aVar.g(16, this.reS);
            }
            aVar.fT(17, this.rhE);
            if (this.rhF == null) {
                return 0;
            }
            aVar.g(18, this.rhF);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(2, this.hbL);
            }
            if (this.rhu != null) {
                fS += f.a.a.b.b.a.h(3, this.rhu);
            }
            fS += f.a.a.a.fQ(4, this.rfe);
            if (this.rhv != null) {
                fS += f.a.a.b.b.a.h(5, this.rhv);
            }
            fS += f.a.a.a.fQ(6, this.rhw);
            if (this.rhx != null) {
                fS += f.a.a.b.b.a.h(7, this.rhx);
            }
            if (this.reE != null) {
                fS += f.a.a.b.b.a.h(8, this.reE);
            }
            fS += f.a.a.a.fQ(9, this.rhy);
            if (this.rhz != null) {
                fS += f.a.a.b.b.a.h(10, this.rhz);
            }
            if (this.rhA != null) {
                fS += f.a.a.b.b.a.h(11, this.rhA);
            }
            if (this.rhB != null) {
                fS += f.a.a.a.fS(12, this.rhB.boi());
            }
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(13, this.iwP);
            }
            fS = (fS + f.a.a.a.fQ(14, this.rhC)) + f.a.a.a.fQ(15, this.rhD);
            if (this.reS != null) {
                fS += f.a.a.b.b.a.h(16, this.reS);
            }
            fS += f.a.a.a.fQ(17, this.rhE);
            if (this.rhF != null) {
                fS += f.a.a.b.b.a.h(18, this.rhF);
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
            hg hgVar = (hg) objArr[1];
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
                        hgVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    hgVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hgVar.rhu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    hgVar.rfe = aVar3.vHC.rY();
                    return 0;
                case 5:
                    hgVar.rhv = aVar3.vHC.readString();
                    return 0;
                case 6:
                    hgVar.rhw = aVar3.vHC.rY();
                    return 0;
                case 7:
                    hgVar.rhx = aVar3.vHC.readString();
                    return 0;
                case 8:
                    hgVar.reE = aVar3.vHC.readString();
                    return 0;
                case 9:
                    hgVar.rhy = aVar3.vHC.rY();
                    return 0;
                case 10:
                    hgVar.rhz = aVar3.vHC.readString();
                    return 0;
                case 11:
                    hgVar.rhA = aVar3.vHC.readString();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        hgVar.rhB = bhy;
                    }
                    return 0;
                case 13:
                    hgVar.iwP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    hgVar.rhC = aVar3.vHC.rY();
                    return 0;
                case 15:
                    hgVar.rhD = aVar3.vHC.rY();
                    return 0;
                case 16:
                    hgVar.reS = aVar3.vHC.readString();
                    return 0;
                case 17:
                    hgVar.rhE = aVar3.vHC.rY();
                    return 0;
                case 18:
                    hgVar.rhF = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
