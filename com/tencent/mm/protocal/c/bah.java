package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bah extends bhd {
    public String jQb;
    public String jTB;
    public int qZe;
    public String rEe;
    public String rhq;
    public String rrC;
    public String rsw;
    public String rsx;
    public String rsy;
    public String rsz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            if (this.rsw != null) {
                aVar.g(3, this.rsw);
            }
            if (this.rhq != null) {
                aVar.g(4, this.rhq);
            }
            if (this.rsx != null) {
                aVar.g(5, this.rsx);
            }
            if (this.rsy != null) {
                aVar.g(6, this.rsy);
            }
            if (this.rsz != null) {
                aVar.g(7, this.rsz);
            }
            if (this.rrC != null) {
                aVar.g(8, this.rrC);
            }
            if (this.rEe != null) {
                aVar.g(9, this.rEe);
            }
            aVar.fT(10, this.qZe);
            if (this.jTB == null) {
                return 0;
            }
            aVar.g(11, this.jTB);
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
            if (this.rsw != null) {
                fS += f.a.a.b.b.a.h(3, this.rsw);
            }
            if (this.rhq != null) {
                fS += f.a.a.b.b.a.h(4, this.rhq);
            }
            if (this.rsx != null) {
                fS += f.a.a.b.b.a.h(5, this.rsx);
            }
            if (this.rsy != null) {
                fS += f.a.a.b.b.a.h(6, this.rsy);
            }
            if (this.rsz != null) {
                fS += f.a.a.b.b.a.h(7, this.rsz);
            }
            if (this.rrC != null) {
                fS += f.a.a.b.b.a.h(8, this.rrC);
            }
            if (this.rEe != null) {
                fS += f.a.a.b.b.a.h(9, this.rEe);
            }
            fS += f.a.a.a.fQ(10, this.qZe);
            if (this.jTB != null) {
                fS += f.a.a.b.b.a.h(11, this.jTB);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bah bah = (bah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bah.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bah.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bah.rsw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bah.rhq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bah.rsx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bah.rsy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bah.rsz = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bah.rrC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bah.rEe = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bah.qZe = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bah.jTB = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
