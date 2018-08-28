package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ayk extends bhp {
    public long cfh;
    public int kLd;
    public int kLe;
    public String kLf;
    public String kLg;
    public String kLh;
    public int qYf;
    public bfi ryB;
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
            aVar.fT(2, this.sbd);
            aVar.fT(3, this.sbe);
            aVar.fT(4, this.kLd);
            aVar.T(5, this.cfh);
            aVar.fT(6, this.sbf);
            aVar.T(7, this.sbg);
            aVar.fT(8, this.qYf);
            aVar.T(9, this.sbh);
            aVar.fT(10, this.kLe);
            aVar.d(11, 8, this.sbi);
            if (this.kLf != null) {
                aVar.g(12, this.kLf);
            }
            if (this.sbj != null) {
                aVar.g(13, this.sbj);
            }
            if (this.sbk != null) {
                aVar.g(14, this.sbk);
            }
            if (this.sbl != null) {
                aVar.g(15, this.sbl);
            }
            aVar.fT(16, this.sbm);
            if (this.kLh != null) {
                aVar.g(17, this.kLh);
            }
            aVar.fT(18, this.sbn);
            if (this.kLg != null) {
                aVar.g(19, this.kLg);
            }
            if (this.ryB != null) {
                aVar.fV(20, this.ryB.boi());
                this.ryB.a(aVar);
            }
            if (this.sbo == null) {
                return 0;
            }
            aVar.g(21, this.sbo);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((((((((fS + f.a.a.a.fQ(2, this.sbd)) + f.a.a.a.fQ(3, this.sbe)) + f.a.a.a.fQ(4, this.kLd)) + f.a.a.a.S(5, this.cfh)) + f.a.a.a.fQ(6, this.sbf)) + f.a.a.a.S(7, this.sbg)) + f.a.a.a.fQ(8, this.qYf)) + f.a.a.a.S(9, this.sbh)) + f.a.a.a.fQ(10, this.kLe)) + f.a.a.a.c(11, 8, this.sbi);
            if (this.kLf != null) {
                fS += f.a.a.b.b.a.h(12, this.kLf);
            }
            if (this.sbj != null) {
                fS += f.a.a.b.b.a.h(13, this.sbj);
            }
            if (this.sbk != null) {
                fS += f.a.a.b.b.a.h(14, this.sbk);
            }
            if (this.sbl != null) {
                fS += f.a.a.b.b.a.h(15, this.sbl);
            }
            fS += f.a.a.a.fQ(16, this.sbm);
            if (this.kLh != null) {
                fS += f.a.a.b.b.a.h(17, this.kLh);
            }
            fS += f.a.a.a.fQ(18, this.sbn);
            if (this.kLg != null) {
                fS += f.a.a.b.b.a.h(19, this.kLg);
            }
            if (this.ryB != null) {
                fS += f.a.a.a.fS(20, this.ryB.boi());
            }
            if (this.sbo != null) {
                fS += f.a.a.b.b.a.h(21, this.sbo);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sbi.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            ayk ayk = (ayk) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        ayk.six = flVar;
                    }
                    return 0;
                case 2:
                    ayk.sbd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ayk.sbe = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ayk.kLd = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ayk.cfh = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    ayk.sbf = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ayk.sbg = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    ayk.qYf = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ayk.sbh = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    ayk.kLe = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alo alo = new alo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alo.a(aVar4, alo, bhp.a(aVar4))) {
                        }
                        ayk.sbi.add(alo);
                    }
                    return 0;
                case 12:
                    ayk.kLf = aVar3.vHC.readString();
                    return 0;
                case 13:
                    ayk.sbj = aVar3.vHC.readString();
                    return 0;
                case 14:
                    ayk.sbk = aVar3.vHC.readString();
                    return 0;
                case 15:
                    ayk.sbl = aVar3.vHC.readString();
                    return 0;
                case 16:
                    ayk.sbm = aVar3.vHC.rY();
                    return 0;
                case 17:
                    ayk.kLh = aVar3.vHC.readString();
                    return 0;
                case 18:
                    ayk.sbn = aVar3.vHC.rY();
                    return 0;
                case 19:
                    ayk.kLg = aVar3.vHC.readString();
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bfi bfi = new bfi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfi.a(aVar4, bfi, bhp.a(aVar4))) {
                        }
                        ayk.ryB = bfi;
                    }
                    return 0;
                case 21:
                    ayk.sbo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
