package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class yr extends bhp {
    public LinkedList<b> rET = new LinkedList();
    public int rEU;
    public LinkedList<Integer> rEV = new LinkedList();
    public int rxy;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.d(2, 6, this.rET);
            aVar.fT(3, this.rEU);
            aVar.fT(4, this.rxy);
            aVar.d(5, 2, this.rEV);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.c(2, 6, this.rET)) + f.a.a.a.fQ(3, this.rEU)) + f.a.a.a.fQ(4, this.rxy)) + f.a.a.a.c(5, 2, this.rEV);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rET.clear();
            this.rEV.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            yr yrVar = (yr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        yrVar.six = flVar;
                    }
                    return 0;
                case 2:
                    yrVar.rET.add(aVar3.cJR());
                    return 0;
                case 3:
                    yrVar.rEU = aVar3.vHC.rY();
                    return 0;
                case 4:
                    yrVar.rxy = aVar3.vHC.rY();
                    return 0;
                case 5:
                    yrVar.rEV.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
