package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class acq extends a {
    public int qZc;
    public int rHi;
    public bhy rHj;
    public String rHk;
    public int rHl;
    public long rHm;
    public int rwr;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.qZc);
            aVar.fT(2, this.rHi);
            if (this.rHj != null) {
                aVar.fV(3, this.rHj.boi());
                this.rHj.a(aVar);
            }
            aVar.fT(4, this.rwr);
            if (this.rHk != null) {
                aVar.g(5, this.rHk);
            }
            aVar.fT(6, this.rHl);
            aVar.T(7, this.rHm);
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.qZc) + 0) + f.a.a.a.fQ(2, this.rHi);
            if (this.rHj != null) {
                fQ += f.a.a.a.fS(3, this.rHj.boi());
            }
            fQ += f.a.a.a.fQ(4, this.rwr);
            if (this.rHk != null) {
                fQ += f.a.a.b.b.a.h(5, this.rHk);
            }
            return (fQ + f.a.a.a.fQ(6, this.rHl)) + f.a.a.a.S(7, this.rHm);
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
            acq acq = (acq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acq.qZc = aVar3.vHC.rY();
                    return 0;
                case 2:
                    acq.rHi = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        acq.rHj = bhy;
                    }
                    return 0;
                case 4:
                    acq.rwr = aVar3.vHC.rY();
                    return 0;
                case 5:
                    acq.rHk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    acq.rHl = aVar3.vHC.rY();
                    return 0;
                case 7:
                    acq.rHm = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
