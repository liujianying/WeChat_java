package com.tencent.mm.plugin.talkroom.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> ovV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((f.a.a.c.a) objArr[0]).d(1, 8, this.ovV);
            return 0;
        } else if (i == 1) {
            return f.a.a.a.c(1, 8, this.ovV) + 0;
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.ovV.clear();
                f.a.a.a.a aVar = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar2 = (f.a.a.a.a) objArr[0];
                b bVar = (b) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList IC = aVar2.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            a aVar3 = new a();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = aVar3.a(aVar4, aVar3, a.a(aVar4))) {
                            }
                            bVar.ovV.add(aVar3);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
