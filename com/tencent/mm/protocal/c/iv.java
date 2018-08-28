package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class iv extends a {
    public String bPS;
    public int rka;
    public int rkb;
    public String rkc;
    public int rkd;
    public String rke;
    public int rkf;
    public int rkg;
    public int rkh;
    public String rki;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            aVar.fT(2, this.rka);
            aVar.fT(3, this.rkb);
            if (this.rkc != null) {
                aVar.g(4, this.rkc);
            }
            aVar.fT(5, this.rkd);
            if (this.rke != null) {
                aVar.g(6, this.rke);
            }
            aVar.fT(7, this.rkf);
            aVar.fT(8, this.rkg);
            aVar.fT(9, this.rkh);
            if (this.rki == null) {
                return 0;
            }
            aVar.g(10, this.rki);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.rka)) + f.a.a.a.fQ(3, this.rkb);
            if (this.rkc != null) {
                h += f.a.a.b.b.a.h(4, this.rkc);
            }
            h += f.a.a.a.fQ(5, this.rkd);
            if (this.rke != null) {
                h += f.a.a.b.b.a.h(6, this.rke);
            }
            h = ((h + f.a.a.a.fQ(7, this.rkf)) + f.a.a.a.fQ(8, this.rkg)) + f.a.a.a.fQ(9, this.rkh);
            if (this.rki != null) {
                h += f.a.a.b.b.a.h(10, this.rki);
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
            iv ivVar = (iv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ivVar.bPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ivVar.rka = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ivVar.rkb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ivVar.rkc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ivVar.rkd = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ivVar.rke = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ivVar.rkf = aVar3.vHC.rY();
                    return 0;
                case 8:
                    ivVar.rkg = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ivVar.rkh = aVar3.vHC.rY();
                    return 0;
                case 10:
                    ivVar.rki = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
