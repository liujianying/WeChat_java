package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class vn extends bhd {
    public String bPS;
    public String ryI;
    public long ryO;
    public String ryP;
    public String ryQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.bPS != null) {
                aVar.g(2, this.bPS);
            }
            aVar.T(3, this.ryO);
            if (this.ryI != null) {
                aVar.g(4, this.ryI);
            }
            if (this.ryP != null) {
                aVar.g(5, this.ryP);
            }
            if (this.ryQ == null) {
                return 0;
            }
            aVar.g(6, this.ryQ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(2, this.bPS);
            }
            fS += f.a.a.a.S(3, this.ryO);
            if (this.ryI != null) {
                fS += f.a.a.b.b.a.h(4, this.ryI);
            }
            if (this.ryP != null) {
                fS += f.a.a.b.b.a.h(5, this.ryP);
            }
            if (this.ryQ != null) {
                fS += f.a.a.b.b.a.h(6, this.ryQ);
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
            vn vnVar = (vn) objArr[1];
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
                        vnVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    vnVar.bPS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vnVar.ryO = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    vnVar.ryI = aVar3.vHC.readString();
                    return 0;
                case 5:
                    vnVar.ryP = aVar3.vHC.readString();
                    return 0;
                case 6:
                    vnVar.ryQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
