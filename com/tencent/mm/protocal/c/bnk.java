package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bnk extends a {
    public LinkedList<String> slr = new LinkedList();
    public LinkedList<String> sls = new LinkedList();
    public LinkedList<Integer> slt = new LinkedList();
    public LinkedList<Integer> slu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.slr);
            aVar.d(2, 1, this.sls);
            aVar.d(3, 2, this.slt);
            aVar.d(4, 2, this.slu);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.c(1, 1, this.slr) + 0) + f.a.a.a.c(2, 1, this.sls)) + f.a.a.a.c(3, 2, this.slt)) + f.a.a.a.c(4, 2, this.slu);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.slr.clear();
                this.sls.clear();
                this.slt.clear();
                this.slu.clear();
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
                bnk bnk = (bnk) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bnk.slr.add(aVar3.vHC.readString());
                        return 0;
                    case 2:
                        bnk.sls.add(aVar3.vHC.readString());
                        return 0;
                    case 3:
                        bnk.slt.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 4:
                        bnk.slu.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
