package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class jc extends a {
    public LinkedList<xc> rkt = new LinkedList();
    public LinkedList<xb> rku = new LinkedList();
    public String rkv;
    public String rkw;
    public String rkx;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rkt);
            aVar.d(2, 8, this.rku);
            if (this.rkv != null) {
                aVar.g(3, this.rkv);
            }
            if (this.rkw != null) {
                aVar.g(4, this.rkw);
            }
            if (this.rkx != null) {
                aVar.g(5, this.rkx);
            }
            return 0;
        } else if (i == 1) {
            c = (f.a.a.a.c(1, 8, this.rkt) + 0) + f.a.a.a.c(2, 8, this.rku);
            if (this.rkv != null) {
                c += f.a.a.b.b.a.h(3, this.rkv);
            }
            if (this.rkw != null) {
                c += f.a.a.b.b.a.h(4, this.rkw);
            }
            if (this.rkx != null) {
                return c + f.a.a.b.b.a.h(5, this.rkx);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rkt.clear();
            this.rku.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jc jcVar = (jc) objArr[1];
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
                        xc xcVar = new xc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xcVar.a(aVar4, xcVar, a.a(aVar4))) {
                        }
                        jcVar.rkt.add(xcVar);
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xb xbVar = new xb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xbVar.a(aVar4, xbVar, a.a(aVar4))) {
                        }
                        jcVar.rku.add(xbVar);
                    }
                    return 0;
                case 3:
                    jcVar.rkv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    jcVar.rkw = aVar3.vHC.readString();
                    return 0;
                case 5:
                    jcVar.rkx = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
