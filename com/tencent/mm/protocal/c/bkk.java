package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bkk extends bhd {
    public bhy rOI;
    public alx rhk;
    public amb sjY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rhk == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.sjY == null) {
                throw new b("Not all required fields were included: HardDeviceMsg");
            } else if (this.rOI == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rhk != null) {
                    aVar.fV(2, this.rhk.boi());
                    this.rhk.a(aVar);
                }
                if (this.sjY != null) {
                    aVar.fV(3, this.sjY.boi());
                    this.sjY.a(aVar);
                }
                if (this.rOI == null) {
                    return 0;
                }
                aVar.fV(4, this.rOI.boi());
                this.rOI.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rhk != null) {
                fS += f.a.a.a.fS(2, this.rhk.boi());
            }
            if (this.sjY != null) {
                fS += f.a.a.a.fS(3, this.sjY.boi());
            }
            if (this.rOI != null) {
                fS += f.a.a.a.fS(4, this.rOI.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rhk == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.sjY == null) {
                throw new b("Not all required fields were included: HardDeviceMsg");
            } else if (this.rOI != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SessionBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bkk bkk = (bkk) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bkk.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alx alx = new alx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alx.a(aVar4, alx, bhd.a(aVar4))) {
                        }
                        bkk.rhk = alx;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amb amb = new amb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amb.a(aVar4, amb, bhd.a(aVar4))) {
                        }
                        bkk.sjY = amb;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        bkk.rOI = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
