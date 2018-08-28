package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ac extends a {
    public int hbr;
    public q hcW;
    public p hcX;
    public r hcY;
    public s hcZ;
    public int hcd;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hbr);
            aVar.fT(2, this.hcd);
            if (this.hcW != null) {
                aVar.fV(3, this.hcW.boi());
                this.hcW.a(aVar);
            }
            if (this.hcX != null) {
                aVar.fV(4, this.hcX.boi());
                this.hcX.a(aVar);
            }
            if (this.hcY != null) {
                aVar.fV(5, this.hcY.boi());
                this.hcY.a(aVar);
            }
            if (this.hcZ != null) {
                aVar.fV(6, this.hcZ.boi());
                this.hcZ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.hbr) + 0) + f.a.a.a.fQ(2, this.hcd);
            if (this.hcW != null) {
                fQ += f.a.a.a.fS(3, this.hcW.boi());
            }
            if (this.hcX != null) {
                fQ += f.a.a.a.fS(4, this.hcX.boi());
            }
            if (this.hcY != null) {
                fQ += f.a.a.a.fS(5, this.hcY.boi());
            }
            if (this.hcZ != null) {
                return fQ + f.a.a.a.fS(6, this.hcZ.boi());
            }
            return fQ;
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
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    acVar.hbr = aVar3.vHC.rY();
                    return 0;
                case 2:
                    acVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        q qVar = new q();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        acVar.hcW = qVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        p pVar = new p();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pVar.a(aVar4, pVar, a.a(aVar4))) {
                        }
                        acVar.hcX = pVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        r rVar = new r();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rVar.a(aVar4, rVar, a.a(aVar4))) {
                        }
                        acVar.hcY = rVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        s sVar = new s();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sVar.a(aVar4, sVar, a.a(aVar4))) {
                        }
                        acVar.hcZ = sVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
