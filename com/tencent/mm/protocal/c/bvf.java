package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bvf extends bhd {
    public int otY;
    public bhy rhB;
    public String srU;
    public String srV;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.srU != null) {
                aVar.g(2, this.srU);
            }
            if (this.srV != null) {
                aVar.g(3, this.srV);
            }
            aVar.fT(4, this.otY);
            if (this.rhB == null) {
                return 0;
            }
            aVar.fV(5, this.rhB.boi());
            this.rhB.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.srU != null) {
                fS += f.a.a.b.b.a.h(2, this.srU);
            }
            if (this.srV != null) {
                fS += f.a.a.b.b.a.h(3, this.srV);
            }
            fS += f.a.a.a.fQ(4, this.otY);
            if (this.rhB != null) {
                fS += f.a.a.a.fS(5, this.rhB.boi());
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
            bvf bvf = (bvf) objArr[1];
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
                        bvf.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvf.srU = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bvf.srV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bvf.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bvf.rhB = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
