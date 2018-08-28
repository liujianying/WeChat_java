package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class axj extends a {
    public String jPc;
    public int jPj;
    public String jPy;
    public String jSv;
    public String rbh;
    public String rbj;
    public String ris;
    public int riv;
    public String sas;
    public String sat;
    public String sau;
    public String sav;
    public String saw;
    public String sax;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc != null) {
                aVar.g(1, this.jPc);
            }
            if (this.jSv != null) {
                aVar.g(2, this.jSv);
            }
            if (this.sas != null) {
                aVar.g(3, this.sas);
            }
            if (this.rbh != null) {
                aVar.g(4, this.rbh);
            }
            if (this.jPy != null) {
                aVar.g(5, this.jPy);
            }
            aVar.fT(6, this.riv);
            if (this.sat != null) {
                aVar.g(7, this.sat);
            }
            if (this.rbj != null) {
                aVar.g(8, this.rbj);
            }
            if (this.ris != null) {
                aVar.g(9, this.ris);
            }
            if (this.sau != null) {
                aVar.g(10, this.sau);
            }
            if (this.sav != null) {
                aVar.g(11, this.sav);
            }
            if (this.saw != null) {
                aVar.g(12, this.saw);
            }
            if (this.sax != null) {
                aVar.g(13, this.sax);
            }
            aVar.fT(14, this.jPj);
            return 0;
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(2, this.jSv);
            }
            if (this.sas != null) {
                h += f.a.a.b.b.a.h(3, this.sas);
            }
            if (this.rbh != null) {
                h += f.a.a.b.b.a.h(4, this.rbh);
            }
            if (this.jPy != null) {
                h += f.a.a.b.b.a.h(5, this.jPy);
            }
            h += f.a.a.a.fQ(6, this.riv);
            if (this.sat != null) {
                h += f.a.a.b.b.a.h(7, this.sat);
            }
            if (this.rbj != null) {
                h += f.a.a.b.b.a.h(8, this.rbj);
            }
            if (this.ris != null) {
                h += f.a.a.b.b.a.h(9, this.ris);
            }
            if (this.sau != null) {
                h += f.a.a.b.b.a.h(10, this.sau);
            }
            if (this.sav != null) {
                h += f.a.a.b.b.a.h(11, this.sav);
            }
            if (this.saw != null) {
                h += f.a.a.b.b.a.h(12, this.saw);
            }
            if (this.sax != null) {
                h += f.a.a.b.b.a.h(13, this.sax);
            }
            return h + f.a.a.a.fQ(14, this.jPj);
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
            axj axj = (axj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axj.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    axj.jSv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    axj.sas = aVar3.vHC.readString();
                    return 0;
                case 4:
                    axj.rbh = aVar3.vHC.readString();
                    return 0;
                case 5:
                    axj.jPy = aVar3.vHC.readString();
                    return 0;
                case 6:
                    axj.riv = aVar3.vHC.rY();
                    return 0;
                case 7:
                    axj.sat = aVar3.vHC.readString();
                    return 0;
                case 8:
                    axj.rbj = aVar3.vHC.readString();
                    return 0;
                case 9:
                    axj.ris = aVar3.vHC.readString();
                    return 0;
                case 10:
                    axj.sau = aVar3.vHC.readString();
                    return 0;
                case 11:
                    axj.sav = aVar3.vHC.readString();
                    return 0;
                case 12:
                    axj.saw = aVar3.vHC.readString();
                    return 0;
                case 13:
                    axj.sax = aVar3.vHC.readString();
                    return 0;
                case 14:
                    axj.jPj = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
