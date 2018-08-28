package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ot extends bhp {
    public int iwS;
    public String iwT;
    public String qUU;
    public azw rsE;
    public btk rsY;
    public String token;

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
            aVar.fT(2, this.iwS);
            if (this.iwT != null) {
                aVar.g(3, this.iwT);
            }
            if (this.token != null) {
                aVar.g(4, this.token);
            }
            if (this.rsE != null) {
                aVar.fV(5, this.rsE.boi());
                this.rsE.a(aVar);
            }
            if (this.qUU != null) {
                aVar.g(6, this.qUU);
            }
            if (this.rsY == null) {
                return 0;
            }
            aVar.fV(7, this.rsY.boi());
            this.rsY.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.iwS);
            if (this.iwT != null) {
                fS += f.a.a.b.b.a.h(3, this.iwT);
            }
            if (this.token != null) {
                fS += f.a.a.b.b.a.h(4, this.token);
            }
            if (this.rsE != null) {
                fS += f.a.a.a.fS(5, this.rsE.boi());
            }
            if (this.qUU != null) {
                fS += f.a.a.b.b.a.h(6, this.qUU);
            }
            if (this.rsY != null) {
                fS += f.a.a.a.fS(7, this.rsY.boi());
            }
            return fS;
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
            ot otVar = (ot) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        otVar.six = flVar;
                    }
                    return 0;
                case 2:
                    otVar.iwS = aVar3.vHC.rY();
                    return 0;
                case 3:
                    otVar.iwT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    otVar.token = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        azw azw = new azw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azw.a(aVar4, azw, bhp.a(aVar4))) {
                        }
                        otVar.rsE = azw;
                    }
                    return 0;
                case 6:
                    otVar.qUU = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btk btk = new btk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btk.a(aVar4, btk, bhp.a(aVar4))) {
                        }
                        otVar.rsY = btk;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
