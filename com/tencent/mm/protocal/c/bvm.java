package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bvm extends bhd {
    public String hbL;
    public int hcE;
    public String jQb;
    public int rdV;
    public int rdW;
    public int rdX;
    public int rdn;
    public bhy rtW;
    public String rwt;
    public String ssa;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            aVar.fT(3, this.rdn);
            if (this.ssa != null) {
                aVar.g(4, this.ssa);
            }
            if (this.hbL != null) {
                aVar.g(5, this.hbL);
            }
            aVar.fT(6, this.rdV);
            aVar.fT(7, this.rdW);
            aVar.fT(8, this.rdX);
            if (this.rtW != null) {
                aVar.fV(9, this.rtW.boi());
                this.rtW.a(aVar);
            }
            aVar.fT(10, this.hcE);
            if (this.rwt == null) {
                return 0;
            }
            aVar.g(11, this.rwt);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(2, this.jQb);
            }
            fS += f.a.a.a.fQ(3, this.rdn);
            if (this.ssa != null) {
                fS += f.a.a.b.b.a.h(4, this.ssa);
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(5, this.hbL);
            }
            fS = ((fS + f.a.a.a.fQ(6, this.rdV)) + f.a.a.a.fQ(7, this.rdW)) + f.a.a.a.fQ(8, this.rdX);
            if (this.rtW != null) {
                fS += f.a.a.a.fS(9, this.rtW.boi());
            }
            fS += f.a.a.a.fQ(10, this.hcE);
            if (this.rwt != null) {
                fS += f.a.a.b.b.a.h(11, this.rwt);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rtW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bvm bvm = (bvm) objArr[1];
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
                        bvm.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvm.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bvm.rdn = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bvm.ssa = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bvm.hbL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bvm.rdV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bvm.rdW = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bvm.rdX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bvm.rtW = bhy;
                    }
                    return 0;
                case 10:
                    bvm.hcE = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bvm.rwt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
