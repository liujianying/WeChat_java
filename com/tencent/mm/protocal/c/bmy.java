package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bmy extends bhp {
    public LinkedList<bmw> dzs = new LinkedList();
    public int hyc;
    public long slb;
    public int sld;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.d(2, 8, this.dzs);
            aVar.fT(3, this.sld);
            aVar.T(4, this.slb);
            aVar.fT(5, this.hyc);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.c(2, 8, this.dzs)) + f.a.a.a.fQ(3, this.sld)) + f.a.a.a.S(4, this.slb)) + f.a.a.a.fQ(5, this.hyc);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.dzs.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bmy bmy = (bmy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
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
                        bmy.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bmw bmw = new bmw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmw.a(aVar4, bmw, bhp.a(aVar4))) {
                        }
                        bmy.dzs.add(bmw);
                    }
                    return 0;
                case 3:
                    bmy.sld = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bmy.slb = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bmy.hyc = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
