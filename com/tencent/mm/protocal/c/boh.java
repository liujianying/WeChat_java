package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class boh extends a {
    public int hcE;
    public String jSA;
    public int lOH;
    public int rdq;
    public String rxF;
    public String seC;
    public String sme;
    public String smf;
    public int smg;
    public int smh;
    public int smi;
    public long smj;
    public long smk;
    public bhy sml;
    public int smm;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.seC != null) {
                aVar.g(1, this.seC);
            }
            if (this.rxF != null) {
                aVar.g(2, this.rxF);
            }
            if (this.sme != null) {
                aVar.g(3, this.sme);
            }
            if (this.smf != null) {
                aVar.g(4, this.smf);
            }
            aVar.fT(5, this.hcE);
            aVar.fT(6, this.rdq);
            aVar.fT(7, this.lOH);
            if (this.jSA != null) {
                aVar.g(8, this.jSA);
            }
            aVar.fT(9, this.smg);
            aVar.fT(10, this.smh);
            aVar.fT(11, this.smi);
            aVar.T(12, this.smj);
            aVar.T(13, this.smk);
            if (this.sml != null) {
                aVar.fV(14, this.sml.boi());
                this.sml.a(aVar);
            }
            aVar.fT(15, this.smm);
            return 0;
        } else if (i == 1) {
            if (this.seC != null) {
                h = f.a.a.b.b.a.h(1, this.seC) + 0;
            } else {
                h = 0;
            }
            if (this.rxF != null) {
                h += f.a.a.b.b.a.h(2, this.rxF);
            }
            if (this.sme != null) {
                h += f.a.a.b.b.a.h(3, this.sme);
            }
            if (this.smf != null) {
                h += f.a.a.b.b.a.h(4, this.smf);
            }
            h = ((h + f.a.a.a.fQ(5, this.hcE)) + f.a.a.a.fQ(6, this.rdq)) + f.a.a.a.fQ(7, this.lOH);
            if (this.jSA != null) {
                h += f.a.a.b.b.a.h(8, this.jSA);
            }
            h = ((((h + f.a.a.a.fQ(9, this.smg)) + f.a.a.a.fQ(10, this.smh)) + f.a.a.a.fQ(11, this.smi)) + f.a.a.a.S(12, this.smj)) + f.a.a.a.S(13, this.smk);
            if (this.sml != null) {
                h += f.a.a.a.fS(14, this.sml.boi());
            }
            return h + f.a.a.a.fQ(15, this.smm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            boh boh = (boh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    boh.seC = aVar3.vHC.readString();
                    return 0;
                case 2:
                    boh.rxF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    boh.sme = aVar3.vHC.readString();
                    return 0;
                case 4:
                    boh.smf = aVar3.vHC.readString();
                    return 0;
                case 5:
                    boh.hcE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    boh.rdq = aVar3.vHC.rY();
                    return 0;
                case 7:
                    boh.lOH = aVar3.vHC.rY();
                    return 0;
                case 8:
                    boh.jSA = aVar3.vHC.readString();
                    return 0;
                case 9:
                    boh.smg = aVar3.vHC.rY();
                    return 0;
                case 10:
                    boh.smh = aVar3.vHC.rY();
                    return 0;
                case 11:
                    boh.smi = aVar3.vHC.rY();
                    return 0;
                case 12:
                    boh.smj = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    boh.smk = aVar3.vHC.rZ();
                    return 0;
                case 14:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        boh.sml = bhy;
                    }
                    return 0;
                case 15:
                    boh.smm = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
