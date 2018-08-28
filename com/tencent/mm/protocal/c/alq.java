package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class alq extends a {
    public String bWP;
    public int huV;
    public String hwg;
    public String hyz;
    public alp rIy;
    public boolean rOf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hwg != null) {
                aVar.g(1, this.hwg);
            }
            if (this.hyz != null) {
                aVar.g(2, this.hyz);
            }
            if (this.bWP != null) {
                aVar.g(3, this.bWP);
            }
            aVar.av(4, this.rOf);
            aVar.fT(5, this.huV);
            if (this.rIy == null) {
                return 0;
            }
            aVar.fV(6, this.rIy.boi());
            this.rIy.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.hwg != null) {
                h = f.a.a.b.b.a.h(1, this.hwg) + 0;
            } else {
                h = 0;
            }
            if (this.hyz != null) {
                h += f.a.a.b.b.a.h(2, this.hyz);
            }
            if (this.bWP != null) {
                h += f.a.a.b.b.a.h(3, this.bWP);
            }
            h = (h + (f.a.a.b.b.a.ec(4) + 1)) + f.a.a.a.fQ(5, this.huV);
            if (this.rIy != null) {
                h += f.a.a.a.fS(6, this.rIy.boi());
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
            alq alq = (alq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    alq.hwg = aVar3.vHC.readString();
                    return 0;
                case 2:
                    alq.hyz = aVar3.vHC.readString();
                    return 0;
                case 3:
                    alq.bWP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    alq.rOf = aVar3.cJQ();
                    return 0;
                case 5:
                    alq.huV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        alp alp = new alp();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = alp.a(aVar4, alp, a.a(aVar4))) {
                        }
                        alq.rIy = alp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
