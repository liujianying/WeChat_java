package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class buq extends a {
    public String content;
    public int hUm;
    public String slj;
    public int sln;
    public String slo;
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.slo != null) {
                aVar.g(1, this.slo);
            }
            aVar.fT(2, this.hUm);
            if (this.content != null) {
                aVar.g(3, this.content);
            }
            if (this.slj != null) {
                aVar.g(4, this.slj);
            }
            aVar.fT(5, this.sln);
            aVar.fT(6, this.state);
            return 0;
        } else if (i == 1) {
            if (this.slo != null) {
                h = f.a.a.b.b.a.h(1, this.slo) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.hUm);
            if (this.content != null) {
                h += f.a.a.b.b.a.h(3, this.content);
            }
            if (this.slj != null) {
                h += f.a.a.b.b.a.h(4, this.slj);
            }
            return (h + f.a.a.a.fQ(5, this.sln)) + f.a.a.a.fQ(6, this.state);
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
            buq buq = (buq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    buq.slo = aVar3.vHC.readString();
                    return 0;
                case 2:
                    buq.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    buq.content = aVar3.vHC.readString();
                    return 0;
                case 4:
                    buq.slj = aVar3.vHC.readString();
                    return 0;
                case 5:
                    buq.sln = aVar3.vHC.rY();
                    return 0;
                case 6:
                    buq.state = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
