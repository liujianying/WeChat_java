package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bmv extends a {
    public String cac;
    public String cad;
    public String huU;
    public String qZN;
    public String qZO;
    public int qZP;
    public String sla;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.cac != null) {
                aVar.g(1, this.cac);
            }
            if (this.huU != null) {
                aVar.g(2, this.huU);
            }
            if (this.cad != null) {
                aVar.g(3, this.cad);
            }
            if (this.qZN != null) {
                aVar.g(4, this.qZN);
            }
            if (this.qZO != null) {
                aVar.g(5, this.qZO);
            }
            aVar.fT(6, this.qZP);
            if (this.sla == null) {
                return 0;
            }
            aVar.g(7, this.sla);
            return 0;
        } else if (i == 1) {
            if (this.cac != null) {
                h = f.a.a.b.b.a.h(1, this.cac) + 0;
            } else {
                h = 0;
            }
            if (this.huU != null) {
                h += f.a.a.b.b.a.h(2, this.huU);
            }
            if (this.cad != null) {
                h += f.a.a.b.b.a.h(3, this.cad);
            }
            if (this.qZN != null) {
                h += f.a.a.b.b.a.h(4, this.qZN);
            }
            if (this.qZO != null) {
                h += f.a.a.b.b.a.h(5, this.qZO);
            }
            h += f.a.a.a.fQ(6, this.qZP);
            if (this.sla != null) {
                h += f.a.a.b.b.a.h(7, this.sla);
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
            bmv bmv = (bmv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmv.cac = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bmv.huU = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bmv.cad = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bmv.qZN = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bmv.qZO = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bmv.qZP = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bmv.sla = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
