package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cdl extends a {
    public String jOS;
    public LinkedList<xg> syV = new LinkedList();
    public String syW;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.syW == null) {
                throw new b("Not all required fields were included: Charset");
            }
            aVar.d(1, 8, this.syV);
            if (this.syW != null) {
                aVar.g(2, this.syW);
            }
            if (this.jOS != null) {
                aVar.g(3, this.jOS);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.syV) + 0;
            if (this.syW != null) {
                c += f.a.a.b.b.a.h(2, this.syW);
            }
            if (this.jOS != null) {
                return c + f.a.a.b.b.a.h(3, this.jOS);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.syV.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            if (this.syW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Charset");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cdl cdl = (cdl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xg xgVar = new xg();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = xgVar.a(aVar4, xgVar, a.a(aVar4))) {
                        }
                        cdl.syV.add(xgVar);
                    }
                    return 0;
                case 2:
                    cdl.syW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cdl.jOS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
