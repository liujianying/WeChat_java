package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class apd extends a {
    public String mPl;
    public int rRm;
    public LinkedList<String> rRn = new LinkedList();
    public String scope;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            aVar.fT(2, this.rRm);
            if (this.mPl != null) {
                aVar.g(3, this.mPl);
            }
            aVar.d(4, 1, this.rRn);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                h = f.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.rRm);
            if (this.mPl != null) {
                h += f.a.a.b.b.a.h(3, this.mPl);
            }
            return h + f.a.a.a.c(4, 1, this.rRn);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rRn.clear();
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
            apd apd = (apd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apd.scope = aVar3.vHC.readString();
                    return 0;
                case 2:
                    apd.rRm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    apd.mPl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    apd.rRn.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
