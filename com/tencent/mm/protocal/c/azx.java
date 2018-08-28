package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class azx extends a {
    public String desc;
    public String huW;
    public String name;
    public int paB;
    public String paC;
    public String paD;
    public String paE;
    public bfr scG;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            if (this.huW != null) {
                aVar.g(4, this.huW);
            }
            aVar.fT(5, this.paB);
            if (this.paC != null) {
                aVar.g(6, this.paC);
            }
            if (this.paD != null) {
                aVar.g(7, this.paD);
            }
            if (this.paE != null) {
                aVar.g(8, this.paE);
            }
            if (this.scG == null) {
                return 0;
            }
            aVar.fV(9, this.scG.boi());
            this.scG.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = f.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(2, this.title);
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(3, this.desc);
            }
            if (this.huW != null) {
                h += f.a.a.b.b.a.h(4, this.huW);
            }
            h += f.a.a.a.fQ(5, this.paB);
            if (this.paC != null) {
                h += f.a.a.b.b.a.h(6, this.paC);
            }
            if (this.paD != null) {
                h += f.a.a.b.b.a.h(7, this.paD);
            }
            if (this.paE != null) {
                h += f.a.a.b.b.a.h(8, this.paE);
            }
            if (this.scG != null) {
                h += f.a.a.a.fS(9, this.scG.boi());
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
            azx azx = (azx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azx.name = aVar3.vHC.readString();
                    return 0;
                case 2:
                    azx.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    azx.desc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    azx.huW = aVar3.vHC.readString();
                    return 0;
                case 5:
                    azx.paB = aVar3.vHC.rY();
                    return 0;
                case 6:
                    azx.paC = aVar3.vHC.readString();
                    return 0;
                case 7:
                    azx.paD = aVar3.vHC.readString();
                    return 0;
                case 8:
                    azx.paE = aVar3.vHC.readString();
                    return 0;
                case 9:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bfr bfr = new bfr();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bfr.a(aVar4, bfr, a.a(aVar4))) {
                        }
                        azx.scG = bfr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
