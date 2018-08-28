package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ayp extends a {
    public pn rZv;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rZv == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.rZv == null) {
                return 0;
            } else {
                aVar.fV(1, this.rZv.boi());
                this.rZv.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.rZv != null) {
                fS = f.a.a.a.fS(1, this.rZv.boi()) + 0;
            } else {
                fS = 0;
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rZv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Oplog");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ayp ayp = (ayp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        pn pnVar = new pn();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = pnVar.a(aVar4, pnVar, a.a(aVar4))) {
                        }
                        ayp.rZv = pnVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
