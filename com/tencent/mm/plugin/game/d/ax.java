package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.fl;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ax extends bhp {
    public boolean jRm;
    public aj jRn;
    public String jRo;
    public f jRp;
    public ab jRq;
    public g jRr;
    public db jRs;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.av(2, this.jRm);
            if (this.jRn != null) {
                aVar.fV(3, this.jRn.boi());
                this.jRn.a(aVar);
            }
            if (this.jRo != null) {
                aVar.g(4, this.jRo);
            }
            if (this.jRp != null) {
                aVar.fV(5, this.jRp.boi());
                this.jRp.a(aVar);
            }
            if (this.jRq != null) {
                aVar.fV(6, this.jRq.boi());
                this.jRq.a(aVar);
            }
            if (this.jRr != null) {
                aVar.fV(7, this.jRr.boi());
                this.jRr.a(aVar);
            }
            if (this.jRs == null) {
                return 0;
            }
            aVar.fV(8, this.jRs.boi());
            this.jRs.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.b.b.a.ec(2) + 1;
            if (this.jRn != null) {
                fS += f.a.a.a.fS(3, this.jRn.boi());
            }
            if (this.jRo != null) {
                fS += f.a.a.b.b.a.h(4, this.jRo);
            }
            if (this.jRp != null) {
                fS += f.a.a.a.fS(5, this.jRp.boi());
            }
            if (this.jRq != null) {
                fS += f.a.a.a.fS(6, this.jRq.boi());
            }
            if (this.jRr != null) {
                fS += f.a.a.a.fS(7, this.jRr.boi());
            }
            if (this.jRs != null) {
                fS += f.a.a.a.fS(8, this.jRs.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ax axVar = (ax) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        axVar.six = flVar;
                    }
                    return 0;
                case 2:
                    axVar.jRm = aVar3.cJQ();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aj ajVar = new aj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, bhp.a(aVar4))) {
                        }
                        axVar.jRn = ajVar;
                    }
                    return 0;
                case 4:
                    axVar.jRo = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        f fVar = new f();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.a(aVar4, fVar, bhp.a(aVar4))) {
                        }
                        axVar.jRp = fVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ab abVar = new ab();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abVar.a(aVar4, abVar, bhp.a(aVar4))) {
                        }
                        axVar.jRq = abVar;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        g gVar = new g();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, bhp.a(aVar4))) {
                        }
                        axVar.jRr = gVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        db dbVar = new db();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dbVar.a(aVar4, dbVar, bhp.a(aVar4))) {
                        }
                        axVar.jRs = dbVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
