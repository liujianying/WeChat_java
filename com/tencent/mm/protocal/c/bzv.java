package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bzv extends a {
    public int iwE;
    public int mEb;
    public bhy rfy;
    public int rtM;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rfy == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            aVar.fT(1, this.rtM);
            aVar.fT(2, this.iwE);
            aVar.fT(3, this.mEb);
            if (this.rfy != null) {
                aVar.fV(4, this.rfy.boi());
                this.rfy.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rtM) + 0) + f.a.a.a.fQ(2, this.iwE)) + f.a.a.a.fQ(3, this.mEb);
            if (this.rfy != null) {
                return fQ + f.a.a.a.fS(4, this.rfy.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rfy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bzv bzv = (bzv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bzv.rtM = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bzv.iwE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bzv.mEb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bzv.rfy = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
