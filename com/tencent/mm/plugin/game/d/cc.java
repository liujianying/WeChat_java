package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cc extends a {
    public e jOV;
    public String jSF;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOV == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.jSF == null) {
                throw new b("Not all required fields were included: Rank");
            } else {
                if (this.jOV != null) {
                    aVar.fV(1, this.jOV.boi());
                    this.jOV.a(aVar);
                }
                if (this.jSF == null) {
                    return 0;
                }
                aVar.g(2, this.jSF);
                return 0;
            }
        } else if (i == 1) {
            if (this.jOV != null) {
                fS = f.a.a.a.fS(1, this.jOV.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jSF != null) {
                fS += f.a.a.b.b.a.h(2, this.jSF);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.jOV == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.jSF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Rank");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        ccVar.jOV = eVar;
                    }
                    return 0;
                case 2:
                    ccVar.jSF = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
