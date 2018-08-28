package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cgo extends a {
    public LinkedList<bax> sAM = new LinkedList();
    public LinkedList<app> sAN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.sAM);
            aVar.d(2, 8, this.sAN);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 8, this.sAM) + 0) + f.a.a.a.c(2, 8, this.sAN);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.sAM.clear();
                this.sAN.clear();
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
                cgo cgo = (cgo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList IC;
                int size;
                f.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            bax bax = new bax();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = bax.a(aVar4, bax, a.a(aVar4))) {
                            }
                            cgo.sAM.add(bax);
                        }
                        return 0;
                    case 2:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            app app = new app();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = app.a(aVar4, app, a.a(aVar4))) {
                            }
                            cgo.sAN.add(app);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
