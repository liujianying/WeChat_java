package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class p extends a {
    public String ID;
    public long hcc;
    public int hcf;
    public int hcg;
    public int hch;
    public long hci;
    public long hcj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fT(2, this.hcf);
            aVar.fT(3, this.hcg);
            aVar.fT(4, this.hch);
            aVar.T(5, this.hcc);
            aVar.T(6, this.hci);
            aVar.T(7, this.hcj);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = f.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            return (((((h + f.a.a.a.fQ(2, this.hcf)) + f.a.a.a.fQ(3, this.hcg)) + f.a.a.a.fQ(4, this.hch)) + f.a.a.a.S(5, this.hcc)) + f.a.a.a.S(6, this.hci)) + f.a.a.a.S(7, this.hcj);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.ID = aVar3.vHC.readString();
                    return 0;
                case 2:
                    pVar.hcf = aVar3.vHC.rY();
                    return 0;
                case 3:
                    pVar.hcg = aVar3.vHC.rY();
                    return 0;
                case 4:
                    pVar.hch = aVar3.vHC.rY();
                    return 0;
                case 5:
                    pVar.hcc = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    pVar.hci = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    pVar.hcj = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
