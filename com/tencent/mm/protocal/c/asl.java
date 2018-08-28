package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class asl extends a {
    public String iwP;
    public int otY;
    public int rUH;
    public aqs rUI;
    public int rUJ;
    public long rUK;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.otY);
            aVar.fT(2, this.rUH);
            if (this.rUI != null) {
                aVar.fV(3, this.rUI.boi());
                this.rUI.a(aVar);
            }
            aVar.fT(4, this.rUJ);
            if (this.iwP != null) {
                aVar.g(5, this.iwP);
            }
            aVar.T(6, this.rUK);
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.otY) + 0) + f.a.a.a.fQ(2, this.rUH);
            if (this.rUI != null) {
                fQ += f.a.a.a.fS(3, this.rUI.boi());
            }
            fQ += f.a.a.a.fQ(4, this.rUJ);
            if (this.iwP != null) {
                fQ += f.a.a.b.b.a.h(5, this.iwP);
            }
            return fQ + f.a.a.a.S(6, this.rUK);
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
            asl asl = (asl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asl.otY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    asl.rUH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        aqs aqs = new aqs();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        asl.rUI = aqs;
                    }
                    return 0;
                case 4:
                    asl.rUJ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    asl.iwP = aVar3.vHC.readString();
                    return 0;
                case 6:
                    asl.rUK = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
