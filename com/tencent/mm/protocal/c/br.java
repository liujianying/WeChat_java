package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class br extends bhd {
    public String jPK;
    public int qZe;
    public String qZf;
    public String rbW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rbW != null) {
                aVar.g(2, this.rbW);
            }
            if (this.jPK != null) {
                aVar.g(3, this.jPK);
            }
            aVar.fT(4, this.qZe);
            if (this.qZf == null) {
                return 0;
            }
            aVar.g(5, this.qZf);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rbW != null) {
                fS += f.a.a.b.b.a.h(2, this.rbW);
            }
            if (this.jPK != null) {
                fS += f.a.a.b.b.a.h(3, this.jPK);
            }
            fS += f.a.a.a.fQ(4, this.qZe);
            if (this.qZf != null) {
                fS += f.a.a.b.b.a.h(5, this.qZf);
            }
            return fS;
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
            br brVar = (br) objArr[1];
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
                        brVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    brVar.rbW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    brVar.jPK = aVar3.vHC.readString();
                    return 0;
                case 4:
                    brVar.qZe = aVar3.vHC.rY();
                    return 0;
                case 5:
                    brVar.qZf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
