package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class brq extends bhd {
    public String rDg;
    public String rDh;
    public String rDi;
    public String rIL;
    public String rwj;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rDg != null) {
                aVar.g(2, this.rDg);
            }
            if (this.rIL != null) {
                aVar.g(3, this.rIL);
            }
            if (this.rDh != null) {
                aVar.g(4, this.rDh);
            }
            if (this.rDi != null) {
                aVar.g(5, this.rDi);
            }
            if (this.rwj == null) {
                return 0;
            }
            aVar.g(6, this.rwj);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rDg != null) {
                fS += f.a.a.b.b.a.h(2, this.rDg);
            }
            if (this.rIL != null) {
                fS += f.a.a.b.b.a.h(3, this.rIL);
            }
            if (this.rDh != null) {
                fS += f.a.a.b.b.a.h(4, this.rDh);
            }
            if (this.rDi != null) {
                fS += f.a.a.b.b.a.h(5, this.rDi);
            }
            if (this.rwj != null) {
                fS += f.a.a.b.b.a.h(6, this.rwj);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            brq brq = (brq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        brq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    brq.rDg = aVar3.vHC.readString();
                    return 0;
                case 3:
                    brq.rIL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    brq.rDh = aVar3.vHC.readString();
                    return 0;
                case 5:
                    brq.rDi = aVar3.vHC.readString();
                    return 0;
                case 6:
                    brq.rwj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
