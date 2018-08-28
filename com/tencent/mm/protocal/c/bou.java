package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bou extends a {
    public int lOH;
    public String rdS;
    public bhy sml;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sml == null) {
                throw new b("Not all required fields were included: HBBuffer");
            }
            if (this.rdS != null) {
                aVar.g(1, this.rdS);
            }
            aVar.fT(2, this.lOH);
            if (this.sml == null) {
                return 0;
            }
            aVar.fV(3, this.sml.boi());
            this.sml.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rdS != null) {
                h = f.a.a.b.b.a.h(1, this.rdS) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.lOH);
            if (this.sml != null) {
                h += f.a.a.a.fS(3, this.sml.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.sml != null) {
                return 0;
            }
            throw new b("Not all required fields were included: HBBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bou bou = (bou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bou.rdS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bou.lOH = aVar3.vHC.rY();
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
                        bou.sml = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
