package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bkb extends bhp {
    public String rgQ;
    public aue rgR;
    public alx rhk;
    public aly rhl;

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
            if (this.rgR != null) {
                aVar.fV(2, this.rgR.boi());
                this.rgR.a(aVar);
            }
            if (this.rhk != null) {
                aVar.fV(3, this.rhk.boi());
                this.rhk.a(aVar);
            }
            if (this.rhl != null) {
                aVar.fV(4, this.rhl.boi());
                this.rhl.a(aVar);
            }
            if (this.rgQ == null) {
                return 0;
            }
            aVar.g(5, this.rgQ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rgR != null) {
                fS += f.a.a.a.fS(2, this.rgR.boi());
            }
            if (this.rhk != null) {
                fS += f.a.a.a.fS(3, this.rhk.boi());
            }
            if (this.rhl != null) {
                fS += f.a.a.a.fS(4, this.rhl.boi());
            }
            if (this.rgQ != null) {
                fS += f.a.a.b.b.a.h(5, this.rgQ);
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
            bkb bkb = (bkb) objArr[1];
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
                        bkb.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aue aue = new aue();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aue.a(aVar4, aue, bhp.a(aVar4))) {
                        }
                        bkb.rgR = aue;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alx alx = new alx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alx.a(aVar4, alx, bhp.a(aVar4))) {
                        }
                        bkb.rhk = alx;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aly aly = new aly();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aly.a(aVar4, aly, bhp.a(aVar4))) {
                        }
                        bkb.rhl = aly;
                    }
                    return 0;
                case 5:
                    bkb.rgQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
