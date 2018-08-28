package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class asq extends bhd {
    public String dkY;
    public String eJK;
    public String hbP;
    public String iwO;
    public String iwP;
    public int jRa;
    public int qZe;
    public String rEt;
    public String rUU;
    public String rUV;
    public String rUW;
    public int rUX;
    public fi reP;
    public String reQ;
    public int reR;
    public String reS;
    public String reT;
    public String rjL;
    public String rjM;
    public String rwh;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.reP != null) {
                aVar.fV(2, this.reP.boi());
                this.reP.a(aVar);
            }
            if (this.dkY != null) {
                aVar.g(3, this.dkY);
            }
            if (this.reQ != null) {
                aVar.g(4, this.reQ);
            }
            aVar.fT(5, this.reR);
            if (this.reS != null) {
                aVar.g(6, this.reS);
            }
            if (this.eJK != null) {
                aVar.g(7, this.eJK);
            }
            if (this.hbP != null) {
                aVar.g(8, this.hbP);
            }
            if (this.reT != null) {
                aVar.g(9, this.reT);
            }
            if (this.iwP != null) {
                aVar.g(10, this.iwP);
            }
            if (this.iwO != null) {
                aVar.g(11, this.iwO);
            }
            aVar.fT(13, this.qZe);
            aVar.fT(14, this.jRa);
            if (this.rjM != null) {
                aVar.g(15, this.rjM);
            }
            if (this.rjL != null) {
                aVar.g(16, this.rjL);
            }
            if (this.rUU != null) {
                aVar.g(17, this.rUU);
            }
            if (this.rwh != null) {
                aVar.g(18, this.rwh);
            }
            if (this.rEt != null) {
                aVar.g(19, this.rEt);
            }
            if (this.rUV != null) {
                aVar.g(20, this.rUV);
            }
            if (this.rUW != null) {
                aVar.g(21, this.rUW);
            }
            aVar.fT(22, this.rUX);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.reP != null) {
                fS += f.a.a.a.fS(2, this.reP.boi());
            }
            if (this.dkY != null) {
                fS += f.a.a.b.b.a.h(3, this.dkY);
            }
            if (this.reQ != null) {
                fS += f.a.a.b.b.a.h(4, this.reQ);
            }
            fS += f.a.a.a.fQ(5, this.reR);
            if (this.reS != null) {
                fS += f.a.a.b.b.a.h(6, this.reS);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(7, this.eJK);
            }
            if (this.hbP != null) {
                fS += f.a.a.b.b.a.h(8, this.hbP);
            }
            if (this.reT != null) {
                fS += f.a.a.b.b.a.h(9, this.reT);
            }
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(10, this.iwP);
            }
            if (this.iwO != null) {
                fS += f.a.a.b.b.a.h(11, this.iwO);
            }
            fS = (fS + f.a.a.a.fQ(13, this.qZe)) + f.a.a.a.fQ(14, this.jRa);
            if (this.rjM != null) {
                fS += f.a.a.b.b.a.h(15, this.rjM);
            }
            if (this.rjL != null) {
                fS += f.a.a.b.b.a.h(16, this.rjL);
            }
            if (this.rUU != null) {
                fS += f.a.a.b.b.a.h(17, this.rUU);
            }
            if (this.rwh != null) {
                fS += f.a.a.b.b.a.h(18, this.rwh);
            }
            if (this.rEt != null) {
                fS += f.a.a.b.b.a.h(19, this.rEt);
            }
            if (this.rUV != null) {
                fS += f.a.a.b.b.a.h(20, this.rUV);
            }
            if (this.rUW != null) {
                fS += f.a.a.b.b.a.h(21, this.rUW);
            }
            return fS + f.a.a.a.fQ(22, this.rUX);
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
            asq asq = (asq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            com.tencent.mm.bk.a fkVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        asq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        asq.reP = fkVar;
                    }
                    return 0;
                case 3:
                    asq.dkY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    asq.reQ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    asq.reR = aVar3.vHC.rY();
                    return 0;
                case 6:
                    asq.reS = aVar3.vHC.readString();
                    return 0;
                case 7:
                    asq.eJK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    asq.hbP = aVar3.vHC.readString();
                    return 0;
                case 9:
                    asq.reT = aVar3.vHC.readString();
                    return 0;
                case 10:
                    asq.iwP = aVar3.vHC.readString();
                    return 0;
                case 11:
                    asq.iwO = aVar3.vHC.readString();
                    return 0;
                case 13:
                    asq.qZe = aVar3.vHC.rY();
                    return 0;
                case 14:
                    asq.jRa = aVar3.vHC.rY();
                    return 0;
                case 15:
                    asq.rjM = aVar3.vHC.readString();
                    return 0;
                case 16:
                    asq.rjL = aVar3.vHC.readString();
                    return 0;
                case 17:
                    asq.rUU = aVar3.vHC.readString();
                    return 0;
                case 18:
                    asq.rwh = aVar3.vHC.readString();
                    return 0;
                case 19:
                    asq.rEt = aVar3.vHC.readString();
                    return 0;
                case 20:
                    asq.rUV = aVar3.vHC.readString();
                    return 0;
                case 21:
                    asq.rUW = aVar3.vHC.readString();
                    return 0;
                case 22:
                    asq.rUX = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
