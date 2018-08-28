package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class fa extends a {
    public String bTi;
    public String plW;
    public String plY;
    public String plZ;
    public String pma;
    public String rfE;
    public String rfF;
    public String rfG;
    public String rfH;
    public String rfI;
    public String rfJ;
    public String rfK;
    public String rfL;
    public String rfM;
    public long rfN;
    public int rfO;
    public String rfP;
    public String rfQ;
    public String rfR;
    public String rfS;
    public fb rfT;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rfE != null) {
                aVar.g(1, this.rfE);
            }
            if (this.rfF != null) {
                aVar.g(2, this.rfF);
            }
            if (this.rfG != null) {
                aVar.g(3, this.rfG);
            }
            if (this.rfH != null) {
                aVar.g(4, this.rfH);
            }
            if (this.rfI != null) {
                aVar.g(5, this.rfI);
            }
            if (this.rfJ != null) {
                aVar.g(6, this.rfJ);
            }
            if (this.rfK != null) {
                aVar.g(7, this.rfK);
            }
            if (this.rfL != null) {
                aVar.g(8, this.rfL);
            }
            if (this.bTi != null) {
                aVar.g(9, this.bTi);
            }
            if (this.rfM != null) {
                aVar.g(10, this.rfM);
            }
            if (this.plY != null) {
                aVar.g(11, this.plY);
            }
            if (this.pma != null) {
                aVar.g(12, this.pma);
            }
            if (this.plZ != null) {
                aVar.g(13, this.plZ);
            }
            aVar.T(14, this.rfN);
            aVar.fT(15, this.rfO);
            if (this.rfP != null) {
                aVar.g(16, this.rfP);
            }
            if (this.rfQ != null) {
                aVar.g(17, this.rfQ);
            }
            if (this.rfR != null) {
                aVar.g(18, this.rfR);
            }
            if (this.plW != null) {
                aVar.g(19, this.plW);
            }
            if (this.rfS != null) {
                aVar.g(20, this.rfS);
            }
            if (this.rfT == null) {
                return 0;
            }
            aVar.fV(21, this.rfT.boi());
            this.rfT.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rfE != null) {
                h = f.a.a.b.b.a.h(1, this.rfE) + 0;
            } else {
                h = 0;
            }
            if (this.rfF != null) {
                h += f.a.a.b.b.a.h(2, this.rfF);
            }
            if (this.rfG != null) {
                h += f.a.a.b.b.a.h(3, this.rfG);
            }
            if (this.rfH != null) {
                h += f.a.a.b.b.a.h(4, this.rfH);
            }
            if (this.rfI != null) {
                h += f.a.a.b.b.a.h(5, this.rfI);
            }
            if (this.rfJ != null) {
                h += f.a.a.b.b.a.h(6, this.rfJ);
            }
            if (this.rfK != null) {
                h += f.a.a.b.b.a.h(7, this.rfK);
            }
            if (this.rfL != null) {
                h += f.a.a.b.b.a.h(8, this.rfL);
            }
            if (this.bTi != null) {
                h += f.a.a.b.b.a.h(9, this.bTi);
            }
            if (this.rfM != null) {
                h += f.a.a.b.b.a.h(10, this.rfM);
            }
            if (this.plY != null) {
                h += f.a.a.b.b.a.h(11, this.plY);
            }
            if (this.pma != null) {
                h += f.a.a.b.b.a.h(12, this.pma);
            }
            if (this.plZ != null) {
                h += f.a.a.b.b.a.h(13, this.plZ);
            }
            h = (h + f.a.a.a.S(14, this.rfN)) + f.a.a.a.fQ(15, this.rfO);
            if (this.rfP != null) {
                h += f.a.a.b.b.a.h(16, this.rfP);
            }
            if (this.rfQ != null) {
                h += f.a.a.b.b.a.h(17, this.rfQ);
            }
            if (this.rfR != null) {
                h += f.a.a.b.b.a.h(18, this.rfR);
            }
            if (this.plW != null) {
                h += f.a.a.b.b.a.h(19, this.plW);
            }
            if (this.rfS != null) {
                h += f.a.a.b.b.a.h(20, this.rfS);
            }
            if (this.rfT != null) {
                h += f.a.a.a.fS(21, this.rfT.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            fa faVar = (fa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    faVar.rfE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    faVar.rfF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    faVar.rfG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    faVar.rfH = aVar3.vHC.readString();
                    return 0;
                case 5:
                    faVar.rfI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    faVar.rfJ = aVar3.vHC.readString();
                    return 0;
                case 7:
                    faVar.rfK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    faVar.rfL = aVar3.vHC.readString();
                    return 0;
                case 9:
                    faVar.bTi = aVar3.vHC.readString();
                    return 0;
                case 10:
                    faVar.rfM = aVar3.vHC.readString();
                    return 0;
                case 11:
                    faVar.plY = aVar3.vHC.readString();
                    return 0;
                case 12:
                    faVar.pma = aVar3.vHC.readString();
                    return 0;
                case 13:
                    faVar.plZ = aVar3.vHC.readString();
                    return 0;
                case 14:
                    faVar.rfN = aVar3.vHC.rZ();
                    return 0;
                case 15:
                    faVar.rfO = aVar3.vHC.rY();
                    return 0;
                case 16:
                    faVar.rfP = aVar3.vHC.readString();
                    return 0;
                case 17:
                    faVar.rfQ = aVar3.vHC.readString();
                    return 0;
                case 18:
                    faVar.rfR = aVar3.vHC.readString();
                    return 0;
                case 19:
                    faVar.plW = aVar3.vHC.readString();
                    return 0;
                case 20:
                    faVar.rfS = aVar3.vHC.readString();
                    return 0;
                case 21:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fb fbVar = new fb();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fbVar.a(aVar4, fbVar, a.a(aVar4))) {
                        }
                        faVar.rfT = fbVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
