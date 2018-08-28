package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ew extends a {
    public String ID;
    public int rfn;
    public bhy rfo;
    public String rfp;
    public int rfq;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rfo == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            }
            aVar.fT(1, this.rfn);
            if (this.rfo != null) {
                aVar.fV(2, this.rfo.boi());
                this.rfo.a(aVar);
            }
            if (this.rfp != null) {
                aVar.g(3, this.rfp);
            }
            aVar.fT(4, this.rfq);
            if (this.ID != null) {
                aVar.g(5, this.ID);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.rfo != null) {
                fQ += f.a.a.a.fS(2, this.rfo.boi());
            }
            if (this.rfp != null) {
                fQ += f.a.a.b.b.a.h(3, this.rfp);
            }
            fQ += f.a.a.a.fQ(4, this.rfq);
            if (this.ID != null) {
                return fQ + f.a.a.b.b.a.h(5, this.ID);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rfo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: QRCodeBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ew ewVar = (ew) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ewVar.rfn = aVar3.vHC.rY();
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
                        ewVar.rfo = bhy;
                    }
                    return 0;
                case 3:
                    ewVar.rfp = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ewVar.rfq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ewVar.ID = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
