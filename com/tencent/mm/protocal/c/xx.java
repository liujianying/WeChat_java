package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class xx extends bhp {
    public String bHD;
    public LinkedList<String> rDJ = new LinkedList();
    public String rDK;
    public LinkedList<String> rDL = new LinkedList();
    public LinkedList<String> rDM = new LinkedList();
    public LinkedList<xy> rDN = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.rDK == null) {
                throw new b("Not all required fields were included: JsonData");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.bHD != null) {
                    aVar.g(2, this.bHD);
                }
                aVar.d(3, 1, this.rDJ);
                if (this.rDK != null) {
                    aVar.g(4, this.rDK);
                }
                aVar.d(5, 1, this.rDL);
                aVar.d(6, 1, this.rDM);
                aVar.d(7, 8, this.rDN);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bHD != null) {
                fS += f.a.a.b.b.a.h(2, this.bHD);
            }
            fS += f.a.a.a.c(3, 1, this.rDJ);
            if (this.rDK != null) {
                fS += f.a.a.b.b.a.h(4, this.rDK);
            }
            return ((fS + f.a.a.a.c(5, 1, this.rDL)) + f.a.a.a.c(6, 1, this.rDM)) + f.a.a.a.c(7, 8, this.rDN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rDJ.clear();
            this.rDL.clear();
            this.rDM.clear();
            this.rDN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.rDK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: JsonData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            xx xxVar = (xx) objArr[1];
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
                        xxVar.six = flVar;
                    }
                    return 0;
                case 2:
                    xxVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    xxVar.rDJ.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    xxVar.rDK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    xxVar.rDL.add(aVar3.vHC.readString());
                    return 0;
                case 6:
                    xxVar.rDM.add(aVar3.vHC.readString());
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xy xyVar = new xy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xyVar.a(aVar4, xyVar, bhp.a(aVar4))) {
                        }
                        xxVar.rDN.add(xyVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
