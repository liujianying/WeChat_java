package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bhh extends bhp {
    public String kRq;
    public String sbb;
    public int sbd;
    public String sbo;
    public int sif;
    public int sig;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.kRq != null) {
                aVar.g(2, this.kRq);
            }
            if (this.sbb != null) {
                aVar.g(3, this.sbb);
            }
            aVar.fT(4, this.sif);
            aVar.fT(5, this.sig);
            aVar.fT(6, this.sbd);
            if (this.sbo == null) {
                return 0;
            }
            aVar.g(7, this.sbo);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.kRq != null) {
                fS += f.a.a.b.b.a.h(2, this.kRq);
            }
            if (this.sbb != null) {
                fS += f.a.a.b.b.a.h(3, this.sbb);
            }
            fS = ((fS + f.a.a.a.fQ(4, this.sif)) + f.a.a.a.fQ(5, this.sig)) + f.a.a.a.fQ(6, this.sbd);
            if (this.sbo != null) {
                fS += f.a.a.b.b.a.h(7, this.sbo);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bhh bhh = (bhh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bhh.six = flVar;
                    }
                    return 0;
                case 2:
                    bhh.kRq = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bhh.sbb = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bhh.sif = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bhh.sig = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bhh.sbd = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bhh.sbo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
