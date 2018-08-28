package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class mi extends bhp {
    public int amount;
    public String bQa;
    public int hUm;
    public String hUn;
    public String rcE;
    public String rqA;
    public String rqo;
    public String rqp;
    public String rqr;

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
            if (this.bQa != null) {
                aVar.g(4, this.bQa);
            }
            if (this.rqr != null) {
                aVar.g(5, this.rqr);
            }
            if (this.rcE != null) {
                aVar.g(6, this.rcE);
            }
            aVar.fT(7, this.amount);
            if (this.rqA != null) {
                aVar.g(8, this.rqA);
            }
            if (this.rqp != null) {
                aVar.g(9, this.rqp);
            }
            if (this.rqo == null) {
                return 0;
            }
            aVar.g(10, this.rqo);
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
            if (this.bQa != null) {
                fS += f.a.a.b.b.a.h(4, this.bQa);
            }
            if (this.rqr != null) {
                fS += f.a.a.b.b.a.h(5, this.rqr);
            }
            if (this.rcE != null) {
                fS += f.a.a.b.b.a.h(6, this.rcE);
            }
            fS += f.a.a.a.fQ(7, this.amount);
            if (this.rqA != null) {
                fS += f.a.a.b.b.a.h(8, this.rqA);
            }
            if (this.rqp != null) {
                fS += f.a.a.b.b.a.h(9, this.rqp);
            }
            if (this.rqo != null) {
                fS += f.a.a.b.b.a.h(10, this.rqo);
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
            mi miVar = (mi) objArr[1];
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
                        miVar.six = flVar;
                    }
                    return 0;
                case 2:
                    miVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    miVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    miVar.bQa = aVar3.vHC.readString();
                    return 0;
                case 5:
                    miVar.rqr = aVar3.vHC.readString();
                    return 0;
                case 6:
                    miVar.rcE = aVar3.vHC.readString();
                    return 0;
                case 7:
                    miVar.amount = aVar3.vHC.rY();
                    return 0;
                case 8:
                    miVar.rqA = aVar3.vHC.readString();
                    return 0;
                case 9:
                    miVar.rqp = aVar3.vHC.readString();
                    return 0;
                case 10:
                    miVar.rqo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
