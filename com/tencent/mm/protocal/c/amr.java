package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class amr extends bhp {
    public int bJL;
    public String errorMsg;
    public bhy rPv;
    public int rPw;
    public String rPx;
    public int rPy;

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
            if (this.rPv != null) {
                aVar.fV(2, this.rPv.boi());
                this.rPv.a(aVar);
            }
            aVar.fT(3, this.rPw);
            if (this.rPx != null) {
                aVar.g(4, this.rPx);
            }
            aVar.fT(5, this.rPy);
            aVar.fT(6, this.bJL);
            if (this.errorMsg == null) {
                return 0;
            }
            aVar.g(7, this.errorMsg);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rPv != null) {
                fS += f.a.a.a.fS(2, this.rPv.boi());
            }
            fS += f.a.a.a.fQ(3, this.rPw);
            if (this.rPx != null) {
                fS += f.a.a.b.b.a.h(4, this.rPx);
            }
            fS = (fS + f.a.a.a.fQ(5, this.rPy)) + f.a.a.a.fQ(6, this.bJL);
            if (this.errorMsg != null) {
                fS += f.a.a.b.b.a.h(7, this.errorMsg);
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
            amr amr = (amr) objArr[1];
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
                        amr.six = flVar;
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
                        amr.rPv = bhy;
                    }
                    return 0;
                case 3:
                    amr.rPw = aVar3.vHC.rY();
                    return 0;
                case 4:
                    amr.rPx = aVar3.vHC.readString();
                    return 0;
                case 5:
                    amr.rPy = aVar3.vHC.rY();
                    return 0;
                case 6:
                    amr.bJL = aVar3.vHC.rY();
                    return 0;
                case 7:
                    amr.errorMsg = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}