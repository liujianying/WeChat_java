package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class aeg extends a {
    public LinkedList<aef> rIt = new LinkedList();
    public aee rIu;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rIt);
            if (this.rIu != null) {
                aVar.fV(2, this.rIu.boi());
                this.rIu.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.rIt) + 0;
            if (this.rIu != null) {
                return c + f.a.a.a.fS(2, this.rIu.boi());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rIt.clear();
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
            aeg aeg = (aeg) objArr[1];
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
                        aef aef = new aef();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aef.a(aVar4, aef, a.a(aVar4))) {
                        }
                        aeg.rIt.add(aef);
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aee aee = new aee();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aee.a(aVar4, aee, a.a(aVar4))) {
                        }
                        aeg.rIu = aee;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
