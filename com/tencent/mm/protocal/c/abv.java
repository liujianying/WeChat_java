package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class abv extends a {
    public String rGo;
    public ma rGr;
    public String rGs;
    public boolean rGt;
    public int rGu;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rGr != null) {
                aVar.fV(1, this.rGr.boi());
                this.rGr.a(aVar);
            }
            if (this.rGo != null) {
                aVar.g(2, this.rGo);
            }
            if (this.rGs != null) {
                aVar.g(3, this.rGs);
            }
            aVar.av(4, this.rGt);
            aVar.fT(5, this.rGu);
            return 0;
        } else if (i == 1) {
            if (this.rGr != null) {
                fS = f.a.a.a.fS(1, this.rGr.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rGo != null) {
                fS += f.a.a.b.b.a.h(2, this.rGo);
            }
            if (this.rGs != null) {
                fS += f.a.a.b.b.a.h(3, this.rGs);
            }
            return (fS + (f.a.a.b.b.a.ec(4) + 1)) + f.a.a.a.fQ(5, this.rGu);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            abv abv = (abv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        ma maVar = new ma();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = maVar.a(aVar4, maVar, a.a(aVar4))) {
                        }
                        abv.rGr = maVar;
                    }
                    return 0;
                case 2:
                    abv.rGo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    abv.rGs = aVar3.vHC.readString();
                    return 0;
                case 4:
                    abv.rGt = aVar3.cJQ();
                    return 0;
                case 5:
                    abv.rGu = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
