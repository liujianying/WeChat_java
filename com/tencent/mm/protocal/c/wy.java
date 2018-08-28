package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class wy extends a {
    public LinkedList<String> rBW = new LinkedList();
    public LinkedList<String> rBX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.rBW);
            aVar.d(2, 1, this.rBX);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 1, this.rBW) + 0) + f.a.a.a.c(2, 1, this.rBX);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rBW.clear();
                this.rBX.clear();
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
                wy wyVar = (wy) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        wyVar.rBW.add(aVar3.vHC.readString());
                        return 0;
                    case 2:
                        wyVar.rBX.add(aVar3.vHC.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
