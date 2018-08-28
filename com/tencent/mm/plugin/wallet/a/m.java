package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;

public final class m extends a {
    public String dzE;
    public int id;
    public String name;
    public String pdR;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.id);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            if (this.pdR != null) {
                aVar.g(4, this.pdR);
            }
            if (this.dzE != null) {
                aVar.g(5, this.dzE);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.id) + 0;
            if (this.name != null) {
                fQ += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.url != null) {
                fQ += f.a.a.b.b.a.h(3, this.url);
            }
            if (this.pdR != null) {
                fQ += f.a.a.b.b.a.h(4, this.pdR);
            }
            if (this.dzE != null) {
                return fQ + f.a.a.b.b.a.h(5, this.dzE);
            }
            return fQ;
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.id = aVar3.vHC.rY();
                    return 0;
                case 2:
                    mVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mVar.url = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mVar.pdR = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mVar.dzE = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
