package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bje extends bhp {
    public bhy rHj;
    public long rHm;
    public String sjt;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.sjt == null) {
                throw new b("Not all required fields were included: SearchResult");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.sjt != null) {
                    aVar.g(2, this.sjt);
                }
                if (this.rHj != null) {
                    aVar.fV(3, this.rHj.boi());
                    this.rHj.a(aVar);
                }
                aVar.T(4, this.rHm);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sjt != null) {
                fS += f.a.a.b.b.a.h(2, this.sjt);
            }
            if (this.rHj != null) {
                fS += f.a.a.a.fS(3, this.rHj.boi());
            }
            return fS + f.a.a.a.S(4, this.rHm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.sjt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SearchResult");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bje bje = (bje) objArr[1];
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
                        bje.six = flVar;
                    }
                    return 0;
                case 2:
                    bje.sjt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bje.rHj = bhy;
                    }
                    return 0;
                case 4:
                    bje.rHm = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
