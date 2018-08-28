package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class arq extends a {
    public LinkedList<ll> rFB = new LinkedList();
    public String rTR;
    public boolean rTS;
    public fa rTT;
    public String rTU;
    public boolean rTV;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rTR != null) {
                aVar.g(1, this.rTR);
            }
            aVar.d(2, 8, this.rFB);
            aVar.av(3, this.rTS);
            if (this.rTT != null) {
                aVar.fV(4, this.rTT.boi());
                this.rTT.a(aVar);
            }
            if (this.rTU != null) {
                aVar.g(5, this.rTU);
            }
            aVar.av(6, this.rTV);
            return 0;
        } else if (i == 1) {
            if (this.rTR != null) {
                h = f.a.a.b.b.a.h(1, this.rTR) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.c(2, 8, this.rFB)) + (f.a.a.b.b.a.ec(3) + 1);
            if (this.rTT != null) {
                h += f.a.a.a.fS(4, this.rTT.boi());
            }
            if (this.rTU != null) {
                h += f.a.a.b.b.a.h(5, this.rTU);
            }
            return h + (f.a.a.b.b.a.ec(6) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rFB.clear();
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
            arq arq = (arq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    arq.rTR = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ll llVar = new ll();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = llVar.a(aVar4, llVar, a.a(aVar4))) {
                        }
                        arq.rFB.add(llVar);
                    }
                    return 0;
                case 3:
                    arq.rTS = aVar3.cJQ();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fa faVar = new fa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = faVar.a(aVar4, faVar, a.a(aVar4))) {
                        }
                        arq.rTT = faVar;
                    }
                    return 0;
                case 5:
                    arq.rTU = aVar3.vHC.readString();
                    return 0;
                case 6:
                    arq.rTV = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
