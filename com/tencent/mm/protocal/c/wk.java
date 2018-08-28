package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class wk extends a {
    public String desc;
    public String info;
    public boolean rBD = false;
    public boolean rBE = false;
    public boolean rBF = false;
    public boolean rzh = false;
    public boolean rzi = false;
    public String thumbUrl;
    public String title;
    public int type;

    public final wk Vp(String str) {
        this.title = str;
        this.rzh = true;
        return this;
    }

    public final wk Vq(String str) {
        this.desc = str;
        this.rzi = true;
        return this;
    }

    public final wk Vr(String str) {
        this.thumbUrl = str;
        this.rBD = true;
        return this;
    }

    public final wk Vs(String str) {
        this.info = str;
        this.rBE = true;
        return this;
    }

    public final wk CL(int i) {
        this.type = i;
        this.rBF = true;
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
            if (this.info != null) {
                aVar.g(4, this.info);
            }
            if (!this.rBF) {
                return 0;
            }
            aVar.fT(5, this.type);
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
            if (this.rBF) {
                h += f.a.a.a.fQ(5, this.type);
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
            wk wkVar = (wk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wkVar.title = aVar3.vHC.readString();
                    wkVar.rzh = true;
                    return 0;
                case 2:
                    wkVar.desc = aVar3.vHC.readString();
                    wkVar.rzi = true;
                    return 0;
                case 3:
                    wkVar.thumbUrl = aVar3.vHC.readString();
                    wkVar.rBD = true;
                    return 0;
                case 4:
                    wkVar.info = aVar3.vHC.readString();
                    wkVar.rBE = true;
                    return 0;
                case 5:
                    wkVar.type = aVar3.vHC.rY();
                    wkVar.rBF = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
