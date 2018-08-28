package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bbs extends a {
    public int hbF;
    public int hcE;
    public String jPe;
    public String lPl;
    public int otY;
    public String rJU;
    public String rxc;
    public int sdS;
    public LinkedList<apx> sdT = new LinkedList();
    public int sdU;
    public String sdV;
    public String sdW;
    public int sdX;
    public String sdY;
    public int sdZ;
    public LinkedList<sg> sea = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sdS);
            aVar.d(2, 8, this.sdT);
            aVar.fT(3, this.hbF);
            aVar.fT(4, this.sdU);
            if (this.rxc != null) {
                aVar.g(5, this.rxc);
            }
            if (this.rJU != null) {
                aVar.g(6, this.rJU);
            }
            if (this.sdV != null) {
                aVar.g(7, this.sdV);
            }
            if (this.sdW != null) {
                aVar.g(8, this.sdW);
            }
            aVar.fT(9, this.hcE);
            if (this.jPe != null) {
                aVar.g(10, this.jPe);
            }
            if (this.lPl != null) {
                aVar.g(11, this.lPl);
            }
            aVar.fT(12, this.sdX);
            aVar.fT(13, this.otY);
            if (this.sdY != null) {
                aVar.g(14, this.sdY);
            }
            aVar.fT(15, this.sdZ);
            aVar.d(16, 8, this.sea);
            return 0;
        } else if (i == 1) {
            fQ = (((f.a.a.a.fQ(1, this.sdS) + 0) + f.a.a.a.c(2, 8, this.sdT)) + f.a.a.a.fQ(3, this.hbF)) + f.a.a.a.fQ(4, this.sdU);
            if (this.rxc != null) {
                fQ += f.a.a.b.b.a.h(5, this.rxc);
            }
            if (this.rJU != null) {
                fQ += f.a.a.b.b.a.h(6, this.rJU);
            }
            if (this.sdV != null) {
                fQ += f.a.a.b.b.a.h(7, this.sdV);
            }
            if (this.sdW != null) {
                fQ += f.a.a.b.b.a.h(8, this.sdW);
            }
            fQ += f.a.a.a.fQ(9, this.hcE);
            if (this.jPe != null) {
                fQ += f.a.a.b.b.a.h(10, this.jPe);
            }
            if (this.lPl != null) {
                fQ += f.a.a.b.b.a.h(11, this.lPl);
            }
            fQ = (fQ + f.a.a.a.fQ(12, this.sdX)) + f.a.a.a.fQ(13, this.otY);
            if (this.sdY != null) {
                fQ += f.a.a.b.b.a.h(14, this.sdY);
            }
            return (fQ + f.a.a.a.fQ(15, this.sdZ)) + f.a.a.a.c(16, 8, this.sea);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sdT.clear();
            this.sea.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bbs bbs = (bbs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bbs.sdS = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        apx apx = new apx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = apx.a(aVar4, apx, a.a(aVar4))) {
                        }
                        bbs.sdT.add(apx);
                    }
                    return 0;
                case 3:
                    bbs.hbF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bbs.sdU = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bbs.rxc = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bbs.rJU = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bbs.sdV = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bbs.sdW = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bbs.hcE = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bbs.jPe = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bbs.lPl = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bbs.sdX = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bbs.otY = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bbs.sdY = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bbs.sdZ = aVar3.vHC.rY();
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sg sgVar = new sg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sgVar.a(aVar4, sgVar, a.a(aVar4))) {
                        }
                        bbs.sea.add(sgVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
