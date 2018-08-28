package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class mn extends bhd {
    public String desc;
    public boolean rqC;
    public boolean rqD;
    public LinkedList<Integer> rqc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.d(2, 2, this.rqc);
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.av(4, this.rqC);
            aVar.av(5, this.rqD);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 2, this.rqc);
            if (this.desc != null) {
                fS += f.a.a.b.b.a.h(3, this.desc);
            }
            return (fS + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rqc.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            mn mnVar = (mn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        mnVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    mnVar.rqc.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 3:
                    mnVar.desc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mnVar.rqC = aVar3.cJQ();
                    return 0;
                case 5:
                    mnVar.rqD = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
