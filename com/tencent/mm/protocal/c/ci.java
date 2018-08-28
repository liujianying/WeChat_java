package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ci extends a {
    public String rcJ;
    public LinkedList<brc> rcK = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcJ != null) {
                aVar.g(1, this.rcJ);
            }
            aVar.d(2, 8, this.rcK);
            if (this.title == null) {
                return 0;
            }
            aVar.g(3, this.title);
            return 0;
        } else if (i == 1) {
            if (this.rcJ != null) {
                h = f.a.a.b.b.a.h(1, this.rcJ) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.c(2, 8, this.rcK);
            if (this.title != null) {
                h += f.a.a.b.b.a.h(3, this.title);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rcK.clear();
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
            ci ciVar = (ci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ciVar.rcJ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brc brc = new brc();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = brc.a(aVar4, brc, a.a(aVar4))) {
                        }
                        ciVar.rcK.add(brc);
                    }
                    return 0;
                case 3:
                    ciVar.title = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
