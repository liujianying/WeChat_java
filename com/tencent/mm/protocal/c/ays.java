package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public class ays extends a {
    public String eJI;
    public String eJJ;
    public String jPe;
    public String lCN;
    public double rji;
    public double rjj;
    public String ruY;
    public String ruZ;
    public String sbw;
    public String sbx;
    public String sby;
    public String sbz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPe != null) {
                aVar.g(1, this.jPe);
            }
            if (this.sbw != null) {
                aVar.g(2, this.sbw);
            }
            aVar.c(3, this.rji);
            aVar.c(4, this.rjj);
            if (this.sbx != null) {
                aVar.g(5, this.sbx);
            }
            if (this.lCN != null) {
                aVar.g(6, this.lCN);
            }
            if (this.sby != null) {
                aVar.g(7, this.sby);
            }
            if (this.eJI != null) {
                aVar.g(8, this.eJI);
            }
            if (this.eJJ != null) {
                aVar.g(9, this.eJJ);
            }
            if (this.ruY != null) {
                aVar.g(10, this.ruY);
            }
            if (this.ruZ != null) {
                aVar.g(11, this.ruZ);
            }
            if (this.sbz == null) {
                return 0;
            }
            aVar.g(12, this.sbz);
            return 0;
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            if (this.sbw != null) {
                h += f.a.a.b.b.a.h(2, this.sbw);
            }
            h = (h + (f.a.a.b.b.a.ec(3) + 8)) + (f.a.a.b.b.a.ec(4) + 8);
            if (this.sbx != null) {
                h += f.a.a.b.b.a.h(5, this.sbx);
            }
            if (this.lCN != null) {
                h += f.a.a.b.b.a.h(6, this.lCN);
            }
            if (this.sby != null) {
                h += f.a.a.b.b.a.h(7, this.sby);
            }
            if (this.eJI != null) {
                h += f.a.a.b.b.a.h(8, this.eJI);
            }
            if (this.eJJ != null) {
                h += f.a.a.b.b.a.h(9, this.eJJ);
            }
            if (this.ruY != null) {
                h += f.a.a.b.b.a.h(10, this.ruY);
            }
            if (this.ruZ != null) {
                h += f.a.a.b.b.a.h(11, this.ruZ);
            }
            if (this.sbz != null) {
                h += f.a.a.b.b.a.h(12, this.sbz);
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
            ays ays = (ays) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ays.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ays.sbw = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ays.rji = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    ays.rjj = aVar3.vHC.readDouble();
                    return 0;
                case 5:
                    ays.sbx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ays.lCN = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ays.sby = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ays.eJI = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ays.eJJ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ays.ruY = aVar3.vHC.readString();
                    return 0;
                case 11:
                    ays.ruZ = aVar3.vHC.readString();
                    return 0;
                case 12:
                    ays.sbz = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
