package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class agz extends bhp {
    public int rKl;
    public bhy rKm;
    public String rKn;
    public String rKo;
    public String rKp;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rKm == null) {
                throw new b("Not all required fields were included: QRCode");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rKm != null) {
                    aVar.fV(2, this.rKm.boi());
                    this.rKm.a(aVar);
                }
                aVar.fT(5, this.rKl);
                if (this.rKn != null) {
                    aVar.g(6, this.rKn);
                }
                if (this.rKo != null) {
                    aVar.g(7, this.rKo);
                }
                if (this.rKp == null) {
                    return 0;
                }
                aVar.g(8, this.rKp);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rKm != null) {
                fS += f.a.a.a.fS(2, this.rKm.boi());
            }
            fS += f.a.a.a.fQ(5, this.rKl);
            if (this.rKn != null) {
                fS += f.a.a.b.b.a.h(6, this.rKn);
            }
            if (this.rKo != null) {
                fS += f.a.a.b.b.a.h(7, this.rKo);
            }
            if (this.rKp != null) {
                fS += f.a.a.b.b.a.h(8, this.rKp);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rKm != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QRCode");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            agz agz = (agz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        agz.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        agz.rKm = bhy;
                    }
                    return 0;
                case 5:
                    agz.rKl = aVar3.vHC.rY();
                    return 0;
                case 6:
                    agz.rKn = aVar3.vHC.readString();
                    return 0;
                case 7:
                    agz.rKo = aVar3.vHC.readString();
                    return 0;
                case 8:
                    agz.rKp = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
