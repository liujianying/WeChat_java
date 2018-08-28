package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class aa extends a {
    public String hbD;
    public long hcP;
    public long hcQ;
    public String hcR;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbD == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.hcR == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else {
                if (this.hbD != null) {
                    aVar.g(1, this.hbD);
                }
                aVar.T(2, this.hcP);
                aVar.T(3, this.hcQ);
                if (this.hcR == null) {
                    return 0;
                }
                aVar.g(4, this.hcR);
                return 0;
            }
        } else if (i == 1) {
            if (this.hbD != null) {
                h = f.a.a.b.b.a.h(1, this.hbD) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.S(2, this.hcP)) + f.a.a.a.S(3, this.hcQ);
            if (this.hcR != null) {
                h += f.a.a.b.b.a.h(4, this.hcR);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hbD == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.hcR != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MsgDataID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaVar.hbD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aaVar.hcP = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    aaVar.hcQ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    aaVar.hcR = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
