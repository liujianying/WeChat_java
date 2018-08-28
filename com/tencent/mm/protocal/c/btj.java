package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btj extends a {
    public String mediaId;
    public long srb;
    public long srf;
    public long srg;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.mediaId != null) {
                aVar.g(1, this.mediaId);
            }
            aVar.T(2, this.srf);
            aVar.T(3, this.srg);
            aVar.T(4, this.srb);
            return 0;
        } else if (i == 1) {
            if (this.mediaId != null) {
                h = f.a.a.b.b.a.h(1, this.mediaId) + 0;
            } else {
                h = 0;
            }
            return ((h + f.a.a.a.S(2, this.srf)) + f.a.a.a.S(3, this.srg)) + f.a.a.a.S(4, this.srb);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            btj btj = (btj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btj.mediaId = aVar3.vHC.readString();
                    return 0;
                case 2:
                    btj.srf = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    btj.srg = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    btj.srb = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
