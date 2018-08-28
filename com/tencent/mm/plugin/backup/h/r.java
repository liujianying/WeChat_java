package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String ID;
    public long hcc;
    public int hcf;
    public int hcg;
    public int hch;
    public long hci;
    public long hcj;
    public LinkedList<t> hcu = new LinkedList();
    public LinkedList<t> hcv = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fT(2, this.hcf);
            aVar.fT(3, this.hcg);
            aVar.fT(4, this.hch);
            aVar.T(5, this.hcc);
            aVar.T(6, this.hci);
            aVar.T(7, this.hcj);
            aVar.d(8, 8, this.hcu);
            aVar.d(9, 8, this.hcv);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = f.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            return (((((((h + f.a.a.a.fQ(2, this.hcf)) + f.a.a.a.fQ(3, this.hcg)) + f.a.a.a.fQ(4, this.hch)) + f.a.a.a.S(5, this.hcc)) + f.a.a.a.S(6, this.hci)) + f.a.a.a.S(7, this.hcj)) + f.a.a.a.c(8, 8, this.hcu)) + f.a.a.a.c(9, 8, this.hcv);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hcu.clear();
            this.hcv.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            t tVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rVar.ID = aVar3.vHC.readString();
                    return 0;
                case 2:
                    rVar.hcf = aVar3.vHC.rY();
                    return 0;
                case 3:
                    rVar.hcg = aVar3.vHC.rY();
                    return 0;
                case 4:
                    rVar.hch = aVar3.vHC.rY();
                    return 0;
                case 5:
                    rVar.hcc = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    rVar.hci = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    rVar.hcj = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tVar = new t();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.hcu.add(tVar);
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tVar = new t();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.hcv.add(tVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
