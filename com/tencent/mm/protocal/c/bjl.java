package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bjl extends a {
    public String rHk;
    public aqs rUI;
    public long rll;
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
            if (this.rUI != null) {
                aVar.fV(3, this.rUI.boi());
                this.rUI.a(aVar);
            }
            aVar.fT(4, this.sjq);
            aVar.d(5, 8, this.sjr);
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.rll) + 0;
            if (this.rHk != null) {
                S += f.a.a.b.b.a.h(2, this.rHk);
            }
            if (this.rUI != null) {
                S += f.a.a.a.fS(3, this.rUI.boi());
            }
            return (S + f.a.a.a.fQ(4, this.sjq)) + f.a.a.a.c(5, 8, this.sjr);
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
            bjl bjl = (bjl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bjl.rll = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    bjl.rHk = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqs aqs = new aqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        bjl.rUI = aqs;
                    }
                    return 0;
                case 4:
                    bjl.sjq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bxd bxd = new bxd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxd.a(aVar4, bxd, a.a(aVar4))) {
                        }
                        bjl.sjr.add(bxd);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
