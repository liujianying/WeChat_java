package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bjd extends a {
    public bhy rHj;
    public String rHk;
    public long rHm;
    public int rgA;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rHk == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.fT(1, this.rgA);
            if (this.rHk != null) {
                aVar.g(2, this.rHk);
            }
            if (this.rHj != null) {
                aVar.fV(3, this.rHj.boi());
                this.rHj.a(aVar);
            }
            aVar.T(4, this.rHm);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rgA) + 0;
            if (this.rHk != null) {
                fQ += f.a.a.b.b.a.h(2, this.rHk);
            }
            if (this.rHj != null) {
                fQ += f.a.a.a.fS(3, this.rHj.boi());
            }
            return fQ + f.a.a.a.S(4, this.rHm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rHk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bjd bjd = (bjd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjd.rgA = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bjd.rHk = aVar3.vHC.readString();
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
                        bjd.rHj = bhy;
                    }
                    return 0;
                case 4:
                    bjd.rHm = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
