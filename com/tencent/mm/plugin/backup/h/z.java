package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class z extends a {
    public String hbD;
    public long hcP;
    public long hcQ;
    public String hcR;
    public String hcS;
    public LinkedList<String> hcv = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbD == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.hcR == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.hcS == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.hbD != null) {
                    aVar.g(1, this.hbD);
                }
                aVar.T(2, this.hcP);
                aVar.T(3, this.hcQ);
                if (this.hcR != null) {
                    aVar.g(4, this.hcR);
                }
                if (this.hcS != null) {
                    aVar.g(5, this.hcS);
                }
                aVar.d(6, 1, this.hcv);
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
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(5, this.hcS);
            }
            return h + f.a.a.a.c(6, 1, this.hcv);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.hcv.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hbD == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.hcR == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.hcS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zVar.hbD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    zVar.hcP = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    zVar.hcQ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    zVar.hcR = aVar3.vHC.readString();
                    return 0;
                case 5:
                    zVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    zVar.hcv.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
