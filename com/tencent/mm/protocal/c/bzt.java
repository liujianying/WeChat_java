package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bzt extends a {
    public String jTv;
    public int rtM;
    public bhy rtN;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rtN == null) {
                throw new b("Not all required fields were included: CmdBuf");
            }
            aVar.fT(1, this.rtM);
            if (this.rtN != null) {
                aVar.fV(2, this.rtN.boi());
                this.rtN.a(aVar);
            }
            if (this.jTv != null) {
                aVar.g(3, this.jTv);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rtM) + 0;
            if (this.rtN != null) {
                fQ += f.a.a.a.fS(2, this.rtN.boi());
            }
            if (this.jTv != null) {
                return fQ + f.a.a.b.b.a.h(3, this.jTv);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rtN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CmdBuf");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bzt bzt = (bzt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bzt.rtM = aVar3.vHC.rY();
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
                        bzt.rtN = bhy;
                    }
                    return 0;
                case 3:
                    bzt.jTv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
