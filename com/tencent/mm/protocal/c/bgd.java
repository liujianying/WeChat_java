package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bgd extends a {
    public String bHD;
    public LinkedList<bhr> rdR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            aVar.d(2, 8, this.rdR);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.c(2, 8, this.rdR);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rdR.clear();
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
            bgd bgd = (bgd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgd.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhr bhr = new bhr();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhr.a(aVar4, bhr, a.a(aVar4))) {
                        }
                        bgd.rdR.add(bhr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}