package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bcn extends a {
    public String bKg;
    public String bRK;
    public boolean seI;
    public int seJ;
    public String url;
    public int version;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.seI);
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.bKg != null) {
                aVar.g(3, this.bKg);
            }
            aVar.fT(4, this.version);
            aVar.fT(5, this.seJ);
            if (this.bRK != null) {
                aVar.g(6, this.bRK);
            }
            return 0;
        } else if (i == 1) {
            ec = (f.a.a.b.b.a.ec(1) + 1) + 0;
            if (this.url != null) {
                ec += f.a.a.b.b.a.h(2, this.url);
            }
            if (this.bKg != null) {
                ec += f.a.a.b.b.a.h(3, this.bKg);
            }
            ec = (ec + f.a.a.a.fQ(4, this.version)) + f.a.a.a.fQ(5, this.seJ);
            if (this.bRK != null) {
                return ec + f.a.a.b.b.a.h(6, this.bRK);
            }
            return ec;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bcn bcn = (bcn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcn.seI = aVar3.cJQ();
                    return 0;
                case 2:
                    bcn.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bcn.bKg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bcn.version = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bcn.seJ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bcn.bRK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
