package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class av extends a {
    public String bHD;
    public String jOT;
    public e jOV;
    public String jPG;
    public String jQb;
    public LinkedList<String> jRf = new LinkedList();
    public String jRg;
    public String jRh;
    public String jRi;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.jPG != null) {
                aVar.g(2, this.jPG);
            }
            aVar.d(3, 1, this.jRf);
            if (this.jRg != null) {
                aVar.g(4, this.jRg);
            }
            if (this.jOT != null) {
                aVar.g(5, this.jOT);
            }
            if (this.jRh != null) {
                aVar.g(6, this.jRh);
            }
            if (this.jRi != null) {
                aVar.g(8, this.jRi);
            }
            if (this.jQb != null) {
                aVar.g(9, this.jQb);
            }
            if (this.jOV == null) {
                return 0;
            }
            aVar.fV(10, this.jOV.boi());
            this.jOV.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(2, this.jPG);
            }
            h += f.a.a.a.c(3, 1, this.jRf);
            if (this.jRg != null) {
                h += f.a.a.b.b.a.h(4, this.jRg);
            }
            if (this.jOT != null) {
                h += f.a.a.b.b.a.h(5, this.jOT);
            }
            if (this.jRh != null) {
                h += f.a.a.b.b.a.h(6, this.jRh);
            }
            if (this.jRi != null) {
                h += f.a.a.b.b.a.h(8, this.jRi);
            }
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(9, this.jQb);
            }
            if (this.jOV != null) {
                h += f.a.a.a.fS(10, this.jOV.boi());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jRf.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            av avVar = (av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    avVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    avVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    avVar.jRf.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    avVar.jRg = aVar3.vHC.readString();
                    return 0;
                case 5:
                    avVar.jOT = aVar3.vHC.readString();
                    return 0;
                case 6:
                    avVar.jRh = aVar3.vHC.readString();
                    return 0;
                case 8:
                    avVar.jRi = aVar3.vHC.readString();
                    return 0;
                case 9:
                    avVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 10:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        avVar.jOV = eVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
