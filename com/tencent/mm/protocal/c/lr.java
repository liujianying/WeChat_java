package com.tencent.mm.protocal.c;

import d.a.a.c;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class lr extends bhp {
    public int hUm;
    public String hUn;
    public c pqb;
    public long pqd;

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
            aVar.fT(2, this.hUm);
            if (this.hUn != null) {
                aVar.g(3, this.hUn);
            }
            aVar.T(4, this.pqd);
            if (this.pqb == null) {
                return 0;
            }
            aVar.fV(5, this.pqb.boi());
            this.pqb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hUm);
            if (this.hUn != null) {
                fS += f.a.a.b.b.a.h(3, this.hUn);
            }
            fS += f.a.a.a.S(4, this.pqd);
            if (this.pqb != null) {
                fS += f.a.a.a.fS(5, this.pqb.boi());
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
            lr lrVar = (lr) objArr[1];
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
                        lrVar.six = flVar;
                    }
                    return 0;
                case 2:
                    lrVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    lrVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    lrVar.pqd = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        c cVar = new c();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, bhp.a(aVar4))) {
                        }
                        lrVar.pqb = cVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
