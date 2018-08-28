package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class fs extends a {
    public int rgA;
    public LinkedList<String> rgB = new LinkedList();
    public int rgz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rgz);
            aVar.fT(2, this.rgA);
            aVar.d(3, 1, this.rgB);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.a.fQ(1, this.rgz) + 0) + f.a.a.a.fQ(2, this.rgA)) + f.a.a.a.c(3, 1, this.rgB);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.rgB.clear();
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
                fs fsVar = (fs) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fsVar.rgz = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        fsVar.rgA = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        fsVar.rgB.add(aVar3.vHC.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
