package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class amp extends a {
    public int create_time;
    public int huK;
    public int huV;
    public String hwg;
    public String kLf;
    public String lMY;
    public String muD;
    public String qYy;
    public String rIw;
    public long rPl;
    public String rPn;
    public int rPp;
    public int rPq;
    public String rPr;
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rIw != null) {
                aVar.g(1, this.rIw);
            }
            if (this.qYy != null) {
                aVar.g(2, this.qYy);
            }
            aVar.T(3, this.rPl);
            aVar.fT(4, this.state);
            aVar.fT(5, this.create_time);
            aVar.fT(6, this.huK);
            aVar.fT(7, this.rPp);
            aVar.fT(8, this.rPq);
            if (this.rPr != null) {
                aVar.g(9, this.rPr);
            }
            if (this.hwg != null) {
                aVar.g(10, this.hwg);
            }
            if (this.kLf != null) {
                aVar.g(11, this.kLf);
            }
            if (this.lMY != null) {
                aVar.g(12, this.lMY);
            }
            if (this.muD != null) {
                aVar.g(13, this.muD);
            }
            if (this.rPn != null) {
                aVar.g(14, this.rPn);
            }
            aVar.fT(15, this.huV);
            return 0;
        } else if (i == 1) {
            if (this.rIw != null) {
                h = f.a.a.b.b.a.h(1, this.rIw) + 0;
            } else {
                h = 0;
            }
            if (this.qYy != null) {
                h += f.a.a.b.b.a.h(2, this.qYy);
            }
            h = (((((h + f.a.a.a.S(3, this.rPl)) + f.a.a.a.fQ(4, this.state)) + f.a.a.a.fQ(5, this.create_time)) + f.a.a.a.fQ(6, this.huK)) + f.a.a.a.fQ(7, this.rPp)) + f.a.a.a.fQ(8, this.rPq);
            if (this.rPr != null) {
                h += f.a.a.b.b.a.h(9, this.rPr);
            }
            if (this.hwg != null) {
                h += f.a.a.b.b.a.h(10, this.hwg);
            }
            if (this.kLf != null) {
                h += f.a.a.b.b.a.h(11, this.kLf);
            }
            if (this.lMY != null) {
                h += f.a.a.b.b.a.h(12, this.lMY);
            }
            if (this.muD != null) {
                h += f.a.a.b.b.a.h(13, this.muD);
            }
            if (this.rPn != null) {
                h += f.a.a.b.b.a.h(14, this.rPn);
            }
            return h + f.a.a.a.fQ(15, this.huV);
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
            amp amp = (amp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amp.rIw = aVar3.vHC.readString();
                    return 0;
                case 2:
                    amp.qYy = aVar3.vHC.readString();
                    return 0;
                case 3:
                    amp.rPl = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    amp.state = aVar3.vHC.rY();
                    return 0;
                case 5:
                    amp.create_time = aVar3.vHC.rY();
                    return 0;
                case 6:
                    amp.huK = aVar3.vHC.rY();
                    return 0;
                case 7:
                    amp.rPp = aVar3.vHC.rY();
                    return 0;
                case 8:
                    amp.rPq = aVar3.vHC.rY();
                    return 0;
                case 9:
                    amp.rPr = aVar3.vHC.readString();
                    return 0;
                case 10:
                    amp.hwg = aVar3.vHC.readString();
                    return 0;
                case 11:
                    amp.kLf = aVar3.vHC.readString();
                    return 0;
                case 12:
                    amp.lMY = aVar3.vHC.readString();
                    return 0;
                case 13:
                    amp.muD = aVar3.vHC.readString();
                    return 0;
                case 14:
                    amp.rPn = aVar3.vHC.readString();
                    return 0;
                case 15:
                    amp.huV = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
