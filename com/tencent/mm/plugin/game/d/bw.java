package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bw extends a {
    public String jOU;
    public String jPc;
    public cf jPq;
    public String jSu;
    public String jSv;
    public String jSw;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc != null) {
                aVar.g(1, this.jPc);
            }
            if (this.jSu != null) {
                aVar.g(2, this.jSu);
            }
            if (this.jSv != null) {
                aVar.g(3, this.jSv);
            }
            if (this.jSw != null) {
                aVar.g(4, this.jSw);
            }
            if (this.jPq != null) {
                aVar.fV(5, this.jPq.boi());
                this.jPq.a(aVar);
            }
            if (this.jOU == null) {
                return 0;
            }
            aVar.g(6, this.jOU);
            return 0;
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            if (this.jSu != null) {
                h += f.a.a.b.b.a.h(2, this.jSu);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(3, this.jSv);
            }
            if (this.jSw != null) {
                h += f.a.a.b.b.a.h(4, this.jSw);
            }
            if (this.jPq != null) {
                h += f.a.a.a.fS(5, this.jPq.boi());
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(6, this.jOU);
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
            bw bwVar = (bw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bwVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bwVar.jSu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bwVar.jSv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bwVar.jSw = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        cf cfVar = new cf();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cfVar.a(aVar4, cfVar, a.a(aVar4))) {
                        }
                        bwVar.jPq = cfVar;
                    }
                    return 0;
                case 6:
                    bwVar.jOU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
