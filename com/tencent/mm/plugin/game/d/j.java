package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class j extends a {
    public String jPA;
    public String jPB;
    public int jPC;
    public a jPD;
    public cz jPE;
    public int jPF;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPB != null) {
                aVar.g(1, this.jPB);
            }
            aVar.fT(2, this.jPC);
            if (this.jPD != null) {
                aVar.fV(3, this.jPD.boi());
                this.jPD.a(aVar);
            }
            if (this.jPE != null) {
                aVar.fV(4, this.jPE.boi());
                this.jPE.a(aVar);
            }
            aVar.fT(5, this.jPF);
            if (this.jPA == null) {
                return 0;
            }
            aVar.g(6, this.jPA);
            return 0;
        } else if (i == 1) {
            if (this.jPB != null) {
                h = f.a.a.b.b.a.h(1, this.jPB) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.jPC);
            if (this.jPD != null) {
                h += f.a.a.a.fS(3, this.jPD.boi());
            }
            if (this.jPE != null) {
                h += f.a.a.a.fS(4, this.jPE.boi());
            }
            h += f.a.a.a.fQ(5, this.jPF);
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(6, this.jPA);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jVar.jPB = aVar3.vHC.readString();
                    return 0;
                case 2:
                    jVar.jPC = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        jVar.jPD = aVar5;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cz czVar = new cz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = czVar.a(aVar4, czVar, a.a(aVar4))) {
                        }
                        jVar.jPE = czVar;
                    }
                    return 0;
                case 5:
                    jVar.jPF = aVar3.vHC.rY();
                    return 0;
                case 6:
                    jVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
