package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class btz extends bhd {
    public String egr;
    public int scene;
    public aob srq;
    public LinkedList<cp> srr = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.egr != null) {
                aVar.g(2, this.egr);
            }
            aVar.fT(3, this.scene);
            if (this.srq != null) {
                aVar.fV(4, this.srq.boi());
                this.srq.a(aVar);
            }
            aVar.d(5, 8, this.srr);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.egr != null) {
                fS += f.a.a.b.b.a.h(2, this.egr);
            }
            fS += f.a.a.a.fQ(3, this.scene);
            if (this.srq != null) {
                fS += f.a.a.a.fS(4, this.srq.boi());
            }
            return fS + f.a.a.a.c(5, 8, this.srr);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.srr.clear();
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
            btz btz = (btz) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        btz.shX = fkVar;
                    }
                    return 0;
                case 2:
                    btz.egr = aVar3.vHC.readString();
                    return 0;
                case 3:
                    btz.scene = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aob aob = new aob();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aob.a(aVar4, aob, bhd.a(aVar4))) {
                        }
                        btz.srq = aob;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cp cpVar = new cp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.a(aVar4, cpVar, bhd.a(aVar4))) {
                        }
                        btz.srr.add(cpVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
