package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwv extends bhd {
    public String jTu;
    public String jTv;
    public int rVw;
    public int rci;
    public String rco;
    public long rcq;
    public String rdo;
    public int rgC;
    public int rjC;
    public bhy rtW;
    public int rvV;
    public int rvX;
    public int rvY;
    public int rwB;
    public int sth;
    public int sti;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.jTv != null) {
                aVar.g(1, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(2, this.jTu);
            }
            aVar.fT(3, this.rjC);
            aVar.fT(4, this.rvV);
            if (this.rdo != null) {
                aVar.g(5, this.rdo);
            }
            aVar.fT(6, this.rci);
            aVar.fT(7, this.rvX);
            if (this.rtW != null) {
                aVar.fV(8, this.rtW.boi());
                this.rtW.a(aVar);
            }
            aVar.fT(9, this.rgC);
            if (this.shX != null) {
                aVar.fV(10, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(11, this.rvY);
            if (this.rco != null) {
                aVar.g(12, this.rco);
            }
            aVar.fT(13, this.rVw);
            aVar.fT(14, this.sth);
            aVar.fT(15, this.sti);
            aVar.T(16, this.rcq);
            aVar.fT(17, this.rwB);
            return 0;
        } else if (i == 1) {
            if (this.jTv != null) {
                h = f.a.a.b.b.a.h(1, this.jTv) + 0;
            } else {
                h = 0;
            }
            if (this.jTu != null) {
                h += f.a.a.b.b.a.h(2, this.jTu);
            }
            h = (h + f.a.a.a.fQ(3, this.rjC)) + f.a.a.a.fQ(4, this.rvV);
            if (this.rdo != null) {
                h += f.a.a.b.b.a.h(5, this.rdo);
            }
            h = (h + f.a.a.a.fQ(6, this.rci)) + f.a.a.a.fQ(7, this.rvX);
            if (this.rtW != null) {
                h += f.a.a.a.fS(8, this.rtW.boi());
            }
            h += f.a.a.a.fQ(9, this.rgC);
            if (this.shX != null) {
                h += f.a.a.a.fS(10, this.shX.boi());
            }
            h += f.a.a.a.fQ(11, this.rvY);
            if (this.rco != null) {
                h += f.a.a.b.b.a.h(12, this.rco);
            }
            return ((((h + f.a.a.a.fQ(13, this.rVw)) + f.a.a.a.fQ(14, this.sth)) + f.a.a.a.fQ(15, this.sti)) + f.a.a.a.S(16, this.rcq)) + f.a.a.a.fQ(17, this.rwB);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = bhd.a(aVar2); h > 0; h = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
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
            bwv bwv = (bwv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bwv.jTv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bwv.jTu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bwv.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bwv.rvV = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bwv.rdo = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bwv.rci = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bwv.rvX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bwv.rtW = bhy;
                    }
                    return 0;
                case 9:
                    bwv.rgC = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bwv.shX = fkVar;
                    }
                    return 0;
                case 11:
                    bwv.rvY = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bwv.rco = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bwv.rVw = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bwv.sth = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bwv.sti = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bwv.rcq = aVar3.vHC.rZ();
                    return 0;
                case 17:
                    bwv.rwB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
