package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class hw extends a {
    public hz riN;
    public String riO;
    public String riP;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.riN != null) {
                aVar.fV(1, this.riN.boi());
                this.riN.a(aVar);
            }
            if (this.riO != null) {
                aVar.g(2, this.riO);
            }
            if (this.riP == null) {
                return 0;
            }
            aVar.g(3, this.riP);
            return 0;
        } else if (i == 1) {
            if (this.riN != null) {
                fS = f.a.a.a.fS(1, this.riN.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.riO != null) {
                fS += f.a.a.b.b.a.h(2, this.riO);
            }
            if (this.riP != null) {
                fS += f.a.a.b.b.a.h(3, this.riP);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            hw hwVar = (hw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        hz hzVar = new hz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hzVar.a(aVar4, hzVar, a.a(aVar4))) {
                        }
                        hwVar.riN = hzVar;
                    }
                    return 0;
                case 2:
                    hwVar.riO = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hwVar.riP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
