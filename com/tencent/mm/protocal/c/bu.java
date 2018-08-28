package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bu extends bhd {
    public int hcE;
    public String rcc;
    public int rcd;
    public String rce;
    public String rcf;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rcc != null) {
                aVar.g(2, this.rcc);
            }
            aVar.fT(3, this.hcE);
            aVar.fT(4, this.rcd);
            if (this.rce != null) {
                aVar.g(5, this.rce);
            }
            if (this.rcf == null) {
                return 0;
            }
            aVar.g(6, this.rcf);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcc != null) {
                fS += f.a.a.b.b.a.h(2, this.rcc);
            }
            fS = (fS + f.a.a.a.fQ(3, this.hcE)) + f.a.a.a.fQ(4, this.rcd);
            if (this.rce != null) {
                fS += f.a.a.b.b.a.h(5, this.rce);
            }
            if (this.rcf != null) {
                fS += f.a.a.b.b.a.h(6, this.rcf);
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
            bu buVar = (bu) objArr[1];
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
                        buVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    buVar.rcc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    buVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 4:
                    buVar.rcd = aVar3.vHC.rY();
                    return 0;
                case 5:
                    buVar.rce = aVar3.vHC.readString();
                    return 0;
                case 6:
                    buVar.rcf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
