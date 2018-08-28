package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class ka extends a {
    public b rlH;
    public b rlI;
    public LinkedList<blk> rlJ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int a;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rlH == null) {
                throw new f.a.a.b("Not all required fields were included: Title");
            } else if (this.rlI == null) {
                throw new f.a.a.b("Not all required fields were included: ServiceUrl");
            } else {
                if (this.rlH != null) {
                    aVar.b(1, this.rlH);
                }
                if (this.rlI != null) {
                    aVar.b(2, this.rlI);
                }
                aVar.d(3, 8, this.rlJ);
                return 0;
            }
        } else if (i == 1) {
            if (this.rlH != null) {
                a = f.a.a.a.a(1, this.rlH) + 0;
            } else {
                a = 0;
            }
            if (this.rlI != null) {
                a += f.a.a.a.a(2, this.rlI);
            }
            return a + f.a.a.a.c(3, 8, this.rlJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rlJ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            if (this.rlH == null) {
                throw new f.a.a.b("Not all required fields were included: Title");
            } else if (this.rlI != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: ServiceUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ka kaVar = (ka) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    kaVar.rlH = aVar3.cJR();
                    return 0;
                case 2:
                    kaVar.rlI = aVar3.cJR();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        blk blk = new blk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = blk.a(aVar4, blk, a.a(aVar4))) {
                        }
                        kaVar.rlJ.add(blk);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
