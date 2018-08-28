package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bfo extends bhp {
    public String hyz;
    public int kLd;
    public int kLe;
    public String kLf;
    public b sbc;
    public int sbd;
    public int sbe;
    public String sbj;
    public String sbk;
    public String sbl;
    public int sbm;
    public String sbo;

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
            aVar.fT(2, this.sbd);
            if (this.kLf != null) {
                aVar.g(3, this.kLf);
            }
            if (this.sbk != null) {
                aVar.g(4, this.sbk);
            }
            if (this.sbl != null) {
                aVar.g(5, this.sbl);
            }
            if (this.sbc != null) {
                aVar.b(6, this.sbc);
            }
            aVar.fT(7, this.sbe);
            aVar.fT(8, this.kLd);
            aVar.fT(9, this.sbm);
            aVar.fT(10, this.kLe);
            if (this.hyz != null) {
                aVar.g(11, this.hyz);
            }
            if (this.sbo != null) {
                aVar.g(12, this.sbo);
            }
            if (this.sbj == null) {
                return 0;
            }
            aVar.g(13, this.sbj);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.sbd);
            if (this.kLf != null) {
                fS += f.a.a.b.b.a.h(3, this.kLf);
            }
            if (this.sbk != null) {
                fS += f.a.a.b.b.a.h(4, this.sbk);
            }
            if (this.sbl != null) {
                fS += f.a.a.b.b.a.h(5, this.sbl);
            }
            if (this.sbc != null) {
                fS += f.a.a.a.a(6, this.sbc);
            }
            fS = (((fS + f.a.a.a.fQ(7, this.sbe)) + f.a.a.a.fQ(8, this.kLd)) + f.a.a.a.fQ(9, this.sbm)) + f.a.a.a.fQ(10, this.kLe);
            if (this.hyz != null) {
                fS += f.a.a.b.b.a.h(11, this.hyz);
            }
            if (this.sbo != null) {
                fS += f.a.a.b.b.a.h(12, this.sbo);
            }
            if (this.sbj != null) {
                fS += f.a.a.b.b.a.h(13, this.sbj);
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
            bfo bfo = (bfo) objArr[1];
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
                        bfo.six = flVar;
                    }
                    return 0;
                case 2:
                    bfo.sbd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bfo.kLf = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bfo.sbk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bfo.sbl = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bfo.sbc = aVar3.cJR();
                    return 0;
                case 7:
                    bfo.sbe = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bfo.kLd = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bfo.sbm = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bfo.kLe = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bfo.hyz = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bfo.sbo = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bfo.sbj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
