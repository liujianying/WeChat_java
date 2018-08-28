package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ati extends a {
    public bhz rvo;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rvo == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.rvo == null) {
                return 0;
            } else {
                aVar.fV(1, this.rvo.boi());
                this.rvo.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.rvo != null) {
                fS = f.a.a.a.fS(1, this.rvo.boi()) + 0;
            } else {
                fS = 0;
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rvo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: MemberName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ati ati = (ati) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        ati.rvo = bhz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
