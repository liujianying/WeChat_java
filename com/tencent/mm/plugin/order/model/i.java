package com.tencent.mm.plugin.order.model;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class i extends a {
    public String jSv;
    public String lOE;
    public double lOF;
    public String lOG;
    public int lOH;
    public String lOI;
    public int lOJ;
    public String lOK;
    public int lOL;
    public int lOM;
    public String lON;
    public String lOO;
    public String lOP;
    public String lOQ;
    public String lOR;
    public int lOS;
    public LinkedList<k> lOT = new LinkedList();
    public String lOU;
    public String lOV;
    public double lOW;
    public String lOX;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lOE != null) {
                aVar.g(1, this.lOE);
            }
            aVar.c(2, this.lOF);
            if (this.lOG != null) {
                aVar.g(3, this.lOG);
            }
            aVar.fT(4, this.lOH);
            if (this.lOI != null) {
                aVar.g(5, this.lOI);
            }
            aVar.fT(6, this.lOJ);
            if (this.lOK != null) {
                aVar.g(7, this.lOK);
            }
            aVar.fT(8, this.lOL);
            aVar.fT(9, this.lOM);
            if (this.lON != null) {
                aVar.g(10, this.lON);
            }
            if (this.jSv != null) {
                aVar.g(11, this.jSv);
            }
            if (this.lOO != null) {
                aVar.g(12, this.lOO);
            }
            if (this.lOP != null) {
                aVar.g(13, this.lOP);
            }
            if (this.lOQ != null) {
                aVar.g(14, this.lOQ);
            }
            if (this.lOR != null) {
                aVar.g(15, this.lOR);
            }
            aVar.fT(16, this.lOS);
            aVar.d(17, 8, this.lOT);
            if (this.lOU != null) {
                aVar.g(18, this.lOU);
            }
            if (this.lOV != null) {
                aVar.g(19, this.lOV);
            }
            aVar.c(20, this.lOW);
            if (this.lOX == null) {
                return 0;
            }
            aVar.g(21, this.lOX);
            return 0;
        } else if (i == 1) {
            if (this.lOE != null) {
                h = f.a.a.b.b.a.h(1, this.lOE) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.b.b.a.ec(2) + 8;
            if (this.lOG != null) {
                h += f.a.a.b.b.a.h(3, this.lOG);
            }
            h += f.a.a.a.fQ(4, this.lOH);
            if (this.lOI != null) {
                h += f.a.a.b.b.a.h(5, this.lOI);
            }
            h += f.a.a.a.fQ(6, this.lOJ);
            if (this.lOK != null) {
                h += f.a.a.b.b.a.h(7, this.lOK);
            }
            h = (h + f.a.a.a.fQ(8, this.lOL)) + f.a.a.a.fQ(9, this.lOM);
            if (this.lON != null) {
                h += f.a.a.b.b.a.h(10, this.lON);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(11, this.jSv);
            }
            if (this.lOO != null) {
                h += f.a.a.b.b.a.h(12, this.lOO);
            }
            if (this.lOP != null) {
                h += f.a.a.b.b.a.h(13, this.lOP);
            }
            if (this.lOQ != null) {
                h += f.a.a.b.b.a.h(14, this.lOQ);
            }
            if (this.lOR != null) {
                h += f.a.a.b.b.a.h(15, this.lOR);
            }
            h = (h + f.a.a.a.fQ(16, this.lOS)) + f.a.a.a.c(17, 8, this.lOT);
            if (this.lOU != null) {
                h += f.a.a.b.b.a.h(18, this.lOU);
            }
            if (this.lOV != null) {
                h += f.a.a.b.b.a.h(19, this.lOV);
            }
            h += f.a.a.b.b.a.ec(20) + 8;
            if (this.lOX != null) {
                h += f.a.a.b.b.a.h(21, this.lOX);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.lOT.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.lOE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    iVar.lOF = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    iVar.lOG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    iVar.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    iVar.lOI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    iVar.lOJ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    iVar.lOK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    iVar.lOL = aVar3.vHC.rY();
                    return 0;
                case 9:
                    iVar.lOM = aVar3.vHC.rY();
                    return 0;
                case 10:
                    iVar.lON = aVar3.vHC.readString();
                    return 0;
                case 11:
                    iVar.jSv = aVar3.vHC.readString();
                    return 0;
                case 12:
                    iVar.lOO = aVar3.vHC.readString();
                    return 0;
                case 13:
                    iVar.lOP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    iVar.lOQ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    iVar.lOR = aVar3.vHC.readString();
                    return 0;
                case 16:
                    iVar.lOS = aVar3.vHC.rY();
                    return 0;
                case 17:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        k kVar = new k();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        iVar.lOT.add(kVar);
                    }
                    return 0;
                case 18:
                    iVar.lOU = aVar3.vHC.readString();
                    return 0;
                case 19:
                    iVar.lOV = aVar3.vHC.readString();
                    return 0;
                case 20:
                    iVar.lOW = aVar3.vHC.readDouble();
                    return 0;
                case 21:
                    iVar.lOX = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
