package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ns extends a {
    public int otY;
    public LinkedList<wd> rrQ = new LinkedList();
    public wo rrR;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rrQ);
            aVar.fT(2, this.otY);
            if (this.rrR != null) {
                aVar.fV(3, this.rrR.boi());
                this.rrR.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = (f.a.a.a.c(1, 8, this.rrQ) + 0) + f.a.a.a.fQ(2, this.otY);
            if (this.rrR != null) {
                return c + f.a.a.a.fS(3, this.rrR.boi());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rrQ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ns nsVar = (ns) objArr[1];
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
                        wd wdVar = new wd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wdVar.a(aVar4, wdVar, a.a(aVar4))) {
                        }
                        nsVar.rrQ.add(wdVar);
                    }
                    return 0;
                case 2:
                    nsVar.otY = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wo woVar = new wo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = woVar.a(aVar4, woVar, a.a(aVar4))) {
                        }
                        nsVar.rrR = woVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
