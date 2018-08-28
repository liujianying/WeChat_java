package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ayz extends a {
    public int sbK;
    public bhy sbL;
    public int sbM;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sbK);
            if (this.sbL != null) {
                aVar.fV(2, this.sbL.boi());
                this.sbL.a(aVar);
            }
            aVar.fT(3, this.sbM);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.sbK) + 0;
            if (this.sbL != null) {
                fQ += f.a.a.a.fS(2, this.sbL.boi());
            }
            return fQ + f.a.a.a.fQ(3, this.sbM);
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
            ayz ayz = (ayz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayz.sbK = aVar3.vHC.rY();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ayz.sbL = bhy;
                    }
                    return 0;
                case 3:
                    ayz.sbM = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
