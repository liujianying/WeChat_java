package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class we extends a {
    public int bSz;
    public String bWB;
    public String label;
    public double lat;
    public double lng;
    public boolean rBu = false;
    public boolean rBv = false;
    public boolean rBw = false;
    public boolean rBx = false;
    public boolean rBy = false;

    public final we y(double d) {
        this.lng = d;
        this.rBu = true;
        return this;
    }

    public final we z(double d) {
        this.lat = d;
        this.rBv = true;
        return this;
    }

    public final we CK(int i) {
        this.bSz = i;
        this.rBw = true;
        return this;
    }

    public final we Vn(String str) {
        this.label = str;
        this.rBx = true;
        return this;
    }

    public final we Vo(String str) {
        this.bWB = str;
        this.rBy = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rBu) {
                aVar.c(1, this.lng);
            }
            if (this.rBv) {
                aVar.c(2, this.lat);
            }
            if (this.rBw) {
                aVar.fT(3, this.bSz);
            }
            if (this.label != null) {
                aVar.g(4, this.label);
            }
            if (this.bWB == null) {
                return 0;
            }
            aVar.g(5, this.bWB);
            return 0;
        } else if (i == 1) {
            if (this.rBu) {
                ec = (f.a.a.b.b.a.ec(1) + 8) + 0;
            } else {
                ec = 0;
            }
            if (this.rBv) {
                ec += f.a.a.b.b.a.ec(2) + 8;
            }
            if (this.rBw) {
                ec += f.a.a.a.fQ(3, this.bSz);
            }
            if (this.label != null) {
                ec += f.a.a.b.b.a.h(4, this.label);
            }
            if (this.bWB != null) {
                ec += f.a.a.b.b.a.h(5, this.bWB);
            }
            return ec;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            we weVar = (we) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    weVar.lng = aVar3.vHC.readDouble();
                    weVar.rBu = true;
                    return 0;
                case 2:
                    weVar.lat = aVar3.vHC.readDouble();
                    weVar.rBv = true;
                    return 0;
                case 3:
                    weVar.bSz = aVar3.vHC.rY();
                    weVar.rBw = true;
                    return 0;
                case 4:
                    weVar.label = aVar3.vHC.readString();
                    weVar.rBx = true;
                    return 0;
                case 5:
                    weVar.bWB = aVar3.vHC.readString();
                    weVar.rBy = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
