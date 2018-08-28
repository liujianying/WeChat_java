package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class as extends a {
    public String raJ;
    public LinkedList<ayd> raK = new LinkedList();
    public LinkedList<ayc> raL = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.raJ != null) {
                aVar.g(1, this.raJ);
            }
            aVar.d(2, 8, this.raK);
            aVar.d(3, 8, this.raL);
            return 0;
        } else if (i == 1) {
            if (this.raJ != null) {
                h = f.a.a.b.b.a.h(1, this.raJ) + 0;
            } else {
                h = 0;
            }
            return (h + f.a.a.a.c(2, 8, this.raK)) + f.a.a.a.c(3, 8, this.raL);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.raK.clear();
            this.raL.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    asVar.raJ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayd ayd = new ayd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayd.a(aVar4, ayd, a.a(aVar4))) {
                        }
                        asVar.raK.add(ayd);
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayc ayc = new ayc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayc.a(aVar4, ayc, a.a(aVar4))) {
                        }
                        asVar.raL.add(ayc);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
