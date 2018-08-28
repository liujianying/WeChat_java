package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ag extends a {
    public String hbD;
    public LinkedList<Long> hda = new LinkedList();
    public LinkedList<String> hdb = new LinkedList();
    public LinkedList<String> hdc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbD == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            aVar.d(1, 3, this.hda);
            aVar.d(2, 1, this.hdb);
            aVar.d(3, 1, this.hdc);
            if (this.hbD != null) {
                aVar.g(4, this.hbD);
            }
            return 0;
        } else if (i == 1) {
            c = ((f.a.a.a.c(1, 3, this.hda) + 0) + f.a.a.a.c(2, 1, this.hdb)) + f.a.a.a.c(3, 1, this.hdc);
            if (this.hbD != null) {
                return c + f.a.a.b.b.a.h(4, this.hbD);
            }
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.hda.clear();
            this.hdb.clear();
            this.hdc.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            if (this.hbD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agVar.hda.add(Long.valueOf(aVar3.vHC.rZ()));
                    return 0;
                case 2:
                    agVar.hdb.add(aVar3.vHC.readString());
                    return 0;
                case 3:
                    agVar.hdc.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    agVar.hbD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
