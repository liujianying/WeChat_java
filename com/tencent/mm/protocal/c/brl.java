package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class brl extends bhp {
    public int reL;
    public String ruV;
    public eg skj;
    public ek spy;

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
            if (this.skj != null) {
                aVar.fV(2, this.skj.boi());
                this.skj.a(aVar);
            }
            aVar.fT(3, this.reL);
            if (this.spy != null) {
                aVar.fV(4, this.spy.boi());
                this.spy.a(aVar);
            }
            if (this.ruV == null) {
                return 0;
            }
            aVar.g(5, this.ruV);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.skj != null) {
                fS += f.a.a.a.fS(2, this.skj.boi());
            }
            fS += f.a.a.a.fQ(3, this.reL);
            if (this.spy != null) {
                fS += f.a.a.a.fS(4, this.spy.boi());
            }
            if (this.ruV != null) {
                fS += f.a.a.b.b.a.h(5, this.ruV);
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
            brl brl = (brl) objArr[1];
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
                        brl.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        eg egVar = new eg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = egVar.a(aVar4, egVar, bhp.a(aVar4))) {
                        }
                        brl.skj = egVar;
                    }
                    return 0;
                case 3:
                    brl.reL = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ek ekVar = new ek();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ekVar.a(aVar4, ekVar, bhp.a(aVar4))) {
                        }
                        brl.spy = ekVar;
                    }
                    return 0;
                case 5:
                    brl.ruV = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
