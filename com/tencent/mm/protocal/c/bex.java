package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bex extends bhp {
    public bey sgt;
    public int sgv;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.sgt == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                if (this.sgt != null) {
                    aVar.fV(1, this.sgt.boi());
                    this.sgt.a(aVar);
                }
                aVar.fT(2, this.sgv);
                if (this.six == null) {
                    return 0;
                }
                aVar.fV(3, this.six.boi());
                this.six.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.sgt != null) {
                fS = f.a.a.a.fS(1, this.sgt.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.sgv);
            if (this.six != null) {
                fS += f.a.a.a.fS(3, this.six.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sgt == null) {
                throw new b("Not all required fields were included: rcptinfolist");
            } else if (this.six != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bex bex = (bex) objArr[1];
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
                        bey bey = new bey();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bey.a(aVar4, bey, bhp.a(aVar4))) {
                        }
                        bex.sgt = bey;
                    }
                    return 0;
                case 2:
                    bex.sgv = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bex.six = flVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
