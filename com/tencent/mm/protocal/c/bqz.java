package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bqz extends bhd {
    public String jTu;
    public String jTv;
    public String rdo;
    public int spd;
    public int spe;
    public LinkedList<brb> spf = new LinkedList();
    public bqy spg;
    public int sph;
    public LinkedList<bqy> spi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.spd);
            if (this.jTv != null) {
                aVar.g(3, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(4, this.jTu);
            }
            if (this.rdo != null) {
                aVar.g(5, this.rdo);
            }
            aVar.fT(6, this.spe);
            aVar.d(7, 8, this.spf);
            if (this.spg != null) {
                aVar.fV(8, this.spg.boi());
                this.spg.a(aVar);
            }
            aVar.fT(9, this.sph);
            aVar.d(10, 8, this.spi);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.spd);
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(3, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(4, this.jTu);
            }
            if (this.rdo != null) {
                fS += f.a.a.b.b.a.h(5, this.rdo);
            }
            fS = (fS + f.a.a.a.fQ(6, this.spe)) + f.a.a.a.c(7, 8, this.spf);
            if (this.spg != null) {
                fS += f.a.a.a.fS(8, this.spg.boi());
            }
            return (fS + f.a.a.a.fQ(9, this.sph)) + f.a.a.a.c(10, 8, this.spi);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.spf.clear();
            this.spi.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqz bqz = (bqz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bqy bqy;
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
                        bqz.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bqz.spd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bqz.jTv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bqz.jTu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bqz.rdo = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bqz.spe = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brb brb = new brb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brb.a(aVar4, brb, bhd.a(aVar4))) {
                        }
                        bqz.spf.add(brb);
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqy = new bqy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqy.a(aVar4, bqy, bhd.a(aVar4))) {
                        }
                        bqz.spg = bqy;
                    }
                    return 0;
                case 9:
                    bqz.sph = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqy = new bqy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqy.a(aVar4, bqy, bhd.a(aVar4))) {
                        }
                        bqz.spi.add(bqy);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
