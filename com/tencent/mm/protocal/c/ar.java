package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ar extends a {
    public String eJM;
    public String hbL;
    public String hcS;
    public int hcd;
    public String raA;
    public int raB;
    public int raC;
    public String raD;
    public int raE;
    public String raF;
    public String raG;
    public int raH;
    public String raI;
    public int ray;
    public String raz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            aVar.fT(3, this.ray);
            if (this.raz != null) {
                aVar.g(4, this.raz);
            }
            if (this.raA != null) {
                aVar.g(5, this.raA);
            }
            if (this.eJM != null) {
                aVar.g(6, this.eJM);
            }
            aVar.fT(8, this.hcd);
            aVar.fT(9, this.raB);
            aVar.fT(10, this.raC);
            if (this.raD != null) {
                aVar.g(11, this.raD);
            }
            aVar.fT(12, this.raE);
            if (this.raF != null) {
                aVar.g(13, this.raF);
            }
            if (this.raG != null) {
                aVar.g(14, this.raG);
            }
            aVar.fT(15, this.raH);
            if (this.raI == null) {
                return 0;
            }
            aVar.g(16, this.raI);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            h += f.a.a.a.fQ(3, this.ray);
            if (this.raz != null) {
                h += f.a.a.b.b.a.h(4, this.raz);
            }
            if (this.raA != null) {
                h += f.a.a.b.b.a.h(5, this.raA);
            }
            if (this.eJM != null) {
                h += f.a.a.b.b.a.h(6, this.eJM);
            }
            h = ((h + f.a.a.a.fQ(8, this.hcd)) + f.a.a.a.fQ(9, this.raB)) + f.a.a.a.fQ(10, this.raC);
            if (this.raD != null) {
                h += f.a.a.b.b.a.h(11, this.raD);
            }
            h += f.a.a.a.fQ(12, this.raE);
            if (this.raF != null) {
                h += f.a.a.b.b.a.h(13, this.raF);
            }
            if (this.raG != null) {
                h += f.a.a.b.b.a.h(14, this.raG);
            }
            h += f.a.a.a.fQ(15, this.raH);
            if (this.raI != null) {
                h += f.a.a.b.b.a.h(16, this.raI);
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
            ar arVar = (ar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    arVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    arVar.ray = aVar3.vHC.rY();
                    return 0;
                case 4:
                    arVar.raz = aVar3.vHC.readString();
                    return 0;
                case 5:
                    arVar.raA = aVar3.vHC.readString();
                    return 0;
                case 6:
                    arVar.eJM = aVar3.vHC.readString();
                    return 0;
                case 8:
                    arVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 9:
                    arVar.raB = aVar3.vHC.rY();
                    return 0;
                case 10:
                    arVar.raC = aVar3.vHC.rY();
                    return 0;
                case 11:
                    arVar.raD = aVar3.vHC.readString();
                    return 0;
                case 12:
                    arVar.raE = aVar3.vHC.rY();
                    return 0;
                case 13:
                    arVar.raF = aVar3.vHC.readString();
                    return 0;
                case 14:
                    arVar.raG = aVar3.vHC.readString();
                    return 0;
                case 15:
                    arVar.raH = aVar3.vHC.rY();
                    return 0;
                case 16:
                    arVar.raI = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
