package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzq extends bhp {
    public long rxH;
    public int svC;
    public int svD;
    public int svE;
    public int svF;
    public b svG;
    public long svs;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.T(2, this.svs);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.svC);
            aVar.fT(5, this.svD);
            aVar.fT(6, this.svE);
            aVar.fT(7, this.svF);
            if (this.svG == null) {
                return 0;
            }
            aVar.b(8, this.svG);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((((fS + f.a.a.a.S(2, this.svs)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.svC)) + f.a.a.a.fQ(5, this.svD)) + f.a.a.a.fQ(6, this.svE)) + f.a.a.a.fQ(7, this.svF);
            if (this.svG != null) {
                fS += f.a.a.a.a(8, this.svG);
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
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bzq bzq = (bzq) objArr[1];
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
                        bzq.six = flVar;
                    }
                    return 0;
                case 2:
                    bzq.svs = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bzq.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bzq.svC = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bzq.svD = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bzq.svE = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bzq.svF = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bzq.svG = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
