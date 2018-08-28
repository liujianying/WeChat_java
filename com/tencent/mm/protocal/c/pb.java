package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class pb extends a {
    public int rti;
    public int rtj;
    public int rtk;
    public LinkedList<pa> rtl = new LinkedList();
    public b rtm;
    public ami rtn;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rti);
            aVar.fT(2, this.rtj);
            aVar.fT(3, this.rtk);
            aVar.d(4, 8, this.rtl);
            if (this.rtm != null) {
                aVar.b(5, this.rtm);
            }
            if (this.rtn != null) {
                aVar.fV(6, this.rtn.boi());
                this.rtn.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (((f.a.a.a.fQ(1, this.rti) + 0) + f.a.a.a.fQ(2, this.rtj)) + f.a.a.a.fQ(3, this.rtk)) + f.a.a.a.c(4, 8, this.rtl);
            if (this.rtm != null) {
                fQ += f.a.a.a.a(5, this.rtm);
            }
            if (this.rtn != null) {
                return fQ + f.a.a.a.fS(6, this.rtn.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rtl.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            pb pbVar = (pb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    pbVar.rti = aVar3.vHC.rY();
                    return 0;
                case 2:
                    pbVar.rtj = aVar3.vHC.rY();
                    return 0;
                case 3:
                    pbVar.rtk = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pa paVar = new pa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = paVar.a(aVar4, paVar, a.a(aVar4))) {
                        }
                        pbVar.rtl.add(paVar);
                    }
                    return 0;
                case 5:
                    pbVar.rtm = aVar3.cJR();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ami ami = new ami();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ami.a(aVar4, ami, a.a(aVar4))) {
                        }
                        pbVar.rtn = ami;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
