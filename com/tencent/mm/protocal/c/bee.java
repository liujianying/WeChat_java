package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bee extends bhp {
    public long cfh;
    public int kLd;
    public int kLe;
    public String kLf;
    public String kLg;
    public String kLh;
    public int qYf;
    public int sbd;
    public int sbe;
    public int sbf;
    public long sbg;
    public long sbh;
    public LinkedList<alo> sbi = new LinkedList();
    public String sbj;
    public String sbk;
    public String sbl;
    public int sbm;
    public int sbn;
    public String sbo;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.T(2, this.cfh);
            aVar.fT(3, this.sbf);
            aVar.T(4, this.sbg);
            aVar.fT(5, this.qYf);
            aVar.T(6, this.sbh);
            aVar.fT(9, this.kLe);
            aVar.d(10, 8, this.sbi);
            if (this.kLf != null) {
                aVar.g(11, this.kLf);
            }
            if (this.sbj != null) {
                aVar.g(12, this.sbj);
            }
            if (this.sbk != null) {
                aVar.g(13, this.sbk);
            }
            if (this.sbl != null) {
                aVar.g(14, this.sbl);
            }
            aVar.fT(15, this.sbm);
            if (this.kLh != null) {
                aVar.g(16, this.kLh);
            }
            aVar.fT(17, this.sbn);
            if (this.kLg != null) {
                aVar.g(18, this.kLg);
            }
            aVar.fT(19, this.sbe);
            aVar.fT(20, this.kLd);
            aVar.fT(21, this.sbd);
            if (this.sbo == null) {
                return 0;
            }
            aVar.g(22, this.sbo);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((((fS + f.a.a.a.S(2, this.cfh)) + f.a.a.a.fQ(3, this.sbf)) + f.a.a.a.S(4, this.sbg)) + f.a.a.a.fQ(5, this.qYf)) + f.a.a.a.S(6, this.sbh)) + f.a.a.a.fQ(9, this.kLe)) + f.a.a.a.c(10, 8, this.sbi);
            if (this.kLf != null) {
                fS += f.a.a.b.b.a.h(11, this.kLf);
            }
            if (this.sbj != null) {
                fS += f.a.a.b.b.a.h(12, this.sbj);
            }
            if (this.sbk != null) {
                fS += f.a.a.b.b.a.h(13, this.sbk);
            }
            if (this.sbl != null) {
                fS += f.a.a.b.b.a.h(14, this.sbl);
            }
            fS += f.a.a.a.fQ(15, this.sbm);
            if (this.kLh != null) {
                fS += f.a.a.b.b.a.h(16, this.kLh);
            }
            fS += f.a.a.a.fQ(17, this.sbn);
            if (this.kLg != null) {
                fS += f.a.a.b.b.a.h(18, this.kLg);
            }
            fS = ((fS + f.a.a.a.fQ(19, this.sbe)) + f.a.a.a.fQ(20, this.kLd)) + f.a.a.a.fQ(21, this.sbd);
            if (this.sbo != null) {
                fS += f.a.a.b.b.a.h(22, this.sbo);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sbi.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bee bee = (bee) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
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
                        bee.six = flVar;
                    }
                    return 0;
                case 2:
                    bee.cfh = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bee.sbf = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bee.sbg = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bee.qYf = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bee.sbh = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    bee.kLe = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alo alo = new alo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alo.a(aVar4, alo, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bee.sbi.add(alo);
                    }
                    return 0;
                case 11:
                    bee.kLf = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bee.sbj = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bee.sbk = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bee.sbl = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bee.sbm = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bee.kLh = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bee.sbn = aVar3.vHC.rY();
                    return 0;
                case 18:
                    bee.kLg = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bee.sbe = aVar3.vHC.rY();
                    return 0;
                case 20:
                    bee.kLd = aVar3.vHC.rY();
                    return 0;
                case 21:
                    bee.sbd = aVar3.vHC.rY();
                    return 0;
                case 22:
                    bee.sbo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
