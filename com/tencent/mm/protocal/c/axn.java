package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class axn extends bhp {
    public int hwV;
    public String hwW;
    public String rhc;
    public bbc rhe;
    public String saE;
    public boolean saF;
    public boolean saG;

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
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            if (this.saE != null) {
                aVar.g(4, this.saE);
            }
            if (this.rhc != null) {
                aVar.g(7, this.rhc);
            }
            if (this.rhe != null) {
                aVar.fV(8, this.rhe.boi());
                this.rhe.a(aVar);
            }
            aVar.av(9, this.saF);
            aVar.av(10, this.saG);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            if (this.saE != null) {
                fS += f.a.a.b.b.a.h(4, this.saE);
            }
            if (this.rhc != null) {
                fS += f.a.a.b.b.a.h(7, this.rhc);
            }
            if (this.rhe != null) {
                fS += f.a.a.a.fS(8, this.rhe.boi());
            }
            return (fS + (f.a.a.b.b.a.ec(9) + 1)) + (f.a.a.b.b.a.ec(10) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
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
            axn axn = (axn) objArr[1];
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
                        com.tencent.mm.bk.a flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        axn.six = flVar;
                    }
                    return 0;
                case 2:
                    axn.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    axn.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    axn.saE = aVar3.vHC.readString();
                    return 0;
                case 7:
                    axn.rhc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbc bbc = new bbc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.a(aVar4, bbc, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        axn.rhe = bbc;
                    }
                    return 0;
                case 9:
                    axn.saF = aVar3.cJQ();
                    return 0;
                case 10:
                    axn.saG = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
