package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bbv extends bhd {
    public String jTu;
    public int rxG;
    public long rxH;
    public long see;
    public int sef;
    public String seg;
    public long seh;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            if (this.jTu != null) {
                aVar.g(4, this.jTu);
            }
            aVar.T(5, this.see);
            aVar.fT(6, this.sef);
            if (this.seg != null) {
                aVar.g(7, this.seg);
            }
            aVar.T(8, this.seh);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH);
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(4, this.jTu);
            }
            fS = (fS + f.a.a.a.S(5, this.see)) + f.a.a.a.fQ(6, this.sef);
            if (this.seg != null) {
                fS += f.a.a.b.b.a.h(7, this.seg);
            }
            return fS + f.a.a.a.S(8, this.seh);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bbv bbv = (bbv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bbv.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bbv.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bbv.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bbv.jTu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbv.see = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bbv.sef = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bbv.seg = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bbv.seh = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
