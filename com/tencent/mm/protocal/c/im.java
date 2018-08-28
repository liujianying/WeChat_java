package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class im extends bhp {
    public int hcE;
    public int rgC;
    public int rjD;
    public String rjF;
    public float rjG;
    public float rjH;
    public int rjz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rjz);
            aVar.fT(3, this.hcE);
            if (this.rjF != null) {
                aVar.g(4, this.rjF);
            }
            aVar.fT(5, this.rgC);
            aVar.fT(6, this.rjD);
            aVar.l(7, this.rjG);
            aVar.l(8, this.rjH);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rjz)) + f.a.a.a.fQ(3, this.hcE);
            if (this.rjF != null) {
                fS += f.a.a.b.b.a.h(4, this.rjF);
            }
            return (((fS + f.a.a.a.fQ(5, this.rgC)) + f.a.a.a.fQ(6, this.rjD)) + (f.a.a.b.b.a.ec(7) + 4)) + (f.a.a.b.b.a.ec(8) + 4);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            im imVar = (im) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        imVar.six = flVar;
                    }
                    return 0;
                case 2:
                    imVar.rjz = aVar3.vHC.rY();
                    return 0;
                case 3:
                    imVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 4:
                    imVar.rjF = aVar3.vHC.readString();
                    return 0;
                case 5:
                    imVar.rgC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    imVar.rjD = aVar3.vHC.rY();
                    return 0;
                case 7:
                    imVar.rjG = aVar3.vHC.readFloat();
                    return 0;
                case 8:
                    imVar.rjH = aVar3.vHC.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
