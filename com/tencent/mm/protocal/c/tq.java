package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class tq extends a {
    public String jTh;
    public String rxn;
    public String rxo;
    public String rxp;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jTh == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.rxn == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.rxo == null) {
                throw new b("Not all required fields were included: Type");
            } else {
                if (this.jTh != null) {
                    aVar.g(1, this.jTh);
                }
                if (this.rxn != null) {
                    aVar.g(2, this.rxn);
                }
                if (this.rxo != null) {
                    aVar.g(3, this.rxo);
                }
                if (this.rxp == null) {
                    return 0;
                }
                aVar.g(4, this.rxp);
                return 0;
            }
        } else if (i == 1) {
            if (this.jTh != null) {
                h = f.a.a.b.b.a.h(1, this.jTh) + 0;
            } else {
                h = 0;
            }
            if (this.rxn != null) {
                h += f.a.a.b.b.a.h(2, this.rxn);
            }
            if (this.rxo != null) {
                h += f.a.a.b.b.a.h(3, this.rxo);
            }
            if (this.rxp != null) {
                h += f.a.a.b.b.a.h(4, this.rxp);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jTh == null) {
                throw new b("Not all required fields were included: Label");
            } else if (this.rxn == null) {
                throw new b("Not all required fields were included: Number");
            } else if (this.rxo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Type");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            tq tqVar = (tq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tqVar.jTh = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tqVar.rxn = aVar3.vHC.readString();
                    return 0;
                case 3:
                    tqVar.rxo = aVar3.vHC.readString();
                    return 0;
                case 4:
                    tqVar.rxp = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
