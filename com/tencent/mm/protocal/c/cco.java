package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cco extends a {
    public bhy rcn;
    public String rhV;
    public bhy rhZ;
    public String syo;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rhZ == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.syo != null) {
                    aVar.g(1, this.syo);
                }
                if (this.rhZ != null) {
                    aVar.fV(2, this.rhZ.boi());
                    this.rhZ.a(aVar);
                }
                if (this.rhV != null) {
                    aVar.g(3, this.rhV);
                }
                if (this.rcn == null) {
                    return 0;
                }
                aVar.fV(4, this.rcn.boi());
                this.rcn.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.syo != null) {
                h = f.a.a.b.b.a.h(1, this.syo) + 0;
            } else {
                h = 0;
            }
            if (this.rhZ != null) {
                h += f.a.a.a.fS(2, this.rhZ.boi());
            }
            if (this.rhV != null) {
                h += f.a.a.b.b.a.h(3, this.rhV);
            }
            if (this.rcn != null) {
                h += f.a.a.a.fS(4, this.rcn.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rhZ == null) {
                throw new b("Not all required fields were included: KSid");
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cco cco = (cco) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cco.syo = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        cco.rhZ = bhy;
                    }
                    return 0;
                case 3:
                    cco.rhV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        cco.rcn = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
