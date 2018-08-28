package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aql extends bhp {
    public aqj rSU;
    public ob rSV;
    public cgo rSW;
    public bcn rSX;
    public ay rSY;

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
            if (this.rSU != null) {
                aVar.fV(2, this.rSU.boi());
                this.rSU.a(aVar);
            }
            if (this.rSV != null) {
                aVar.fV(3, this.rSV.boi());
                this.rSV.a(aVar);
            }
            if (this.rSW != null) {
                aVar.fV(4, this.rSW.boi());
                this.rSW.a(aVar);
            }
            if (this.rSX != null) {
                aVar.fV(5, this.rSX.boi());
                this.rSX.a(aVar);
            }
            if (this.rSY == null) {
                return 0;
            }
            aVar.fV(6, this.rSY.boi());
            this.rSY.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rSU != null) {
                fS += f.a.a.a.fS(2, this.rSU.boi());
            }
            if (this.rSV != null) {
                fS += f.a.a.a.fS(3, this.rSV.boi());
            }
            if (this.rSW != null) {
                fS += f.a.a.a.fS(4, this.rSW.boi());
            }
            if (this.rSX != null) {
                fS += f.a.a.a.fS(5, this.rSX.boi());
            }
            if (this.rSY != null) {
                fS += f.a.a.a.fS(6, this.rSY.boi());
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
            aql aql = (aql) objArr[1];
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
                        aql.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqj aqj = new aqj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqj.a(aVar4, aqj, bhp.a(aVar4))) {
                        }
                        aql.rSU = aqj;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ob obVar = new ob();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = obVar.a(aVar4, obVar, bhp.a(aVar4))) {
                        }
                        aql.rSV = obVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cgo cgo = new cgo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgo.a(aVar4, cgo, bhp.a(aVar4))) {
                        }
                        aql.rSW = cgo;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bcn bcn = new bcn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bcn.a(aVar4, bcn, bhp.a(aVar4))) {
                        }
                        aql.rSX = bcn;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ay ayVar = new ay();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayVar.a(aVar4, ayVar, bhp.a(aVar4))) {
                        }
                        aql.rSY = ayVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
