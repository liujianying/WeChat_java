package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bk.a;

public final class n extends a {
    public String kPS;
    public String kQC;
    public String kQD;
    public String kQE;
    public String kQF;
    public long kQp;
    public String kQq;
    public String userName;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.kQC != null) {
                aVar.g(1, this.kQC);
            }
            if (this.kQD != null) {
                aVar.g(2, this.kQD);
            }
            aVar.T(3, this.kQp);
            if (this.kQq != null) {
                aVar.g(4, this.kQq);
            }
            if (this.kQE != null) {
                aVar.g(5, this.kQE);
            }
            if (this.kPS != null) {
                aVar.g(6, this.kPS);
            }
            if (this.kQF != null) {
                aVar.g(7, this.kQF);
            }
            if (this.userName == null) {
                return 0;
            }
            aVar.g(8, this.userName);
            return 0;
        } else if (i == 1) {
            if (this.kQC != null) {
                h = f.a.a.b.b.a.h(1, this.kQC) + 0;
            } else {
                h = 0;
            }
            if (this.kQD != null) {
                h += f.a.a.b.b.a.h(2, this.kQD);
            }
            h += f.a.a.a.S(3, this.kQp);
            if (this.kQq != null) {
                h += f.a.a.b.b.a.h(4, this.kQq);
            }
            if (this.kQE != null) {
                h += f.a.a.b.b.a.h(5, this.kQE);
            }
            if (this.kPS != null) {
                h += f.a.a.b.b.a.h(6, this.kPS);
            }
            if (this.kQF != null) {
                h += f.a.a.b.b.a.h(7, this.kQF);
            }
            if (this.userName != null) {
                h += f.a.a.b.b.a.h(8, this.userName);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.kQC = aVar3.vHC.readString();
                    return 0;
                case 2:
                    nVar.kQD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nVar.kQp = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    nVar.kQq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    nVar.kQE = aVar3.vHC.readString();
                    return 0;
                case 6:
                    nVar.kPS = aVar3.vHC.readString();
                    return 0;
                case 7:
                    nVar.kQF = aVar3.vHC.readString();
                    return 0;
                case 8:
                    nVar.userName = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
