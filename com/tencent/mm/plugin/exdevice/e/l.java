package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class l extends j {
    public b hbs;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ixj == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.ixj != null) {
                aVar.fV(1, this.ixj.boi());
                this.ixj.a(aVar);
            }
            if (this.hbs == null) {
                return 0;
            }
            aVar.b(2, this.hbs);
            return 0;
        } else if (i == 1) {
            if (this.ixj != null) {
                fS = f.a.a.a.fS(1, this.ixj.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hbs != null) {
                fS += f.a.a.a.a(2, this.hbs);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = j.a(aVar2); fS > 0; fS = j.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ixj != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        lVar.ixj = eVar;
                    }
                    return 0;
                case 2:
                    lVar.hbs = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
