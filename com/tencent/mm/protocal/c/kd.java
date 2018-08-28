package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class kd extends a {
    public String bWP;
    public String poH;
    public String pwk;
    public String rlM;
    public String rlN;
    public int rlO;
    public String title;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.type);
            if (this.pwk != null) {
                aVar.g(2, this.pwk);
            }
            if (this.bWP != null) {
                aVar.g(3, this.bWP);
            }
            if (this.title != null) {
                aVar.g(4, this.title);
            }
            if (this.poH != null) {
                aVar.g(5, this.poH);
            }
            if (this.url != null) {
                aVar.g(6, this.url);
            }
            if (this.rlM != null) {
                aVar.g(7, this.rlM);
            }
            if (this.rlN != null) {
                aVar.g(8, this.rlN);
            }
            aVar.fT(9, this.rlO);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.type) + 0;
            if (this.pwk != null) {
                fQ += f.a.a.b.b.a.h(2, this.pwk);
            }
            if (this.bWP != null) {
                fQ += f.a.a.b.b.a.h(3, this.bWP);
            }
            if (this.title != null) {
                fQ += f.a.a.b.b.a.h(4, this.title);
            }
            if (this.poH != null) {
                fQ += f.a.a.b.b.a.h(5, this.poH);
            }
            if (this.url != null) {
                fQ += f.a.a.b.b.a.h(6, this.url);
            }
            if (this.rlM != null) {
                fQ += f.a.a.b.b.a.h(7, this.rlM);
            }
            if (this.rlN != null) {
                fQ += f.a.a.b.b.a.h(8, this.rlN);
            }
            return fQ + f.a.a.a.fQ(9, this.rlO);
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
            kd kdVar = (kd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kdVar.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    kdVar.pwk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    kdVar.bWP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    kdVar.title = aVar3.vHC.readString();
                    return 0;
                case 5:
                    kdVar.poH = aVar3.vHC.readString();
                    return 0;
                case 6:
                    kdVar.url = aVar3.vHC.readString();
                    return 0;
                case 7:
                    kdVar.rlM = aVar3.vHC.readString();
                    return 0;
                case 8:
                    kdVar.rlN = aVar3.vHC.readString();
                    return 0;
                case 9:
                    kdVar.rlO = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
