package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class yd extends a {
    public String bHD;
    public int create_time;
    public String jOS;
    public String jQb;
    public String jSv;
    public String lPl;
    public String rDG;
    public int rEb;
    public int rEc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.lPl == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                if (this.bHD != null) {
                    aVar.g(1, this.bHD);
                }
                if (this.jOS != null) {
                    aVar.g(2, this.jOS);
                }
                if (this.lPl != null) {
                    aVar.g(3, this.lPl);
                }
                if (this.rDG != null) {
                    aVar.g(4, this.rDG);
                }
                aVar.fT(5, this.rEb);
                aVar.fT(6, this.rEc);
                if (this.jQb != null) {
                    aVar.g(7, this.jQb);
                }
                aVar.fT(8, this.create_time);
                if (this.jSv == null) {
                    return 0;
                }
                aVar.g(9, this.jSv);
                return 0;
            }
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(2, this.jOS);
            }
            if (this.lPl != null) {
                h += f.a.a.b.b.a.h(3, this.lPl);
            }
            if (this.rDG != null) {
                h += f.a.a.b.b.a.h(4, this.rDG);
            }
            h = (h + f.a.a.a.fQ(5, this.rEb)) + f.a.a.a.fQ(6, this.rEc);
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(7, this.jQb);
            }
            h += f.a.a.a.fQ(8, this.create_time);
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(9, this.jSv);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.lPl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            yd ydVar = (yd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ydVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ydVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ydVar.lPl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ydVar.rDG = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ydVar.rEb = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ydVar.rEc = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ydVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ydVar.create_time = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ydVar.jSv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
