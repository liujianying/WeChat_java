package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class arj extends a {
    public float biF;
    public String country;
    public String eJJ;
    public String kFa;
    public int nOB;
    public int nOD;
    public String nOz;
    public String rTG;
    public String rTH;
    public int rTI;
    public int rTJ;
    public b rTK;
    public String rTL;
    public float rmr;
    public float rms;
    public int score;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.l(1, this.rmr);
            aVar.l(2, this.rms);
            if (this.eJJ != null) {
                aVar.g(3, this.eJJ);
            }
            if (this.kFa != null) {
                aVar.g(4, this.kFa);
            }
            if (this.nOz != null) {
                aVar.g(5, this.nOz);
            }
            if (this.rTG != null) {
                aVar.g(6, this.rTG);
            }
            aVar.fT(7, this.nOB);
            if (this.rTH != null) {
                aVar.g(8, this.rTH);
            }
            aVar.fT(9, this.rTI);
            aVar.fT(10, this.rTJ);
            aVar.fT(11, this.nOD);
            aVar.l(12, this.biF);
            if (this.rTK != null) {
                aVar.b(13, this.rTK);
            }
            aVar.fT(14, this.score);
            if (this.rTL != null) {
                aVar.g(15, this.rTL);
            }
            if (this.country != null) {
                aVar.g(16, this.country);
            }
            return 0;
        } else if (i == 1) {
            ec = ((f.a.a.b.b.a.ec(1) + 4) + 0) + (f.a.a.b.b.a.ec(2) + 4);
            if (this.eJJ != null) {
                ec += f.a.a.b.b.a.h(3, this.eJJ);
            }
            if (this.kFa != null) {
                ec += f.a.a.b.b.a.h(4, this.kFa);
            }
            if (this.nOz != null) {
                ec += f.a.a.b.b.a.h(5, this.nOz);
            }
            if (this.rTG != null) {
                ec += f.a.a.b.b.a.h(6, this.rTG);
            }
            ec += f.a.a.a.fQ(7, this.nOB);
            if (this.rTH != null) {
                ec += f.a.a.b.b.a.h(8, this.rTH);
            }
            ec = (((ec + f.a.a.a.fQ(9, this.rTI)) + f.a.a.a.fQ(10, this.rTJ)) + f.a.a.a.fQ(11, this.nOD)) + (f.a.a.b.b.a.ec(12) + 4);
            if (this.rTK != null) {
                ec += f.a.a.a.a(13, this.rTK);
            }
            ec += f.a.a.a.fQ(14, this.score);
            if (this.rTL != null) {
                ec += f.a.a.b.b.a.h(15, this.rTL);
            }
            if (this.country != null) {
                return ec + f.a.a.b.b.a.h(16, this.country);
            }
            return ec;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            arj arj = (arj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arj.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 2:
                    arj.rms = aVar3.vHC.readFloat();
                    return 0;
                case 3:
                    arj.eJJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    arj.kFa = aVar3.vHC.readString();
                    return 0;
                case 5:
                    arj.nOz = aVar3.vHC.readString();
                    return 0;
                case 6:
                    arj.rTG = aVar3.vHC.readString();
                    return 0;
                case 7:
                    arj.nOB = aVar3.vHC.rY();
                    return 0;
                case 8:
                    arj.rTH = aVar3.vHC.readString();
                    return 0;
                case 9:
                    arj.rTI = aVar3.vHC.rY();
                    return 0;
                case 10:
                    arj.rTJ = aVar3.vHC.rY();
                    return 0;
                case 11:
                    arj.nOD = aVar3.vHC.rY();
                    return 0;
                case 12:
                    arj.biF = aVar3.vHC.readFloat();
                    return 0;
                case 13:
                    arj.rTK = aVar3.cJR();
                    return 0;
                case 14:
                    arj.score = aVar3.vHC.rY();
                    return 0;
                case 15:
                    arj.rTL = aVar3.vHC.readString();
                    return 0;
                case 16:
                    arj.country = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
