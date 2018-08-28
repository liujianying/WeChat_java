package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aiz extends bhp {
    public b rLH;
    public LinkedList<bwy> rLI = new LinkedList();
    public int rLJ;
    public bxa rvs;

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
            if (this.rvs != null) {
                aVar.fV(2, this.rvs.boi());
                this.rvs.a(aVar);
            }
            aVar.d(3, 8, this.rLI);
            if (this.rLH != null) {
                aVar.b(4, this.rLH);
            }
            aVar.fT(5, this.rLJ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rvs != null) {
                fS += f.a.a.a.fS(2, this.rvs.boi());
            }
            fS += f.a.a.a.c(3, 8, this.rLI);
            if (this.rLH != null) {
                fS += f.a.a.a.a(4, this.rLH);
            }
            return fS + f.a.a.a.fQ(5, this.rLJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rLI.clear();
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
            aiz aiz = (aiz) objArr[1];
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
                        aiz.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bxa bxa = new bxa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxa.a(aVar4, bxa, bhp.a(aVar4))) {
                        }
                        aiz.rvs = bxa;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bwy bwy = new bwy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bwy.a(aVar4, bwy, bhp.a(aVar4))) {
                        }
                        aiz.rLI.add(bwy);
                    }
                    return 0;
                case 4:
                    aiz.rLH = aVar3.cJR();
                    return 0;
                case 5:
                    aiz.rLJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
