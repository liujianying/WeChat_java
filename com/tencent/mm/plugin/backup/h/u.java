package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;

public final class u extends a {
    public String cGI;
    public int hcA;
    public long hcB;
    public int hcz;
    public String mediaId;
    public String path;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcz);
            if (this.cGI != null) {
                aVar.g(2, this.cGI);
            }
            if (this.mediaId != null) {
                aVar.g(3, this.mediaId);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            aVar.fT(5, this.type);
            aVar.fT(6, this.hcA);
            aVar.T(7, this.hcB);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcz) + 0;
            if (this.cGI != null) {
                fQ += f.a.a.b.b.a.h(2, this.cGI);
            }
            if (this.mediaId != null) {
                fQ += f.a.a.b.b.a.h(3, this.mediaId);
            }
            if (this.path != null) {
                fQ += f.a.a.b.b.a.h(4, this.path);
            }
            return ((fQ + f.a.a.a.fQ(5, this.type)) + f.a.a.a.fQ(6, this.hcA)) + f.a.a.a.S(7, this.hcB);
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
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.hcz = aVar3.vHC.rY();
                    return 0;
                case 2:
                    uVar.cGI = aVar3.vHC.readString();
                    return 0;
                case 3:
                    uVar.mediaId = aVar3.vHC.readString();
                    return 0;
                case 4:
                    uVar.path = aVar3.vHC.readString();
                    return 0;
                case 5:
                    uVar.type = aVar3.vHC.rY();
                    return 0;
                case 6:
                    uVar.hcA = aVar3.vHC.rY();
                    return 0;
                case 7:
                    uVar.hcB = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
