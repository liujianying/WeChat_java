package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class qc extends a {
    public String bHD;
    public String jOS;
    public String jPK;
    public LinkedList<ate> ruA = new LinkedList();
    public int ruB;
    public String ruC;
    public int ruz;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOS != null) {
                aVar.g(1, this.jOS);
            }
            aVar.fT(2, this.ruz);
            if (this.bHD != null) {
                aVar.g(3, this.bHD);
            }
            if (this.jPK != null) {
                aVar.g(4, this.jPK);
            }
            aVar.d(5, 8, this.ruA);
            aVar.fT(6, this.ruB);
            if (this.ruC == null) {
                return 0;
            }
            aVar.g(7, this.ruC);
            return 0;
        } else if (i == 1) {
            if (this.jOS != null) {
                h = f.a.a.b.b.a.h(1, this.jOS) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.ruz);
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(3, this.bHD);
            }
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(4, this.jPK);
            }
            h = (h + f.a.a.a.c(5, 8, this.ruA)) + f.a.a.a.fQ(6, this.ruB);
            if (this.ruC != null) {
                h += f.a.a.b.b.a.h(7, this.ruC);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ruA.clear();
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
            qc qcVar = (qc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qcVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    qcVar.ruz = aVar3.vHC.rY();
                    return 0;
                case 3:
                    qcVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 4:
                    qcVar.jPK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ate ate = new ate();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ate.a(aVar4, ate, a.a(aVar4))) {
                        }
                        qcVar.ruA.add(ate);
                    }
                    return 0;
                case 6:
                    qcVar.ruB = aVar3.vHC.rY();
                    return 0;
                case 7:
                    qcVar.ruC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
