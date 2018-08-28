package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aqt extends bhd {
    public int qZc;
    public bhy rTr;
    public float rmr;
    public float rms;
    public int ryV;
    public String ryW;
    public String ryX;
    public int ryY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.qZc);
            aVar.l(3, this.rmr);
            aVar.l(4, this.rms);
            aVar.fT(5, this.ryV);
            if (this.ryW != null) {
                aVar.g(6, this.ryW);
            }
            if (this.ryX != null) {
                aVar.g(7, this.ryX);
            }
            aVar.fT(8, this.ryY);
            if (this.rTr == null) {
                return 0;
            }
            aVar.fV(9, this.rTr.boi());
            this.rTr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((fS + f.a.a.a.fQ(2, this.qZc)) + (f.a.a.b.b.a.ec(3) + 4)) + (f.a.a.b.b.a.ec(4) + 4)) + f.a.a.a.fQ(5, this.ryV);
            if (this.ryW != null) {
                fS += f.a.a.b.b.a.h(6, this.ryW);
            }
            if (this.ryX != null) {
                fS += f.a.a.b.b.a.h(7, this.ryX);
            }
            fS += f.a.a.a.fQ(8, this.ryY);
            if (this.rTr != null) {
                fS += f.a.a.a.fS(9, this.rTr.boi());
            }
            return fS;
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
            aqt aqt = (aqt) objArr[1];
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
                        aqt.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aqt.qZc = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aqt.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 4:
                    aqt.rms = aVar3.vHC.readFloat();
                    return 0;
                case 5:
                    aqt.ryV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aqt.ryW = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aqt.ryX = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aqt.ryY = aVar3.vHC.rY();
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
                        aqt.rTr = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
