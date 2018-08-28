package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aft extends bhp {
    public db rJD;
    public as rJE;
    public LinkedList<cgb> rJF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.rJD != null) {
                aVar.fV(2, this.rJD.boi());
                this.rJD.a(aVar);
            }
            if (this.rJE != null) {
                aVar.fV(3, this.rJE.boi());
                this.rJE.a(aVar);
            }
            aVar.d(4, 8, this.rJF);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rJD != null) {
                fS += f.a.a.a.fS(2, this.rJD.boi());
            }
            if (this.rJE != null) {
                fS += f.a.a.a.fS(3, this.rJE.boi());
            }
            return fS + f.a.a.a.c(4, 8, this.rJF);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rJF.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aft aft = (aft) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        aft.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        db dbVar = new db();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dbVar.a(aVar4, dbVar, bhp.a(aVar4))) {
                        }
                        aft.rJD = dbVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        as asVar = new as();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, bhp.a(aVar4))) {
                        }
                        aft.rJE = asVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cgb cgb = new cgb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgb.a(aVar4, cgb, bhp.a(aVar4))) {
                        }
                        aft.rJF.add(cgb);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
