package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<String> hbH = new LinkedList();
    public LinkedList<Long> hbI = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.hbH);
            aVar.d(2, 3, this.hbI);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(1, 1, this.hbH) + 0) + f.a.a.a.c(2, 3, this.hbI);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.hbH.clear();
                this.hbI.clear();
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
                i iVar = (i) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iVar.hbH.add(aVar3.vHC.readString());
                        return 0;
                    case 2:
                        iVar.hbI.add(Long.valueOf(aVar3.vHC.rZ()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
