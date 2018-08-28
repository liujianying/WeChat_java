package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class sd extends a {
    public String desc;
    public String detail;
    public String rvA;
    public LinkedList<String> rvz = new LinkedList();
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.d(4, 1, this.rvz);
            if (this.detail != null) {
                aVar.g(5, this.detail);
            }
            if (this.rvA == null) {
                return 0;
            }
            aVar.g(6, this.rvA);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.url != null) {
                h += f.a.a.b.b.a.h(2, this.url);
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(3, this.desc);
            }
            h += f.a.a.a.c(4, 1, this.rvz);
            if (this.detail != null) {
                h += f.a.a.b.b.a.h(5, this.detail);
            }
            if (this.rvA != null) {
                h += f.a.a.b.b.a.h(6, this.rvA);
            }
            return h;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rvz.clear();
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
            sd sdVar = (sd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sdVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    sdVar.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    sdVar.desc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    sdVar.rvz.add(aVar3.vHC.readString());
                    return 0;
                case 5:
                    sdVar.detail = aVar3.vHC.readString();
                    return 0;
                case 6:
                    sdVar.rvA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
