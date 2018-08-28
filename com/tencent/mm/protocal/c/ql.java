package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ql extends bhd {
    public String riK;
    public xr ruQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruQ == null) {
                throw new b("Not all required fields were included: full_chat");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.riK != null) {
                aVar.g(2, this.riK);
            }
            if (this.ruQ == null) {
                return 0;
            }
            aVar.fV(3, this.ruQ.boi());
            this.ruQ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.riK != null) {
                fS += f.a.a.b.b.a.h(2, this.riK);
            }
            if (this.ruQ != null) {
                fS += f.a.a.a.fS(3, this.ruQ.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ruQ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: full_chat");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ql qlVar = (ql) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        qlVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    qlVar.riK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xr xrVar = new xr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xrVar.a(aVar4, xrVar, bhd.a(aVar4))) {
                        }
                        qlVar.ruQ = xrVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
