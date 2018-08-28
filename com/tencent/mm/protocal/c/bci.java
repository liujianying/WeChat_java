package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bci extends bhd {
    public int hcd;
    public String jTv;
    public int rxG;
    public long rxH;
    public long see;
    public long seh;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.jTv == null) {
                throw new b("Not all required fields were included: FromUserName");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jTv != null) {
                aVar.g(2, this.jTv);
            }
            aVar.fT(3, this.rxG);
            aVar.T(4, this.rxH);
            aVar.T(5, this.see);
            aVar.T(6, this.seh);
            aVar.fT(7, this.hcd);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(2, this.jTv);
            }
            return ((((fS + f.a.a.a.fQ(3, this.rxG)) + f.a.a.a.S(4, this.rxH)) + f.a.a.a.S(5, this.see)) + f.a.a.a.S(6, this.seh)) + f.a.a.a.fQ(7, this.hcd);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.jTv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: FromUserName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bci bci = (bci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bci.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bci.jTv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bci.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bci.rxH = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bci.see = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bci.seh = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    bci.hcd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
