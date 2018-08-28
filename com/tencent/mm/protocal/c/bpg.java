package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bpg extends a {
    public int snj;
    public bqh snk;
    public bef snl;
    public rt snm;
    public bbo snn;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.snj);
            if (this.snk != null) {
                aVar.fV(2, this.snk.boi());
                this.snk.a(aVar);
            }
            if (this.snl != null) {
                aVar.fV(3, this.snl.boi());
                this.snl.a(aVar);
            }
            if (this.snm != null) {
                aVar.fV(4, this.snm.boi());
                this.snm.a(aVar);
            }
            if (this.snn != null) {
                aVar.fV(5, this.snn.boi());
                this.snn.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.snj) + 0;
            if (this.snk != null) {
                fQ += f.a.a.a.fS(2, this.snk.boi());
            }
            if (this.snl != null) {
                fQ += f.a.a.a.fS(3, this.snl.boi());
            }
            if (this.snm != null) {
                fQ += f.a.a.a.fS(4, this.snm.boi());
            }
            if (this.snn != null) {
                return fQ + f.a.a.a.fS(5, this.snn.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bpg bpg = (bpg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bpg.snj = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqh bqh = new bqh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqh.a(aVar4, bqh, a.a(aVar4))) {
                        }
                        bpg.snk = bqh;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bef bef = new bef();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bef.a(aVar4, bef, a.a(aVar4))) {
                        }
                        bpg.snl = bef;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        rt rtVar = new rt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rtVar.a(aVar4, rtVar, a.a(aVar4))) {
                        }
                        bpg.snm = rtVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbo bbo = new bbo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbo.a(aVar4, bbo, a.a(aVar4))) {
                        }
                        bpg.snn = bbo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
