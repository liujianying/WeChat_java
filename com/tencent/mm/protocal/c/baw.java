package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class baw extends a {
    public String rtC;
    public cfv sdh;
    public cfx sdi;
    public cfr sdj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rtC == null) {
                throw new b("Not all required fields were included: PkgId");
            }
            if (this.rtC != null) {
                aVar.g(1, this.rtC);
            }
            if (this.sdh != null) {
                aVar.fV(2, this.sdh.boi());
                this.sdh.a(aVar);
            }
            if (this.sdi != null) {
                aVar.fV(3, this.sdi.boi());
                this.sdi.a(aVar);
            }
            if (this.sdj == null) {
                return 0;
            }
            aVar.fV(4, this.sdj.boi());
            this.sdj.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rtC != null) {
                h = f.a.a.b.b.a.h(1, this.rtC) + 0;
            } else {
                h = 0;
            }
            if (this.sdh != null) {
                h += f.a.a.a.fS(2, this.sdh.boi());
            }
            if (this.sdi != null) {
                h += f.a.a.a.fS(3, this.sdi.boi());
            }
            if (this.sdj != null) {
                h += f.a.a.a.fS(4, this.sdj.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rtC != null) {
                return 0;
            }
            throw new b("Not all required fields were included: PkgId");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            baw baw = (baw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    baw.rtC = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cfv cfv = new cfv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfv.a(aVar4, cfv, a.a(aVar4))) {
                        }
                        baw.sdh = cfv;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cfx cfx = new cfx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfx.a(aVar4, cfx, a.a(aVar4))) {
                        }
                        baw.sdi = cfx;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cfr cfr = new cfr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfr.a(aVar4, cfr, a.a(aVar4))) {
                        }
                        baw.sdj = cfr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
