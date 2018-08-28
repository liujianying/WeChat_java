package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class ta extends a {
    public String jPK;
    public String lPl;
    public String rem;
    public String rwk;
    public String rwl;
    public String rwm;
    public String rwn;
    public String rwo;
    public String rwp;
    public String rwq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwk == null) {
                throw new b("Not all required fields were included: Md5");
            }
            if (this.rwk != null) {
                aVar.g(1, this.rwk);
            }
            if (this.jPK != null) {
                aVar.g(2, this.jPK);
            }
            if (this.lPl != null) {
                aVar.g(3, this.lPl);
            }
            if (this.rwl != null) {
                aVar.g(4, this.rwl);
            }
            if (this.rwm != null) {
                aVar.g(5, this.rwm);
            }
            if (this.rwn != null) {
                aVar.g(6, this.rwn);
            }
            if (this.rem != null) {
                aVar.g(7, this.rem);
            }
            if (this.rwo != null) {
                aVar.g(8, this.rwo);
            }
            if (this.rwp != null) {
                aVar.g(9, this.rwp);
            }
            if (this.rwq == null) {
                return 0;
            }
            aVar.g(10, this.rwq);
            return 0;
        } else if (i == 1) {
            if (this.rwk != null) {
                h = f.a.a.b.b.a.h(1, this.rwk) + 0;
            } else {
                h = 0;
            }
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(2, this.jPK);
            }
            if (this.lPl != null) {
                h += f.a.a.b.b.a.h(3, this.lPl);
            }
            if (this.rwl != null) {
                h += f.a.a.b.b.a.h(4, this.rwl);
            }
            if (this.rwm != null) {
                h += f.a.a.b.b.a.h(5, this.rwm);
            }
            if (this.rwn != null) {
                h += f.a.a.b.b.a.h(6, this.rwn);
            }
            if (this.rem != null) {
                h += f.a.a.b.b.a.h(7, this.rem);
            }
            if (this.rwo != null) {
                h += f.a.a.b.b.a.h(8, this.rwo);
            }
            if (this.rwp != null) {
                h += f.a.a.b.b.a.h(9, this.rwp);
            }
            if (this.rwq != null) {
                h += f.a.a.b.b.a.h(10, this.rwq);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rwk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Md5");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ta taVar = (ta) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    taVar.rwk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    taVar.jPK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    taVar.lPl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    taVar.rwl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    taVar.rwm = aVar3.vHC.readString();
                    return 0;
                case 6:
                    taVar.rwn = aVar3.vHC.readString();
                    return 0;
                case 7:
                    taVar.rem = aVar3.vHC.readString();
                    return 0;
                case 8:
                    taVar.rwo = aVar3.vHC.readString();
                    return 0;
                case 9:
                    taVar.rwp = aVar3.vHC.readString();
                    return 0;
                case 10:
                    taVar.rwq = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
