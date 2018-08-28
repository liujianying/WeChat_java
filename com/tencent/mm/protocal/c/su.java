package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class su extends bhd {
    public String aAL;
    public String bPS;
    public String bWm;
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
            if (this.aAL != null) {
                aVar.g(2, this.aAL);
            }
            if (this.bPS != null) {
                aVar.g(3, this.bPS);
            }
            if (this.bWm != null) {
                aVar.g(4, this.bWm);
            }
            aVar.fT(5, this.scene);
            if (this.url == null) {
                return 0;
            }
            aVar.g(6, this.url);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.aAL != null) {
                fS += f.a.a.b.b.a.h(2, this.aAL);
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(3, this.bPS);
            }
            if (this.bWm != null) {
                fS += f.a.a.b.b.a.h(4, this.bWm);
            }
            fS += f.a.a.a.fQ(5, this.scene);
            if (this.url != null) {
                fS += f.a.a.b.b.a.h(6, this.url);
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
            su suVar = (su) objArr[1];
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
                        suVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    suVar.aAL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    suVar.bPS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    suVar.bWm = aVar3.vHC.readString();
                    return 0;
                case 5:
                    suVar.scene = aVar3.vHC.rY();
                    return 0;
                case 6:
                    suVar.url = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
