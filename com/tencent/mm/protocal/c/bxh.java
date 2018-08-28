package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bxh extends a {
    public String hbP;
    public String jPG;
    public String jSv;
    public String rOw;
    public String reT;
    public String ruf;
    public String sbQ;
    public long stL;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ruf != null) {
                aVar.g(1, this.ruf);
            }
            if (this.reT != null) {
                aVar.g(2, this.reT);
            }
            if (this.sbQ != null) {
                aVar.g(3, this.sbQ);
            }
            if (this.jSv != null) {
                aVar.g(4, this.jSv);
            }
            if (this.hbP != null) {
                aVar.g(5, this.hbP);
            }
            if (this.jPG != null) {
                aVar.g(6, this.jPG);
            }
            if (this.rOw != null) {
                aVar.g(7, this.rOw);
            }
            aVar.T(8, this.stL);
            return 0;
        } else if (i == 1) {
            if (this.ruf != null) {
                h = f.a.a.b.b.a.h(1, this.ruf) + 0;
            } else {
                h = 0;
            }
            if (this.reT != null) {
                h += f.a.a.b.b.a.h(2, this.reT);
            }
            if (this.sbQ != null) {
                h += f.a.a.b.b.a.h(3, this.sbQ);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(4, this.jSv);
            }
            if (this.hbP != null) {
                h += f.a.a.b.b.a.h(5, this.hbP);
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(6, this.jPG);
            }
            if (this.rOw != null) {
                h += f.a.a.b.b.a.h(7, this.rOw);
            }
            return h + f.a.a.a.S(8, this.stL);
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
            bxh bxh = (bxh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxh.ruf = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bxh.reT = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bxh.sbQ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bxh.jSv = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bxh.hbP = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bxh.jPG = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bxh.rOw = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bxh.stL = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
