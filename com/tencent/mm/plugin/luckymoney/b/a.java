package com.tencent.mm.plugin.luckymoney.b;

public final class a extends com.tencent.mm.bk.a {
    public int ddp;
    public String kPw;
    public String kPx;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.ddp);
            if (this.kPw != null) {
                aVar.g(2, this.kPw);
            }
            if (this.kPx != null) {
                aVar.g(3, this.kPx);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.ddp) + 0;
            if (this.kPw != null) {
                fQ += f.a.a.b.b.a.h(2, this.kPw);
            }
            if (this.kPx != null) {
                return fQ + f.a.a.b.b.a.h(3, this.kPx);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = com.tencent.mm.bk.a.a(aVar2); fQ > 0; fQ = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.ddp = aVar3.vHC.rY();
                    return 0;
                case 2:
                    aVar4.kPw = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aVar4.kPx = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
