package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cie extends a {
    public int sCd;
    public int sCe;
    public int sCf;
    public int score;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.fT(2, this.score);
            aVar.fT(3, this.sCd);
            aVar.fT(4, this.sCe);
            aVar.fT(5, this.sCf);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            return (((h + f.a.a.a.fQ(2, this.score)) + f.a.a.a.fQ(3, this.sCd)) + f.a.a.a.fQ(4, this.sCe)) + f.a.a.a.fQ(5, this.sCf);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cie cie = (cie) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cie.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cie.score = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cie.sCd = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cie.sCe = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cie.sCf = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
