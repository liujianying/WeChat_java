package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class wu extends a {
    public String desc;
    public String info;
    public boolean rBD = false;
    public boolean rBE = false;
    public boolean rzh = false;
    public boolean rzi = false;
    public String thumbUrl;
    public String title;

    public final wu VF(String str) {
        this.title = str;
        this.rzh = true;
        return this;
    }

    public final wu VG(String str) {
        this.desc = str;
        this.rzi = true;
        return this;
    }

    public final wu VH(String str) {
        this.thumbUrl = str;
        this.rBD = true;
        return this;
    }

    public final wu VI(String str) {
        this.info = str;
        this.rBE = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.thumbUrl != null) {
                aVar.g(3, this.thumbUrl);
            }
            if (this.info == null) {
                return 0;
            }
            aVar.g(4, this.info);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(2, this.desc);
            }
            if (this.thumbUrl != null) {
                h += f.a.a.b.b.a.h(3, this.thumbUrl);
            }
            if (this.info != null) {
                h += f.a.a.b.b.a.h(4, this.info);
            }
            return h;
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
            wu wuVar = (wu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wuVar.title = aVar3.vHC.readString();
                    wuVar.rzh = true;
                    return 0;
                case 2:
                    wuVar.desc = aVar3.vHC.readString();
                    wuVar.rzi = true;
                    return 0;
                case 3:
                    wuVar.thumbUrl = aVar3.vHC.readString();
                    wuVar.rBD = true;
                    return 0;
                case 4:
                    wuVar.info = aVar3.vHC.readString();
                    wuVar.rBE = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
