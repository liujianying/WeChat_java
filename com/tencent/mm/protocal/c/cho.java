package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cho extends a {
    public int riv;
    public String rwk;
    public int sBF;
    public boolean sBG;
    public chl sBu;
    public int sil;
    public int sin;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sBu != null) {
                aVar.fV(1, this.sBu.boi());
                this.sBu.a(aVar);
            }
            aVar.fT(2, this.sBF);
            aVar.fT(3, this.sil);
            aVar.fT(4, this.sin);
            aVar.av(5, this.sBG);
            aVar.fT(6, this.riv);
            if (this.rwk == null) {
                return 0;
            }
            aVar.g(7, this.rwk);
            return 0;
        } else if (i == 1) {
            if (this.sBu != null) {
                fS = f.a.a.a.fS(1, this.sBu.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.sBF)) + f.a.a.a.fQ(3, this.sil)) + f.a.a.a.fQ(4, this.sin)) + (f.a.a.b.b.a.ec(5) + 1)) + f.a.a.a.fQ(6, this.riv);
            if (this.rwk != null) {
                fS += f.a.a.b.b.a.h(7, this.rwk);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cho cho = (cho) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        chl chl = new chl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chl.a(aVar4, chl, a.a(aVar4))) {
                        }
                        cho.sBu = chl;
                    }
                    return 0;
                case 2:
                    cho.sBF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cho.sil = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cho.sin = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cho.sBG = aVar3.cJQ();
                    return 0;
                case 6:
                    cho.riv = aVar3.vHC.rY();
                    return 0;
                case 7:
                    cho.rwk = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
