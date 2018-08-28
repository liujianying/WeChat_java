package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bjb extends a {
    public int otY;
    public String rHk;
    public aqs rUI;
    public int rjC;
    public long rll;
    public String rlo;
    public int sjq;
    public LinkedList<bxd> sjr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int S;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rHk == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.T(1, this.rll);
            if (this.rHk != null) {
                aVar.g(2, this.rHk);
            }
            aVar.fT(3, this.rjC);
            if (this.rUI != null) {
                aVar.fV(4, this.rUI.boi());
                this.rUI.a(aVar);
            }
            aVar.fT(5, this.sjq);
            aVar.d(6, 8, this.sjr);
            aVar.fT(7, this.otY);
            if (this.rlo != null) {
                aVar.g(8, this.rlo);
            }
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.rll) + 0;
            if (this.rHk != null) {
                S += f.a.a.b.b.a.h(2, this.rHk);
            }
            S += f.a.a.a.fQ(3, this.rjC);
            if (this.rUI != null) {
                S += f.a.a.a.fS(4, this.rUI.boi());
            }
            S = ((S + f.a.a.a.fQ(5, this.sjq)) + f.a.a.a.c(6, 8, this.sjr)) + f.a.a.a.fQ(7, this.otY);
            if (this.rlo != null) {
                return S + f.a.a.b.b.a.h(8, this.rlo);
            }
            return S;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sjr.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.rHk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bjb bjb = (bjb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bjb.rll = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    bjb.rHk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bjb.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqs aqs = new aqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        bjb.rUI = aqs;
                    }
                    return 0;
                case 5:
                    bjb.sjq = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bxd bxd = new bxd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxd.a(aVar4, bxd, a.a(aVar4))) {
                        }
                        bjb.sjr.add(bxd);
                    }
                    return 0;
                case 7:
                    bjb.otY = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bjb.rlo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
