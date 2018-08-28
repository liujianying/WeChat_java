package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bav extends bhp {
    public String hcS;
    public int jQd;
    public int rGc;
    public int rGd;
    public String rIk;
    public String say;
    public int sde;
    public int sdf;
    public int sdg;

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
            aVar.fT(2, this.sde);
            aVar.fT(3, this.jQd);
            if (this.say != null) {
                aVar.g(4, this.say);
            }
            if (this.rIk != null) {
                aVar.g(5, this.rIk);
            }
            if (this.hcS != null) {
                aVar.g(6, this.hcS);
            }
            aVar.fT(7, this.sdf);
            aVar.fT(8, this.rGc);
            aVar.fT(9, this.rGd);
            aVar.fT(10, this.sdg);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.sde)) + f.a.a.a.fQ(3, this.jQd);
            if (this.say != null) {
                fS += f.a.a.b.b.a.h(4, this.say);
            }
            if (this.rIk != null) {
                fS += f.a.a.b.b.a.h(5, this.rIk);
            }
            if (this.hcS != null) {
                fS += f.a.a.b.b.a.h(6, this.hcS);
            }
            return (((fS + f.a.a.a.fQ(7, this.sdf)) + f.a.a.a.fQ(8, this.rGc)) + f.a.a.a.fQ(9, this.rGd)) + f.a.a.a.fQ(10, this.sdg);
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
            bav bav = (bav) objArr[1];
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
                        bav.six = flVar;
                    }
                    return 0;
                case 2:
                    bav.sde = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bav.jQd = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bav.say = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bav.rIk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bav.hcS = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bav.sdf = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bav.rGc = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bav.rGd = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bav.sdg = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
