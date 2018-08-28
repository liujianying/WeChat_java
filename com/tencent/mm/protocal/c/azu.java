package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class azu extends bhp {
    public int iwS;
    public String iwT;
    public azv scs;
    public azj sct;
    public LinkedList<azi> scu = new LinkedList();
    public int scv;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.iwS);
            if (this.iwT != null) {
                aVar.g(3, this.iwT);
            }
            if (this.scs != null) {
                aVar.fV(4, this.scs.boi());
                this.scs.a(aVar);
            }
            if (this.sct != null) {
                aVar.fV(5, this.sct.boi());
                this.sct.a(aVar);
            }
            aVar.d(6, 8, this.scu);
            aVar.fT(7, this.scv);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.iwS);
            if (this.iwT != null) {
                fS += f.a.a.b.b.a.h(3, this.iwT);
            }
            if (this.scs != null) {
                fS += f.a.a.a.fS(4, this.scs.boi());
            }
            if (this.sct != null) {
                fS += f.a.a.a.fS(5, this.sct.boi());
            }
            return (fS + f.a.a.a.c(6, 8, this.scu)) + f.a.a.a.fQ(7, this.scv);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.scu.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            azu azu = (azu) objArr[1];
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
                        azu.six = flVar;
                    }
                    return 0;
                case 2:
                    azu.iwS = aVar3.vHC.rY();
                    return 0;
                case 3:
                    azu.iwT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        azv azv = new azv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azv.a(aVar4, azv, bhp.a(aVar4))) {
                        }
                        azu.scs = azv;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        azj azj = new azj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azj.a(aVar4, azj, bhp.a(aVar4))) {
                        }
                        azu.sct = azj;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        azi azi = new azi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azi.a(aVar4, azi, bhp.a(aVar4))) {
                        }
                        azu.scu.add(azi);
                    }
                    return 0;
                case 7:
                    azu.scv = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
