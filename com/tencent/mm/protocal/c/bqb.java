package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bqb extends bhd {
    public int hcE;
    public String jQb;
    public int rWa;
    public int rWb;
    public int rXx;
    public String rcc;
    public int rdV;
    public int rdW;
    public String rej;
    public bhy rfy;
    public int rth;
    public String rwt;
    public bue sdt;
    public int soa;
    public int sob;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rfy == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.hcE);
            aVar.fT(3, this.rdW);
            aVar.fT(4, this.rdV);
            if (this.rfy != null) {
                aVar.fV(5, this.rfy.boi());
                this.rfy.a(aVar);
            }
            if (this.rcc != null) {
                aVar.g(6, this.rcc);
            }
            aVar.fT(7, this.rWa);
            aVar.fT(8, this.rWb);
            if (this.rej != null) {
                aVar.g(9, this.rej);
            }
            aVar.fT(10, this.soa);
            aVar.fT(11, this.rth);
            if (this.sdt != null) {
                aVar.fV(12, this.sdt.boi());
                this.sdt.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(13, this.jQb);
            }
            aVar.fT(14, this.rXx);
            if (this.rwt != null) {
                aVar.g(15, this.rwt);
            }
            aVar.fT(16, this.sob);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.hcE)) + f.a.a.a.fQ(3, this.rdW)) + f.a.a.a.fQ(4, this.rdV);
            if (this.rfy != null) {
                fS += f.a.a.a.fS(5, this.rfy.boi());
            }
            if (this.rcc != null) {
                fS += f.a.a.b.b.a.h(6, this.rcc);
            }
            fS = (fS + f.a.a.a.fQ(7, this.rWa)) + f.a.a.a.fQ(8, this.rWb);
            if (this.rej != null) {
                fS += f.a.a.b.b.a.h(9, this.rej);
            }
            fS = (fS + f.a.a.a.fQ(10, this.soa)) + f.a.a.a.fQ(11, this.rth);
            if (this.sdt != null) {
                fS += f.a.a.a.fS(12, this.sdt.boi());
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(13, this.jQb);
            }
            fS += f.a.a.a.fQ(14, this.rXx);
            if (this.rwt != null) {
                fS += f.a.a.b.b.a.h(15, this.rwt);
            }
            return fS + f.a.a.a.fQ(16, this.sob);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rfy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqb bqb = (bqb) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bqb.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bqb.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bqb.rdW = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bqb.rdV = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bqb.rfy = bhy;
                    }
                    return 0;
                case 6:
                    bqb.rcc = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bqb.rWa = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bqb.rWb = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bqb.rej = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bqb.soa = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bqb.rth = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bue bue = new bue();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bue.a(aVar4, bue, bhd.a(aVar4))) {
                        }
                        bqb.sdt = bue;
                    }
                    return 0;
                case 13:
                    bqb.jQb = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bqb.rXx = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bqb.rwt = aVar3.vHC.readString();
                    return 0;
                case 16:
                    bqb.sob = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
