package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class al extends a {
    public String bHD;
    public String jPA;
    public String jQS;
    public LinkedList<cs> jQT = new LinkedList();
    public dl jQU;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQS != null) {
                aVar.g(1, this.jQS);
            }
            if (this.bHD != null) {
                aVar.g(2, this.bHD);
            }
            aVar.d(3, 8, this.jQT);
            if (this.jQU != null) {
                aVar.fV(4, this.jQU.boi());
                this.jQU.a(aVar);
            }
            if (this.jPA == null) {
                return 0;
            }
            aVar.g(5, this.jPA);
            return 0;
        } else if (i == 1) {
            if (this.jQS != null) {
                h = f.a.a.b.b.a.h(1, this.jQS) + 0;
            } else {
                h = 0;
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(2, this.bHD);
            }
            h += f.a.a.a.c(3, 8, this.jQT);
            if (this.jQU != null) {
                h += f.a.a.a.fS(4, this.jQU.boi());
            }
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(5, this.jPA);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jQT.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            al alVar = (al) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    alVar.jQS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    alVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cs csVar = new cs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csVar.a(aVar4, csVar, a.a(aVar4))) {
                        }
                        alVar.jQT.add(csVar);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dl dlVar = new dl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        alVar.jQU = dlVar;
                    }
                    return 0;
                case 5:
                    alVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
