package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class kj extends bhp {
    public String jTu;
    public String jTv;
    public int lOH;
    public long rcq;
    public String rmC;
    public String rmn;
    public String rmy;

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
            if (this.rmn != null) {
                aVar.g(3, this.rmn);
            }
            if (this.jTv != null) {
                aVar.g(4, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(5, this.jTu);
            }
            aVar.fT(9, this.lOH);
            aVar.T(10, this.rcq);
            if (this.rmy != null) {
                aVar.g(11, this.rmy);
            }
            if (this.rmC == null) {
                return 0;
            }
            aVar.g(12, this.rmC);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rmn != null) {
                fS += f.a.a.b.b.a.h(3, this.rmn);
            }
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(4, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(5, this.jTu);
            }
            fS = (fS + f.a.a.a.fQ(9, this.lOH)) + f.a.a.a.S(10, this.rcq);
            if (this.rmy != null) {
                fS += f.a.a.b.b.a.h(11, this.rmy);
            }
            if (this.rmC != null) {
                fS += f.a.a.b.b.a.h(12, this.rmC);
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
            kj kjVar = (kj) objArr[1];
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
                        kjVar.six = flVar;
                    }
                    return 0;
                case 3:
                    kjVar.rmn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    kjVar.jTv = aVar3.vHC.readString();
                    return 0;
                case 5:
                    kjVar.jTu = aVar3.vHC.readString();
                    return 0;
                case 9:
                    kjVar.lOH = aVar3.vHC.rY();
                    return 0;
                case 10:
                    kjVar.rcq = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    kjVar.rmy = aVar3.vHC.readString();
                    return 0;
                case 12:
                    kjVar.rmC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
