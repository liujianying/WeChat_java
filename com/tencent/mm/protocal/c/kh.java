package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class kh extends a {
    public int rml;
    public LinkedList<Integer> rmm = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rml);
            aVar.c(2, this.rmm);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.fQ(1, this.rml) + 0) + f.a.a.a.b(2, this.rmm);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rmm.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                kh khVar = (kh) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        khVar.rml = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        khVar.rmm = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
