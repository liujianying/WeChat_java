package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzl extends bhp {
    public LinkedList<bzc> rfi = new LinkedList();
    public long rxH;
    public long svs;

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
            aVar.T(2, this.svs);
            aVar.T(3, this.rxH);
            aVar.d(4, 8, this.rfi);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((fS + f.a.a.a.S(2, this.svs)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.c(4, 8, this.rfi);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfi.clear();
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
            bzl bzl = (bzl) objArr[1];
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
                        bzl.six = flVar;
                    }
                    return 0;
                case 2:
                    bzl.svs = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bzl.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bzc bzc = new bzc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzc.a(aVar4, bzc, bhp.a(aVar4))) {
                        }
                        bzl.rfi.add(bzc);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
