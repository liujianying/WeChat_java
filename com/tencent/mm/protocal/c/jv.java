package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class jv extends a {
    public String jPG;
    public String rlp;
    public String rlq;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPG == null) {
                throw new b("Not all required fields were included: IconUrl");
            }
            if (this.jPG != null) {
                aVar.g(1, this.jPG);
            }
            if (this.rlp != null) {
                aVar.g(2, this.rlp);
            }
            if (this.rlq == null) {
                return 0;
            }
            aVar.g(3, this.rlq);
            return 0;
        } else if (i == 1) {
            if (this.jPG != null) {
                h = f.a.a.b.b.a.h(1, this.jPG) + 0;
            } else {
                h = 0;
            }
            if (this.rlp != null) {
                h += f.a.a.b.b.a.h(2, this.rlp);
            }
            if (this.rlq != null) {
                h += f.a.a.b.b.a.h(3, this.rlq);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: IconUrl");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jv jvVar = (jv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jvVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 2:
                    jvVar.rlp = aVar3.vHC.readString();
                    return 0;
                case 3:
                    jvVar.rlq = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
