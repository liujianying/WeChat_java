package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class amx extends a {
    public int hcy;
    public String jPK;
    public String jPe;
    public String rPJ;
    public String rmC;
    public String rmy;
    public String rwk;
    public String rxo;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rxo != null) {
                aVar.g(1, this.rxo);
            }
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            aVar.fT(3, this.hcy);
            if (this.rwk != null) {
                aVar.g(4, this.rwk);
            }
            if (this.rmC != null) {
                aVar.g(5, this.rmC);
            }
            if (this.rmy != null) {
                aVar.g(6, this.rmy);
            }
            if (this.jPK != null) {
                aVar.g(7, this.jPK);
            }
            if (this.rPJ == null) {
                return 0;
            }
            aVar.g(8, this.rPJ);
            return 0;
        } else if (i == 1) {
            if (this.rxo != null) {
                h = f.a.a.b.b.a.h(1, this.rxo) + 0;
            } else {
                h = 0;
            }
            if (this.jPe != null) {
                h += f.a.a.b.b.a.h(2, this.jPe);
            }
            h += f.a.a.a.fQ(3, this.hcy);
            if (this.rwk != null) {
                h += f.a.a.b.b.a.h(4, this.rwk);
            }
            if (this.rmC != null) {
                h += f.a.a.b.b.a.h(5, this.rmC);
            }
            if (this.rmy != null) {
                h += f.a.a.b.b.a.h(6, this.rmy);
            }
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(7, this.jPK);
            }
            if (this.rPJ != null) {
                h += f.a.a.b.b.a.h(8, this.rPJ);
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
            amx amx = (amx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amx.rxo = aVar3.vHC.readString();
                    return 0;
                case 2:
                    amx.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    amx.hcy = aVar3.vHC.rY();
                    return 0;
                case 4:
                    amx.rwk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    amx.rmC = aVar3.vHC.readString();
                    return 0;
                case 6:
                    amx.rmy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    amx.jPK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    amx.rPJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
