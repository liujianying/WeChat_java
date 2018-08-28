package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aac extends bhp {
    public int hUm;
    public String hUn;
    public LinkedList<String> piZ = new LinkedList();
    public String rFG;

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
            aVar.d(2, 1, this.piZ);
            aVar.fT(3, this.hUm);
            if (this.hUn != null) {
                aVar.g(4, this.hUn);
            }
            if (this.rFG == null) {
                return 0;
            }
            aVar.g(5, this.rFG);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.c(2, 1, this.piZ)) + f.a.a.a.fQ(3, this.hUm);
            if (this.hUn != null) {
                fS += f.a.a.b.b.a.h(4, this.hUn);
            }
            if (this.rFG != null) {
                fS += f.a.a.b.b.a.h(5, this.rFG);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.piZ.clear();
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
            aac aac = (aac) objArr[1];
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
                        aac.six = flVar;
                    }
                    return 0;
                case 2:
                    aac.piZ.add(aVar3.vHC.readString());
                    return 0;
                case 3:
                    aac.hUm = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aac.hUn = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aac.rFG = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
