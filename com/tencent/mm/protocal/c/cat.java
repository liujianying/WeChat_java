package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class cat extends bhd {
    public long suO;
    public cas svJ;
    public cas sxd;
    public cas sxe;
    public cas sxf;
    public cas sxg;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.svJ == null) {
                throw new b("Not all required fields were included: ReportData");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.svJ != null) {
                aVar.fV(2, this.svJ.boi());
                this.svJ.a(aVar);
            }
            if (this.sxd != null) {
                aVar.fV(3, this.sxd.boi());
                this.sxd.a(aVar);
            }
            if (this.sxe != null) {
                aVar.fV(4, this.sxe.boi());
                this.sxe.a(aVar);
            }
            if (this.sxf != null) {
                aVar.fV(5, this.sxf.boi());
                this.sxf.a(aVar);
            }
            aVar.T(6, this.suO);
            if (this.sxg == null) {
                return 0;
            }
            aVar.fV(7, this.sxg.boi());
            this.sxg.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.svJ != null) {
                fS += f.a.a.a.fS(2, this.svJ.boi());
            }
            if (this.sxd != null) {
                fS += f.a.a.a.fS(3, this.sxd.boi());
            }
            if (this.sxe != null) {
                fS += f.a.a.a.fS(4, this.sxe.boi());
            }
            if (this.sxf != null) {
                fS += f.a.a.a.fS(5, this.sxf.boi());
            }
            fS += f.a.a.a.S(6, this.suO);
            if (this.sxg != null) {
                fS += f.a.a.a.fS(7, this.sxg.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.svJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReportData");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cat cat = (cat) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            cas cas;
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
                        cat.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, bhd.a(aVar4))) {
                        }
                        cat.svJ = cas;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, bhd.a(aVar4))) {
                        }
                        cat.sxd = cas;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, bhd.a(aVar4))) {
                        }
                        cat.sxe = cas;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, bhd.a(aVar4))) {
                        }
                        cat.sxf = cas;
                    }
                    return 0;
                case 6:
                    cat.suO = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cas = new cas();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cas.a(aVar4, cas, bhd.a(aVar4))) {
                        }
                        cat.sxg = cas;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
