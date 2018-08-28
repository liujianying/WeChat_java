package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aol extends bhd {
    public String bJT;
    public String bPS;
    public String rQE;
    public String rQF;
    public LinkedList<String> rQU = new LinkedList();
    public String rQV;
    public int scene;
    public String signature;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.bPS != null) {
                aVar.g(3, this.bPS);
            }
            aVar.d(4, 1, this.rQU);
            if (this.bJT != null) {
                aVar.g(5, this.bJT);
            }
            if (this.rQE != null) {
                aVar.g(6, this.rQE);
            }
            if (this.signature != null) {
                aVar.g(7, this.signature);
            }
            if (this.rQF != null) {
                aVar.g(8, this.rQF);
            }
            aVar.fT(9, this.scene);
            if (this.rQV == null) {
                return 0;
            }
            aVar.g(10, this.rQV);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.url != null) {
                fS += f.a.a.b.b.a.h(2, this.url);
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(3, this.bPS);
            }
            fS += f.a.a.a.c(4, 1, this.rQU);
            if (this.bJT != null) {
                fS += f.a.a.b.b.a.h(5, this.bJT);
            }
            if (this.rQE != null) {
                fS += f.a.a.b.b.a.h(6, this.rQE);
            }
            if (this.signature != null) {
                fS += f.a.a.b.b.a.h(7, this.signature);
            }
            if (this.rQF != null) {
                fS += f.a.a.b.b.a.h(8, this.rQF);
            }
            fS += f.a.a.a.fQ(9, this.scene);
            if (this.rQV != null) {
                fS += f.a.a.b.b.a.h(10, this.rQV);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rQU.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aol aol = (aol) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        aol.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aol.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aol.bPS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aol.rQU.add(aVar3.vHC.readString());
                    return 0;
                case 5:
                    aol.bJT = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aol.rQE = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aol.signature = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aol.rQF = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aol.scene = aVar3.vHC.rY();
                    return 0;
                case 10:
                    aol.rQV = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
