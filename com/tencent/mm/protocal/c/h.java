package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class h extends bhd {
    public String qYd;
    public LinkedList<j> qYh = new LinkedList();
    public aw qYi;
    public long qYj;
    public long qYl;
    public int scene;
    public String title;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.T(3, this.qYl);
            aVar.d(5, 8, this.qYh);
            aVar.fT(7, this.scene);
            if (this.qYd != null) {
                aVar.g(8, this.qYd);
            }
            if (this.qYi != null) {
                aVar.fV(9, this.qYi.boi());
                this.qYi.a(aVar);
            }
            aVar.T(10, this.qYj);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(2, this.title);
            }
            fS = ((fS + f.a.a.a.S(3, this.qYl)) + f.a.a.a.c(5, 8, this.qYh)) + f.a.a.a.fQ(7, this.scene);
            if (this.qYd != null) {
                fS += f.a.a.b.b.a.h(8, this.qYd);
            }
            if (this.qYi != null) {
                fS += f.a.a.a.fS(9, this.qYi.boi());
            }
            return fS + f.a.a.a.S(10, this.qYj);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qYh.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            h hVar = (h) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        hVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    hVar.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hVar.qYl = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        j jVar = new j();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jVar.a(aVar4, jVar, bhd.a(aVar4))) {
                        }
                        hVar.qYh.add(jVar);
                    }
                    return 0;
                case 7:
                    hVar.scene = aVar3.vHC.rY();
                    return 0;
                case 8:
                    hVar.qYd = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, bhd.a(aVar4))) {
                        }
                        hVar.qYi = awVar;
                    }
                    return 0;
                case 10:
                    hVar.qYj = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
