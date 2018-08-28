package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class avr extends a {
    public String path;
    public String rYG;
    public String rYH;
    public int rkb;
    public int type;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            if (this.rYG != null) {
                aVar.g(2, this.rYG);
            }
            if (this.rYH != null) {
                aVar.g(3, this.rYH);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            aVar.fT(5, this.rkb);
            aVar.fT(6, this.type);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            if (this.rYG != null) {
                h += f.a.a.b.b.a.h(2, this.rYG);
            }
            if (this.rYH != null) {
                h += f.a.a.b.b.a.h(3, this.rYH);
            }
            if (this.path != null) {
                h += f.a.a.b.b.a.h(4, this.path);
            }
            return (h + f.a.a.a.fQ(5, this.rkb)) + f.a.a.a.fQ(6, this.type);
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
            avr avr = (avr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avr.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    avr.rYG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    avr.rYH = aVar3.vHC.readString();
                    return 0;
                case 4:
                    avr.path = aVar3.vHC.readString();
                    return 0;
                case 5:
                    avr.rkb = aVar3.vHC.rY();
                    return 0;
                case 6:
                    avr.type = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
