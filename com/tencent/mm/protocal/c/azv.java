package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class azv extends a {
    public String dWh;
    public String lNV;
    public String myq;
    public String rQl;
    public int scA;
    public String scB;
    public long scC;
    public LinkedList<azm> scD = new LinkedList();
    public int scw;
    public String scx;
    public int scy;
    public String scz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.scw);
            if (this.scx != null) {
                aVar.g(2, this.scx);
            }
            if (this.rQl != null) {
                aVar.g(3, this.rQl);
            }
            aVar.fT(4, this.scy);
            if (this.lNV != null) {
                aVar.g(5, this.lNV);
            }
            if (this.scz != null) {
                aVar.g(6, this.scz);
            }
            if (this.myq != null) {
                aVar.g(7, this.myq);
            }
            aVar.fT(8, this.scA);
            if (this.dWh != null) {
                aVar.g(9, this.dWh);
            }
            if (this.scB != null) {
                aVar.g(10, this.scB);
            }
            aVar.T(11, this.scC);
            aVar.d(12, 8, this.scD);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.scw) + 0;
            if (this.scx != null) {
                fQ += f.a.a.b.b.a.h(2, this.scx);
            }
            if (this.rQl != null) {
                fQ += f.a.a.b.b.a.h(3, this.rQl);
            }
            fQ += f.a.a.a.fQ(4, this.scy);
            if (this.lNV != null) {
                fQ += f.a.a.b.b.a.h(5, this.lNV);
            }
            if (this.scz != null) {
                fQ += f.a.a.b.b.a.h(6, this.scz);
            }
            if (this.myq != null) {
                fQ += f.a.a.b.b.a.h(7, this.myq);
            }
            fQ += f.a.a.a.fQ(8, this.scA);
            if (this.dWh != null) {
                fQ += f.a.a.b.b.a.h(9, this.dWh);
            }
            if (this.scB != null) {
                fQ += f.a.a.b.b.a.h(10, this.scB);
            }
            return (fQ + f.a.a.a.S(11, this.scC)) + f.a.a.a.c(12, 8, this.scD);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.scD.clear();
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
            azv azv = (azv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azv.scw = aVar3.vHC.rY();
                    return 0;
                case 2:
                    azv.scx = aVar3.vHC.readString();
                    return 0;
                case 3:
                    azv.rQl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    azv.scy = aVar3.vHC.rY();
                    return 0;
                case 5:
                    azv.lNV = aVar3.vHC.readString();
                    return 0;
                case 6:
                    azv.scz = aVar3.vHC.readString();
                    return 0;
                case 7:
                    azv.myq = aVar3.vHC.readString();
                    return 0;
                case 8:
                    azv.scA = aVar3.vHC.rY();
                    return 0;
                case 9:
                    azv.dWh = aVar3.vHC.readString();
                    return 0;
                case 10:
                    azv.scB = aVar3.vHC.readString();
                    return 0;
                case 11:
                    azv.scC = aVar3.vHC.rZ();
                    return 0;
                case 12:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        azm azm = new azm();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = azm.a(aVar4, azm, a.a(aVar4))) {
                        }
                        azv.scD.add(azm);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
