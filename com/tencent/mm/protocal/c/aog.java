package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aog extends bhd {
    public String bPS;
    public int hUp;
    public String rQM;
    public String rQN;
    public int rQO;
    public int rQP;
    public int scene;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.bPS != null) {
                aVar.g(2, this.bPS);
            }
            if (this.rQM != null) {
                aVar.g(3, this.rQM);
            }
            aVar.fT(4, this.scene);
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            if (this.rQN != null) {
                aVar.g(6, this.rQN);
            }
            aVar.fT(7, this.hUp);
            aVar.fT(8, this.rQO);
            aVar.fT(9, this.rQP);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(2, this.bPS);
            }
            if (this.rQM != null) {
                fS += f.a.a.b.b.a.h(3, this.rQM);
            }
            fS += f.a.a.a.fQ(4, this.scene);
            if (this.url != null) {
                fS += f.a.a.b.b.a.h(5, this.url);
            }
            if (this.rQN != null) {
                fS += f.a.a.b.b.a.h(6, this.rQN);
            }
            return ((fS + f.a.a.a.fQ(7, this.hUp)) + f.a.a.a.fQ(8, this.rQO)) + f.a.a.a.fQ(9, this.rQP);
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
            aog aog = (aog) objArr[1];
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
                        aog.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aog.bPS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aog.rQM = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aog.scene = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aog.url = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aog.rQN = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aog.hUp = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aog.rQO = aVar3.vHC.rY();
                    return 0;
                case 9:
                    aog.rQP = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
