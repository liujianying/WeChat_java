package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ho extends a {
    public String jPe;
    public int jPj;
    public String jQb;
    public String rbj;
    public String rbk;
    public String rcY;
    public String rej;
    public String rik;
    public String ril;
    public String rim;
    public String rin;
    public String rio;
    public String rip;
    public String riq;
    public String rir;
    public String ris;
    public String rit;
    public String riu;
    public int riv;
    public int riw;
    public String rix;
    public String riy;
    public long riz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb != null) {
                aVar.g(1, this.jQb);
            }
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            if (this.rej != null) {
                aVar.g(3, this.rej);
            }
            if (this.rik != null) {
                aVar.g(4, this.rik);
            }
            if (this.ril != null) {
                aVar.g(5, this.ril);
            }
            if (this.rim != null) {
                aVar.g(6, this.rim);
            }
            if (this.rin != null) {
                aVar.g(7, this.rin);
            }
            if (this.rio != null) {
                aVar.g(8, this.rio);
            }
            if (this.rip != null) {
                aVar.g(9, this.rip);
            }
            if (this.riq != null) {
                aVar.g(10, this.riq);
            }
            if (this.rir != null) {
                aVar.g(11, this.rir);
            }
            if (this.rbj != null) {
                aVar.g(12, this.rbj);
            }
            if (this.ris != null) {
                aVar.g(13, this.ris);
            }
            if (this.rit != null) {
                aVar.g(14, this.rit);
            }
            if (this.riu != null) {
                aVar.g(15, this.riu);
            }
            aVar.fT(16, this.jPj);
            aVar.fT(17, this.riv);
            aVar.fT(18, this.riw);
            if (this.rix != null) {
                aVar.g(19, this.rix);
            }
            if (this.rcY != null) {
                aVar.g(20, this.rcY);
            }
            if (this.riy != null) {
                aVar.g(21, this.riy);
            }
            if (this.rbk != null) {
                aVar.g(22, this.rbk);
            }
            aVar.T(23, this.riz);
            return 0;
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            if (this.jPe != null) {
                h += f.a.a.b.b.a.h(2, this.jPe);
            }
            if (this.rej != null) {
                h += f.a.a.b.b.a.h(3, this.rej);
            }
            if (this.rik != null) {
                h += f.a.a.b.b.a.h(4, this.rik);
            }
            if (this.ril != null) {
                h += f.a.a.b.b.a.h(5, this.ril);
            }
            if (this.rim != null) {
                h += f.a.a.b.b.a.h(6, this.rim);
            }
            if (this.rin != null) {
                h += f.a.a.b.b.a.h(7, this.rin);
            }
            if (this.rio != null) {
                h += f.a.a.b.b.a.h(8, this.rio);
            }
            if (this.rip != null) {
                h += f.a.a.b.b.a.h(9, this.rip);
            }
            if (this.riq != null) {
                h += f.a.a.b.b.a.h(10, this.riq);
            }
            if (this.rir != null) {
                h += f.a.a.b.b.a.h(11, this.rir);
            }
            if (this.rbj != null) {
                h += f.a.a.b.b.a.h(12, this.rbj);
            }
            if (this.ris != null) {
                h += f.a.a.b.b.a.h(13, this.ris);
            }
            if (this.rit != null) {
                h += f.a.a.b.b.a.h(14, this.rit);
            }
            if (this.riu != null) {
                h += f.a.a.b.b.a.h(15, this.riu);
            }
            h = ((h + f.a.a.a.fQ(16, this.jPj)) + f.a.a.a.fQ(17, this.riv)) + f.a.a.a.fQ(18, this.riw);
            if (this.rix != null) {
                h += f.a.a.b.b.a.h(19, this.rix);
            }
            if (this.rcY != null) {
                h += f.a.a.b.b.a.h(20, this.rcY);
            }
            if (this.riy != null) {
                h += f.a.a.b.b.a.h(21, this.riy);
            }
            if (this.rbk != null) {
                h += f.a.a.b.b.a.h(22, this.rbk);
            }
            return h + f.a.a.a.S(23, this.riz);
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
            ho hoVar = (ho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hoVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    hoVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hoVar.rej = aVar3.vHC.readString();
                    return 0;
                case 4:
                    hoVar.rik = aVar3.vHC.readString();
                    return 0;
                case 5:
                    hoVar.ril = aVar3.vHC.readString();
                    return 0;
                case 6:
                    hoVar.rim = aVar3.vHC.readString();
                    return 0;
                case 7:
                    hoVar.rin = aVar3.vHC.readString();
                    return 0;
                case 8:
                    hoVar.rio = aVar3.vHC.readString();
                    return 0;
                case 9:
                    hoVar.rip = aVar3.vHC.readString();
                    return 0;
                case 10:
                    hoVar.riq = aVar3.vHC.readString();
                    return 0;
                case 11:
                    hoVar.rir = aVar3.vHC.readString();
                    return 0;
                case 12:
                    hoVar.rbj = aVar3.vHC.readString();
                    return 0;
                case 13:
                    hoVar.ris = aVar3.vHC.readString();
                    return 0;
                case 14:
                    hoVar.rit = aVar3.vHC.readString();
                    return 0;
                case 15:
                    hoVar.riu = aVar3.vHC.readString();
                    return 0;
                case 16:
                    hoVar.jPj = aVar3.vHC.rY();
                    return 0;
                case 17:
                    hoVar.riv = aVar3.vHC.rY();
                    return 0;
                case 18:
                    hoVar.riw = aVar3.vHC.rY();
                    return 0;
                case 19:
                    hoVar.rix = aVar3.vHC.readString();
                    return 0;
                case 20:
                    hoVar.rcY = aVar3.vHC.readString();
                    return 0;
                case 21:
                    hoVar.riy = aVar3.vHC.readString();
                    return 0;
                case 22:
                    hoVar.rbk = aVar3.vHC.readString();
                    return 0;
                case 23:
                    hoVar.riz = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
