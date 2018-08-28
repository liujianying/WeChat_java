package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class boi extends a {
    public String rcc;
    public long rlK;
    public long smn;
    public boh smo;
    public boh smp;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.smo == null) {
                throw new b("Not all required fields were included: CurrentAction");
            }
            aVar.T(1, this.rlK);
            aVar.T(2, this.smn);
            if (this.smo != null) {
                aVar.fV(3, this.smo.boi());
                this.smo.a(aVar);
            }
            if (this.smp != null) {
                aVar.fV(4, this.smp.boi());
                this.smp.a(aVar);
            }
            if (this.rcc != null) {
                aVar.g(5, this.rcc);
            }
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.rlK) + 0) + f.a.a.a.S(2, this.smn);
            if (this.smo != null) {
                S += f.a.a.a.fS(3, this.smo.boi());
            }
            if (this.smp != null) {
                S += f.a.a.a.fS(4, this.smp.boi());
            }
            if (this.rcc != null) {
                return S + f.a.a.b.b.a.h(5, this.rcc);
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.smo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CurrentAction");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            boi boi = (boi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            boh boh;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    boi.rlK = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    boi.smn = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boh = new boh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boh.a(aVar4, boh, a.a(aVar4))) {
                        }
                        boi.smo = boh;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boh = new boh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boh.a(aVar4, boh, a.a(aVar4))) {
                        }
                        boi.smp = boh;
                    }
                    return 0;
                case 5:
                    boi.rcc = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
