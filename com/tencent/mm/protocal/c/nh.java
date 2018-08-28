package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class nh extends a {
    public String rro;
    public String rrp;
    public String rrq;
    public int rrr;
    public int rrs;
    public String rrt;
    public int rru;

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
            aVar.fT(5, this.rrs);
            if (this.rrt != null) {
                aVar.g(6, this.rrt);
            }
            aVar.fT(7, this.rru);
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
            h = (h + f.a.a.a.fQ(4, this.rrr)) + f.a.a.a.fQ(5, this.rrs);
            if (this.rrt != null) {
                h += f.a.a.b.b.a.h(6, this.rrt);
            }
            return h + f.a.a.a.fQ(7, this.rru);
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
            nh nhVar = (nh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nhVar.rro = aVar3.vHC.readString();
                    return 0;
                case 2:
                    nhVar.rrp = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nhVar.rrq = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nhVar.rrr = aVar3.vHC.rY();
                    return 0;
                case 5:
                    nhVar.rrs = aVar3.vHC.rY();
                    return 0;
                case 6:
                    nhVar.rrt = aVar3.vHC.readString();
                    return 0;
                case 7:
                    nhVar.rru = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
