package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.b;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.fl;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bb extends bhp {
    public String jPB;
    public LinkedList<ac> jRH = new LinkedList();
    public b jRI;
    public boolean jRJ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.d(2, 8, this.jRH);
            if (this.jRI != null) {
                aVar.b(3, this.jRI);
            }
            aVar.av(4, this.jRJ);
            if (this.jPB == null) {
                return 0;
            }
            aVar.g(5, this.jPB);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 8, this.jRH);
            if (this.jRI != null) {
                fS += f.a.a.a.a(3, this.jRI);
            }
            fS += f.a.a.b.b.a.ec(4) + 1;
            if (this.jPB != null) {
                fS += f.a.a.b.b.a.h(5, this.jPB);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jRH.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bb bbVar = (bb) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bbVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ac acVar = new ac();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acVar.a(aVar4, acVar, bhp.a(aVar4))) {
                        }
                        bbVar.jRH.add(acVar);
                    }
                    return 0;
                case 3:
                    bbVar.jRI = aVar3.cJR();
                    return 0;
                case 4:
                    bbVar.jRJ = aVar3.cJQ();
                    return 0;
                case 5:
                    bbVar.jPB = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
