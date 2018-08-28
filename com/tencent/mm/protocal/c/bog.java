package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bog extends a {
    public bhz slT;
    public long smd;

    protected final int a(int i, Object... objArr) {
        int S;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.smd);
            if (this.slT != null) {
                aVar.fV(2, this.slT.boi());
                this.slT.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.smd) + 0;
            if (this.slT != null) {
                return S + f.a.a.a.fS(2, this.slT.boi());
            }
            return S;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bog bog = (bog) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bog.smd = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bog.slT = bhz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
