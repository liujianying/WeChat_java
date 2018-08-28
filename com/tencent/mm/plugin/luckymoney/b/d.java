package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bk.a;

public final class d extends a {
    public int hUw;
    public int kKQ;
    public double kKR;
    public double kKS;
    public double kKT;
    public double kKU;
    public String kKV;
    public String kKW;
    public String kPE;
    public String kPF;
    public int kPG;
    public String kPH;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.kKQ);
            aVar.c(2, this.kKT);
            if (this.kPE != null) {
                aVar.g(3, this.kPE);
            }
            if (this.kPF != null) {
                aVar.g(4, this.kPF);
            }
            aVar.c(5, this.kKR);
            aVar.c(6, this.kKU);
            aVar.c(7, this.kKS);
            aVar.fT(8, this.kPG);
            aVar.fT(9, this.hUw);
            if (this.kKV != null) {
                aVar.g(10, this.kKV);
            }
            if (this.kKW != null) {
                aVar.g(11, this.kKW);
            }
            if (this.kPH != null) {
                aVar.g(12, this.kPH);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.kKQ) + 0) + (f.a.a.b.b.a.ec(2) + 8);
            if (this.kPE != null) {
                fQ += f.a.a.b.b.a.h(3, this.kPE);
            }
            if (this.kPF != null) {
                fQ += f.a.a.b.b.a.h(4, this.kPF);
            }
            fQ = ((((fQ + (f.a.a.b.b.a.ec(5) + 8)) + (f.a.a.b.b.a.ec(6) + 8)) + (f.a.a.b.b.a.ec(7) + 8)) + f.a.a.a.fQ(8, this.kPG)) + f.a.a.a.fQ(9, this.hUw);
            if (this.kKV != null) {
                fQ += f.a.a.b.b.a.h(10, this.kKV);
            }
            if (this.kKW != null) {
                fQ += f.a.a.b.b.a.h(11, this.kKW);
            }
            if (this.kPH != null) {
                return fQ + f.a.a.b.b.a.h(12, this.kPH);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.kKQ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    dVar.kKT = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    dVar.kPE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    dVar.kPF = aVar3.vHC.readString();
                    return 0;
                case 5:
                    dVar.kKR = aVar3.vHC.readDouble();
                    return 0;
                case 6:
                    dVar.kKU = aVar3.vHC.readDouble();
                    return 0;
                case 7:
                    dVar.kKS = aVar3.vHC.readDouble();
                    return 0;
                case 8:
                    dVar.kPG = aVar3.vHC.rY();
                    return 0;
                case 9:
                    dVar.hUw = aVar3.vHC.rY();
                    return 0;
                case 10:
                    dVar.kKV = aVar3.vHC.readString();
                    return 0;
                case 11:
                    dVar.kKW = aVar3.vHC.readString();
                    return 0;
                case 12:
                    dVar.kPH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
