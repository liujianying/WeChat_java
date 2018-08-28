package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cbb extends a {
    public String sxk;
    public String sxl;
    public LinkedList<String> sxm = new LinkedList();
    public int sxn;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxk != null) {
                aVar.g(1, this.sxk);
            }
            if (this.sxl != null) {
                aVar.g(2, this.sxl);
            }
            aVar.d(3, 1, this.sxm);
            aVar.fT(4, this.sxn);
            return 0;
        } else if (i == 1) {
            if (this.sxk != null) {
                h = f.a.a.b.b.a.h(1, this.sxk) + 0;
            } else {
                h = 0;
            }
            if (this.sxl != null) {
                h += f.a.a.b.b.a.h(2, this.sxl);
            }
            return (h + f.a.a.a.c(3, 1, this.sxm)) + f.a.a.a.fQ(4, this.sxn);
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
            cbb cbb = (cbb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbb.sxk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cbb.sxl = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cbb.sxm.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    cbb.sxn = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
