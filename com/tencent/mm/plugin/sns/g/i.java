package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> nve = new LinkedList();
    public g nvf;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nve);
            if (this.nvf != null) {
                aVar.fV(2, this.nvf.boi());
                this.nvf.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.nve) + 0;
            if (this.nvf != null) {
                return c + f.a.a.a.fS(2, this.nvf.boi());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nve.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
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
                        h hVar = new h();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        iVar.nve.add(hVar);
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        g gVar = new g();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        iVar.nvf = gVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
