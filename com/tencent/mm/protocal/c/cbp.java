package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cbp extends a {
    public LinkedList<cbl> sxF = new LinkedList();
    public String sxk;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxk != null) {
                aVar.g(1, this.sxk);
            }
            aVar.d(2, 8, this.sxF);
            return 0;
        } else if (i == 1) {
            if (this.sxk != null) {
                h = f.a.a.b.b.a.h(1, this.sxk) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.c(2, 8, this.sxF);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sxF.clear();
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
            cbp cbp = (cbp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbp.sxk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cbl cbl = new cbl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cbl.a(aVar4, cbl, a.a(aVar4))) {
                        }
                        cbp.sxF.add(cbl);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
