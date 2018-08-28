package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.fl;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bj extends bhp {
    public as jRV;
    public ai jRW;
    public i jRX;
    public cb jRY;
    public ch jRZ;

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
            if (this.jRW != null) {
                aVar.fV(2, this.jRW.boi());
                this.jRW.a(aVar);
            }
            if (this.jRV != null) {
                aVar.fV(3, this.jRV.boi());
                this.jRV.a(aVar);
            }
            if (this.jRX != null) {
                aVar.fV(4, this.jRX.boi());
                this.jRX.a(aVar);
            }
            if (this.jRY != null) {
                aVar.fV(5, this.jRY.boi());
                this.jRY.a(aVar);
            }
            if (this.jRZ == null) {
                return 0;
            }
            aVar.fV(6, this.jRZ.boi());
            this.jRZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jRW != null) {
                fS += f.a.a.a.fS(2, this.jRW.boi());
            }
            if (this.jRV != null) {
                fS += f.a.a.a.fS(3, this.jRV.boi());
            }
            if (this.jRX != null) {
                fS += f.a.a.a.fS(4, this.jRX.boi());
            }
            if (this.jRY != null) {
                fS += f.a.a.a.fS(5, this.jRY.boi());
            }
            if (this.jRZ != null) {
                fS += f.a.a.a.fS(6, this.jRZ.boi());
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
            bj bjVar = (bj) objArr[1];
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
                        bjVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ai aiVar = new ai();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aiVar.a(aVar4, aiVar, bhp.a(aVar4))) {
                        }
                        bjVar.jRW = aiVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        as asVar = new as();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, bhp.a(aVar4))) {
                        }
                        bjVar.jRV = asVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        i iVar = new i();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, bhp.a(aVar4))) {
                        }
                        bjVar.jRX = iVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cb cbVar = new cb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbVar.a(aVar4, cbVar, bhp.a(aVar4))) {
                        }
                        bjVar.jRY = cbVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ch chVar = new ch();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chVar.a(aVar4, chVar, bhp.a(aVar4))) {
                        }
                        bjVar.jRZ = chVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
