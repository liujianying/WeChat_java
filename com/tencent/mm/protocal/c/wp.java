package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class wp extends a {
    public int jRb;
    public String rBM;
    public LinkedList<wj> rBN = new LinkedList();
    public wj rBO;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.jRb);
            if (this.rBM != null) {
                aVar.g(2, this.rBM);
            }
            aVar.d(3, 8, this.rBN);
            if (this.rBO != null) {
                aVar.fV(4, this.rBO.boi());
                this.rBO.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.jRb) + 0;
            if (this.rBM != null) {
                fQ += f.a.a.b.b.a.h(2, this.rBM);
            }
            fQ += f.a.a.a.c(3, 8, this.rBN);
            if (this.rBO != null) {
                return fQ + f.a.a.a.fS(4, this.rBO.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rBN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            wp wpVar = (wp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            wj wjVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    wpVar.jRb = aVar3.vHC.rY();
                    return 0;
                case 2:
                    wpVar.rBM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wjVar = new wj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wjVar.a(aVar4, wjVar, a.a(aVar4))) {
                        }
                        wpVar.rBN.add(wjVar);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wjVar = new wj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wjVar.a(aVar4, wjVar, a.a(aVar4))) {
                        }
                        wpVar.rBO = wjVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
