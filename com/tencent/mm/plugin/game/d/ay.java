package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.fk;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ay extends bhd {
    public String eJQ;
    public String jPc;
    public String jRj;
    public boolean jRt;
    public boolean jRu;
    public boolean jRv;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.jRj == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.jPc == null) {
                throw new b("Not all required fields were included: AppID");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.jRj != null) {
                    aVar.g(2, this.jRj);
                }
                if (this.jPc != null) {
                    aVar.g(3, this.jPc);
                }
                aVar.av(4, this.jRt);
                if (this.eJQ != null) {
                    aVar.g(5, this.eJQ);
                }
                aVar.av(6, this.jRu);
                aVar.av(7, this.jRv);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jRj != null) {
                fS += f.a.a.b.b.a.h(2, this.jRj);
            }
            if (this.jPc != null) {
                fS += f.a.a.b.b.a.h(3, this.jPc);
            }
            fS += f.a.a.b.b.a.ec(4) + 1;
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(5, this.eJQ);
            }
            return (fS + (f.a.a.b.b.a.ec(6) + 1)) + (f.a.a.b.b.a.ec(7) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.jRj == null) {
                throw new b("Not all required fields were included: Lang");
            } else if (this.jPc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
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
                        ayVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ayVar.jRj = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ayVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ayVar.jRt = aVar3.cJQ();
                    return 0;
                case 5:
                    ayVar.eJQ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ayVar.jRu = aVar3.cJQ();
                    return 0;
                case 7:
                    ayVar.jRv = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
