package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ceq extends a {
    public LinkedList<cej> rLq = new LinkedList();
    public boolean szb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.szb);
            aVar.d(2, 8, this.rLq);
            return 0;
        } else if (i == 1) {
            return ((f.a.a.b.b.a.ec(1) + 1) + 0) + f.a.a.a.c(2, 8, this.rLq);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.rLq.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                ceq ceq = (ceq) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        ceq.szb = aVar3.cJQ();
                        return 0;
                    case 2:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            cej cej = new cej();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = cej.a(aVar4, cej, a.a(aVar4))) {
                            }
                            ceq.rLq.add(cej);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
