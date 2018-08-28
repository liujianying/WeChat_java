package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aek extends bhp {
    public int hwV;
    public String hwW;
    public asp rHh;
    public ke rIx;
    public alp rIy;
    public amp rIz;
    public alr rrT;

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
            if (this.rrT != null) {
                aVar.fV(4, this.rrT.boi());
                this.rrT.a(aVar);
            }
            if (this.rIx != null) {
                aVar.fV(8, this.rIx.boi());
                this.rIx.a(aVar);
            }
            if (this.rHh != null) {
                aVar.fV(9, this.rHh.boi());
                this.rHh.a(aVar);
            }
            if (this.rIy != null) {
                aVar.fV(10, this.rIy.boi());
                this.rIy.a(aVar);
            }
            if (this.rIz == null) {
                return 0;
            }
            aVar.fV(11, this.rIz.boi());
            this.rIz.a(aVar);
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
            if (this.rrT != null) {
                fS += f.a.a.a.fS(4, this.rrT.boi());
            }
            if (this.rIx != null) {
                fS += f.a.a.a.fS(8, this.rIx.boi());
            }
            if (this.rHh != null) {
                fS += f.a.a.a.fS(9, this.rHh.boi());
            }
            if (this.rIy != null) {
                fS += f.a.a.a.fS(10, this.rIy.boi());
            }
            if (this.rIz != null) {
                fS += f.a.a.a.fS(11, this.rIz.boi());
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
            aek aek = (aek) objArr[1];
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
                        aek.six = flVar;
                    }
                    return 0;
                case 2:
                    aek.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aek.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alr alr = new alr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alr.a(aVar4, alr, bhp.a(aVar4))) {
                        }
                        aek.rrT = alr;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ke keVar = new ke();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = keVar.a(aVar4, keVar, bhp.a(aVar4))) {
                        }
                        aek.rIx = keVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        asp asp = new asp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asp.a(aVar4, asp, bhp.a(aVar4))) {
                        }
                        aek.rHh = asp;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alp alp = new alp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alp.a(aVar4, alp, bhp.a(aVar4))) {
                        }
                        aek.rIy = alp;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amp amp = new amp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amp.a(aVar4, amp, bhp.a(aVar4))) {
                        }
                        aek.rIz = amp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
