package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cbl extends a {
    public String sxl;
    public LinkedList<String> sxm = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxl != null) {
                aVar.g(1, this.sxl);
            }
            aVar.d(2, 1, this.sxm);
            return 0;
        } else if (i == 1) {
            if (this.sxl != null) {
                h = f.a.a.b.b.a.h(1, this.sxl) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.c(2, 1, this.sxm);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.sxm.clear();
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
            cbl cbl = (cbl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbl.sxl = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cbl.sxm.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
