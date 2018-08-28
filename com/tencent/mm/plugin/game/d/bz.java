package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bz extends a {
    public String bHD;
    public String jSA;
    public LinkedList<String> jSB = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.jSA != null) {
                aVar.g(2, this.jSA);
            }
            aVar.d(3, 1, this.jSB);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jSA != null) {
                h += f.a.a.b.b.a.h(2, this.jSA);
            }
            return h + f.a.a.a.c(3, 1, this.jSB);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jSB.clear();
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
            bz bzVar = (bz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bzVar.jSA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bzVar.jSB.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
