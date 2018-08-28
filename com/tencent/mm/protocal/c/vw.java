package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class vw extends a {
    public int hcd;
    public String rmy;
    public int rmz;
    public String rro;
    public String rrp;
    public String rrq;
    public int rrr;
    public String rze;
    public String rzf;
    public int rzg;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rro != null) {
                aVar.g(1, this.rro);
            }
            if (this.rrp != null) {
                aVar.g(2, this.rrp);
            }
            if (this.rrq != null) {
                aVar.g(3, this.rrq);
            }
            aVar.fT(4, this.rrr);
            if (this.rze != null) {
                aVar.g(5, this.rze);
            }
            if (this.rmy != null) {
                aVar.g(6, this.rmy);
            }
            aVar.fT(7, this.rmz);
            if (this.rzf != null) {
                aVar.g(8, this.rzf);
            }
            aVar.fT(9, this.hcd);
            aVar.fT(10, this.rzg);
            return 0;
        } else if (i == 1) {
            if (this.rro != null) {
                h = f.a.a.b.b.a.h(1, this.rro) + 0;
            } else {
                h = 0;
            }
            if (this.rrp != null) {
                h += f.a.a.b.b.a.h(2, this.rrp);
            }
            if (this.rrq != null) {
                h += f.a.a.b.b.a.h(3, this.rrq);
            }
            h += f.a.a.a.fQ(4, this.rrr);
            if (this.rze != null) {
                h += f.a.a.b.b.a.h(5, this.rze);
            }
            if (this.rmy != null) {
                h += f.a.a.b.b.a.h(6, this.rmy);
            }
            h += f.a.a.a.fQ(7, this.rmz);
            if (this.rzf != null) {
                h += f.a.a.b.b.a.h(8, this.rzf);
            }
            return (h + f.a.a.a.fQ(9, this.hcd)) + f.a.a.a.fQ(10, this.rzg);
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
            vw vwVar = (vw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vwVar.rro = aVar3.vHC.readString();
                    return 0;
                case 2:
                    vwVar.rrp = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vwVar.rrq = aVar3.vHC.readString();
                    return 0;
                case 4:
                    vwVar.rrr = aVar3.vHC.rY();
                    return 0;
                case 5:
                    vwVar.rze = aVar3.vHC.readString();
                    return 0;
                case 6:
                    vwVar.rmy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    vwVar.rmz = aVar3.vHC.rY();
                    return 0;
                case 8:
                    vwVar.rzf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    vwVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 10:
                    vwVar.rzg = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
