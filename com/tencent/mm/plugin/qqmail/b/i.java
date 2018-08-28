package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class i extends a {
    public String kCs;
    public int mcB;
    public int mcC;
    public String mcD;
    public String name;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.kCs == null) {
                throw new b("Not all required fields were included: addr");
            } else {
                aVar.fT(1, this.mcB);
                if (this.name != null) {
                    aVar.g(2, this.name);
                }
                if (this.kCs != null) {
                    aVar.g(3, this.kCs);
                }
                aVar.fT(4, this.mcC);
                if (this.mcD != null) {
                    aVar.g(5, this.mcD);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.mcB) + 0;
            if (this.name != null) {
                fQ += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.kCs != null) {
                fQ += f.a.a.b.b.a.h(3, this.kCs);
            }
            fQ += f.a.a.a.fQ(4, this.mcC);
            if (this.mcD != null) {
                return fQ + f.a.a.b.b.a.h(5, this.mcD);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.kCs != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: addr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.mcB = aVar3.vHC.rY();
                    return 0;
                case 2:
                    iVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    iVar.kCs = aVar3.vHC.readString();
                    return 0;
                case 4:
                    iVar.mcC = aVar3.vHC.rY();
                    return 0;
                case 5:
                    iVar.mcD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
