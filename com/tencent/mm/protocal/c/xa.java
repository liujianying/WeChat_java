package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class xa extends a {
    public String canvasPageXml;
    public String desc;
    public int dwt;
    public boolean rAt = false;
    public boolean rBD = false;
    public String rCn;
    public boolean rCo = false;
    public int rCp;
    public boolean rCq = false;
    public boolean rCr = false;
    public boolean rzh = false;
    public boolean rzi = false;
    public String thumbUrl;
    public String title;

    public final xa VJ(String str) {
        this.title = str;
        this.rzh = true;
        return this;
    }

    public final xa VK(String str) {
        this.desc = str;
        this.rzi = true;
        return this;
    }

    public final xa VL(String str) {
        this.rCn = str;
        this.rCo = true;
        return this;
    }

    public final xa VM(String str) {
        this.thumbUrl = str;
        this.rBD = true;
        return this;
    }

    public final xa CP(int i) {
        this.rCp = i;
        this.rCq = true;
        return this;
    }

    public final xa CQ(int i) {
        this.dwt = i;
        this.rCr = true;
        return this;
    }

    public final xa VN(String str) {
        this.canvasPageXml = str;
        this.rAt = true;
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
            if (this.rCn != null) {
                aVar.g(3, this.rCn);
            }
            if (this.thumbUrl != null) {
                aVar.g(4, this.thumbUrl);
            }
            if (this.rCq) {
                aVar.fT(5, this.rCp);
            }
            if (this.rCr) {
                aVar.fT(6, this.dwt);
            }
            if (this.canvasPageXml == null) {
                return 0;
            }
            aVar.g(7, this.canvasPageXml);
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
            if (this.rCn != null) {
                h += f.a.a.b.b.a.h(3, this.rCn);
            }
            if (this.thumbUrl != null) {
                h += f.a.a.b.b.a.h(4, this.thumbUrl);
            }
            if (this.rCq) {
                h += f.a.a.a.fQ(5, this.rCp);
            }
            if (this.rCr) {
                h += f.a.a.a.fQ(6, this.dwt);
            }
            if (this.canvasPageXml != null) {
                h += f.a.a.b.b.a.h(7, this.canvasPageXml);
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
            xa xaVar = (xa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xaVar.title = aVar3.vHC.readString();
                    xaVar.rzh = true;
                    return 0;
                case 2:
                    xaVar.desc = aVar3.vHC.readString();
                    xaVar.rzi = true;
                    return 0;
                case 3:
                    xaVar.rCn = aVar3.vHC.readString();
                    xaVar.rCo = true;
                    return 0;
                case 4:
                    xaVar.thumbUrl = aVar3.vHC.readString();
                    xaVar.rBD = true;
                    return 0;
                case 5:
                    xaVar.rCp = aVar3.vHC.rY();
                    xaVar.rCq = true;
                    return 0;
                case 6:
                    xaVar.dwt = aVar3.vHC.rY();
                    xaVar.rCr = true;
                    return 0;
                case 7:
                    xaVar.canvasPageXml = aVar3.vHC.readString();
                    xaVar.rAt = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
