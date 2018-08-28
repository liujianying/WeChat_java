package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class az extends a {
    public String bSc;
    public String bWP;
    public String paD;
    public String paE;
    public String pwk;
    public int pwl;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.bSc != null) {
                aVar.g(2, this.bSc);
            }
            if (this.bWP != null) {
                aVar.g(3, this.bWP);
            }
            if (this.pwk != null) {
                aVar.g(4, this.pwk);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.paD != null) {
                aVar.g(6, this.paD);
            }
            if (this.paE != null) {
                aVar.g(7, this.paE);
            }
            aVar.fT(8, this.pwl);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                h = f.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                h = 0;
            }
            if (this.bSc != null) {
                h += f.a.a.b.b.a.h(2, this.bSc);
            }
            if (this.bWP != null) {
                h += f.a.a.b.b.a.h(3, this.bWP);
            }
            if (this.pwk != null) {
                h += f.a.a.b.b.a.h(4, this.pwk);
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(5, this.title);
            }
            if (this.paD != null) {
                h += f.a.a.b.b.a.h(6, this.paD);
            }
            if (this.paE != null) {
                h += f.a.a.b.b.a.h(7, this.paE);
            }
            return h + f.a.a.a.fQ(8, this.pwl);
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
            az azVar = (az) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azVar.url = aVar3.vHC.readString();
                    return 0;
                case 2:
                    azVar.bSc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    azVar.bWP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    azVar.pwk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    azVar.title = aVar3.vHC.readString();
                    return 0;
                case 6:
                    azVar.paD = aVar3.vHC.readString();
                    return 0;
                case 7:
                    azVar.paE = aVar3.vHC.readString();
                    return 0;
                case 8:
                    azVar.pwl = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
