package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bqc extends bhp {
    public int hcE;
    public int rWy;
    public LinkedList<bok> rWz = new LinkedList();
    public String rcc;
    public int rdV;
    public int rdW;
    public long rlK;
    public bok soc;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.soc == null) {
                throw new b("Not all required fields were included: BufferUrl");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.rdW);
                aVar.fT(3, this.rdV);
                if (this.rcc != null) {
                    aVar.g(4, this.rcc);
                }
                if (this.soc != null) {
                    aVar.fV(5, this.soc.boi());
                    this.soc.a(aVar);
                }
                aVar.fT(6, this.rWy);
                aVar.d(7, 8, this.rWz);
                aVar.T(8, this.rlK);
                aVar.fT(9, this.hcE);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rdW)) + f.a.a.a.fQ(3, this.rdV);
            if (this.rcc != null) {
                fS += f.a.a.b.b.a.h(4, this.rcc);
            }
            if (this.soc != null) {
                fS += f.a.a.a.fS(5, this.soc.boi());
            }
            return (((fS + f.a.a.a.fQ(6, this.rWy)) + f.a.a.a.c(7, 8, this.rWz)) + f.a.a.a.S(8, this.rlK)) + f.a.a.a.fQ(9, this.hcE);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rWz.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.soc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BufferUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqc bqc = (bqc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bok bok;
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
                        bqc.six = flVar;
                    }
                    return 0;
                case 2:
                    bqc.rdW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bqc.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bqc.rcc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bok = new bok();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bok.a(aVar4, bok, bhp.a(aVar4))) {
                        }
                        bqc.soc = bok;
                    }
                    return 0;
                case 6:
                    bqc.rWy = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bok = new bok();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bok.a(aVar4, bok, bhp.a(aVar4))) {
                        }
                        bqc.rWz.add(bok);
                    }
                    return 0;
                case 8:
                    bqc.rlK = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    bqc.hcE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
