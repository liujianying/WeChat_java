package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class byj extends bhp {
    public int rsj;
    public int shg;
    public byp shl;
    public String sur;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.shl == null) {
                throw new b("Not all required fields were included: NextPiece");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.shl != null) {
                    aVar.fV(2, this.shl.boi());
                    this.shl.a(aVar);
                }
                aVar.fT(3, this.rsj);
                aVar.fT(4, this.shg);
                if (this.sur == null) {
                    return 0;
                }
                aVar.g(5, this.sur);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.shl != null) {
                fS += f.a.a.a.fS(2, this.shl.boi());
            }
            fS = (fS + f.a.a.a.fQ(3, this.rsj)) + f.a.a.a.fQ(4, this.shg);
            if (this.sur != null) {
                fS += f.a.a.b.b.a.h(5, this.sur);
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
            } else if (this.shl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NextPiece");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            byj byj = (byj) objArr[1];
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
                        byj.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byp byp = new byp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byp.a(aVar4, byp, bhp.a(aVar4))) {
                        }
                        byj.shl = byp;
                    }
                    return 0;
                case 3:
                    byj.rsj = aVar3.vHC.rY();
                    return 0;
                case 4:
                    byj.shg = aVar3.vHC.rY();
                    return 0;
                case 5:
                    byj.sur = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
