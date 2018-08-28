package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bbf extends a {
    public int rID;
    public String rIE;
    public String rIF;
    public bue sdt;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rID);
            if (this.rIE != null) {
                aVar.g(2, this.rIE);
            }
            if (this.rIF != null) {
                aVar.g(3, this.rIF);
            }
            if (this.sdt != null) {
                aVar.fV(4, this.sdt.boi());
                this.sdt.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rID) + 0;
            if (this.rIE != null) {
                fQ += f.a.a.b.b.a.h(2, this.rIE);
            }
            if (this.rIF != null) {
                fQ += f.a.a.b.b.a.h(3, this.rIF);
            }
            if (this.sdt != null) {
                return fQ + f.a.a.a.fS(4, this.sdt.boi());
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
            bbf bbf = (bbf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbf.rID = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bbf.rIE = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbf.rIF = aVar3.vHC.readString();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bue bue = new bue();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bue.a(aVar4, bue, a.a(aVar4))) {
                        }
                        bbf.sdt = bue;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
