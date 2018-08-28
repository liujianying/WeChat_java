package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ccn extends a {
    public String rhV;
    public String rhW;
    public bhy rhZ;
    public String syo;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rhZ == null) {
                throw new b("Not all required fields were included: KSid");
            }
            if (this.rhV != null) {
                aVar.g(1, this.rhV);
            }
            if (this.rhW != null) {
                aVar.g(2, this.rhW);
            }
            if (this.syo != null) {
                aVar.g(3, this.syo);
            }
            if (this.rhZ == null) {
                return 0;
            }
            aVar.fV(4, this.rhZ.boi());
            this.rhZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rhV != null) {
                h = f.a.a.b.b.a.h(1, this.rhV) + 0;
            } else {
                h = 0;
            }
            if (this.rhW != null) {
                h += f.a.a.b.b.a.h(2, this.rhW);
            }
            if (this.syo != null) {
                h += f.a.a.b.b.a.h(3, this.syo);
            }
            if (this.rhZ != null) {
                h += f.a.a.a.fS(4, this.rhZ.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rhZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KSid");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ccn ccn = (ccn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccn.rhV = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ccn.rhW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ccn.syo = aVar3.vHC.readString();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        a bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ccn.rhZ = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
