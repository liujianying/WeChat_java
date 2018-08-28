package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.fl;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bd extends bhp {
    public ad jRO;
    public ag jRP;
    public ah jRQ;
    public bx jRR;
    public dg jRS;
    public al jRT;

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
            if (this.jRO != null) {
                aVar.fV(3, this.jRO.boi());
                this.jRO.a(aVar);
            }
            if (this.jRP != null) {
                aVar.fV(4, this.jRP.boi());
                this.jRP.a(aVar);
            }
            if (this.jRQ != null) {
                aVar.fV(5, this.jRQ.boi());
                this.jRQ.a(aVar);
            }
            if (this.jRR != null) {
                aVar.fV(6, this.jRR.boi());
                this.jRR.a(aVar);
            }
            if (this.jRS != null) {
                aVar.fV(8, this.jRS.boi());
                this.jRS.a(aVar);
            }
            if (this.jRT == null) {
                return 0;
            }
            aVar.fV(9, this.jRT.boi());
            this.jRT.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jRO != null) {
                fS += f.a.a.a.fS(3, this.jRO.boi());
            }
            if (this.jRP != null) {
                fS += f.a.a.a.fS(4, this.jRP.boi());
            }
            if (this.jRQ != null) {
                fS += f.a.a.a.fS(5, this.jRQ.boi());
            }
            if (this.jRR != null) {
                fS += f.a.a.a.fS(6, this.jRR.boi());
            }
            if (this.jRS != null) {
                fS += f.a.a.a.fS(8, this.jRS.boi());
            }
            if (this.jRT != null) {
                fS += f.a.a.a.fS(9, this.jRT.boi());
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
            bd bdVar = (bd) objArr[1];
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
                        bdVar.six = flVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ad adVar = new ad();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = adVar.a(aVar4, adVar, bhp.a(aVar4))) {
                        }
                        bdVar.jRO = adVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ag agVar = new ag();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = agVar.a(aVar4, agVar, bhp.a(aVar4))) {
                        }
                        bdVar.jRP = agVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ah ahVar = new ah();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ahVar.a(aVar4, ahVar, bhp.a(aVar4))) {
                        }
                        bdVar.jRQ = ahVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bx bxVar = new bx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxVar.a(aVar4, bxVar, bhp.a(aVar4))) {
                        }
                        bdVar.jRR = bxVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dg dgVar = new dg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, bhp.a(aVar4))) {
                        }
                        bdVar.jRS = dgVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        al alVar = new al();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alVar.a(aVar4, alVar, bhp.a(aVar4))) {
                        }
                        bdVar.jRT = alVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
