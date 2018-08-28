package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class kg extends a {
    public int iwE;
    public int rlX;
    public int rlY;
    public int rlZ;
    public int rma;
    public LinkedList<bhz> rmb = new LinkedList();
    public String rmc;
    public bhy rmd;
    public int rme;
    public int rmf;
    public LinkedList<bhz> rmg = new LinkedList();
    public LinkedList<kh> rmh = new LinkedList();
    public LinkedList<kh> rmi = new LinkedList();
    public int rmj;
    public int rmk;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rmd == null) {
                throw new b("Not all required fields were included: AuthKey");
            }
            aVar.fT(1, this.rlX);
            aVar.fT(2, this.iwE);
            aVar.fT(3, this.rlY);
            aVar.fT(4, this.rlZ);
            aVar.fT(5, this.rma);
            aVar.d(6, 8, this.rmb);
            if (this.rmc != null) {
                aVar.g(7, this.rmc);
            }
            if (this.rmd != null) {
                aVar.fV(8, this.rmd.boi());
                this.rmd.a(aVar);
            }
            aVar.fT(9, this.rme);
            aVar.fT(10, this.rmf);
            aVar.d(11, 8, this.rmg);
            aVar.d(12, 8, this.rmh);
            aVar.d(13, 8, this.rmi);
            aVar.fT(14, this.rmj);
            aVar.fT(15, this.rmk);
            return 0;
        } else if (i == 1) {
            fQ = (((((f.a.a.a.fQ(1, this.rlX) + 0) + f.a.a.a.fQ(2, this.iwE)) + f.a.a.a.fQ(3, this.rlY)) + f.a.a.a.fQ(4, this.rlZ)) + f.a.a.a.fQ(5, this.rma)) + f.a.a.a.c(6, 8, this.rmb);
            if (this.rmc != null) {
                fQ += f.a.a.b.b.a.h(7, this.rmc);
            }
            if (this.rmd != null) {
                fQ += f.a.a.a.fS(8, this.rmd.boi());
            }
            return ((((((fQ + f.a.a.a.fQ(9, this.rme)) + f.a.a.a.fQ(10, this.rmf)) + f.a.a.a.c(11, 8, this.rmg)) + f.a.a.a.c(12, 8, this.rmh)) + f.a.a.a.c(13, 8, this.rmi)) + f.a.a.a.fQ(14, this.rmj)) + f.a.a.a.fQ(15, this.rmk);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rmb.clear();
            this.rmg.clear();
            this.rmh.clear();
            this.rmi.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rmd != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            kg kgVar = (kg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            a bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    kgVar.rlX = aVar3.vHC.rY();
                    return 0;
                case 2:
                    kgVar.iwE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    kgVar.rlY = aVar3.vHC.rY();
                    return 0;
                case 4:
                    kgVar.rlZ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    kgVar.rma = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        kgVar.rmb.add(bhz);
                    }
                    return 0;
                case 7:
                    kgVar.rmc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        kgVar.rmd = bhz;
                    }
                    return 0;
                case 9:
                    kgVar.rme = aVar3.vHC.rY();
                    return 0;
                case 10:
                    kgVar.rmf = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        kgVar.rmg.add(bhz);
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new kh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        kgVar.rmh.add(bhz);
                    }
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new kh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        kgVar.rmi.add(bhz);
                    }
                    return 0;
                case 14:
                    kgVar.rmj = aVar3.vHC.rY();
                    return 0;
                case 15:
                    kgVar.rmk = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
