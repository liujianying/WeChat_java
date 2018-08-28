package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class xb extends a {
    public String mwP;
    public String rCs;
    public long rCt;
    public long rCu;
    public String rCv;
    public long rCw;
    public LinkedList<xc> rkt = new LinkedList();
    public String rqo;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rCs != null) {
                aVar.g(1, this.rCs);
            }
            aVar.d(2, 8, this.rkt);
            aVar.T(3, this.rCt);
            aVar.T(4, this.rCu);
            if (this.rCv != null) {
                aVar.g(5, this.rCv);
            }
            if (this.mwP != null) {
                aVar.g(6, this.mwP);
            }
            aVar.T(7, this.rCw);
            if (this.rqo == null) {
                return 0;
            }
            aVar.g(8, this.rqo);
            return 0;
        } else if (i == 1) {
            if (this.rCs != null) {
                h = f.a.a.b.b.a.h(1, this.rCs) + 0;
            } else {
                h = 0;
            }
            h = ((h + f.a.a.a.c(2, 8, this.rkt)) + f.a.a.a.S(3, this.rCt)) + f.a.a.a.S(4, this.rCu);
            if (this.rCv != null) {
                h += f.a.a.b.b.a.h(5, this.rCv);
            }
            if (this.mwP != null) {
                h += f.a.a.b.b.a.h(6, this.mwP);
            }
            h += f.a.a.a.S(7, this.rCw);
            if (this.rqo != null) {
                h += f.a.a.b.b.a.h(8, this.rqo);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rkt.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            xb xbVar = (xb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xbVar.rCs = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xc xcVar = new xc();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = xcVar.a(aVar4, xcVar, a.a(aVar4))) {
                        }
                        xbVar.rkt.add(xcVar);
                    }
                    return 0;
                case 3:
                    xbVar.rCt = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    xbVar.rCu = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    xbVar.rCv = aVar3.vHC.readString();
                    return 0;
                case 6:
                    xbVar.mwP = aVar3.vHC.readString();
                    return 0;
                case 7:
                    xbVar.rCw = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    xbVar.rqo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
