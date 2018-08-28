package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cb extends a {
    public String bHD;
    public LinkedList<cc> jSD = new LinkedList();
    public cd jSE;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            aVar.d(2, 8, this.jSD);
            if (this.jSE == null) {
                return 0;
            }
            aVar.fV(3, this.jSE.boi());
            this.jSE.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.c(2, 8, this.jSD);
            if (this.jSE != null) {
                h += f.a.a.a.fS(3, this.jSE.boi());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jSD.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cb cbVar = (cb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cbVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cc ccVar = new cc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccVar.a(aVar4, ccVar, a.a(aVar4))) {
                        }
                        cbVar.jSD.add(ccVar);
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cd cdVar = new cd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdVar.a(aVar4, cdVar, a.a(aVar4))) {
                        }
                        cbVar.jSE = cdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
