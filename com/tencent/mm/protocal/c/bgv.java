package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bgv extends bhd {
    public float bSx;
    public float bUg;
    public String cac;
    public float shF;
    public b shG;
    public boolean shH;
    public boolean shI;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.l(2, this.bUg);
            aVar.l(3, this.bSx);
            aVar.l(4, this.shF);
            if (this.shG != null) {
                aVar.b(5, this.shG);
            }
            if (this.cac != null) {
                aVar.g(6, this.cac);
            }
            aVar.av(7, this.shH);
            aVar.av(8, this.shI);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + (f.a.a.b.b.a.ec(2) + 4)) + (f.a.a.b.b.a.ec(3) + 4)) + (f.a.a.b.b.a.ec(4) + 4);
            if (this.shG != null) {
                fS += f.a.a.a.a(5, this.shG);
            }
            if (this.cac != null) {
                fS += f.a.a.b.b.a.h(6, this.cac);
            }
            return (fS + (f.a.a.b.b.a.ec(7) + 1)) + (f.a.a.b.b.a.ec(8) + 1);
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
            bgv bgv = (bgv) objArr[1];
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
                        bgv.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bgv.bUg = aVar3.vHC.readFloat();
                    return 0;
                case 3:
                    bgv.bSx = aVar3.vHC.readFloat();
                    return 0;
                case 4:
                    bgv.shF = aVar3.vHC.readFloat();
                    return 0;
                case 5:
                    bgv.shG = aVar3.cJR();
                    return 0;
                case 6:
                    bgv.cac = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bgv.shH = aVar3.cJQ();
                    return 0;
                case 8:
                    bgv.shI = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
