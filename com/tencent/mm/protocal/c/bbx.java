package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bbx extends bhd {
    public String sei;
    public String sej;
    public String sek;
    public String sel;
    public String sem;
    public int sen;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.sei != null) {
                aVar.g(2, this.sei);
            }
            if (this.sej != null) {
                aVar.g(3, this.sej);
            }
            if (this.sek != null) {
                aVar.g(4, this.sek);
            }
            if (this.sel != null) {
                aVar.g(5, this.sel);
            }
            if (this.sem != null) {
                aVar.g(6, this.sem);
            }
            aVar.fT(7, this.sen);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sei != null) {
                fS += f.a.a.b.b.a.h(2, this.sei);
            }
            if (this.sej != null) {
                fS += f.a.a.b.b.a.h(3, this.sej);
            }
            if (this.sek != null) {
                fS += f.a.a.b.b.a.h(4, this.sek);
            }
            if (this.sel != null) {
                fS += f.a.a.b.b.a.h(5, this.sel);
            }
            if (this.sem != null) {
                fS += f.a.a.b.b.a.h(6, this.sem);
            }
            return fS + f.a.a.a.fQ(7, this.sen);
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
            bbx bbx = (bbx) objArr[1];
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
                        bbx.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bbx.sei = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbx.sej = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bbx.sek = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbx.sel = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bbx.sem = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bbx.sen = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
