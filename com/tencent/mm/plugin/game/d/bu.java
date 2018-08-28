package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bu extends a {
    public String bHD;
    public String jSn;
    public String jSo;
    public LinkedList<bv> jSs = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            aVar.d(2, 8, this.jSs);
            if (this.jSn != null) {
                aVar.g(3, this.jSn);
            }
            if (this.jSo == null) {
                return 0;
            }
            aVar.g(4, this.jSo);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.c(2, 8, this.jSs);
            if (this.jSn != null) {
                h += f.a.a.b.b.a.h(3, this.jSn);
            }
            if (this.jSo != null) {
                h += f.a.a.b.b.a.h(4, this.jSo);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jSs.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bu buVar = (bu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    buVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bv bvVar = new bv();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bvVar.a(aVar4, bvVar, a.a(aVar4))) {
                        }
                        buVar.jSs.add(bvVar);
                    }
                    return 0;
                case 3:
                    buVar.jSn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    buVar.jSo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
