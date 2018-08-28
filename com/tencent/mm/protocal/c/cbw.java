package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cbw extends a {
    public String sxH;
    public cay sxM;
    public String sxX;
    public String username;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxM == null) {
                throw new b("Not all required fields were included: base_request");
            }
            if (this.sxM != null) {
                aVar.fV(1, this.sxM.boi());
                this.sxM.a(aVar);
            }
            if (this.username != null) {
                aVar.g(2, this.username);
            }
            if (this.sxH != null) {
                aVar.g(3, this.sxH);
            }
            if (this.sxX == null) {
                return 0;
            }
            aVar.g(4, this.sxX);
            return 0;
        } else if (i == 1) {
            if (this.sxM != null) {
                fS = f.a.a.a.fS(1, this.sxM.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.username != null) {
                fS += f.a.a.b.b.a.h(2, this.username);
            }
            if (this.sxH != null) {
                fS += f.a.a.b.b.a.h(3, this.sxH);
            }
            if (this.sxX != null) {
                fS += f.a.a.b.b.a.h(4, this.sxX);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sxM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_request");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cbw cbw = (cbw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        cay cay = new cay();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cay.a(aVar4, cay, a.a(aVar4))) {
                        }
                        cbw.sxM = cay;
                    }
                    return 0;
                case 2:
                    cbw.username = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cbw.sxH = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cbw.sxX = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
