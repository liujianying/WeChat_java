package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class acl extends bhp {
    public int rHb;
    public LinkedList<aue> rHc = new LinkedList();
    public LinkedList<Integer> rHd = new LinkedList();
    public LinkedList<byf> rHe = new LinkedList();

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
            aVar.fT(2, this.rHb);
            aVar.d(3, 8, this.rHc);
            aVar.c(4, this.rHd);
            aVar.d(5, 8, this.rHe);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.fQ(2, this.rHb)) + f.a.a.a.c(3, 8, this.rHc)) + f.a.a.a.b(4, this.rHd)) + f.a.a.a.c(5, 8, this.rHe);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHc.clear();
            this.rHd.clear();
            this.rHe.clear();
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
            acl acl = (acl) objArr[1];
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
                        acl.six = flVar;
                    }
                    return 0;
                case 2:
                    acl.rHb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aue aue = new aue();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aue.a(aVar4, aue, bhp.a(aVar4))) {
                        }
                        acl.rHc.add(aue);
                    }
                    return 0;
                case 4:
                    acl.rHd = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byf byf = new byf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byf.a(aVar4, byf, bhp.a(aVar4))) {
                        }
                        acl.rHe.add(byf);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
