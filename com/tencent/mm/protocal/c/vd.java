package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class vd extends bhd {
    public String csK;
    public String csL;
    public String ixy;
    public double ryA;
    public String ryw;
    public String ryx;
    public long ryy;
    public double ryz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.ixy != null) {
                aVar.g(2, this.ixy);
            }
            if (this.csL != null) {
                aVar.g(3, this.csL);
            }
            if (this.csK != null) {
                aVar.g(4, this.csK);
            }
            if (this.ryw != null) {
                aVar.g(5, this.ryw);
            }
            if (this.ryx != null) {
                aVar.g(6, this.ryx);
            }
            aVar.T(7, this.ryy);
            aVar.c(8, this.ryz);
            aVar.c(9, this.ryA);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ixy != null) {
                fS += f.a.a.b.b.a.h(2, this.ixy);
            }
            if (this.csL != null) {
                fS += f.a.a.b.b.a.h(3, this.csL);
            }
            if (this.csK != null) {
                fS += f.a.a.b.b.a.h(4, this.csK);
            }
            if (this.ryw != null) {
                fS += f.a.a.b.b.a.h(5, this.ryw);
            }
            if (this.ryx != null) {
                fS += f.a.a.b.b.a.h(6, this.ryx);
            }
            return ((fS + f.a.a.a.S(7, this.ryy)) + (f.a.a.b.b.a.ec(8) + 8)) + (f.a.a.b.b.a.ec(9) + 8);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            vd vdVar = (vd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        vdVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    vdVar.ixy = aVar3.vHC.readString();
                    return 0;
                case 3:
                    vdVar.csL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    vdVar.csK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    vdVar.ryw = aVar3.vHC.readString();
                    return 0;
                case 6:
                    vdVar.ryx = aVar3.vHC.readString();
                    return 0;
                case 7:
                    vdVar.ryy = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    vdVar.ryz = aVar3.vHC.readDouble();
                    return 0;
                case 9:
                    vdVar.ryA = aVar3.vHC.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
