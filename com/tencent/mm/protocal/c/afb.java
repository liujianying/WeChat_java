package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class afb extends bhd {
    public int Height;
    public int Width;
    public String iwP;
    public int rJk;
    public int rJl;
    public float rmr;
    public float rms;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.l(2, this.rmr);
            aVar.l(3, this.rms);
            aVar.fT(4, this.Width);
            aVar.fT(5, this.Height);
            if (this.iwP != null) {
                aVar.g(6, this.iwP);
            }
            aVar.fT(7, this.rJk);
            aVar.fT(8, this.rJl);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((fS + (f.a.a.b.b.a.ec(2) + 4)) + (f.a.a.b.b.a.ec(3) + 4)) + f.a.a.a.fQ(4, this.Width)) + f.a.a.a.fQ(5, this.Height);
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(6, this.iwP);
            }
            return (fS + f.a.a.a.fQ(7, this.rJk)) + f.a.a.a.fQ(8, this.rJl);
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
            afb afb = (afb) objArr[1];
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
                        afb.shX = fkVar;
                    }
                    return 0;
                case 2:
                    afb.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 3:
                    afb.rms = aVar3.vHC.readFloat();
                    return 0;
                case 4:
                    afb.Width = aVar3.vHC.rY();
                    return 0;
                case 5:
                    afb.Height = aVar3.vHC.rY();
                    return 0;
                case 6:
                    afb.iwP = aVar3.vHC.readString();
                    return 0;
                case 7:
                    afb.rJk = aVar3.vHC.rY();
                    return 0;
                case 8:
                    afb.rJl = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
