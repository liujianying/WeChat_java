package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aly extends a {
    public int cCV;
    public long cCW;
    public String cCX;
    public String cCY;
    public String cCZ;
    public String cDa;
    public String eJM;
    public String jOU;
    public String jPG;
    public int rOA;
    public String rOB;
    public String rOC;
    public String rOD;
    public String rOE;
    public int rOF;
    public String rOv;
    public String rOw;
    public int rOx;
    public int rOy;
    public int rOz;
    public String reA;
    public String rgL;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rOv != null) {
                aVar.g(1, this.rOv);
            }
            if (this.reA != null) {
                aVar.g(2, this.reA);
            }
            if (this.rgL != null) {
                aVar.g(3, this.rgL);
            }
            if (this.rOw != null) {
                aVar.g(4, this.rOw);
            }
            aVar.fT(5, this.rOx);
            aVar.fT(6, this.rOy);
            aVar.fT(7, this.rOz);
            aVar.fT(8, this.rOA);
            if (this.rOB != null) {
                aVar.g(9, this.rOB);
            }
            if (this.eJM != null) {
                aVar.g(10, this.eJM);
            }
            if (this.jPG != null) {
                aVar.g(11, this.jPG);
            }
            if (this.jOU != null) {
                aVar.g(12, this.jOU);
            }
            if (this.rOC != null) {
                aVar.g(13, this.rOC);
            }
            if (this.rOD != null) {
                aVar.g(14, this.rOD);
            }
            if (this.rOE != null) {
                aVar.g(15, this.rOE);
            }
            aVar.fT(16, this.rOF);
            aVar.fT(17, this.cCV);
            aVar.T(18, this.cCW);
            if (this.cCX != null) {
                aVar.g(19, this.cCX);
            }
            if (this.cCY != null) {
                aVar.g(20, this.cCY);
            }
            if (this.cCZ != null) {
                aVar.g(21, this.cCZ);
            }
            if (this.cDa == null) {
                return 0;
            }
            aVar.g(22, this.cDa);
            return 0;
        } else if (i == 1) {
            if (this.rOv != null) {
                h = f.a.a.b.b.a.h(1, this.rOv) + 0;
            } else {
                h = 0;
            }
            if (this.reA != null) {
                h += f.a.a.b.b.a.h(2, this.reA);
            }
            if (this.rgL != null) {
                h += f.a.a.b.b.a.h(3, this.rgL);
            }
            if (this.rOw != null) {
                h += f.a.a.b.b.a.h(4, this.rOw);
            }
            h = (((h + f.a.a.a.fQ(5, this.rOx)) + f.a.a.a.fQ(6, this.rOy)) + f.a.a.a.fQ(7, this.rOz)) + f.a.a.a.fQ(8, this.rOA);
            if (this.rOB != null) {
                h += f.a.a.b.b.a.h(9, this.rOB);
            }
            if (this.eJM != null) {
                h += f.a.a.b.b.a.h(10, this.eJM);
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(11, this.jPG);
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(12, this.jOU);
            }
            if (this.rOC != null) {
                h += f.a.a.b.b.a.h(13, this.rOC);
            }
            if (this.rOD != null) {
                h += f.a.a.b.b.a.h(14, this.rOD);
            }
            if (this.rOE != null) {
                h += f.a.a.b.b.a.h(15, this.rOE);
            }
            h = ((h + f.a.a.a.fQ(16, this.rOF)) + f.a.a.a.fQ(17, this.cCV)) + f.a.a.a.S(18, this.cCW);
            if (this.cCX != null) {
                h += f.a.a.b.b.a.h(19, this.cCX);
            }
            if (this.cCY != null) {
                h += f.a.a.b.b.a.h(20, this.cCY);
            }
            if (this.cCZ != null) {
                h += f.a.a.b.b.a.h(21, this.cCZ);
            }
            if (this.cDa != null) {
                h += f.a.a.b.b.a.h(22, this.cDa);
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
            aly aly = (aly) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aly.rOv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aly.reA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aly.rgL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aly.rOw = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aly.rOx = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aly.rOy = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aly.rOz = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aly.rOA = aVar3.vHC.rY();
                    return 0;
                case 9:
                    aly.rOB = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aly.eJM = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aly.jPG = aVar3.vHC.readString();
                    return 0;
                case 12:
                    aly.jOU = aVar3.vHC.readString();
                    return 0;
                case 13:
                    aly.rOC = aVar3.vHC.readString();
                    return 0;
                case 14:
                    aly.rOD = aVar3.vHC.readString();
                    return 0;
                case 15:
                    aly.rOE = aVar3.vHC.readString();
                    return 0;
                case 16:
                    aly.rOF = aVar3.vHC.rY();
                    return 0;
                case 17:
                    aly.cCV = aVar3.vHC.rY();
                    return 0;
                case 18:
                    aly.cCW = aVar3.vHC.rZ();
                    return 0;
                case 19:
                    aly.cCX = aVar3.vHC.readString();
                    return 0;
                case 20:
                    aly.cCY = aVar3.vHC.readString();
                    return 0;
                case 21:
                    aly.cCZ = aVar3.vHC.readString();
                    return 0;
                case 22:
                    aly.cDa = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
