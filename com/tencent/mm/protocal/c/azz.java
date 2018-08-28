package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class azz extends a {
    public String jSv;
    public String lOE;
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
    public LinkedList<bnt> lOT = new LinkedList();
    public int scI;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lOE != null) {
                aVar.g(1, this.lOE);
            }
            aVar.fT(2, this.scI);
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
            return 0;
        } else if (i == 1) {
            if (this.lOE != null) {
                h = f.a.a.b.b.a.h(1, this.lOE) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.scI);
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
            return (h + f.a.a.a.fQ(16, this.lOS)) + f.a.a.a.c(17, 8, this.lOT);
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
            azz azz = (azz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azz.lOE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    azz.scI = aVar3.vHC.rY();
                    return 0;
                case 3:
                    azz.lOG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    azz.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    azz.lOI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    azz.lOJ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    azz.lOK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    azz.lOL = aVar3.vHC.rY();
                    return 0;
                case 9:
                    azz.lOM = aVar3.vHC.rY();
                    return 0;
                case 10:
                    azz.lON = aVar3.vHC.readString();
                    return 0;
                case 11:
                    azz.jSv = aVar3.vHC.readString();
                    return 0;
                case 12:
                    azz.lOO = aVar3.vHC.readString();
                    return 0;
                case 13:
                    azz.lOP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    azz.lOQ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    azz.lOR = aVar3.vHC.readString();
                    return 0;
                case 16:
                    azz.lOS = aVar3.vHC.rY();
                    return 0;
                case 17:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnt bnt = new bnt();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bnt.a(aVar4, bnt, a.a(aVar4))) {
                        }
                        azz.lOT.add(bnt);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
