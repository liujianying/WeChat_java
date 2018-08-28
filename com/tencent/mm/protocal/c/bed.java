package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bed extends bhd {
    public String bPS;
    public int offset;
    public String sbb;

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
            if (this.sbb != null) {
                aVar.g(3, this.sbb);
            }
            aVar.fT(4, this.offset);
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
            if (this.sbb != null) {
                fS += f.a.a.b.b.a.h(3, this.sbb);
            }
            return fS + f.a.a.a.fQ(4, this.offset);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bed bed = (bed) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bed.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bed.bPS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bed.sbb = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bed.offset = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
