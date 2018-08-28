package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cv extends a {
    public String bHD;
    public String jOS;
    public String jOT;
    public String jOU;
    public String jPA;
    public String jQb;
    public String jSv;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jSv == null) {
                throw new b("Not all required fields were included: AppName");
            }
            if (this.jSv != null) {
                aVar.g(1, this.jSv);
            }
            if (this.jOT != null) {
                aVar.g(2, this.jOT);
            }
            if (this.bHD != null) {
                aVar.g(3, this.bHD);
            }
            if (this.jOS != null) {
                aVar.g(4, this.jOS);
            }
            if (this.jPA != null) {
                aVar.g(5, this.jPA);
            }
            if (this.jOU != null) {
                aVar.g(6, this.jOU);
            }
            if (this.jQb == null) {
                return 0;
            }
            aVar.g(7, this.jQb);
            return 0;
        } else if (i == 1) {
            if (this.jSv != null) {
                h = f.a.a.b.b.a.h(1, this.jSv) + 0;
            } else {
                h = 0;
            }
            if (this.jOT != null) {
                h += f.a.a.b.b.a.h(2, this.jOT);
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(3, this.bHD);
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(4, this.jOS);
            }
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(5, this.jPA);
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(6, this.jOU);
            }
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(7, this.jQb);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jSv != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cv cvVar = (cv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvVar.jSv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cvVar.jOT = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cvVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cvVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cvVar.jPA = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cvVar.jOU = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cvVar.jQb = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
