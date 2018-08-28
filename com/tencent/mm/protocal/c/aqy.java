package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aqy extends bhd {
    public String ebL;
    public int qZc;
    public int rTv;
    public int rTw;
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
            if (this.ebL != null) {
                aVar.g(9, this.ebL);
            }
            aVar.fT(10, this.rTv);
            aVar.fT(11, this.rTw);
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
            if (this.ebL != null) {
                fS += f.a.a.b.b.a.h(9, this.ebL);
            }
            return (fS + f.a.a.a.fQ(10, this.rTv)) + f.a.a.a.fQ(11, this.rTw);
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
            aqy aqy = (aqy) objArr[1];
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
                        aqy.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aqy.qZc = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aqy.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 4:
                    aqy.rms = aVar3.vHC.readFloat();
                    return 0;
                case 5:
                    aqy.ryV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aqy.ryW = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aqy.ryX = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aqy.ryY = aVar3.vHC.rY();
                    return 0;
                case 9:
                    aqy.ebL = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aqy.rTv = aVar3.vHC.rY();
                    return 0;
                case 11:
                    aqy.rTw = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
