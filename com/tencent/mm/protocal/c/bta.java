package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bta extends a {
    public String rsQ;
    public LinkedList<bsz> sqs = new LinkedList();
    public int sqt;
    public int squ;
    public bhl sqv;
    public int sqw;
    public LinkedList<bsy> sqx = new LinkedList();
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rsQ == null) {
                throw new b("Not all required fields were included: patchid");
            }
            if (this.rsQ != null) {
                aVar.g(1, this.rsQ);
            }
            aVar.fT(2, this.state);
            aVar.d(3, 8, this.sqs);
            aVar.fT(4, this.sqt);
            aVar.fT(5, this.squ);
            if (this.sqv != null) {
                aVar.fV(6, this.sqv.boi());
                this.sqv.a(aVar);
            }
            aVar.fT(7, this.sqw);
            aVar.d(8, 8, this.sqx);
            return 0;
        } else if (i == 1) {
            if (this.rsQ != null) {
                h = f.a.a.b.b.a.h(1, this.rsQ) + 0;
            } else {
                h = 0;
            }
            h = (((h + f.a.a.a.fQ(2, this.state)) + f.a.a.a.c(3, 8, this.sqs)) + f.a.a.a.fQ(4, this.sqt)) + f.a.a.a.fQ(5, this.squ);
            if (this.sqv != null) {
                h += f.a.a.a.fS(6, this.sqv.boi());
            }
            return (h + f.a.a.a.fQ(7, this.sqw)) + f.a.a.a.c(8, 8, this.sqx);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sqs.clear();
            this.sqx.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rsQ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: patchid");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bta bta = (bta) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bta.rsQ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bta.state = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsz bsz = new bsz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.a(aVar4, bsz, a.a(aVar4))) {
                        }
                        bta.sqs.add(bsz);
                    }
                    return 0;
                case 4:
                    bta.sqt = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bta.squ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhl bhl = new bhl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhl.a(aVar4, bhl, a.a(aVar4))) {
                        }
                        bta.sqv = bhl;
                    }
                    return 0;
                case 7:
                    bta.sqw = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsy bsy = new bsy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsy.a(aVar4, bsy, a.a(aVar4))) {
                        }
                        bta.sqx.add(bsy);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
