package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ar extends a {
    public String bHD;
    public LinkedList<w> jPz = new LinkedList();
    public String jQG;
    public String jQZ;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.jPz);
            if (this.bHD != null) {
                aVar.g(2, this.bHD);
            }
            if (this.jQG != null) {
                aVar.g(3, this.jQG);
            }
            if (this.jQZ != null) {
                aVar.g(4, this.jQZ);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.jPz) + 0;
            if (this.bHD != null) {
                c += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.jQG != null) {
                c += f.a.a.b.b.a.h(3, this.jQG);
            }
            if (this.jQZ != null) {
                return c + f.a.a.b.b.a.h(4, this.jQZ);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jPz.clear();
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
            ar arVar = (ar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        w wVar = new w();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = wVar.a(aVar4, wVar, a.a(aVar4))) {
                        }
                        arVar.jPz.add(wVar);
                    }
                    return 0;
                case 2:
                    arVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    arVar.jQG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    arVar.jQZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
