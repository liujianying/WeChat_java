package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class dl extends a {
    public String hbL;
    public String jPA;
    public String jPG;
    public String jQb;
    public String jSv;
    public String jTx;
    public int jTy;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            }
            if (this.jQb != null) {
                aVar.g(1, this.jQb);
            }
            if (this.jSv != null) {
                aVar.g(2, this.jSv);
            }
            if (this.jPG != null) {
                aVar.g(3, this.jPG);
            }
            if (this.hbL != null) {
                aVar.g(4, this.hbL);
            }
            if (this.jTx != null) {
                aVar.g(5, this.jTx);
            }
            aVar.fT(6, this.jTy);
            if (this.jPA == null) {
                return 0;
            }
            aVar.g(7, this.jPA);
            return 0;
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(2, this.jSv);
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(3, this.jPG);
            }
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(4, this.hbL);
            }
            if (this.jTx != null) {
                h += f.a.a.b.b.a.h(5, this.jTx);
            }
            h += f.a.a.a.fQ(6, this.jTy);
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(7, this.jPA);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jQb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dlVar.jSv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dlVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    dlVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    dlVar.jTx = aVar3.vHC.readString();
                    return 0;
                case 6:
                    dlVar.jTy = aVar3.vHC.rY();
                    return 0;
                case 7:
                    dlVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
