package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class ace extends a {
    public int rGN;
    public int rGO;
    public int rGP;
    public int rti;
    public int rtj;
    public int rtk;
    public b rtm;
    public ami rtn;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rti);
            aVar.fT(2, this.rtj);
            aVar.fT(3, this.rtk);
            if (this.rtm != null) {
                aVar.b(4, this.rtm);
            }
            aVar.fT(5, this.rGN);
            aVar.fT(6, this.rGO);
            aVar.fT(7, this.rGP);
            if (this.rtn != null) {
                aVar.fV(8, this.rtn.boi());
                this.rtn.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.rti) + 0) + f.a.a.a.fQ(2, this.rtj)) + f.a.a.a.fQ(3, this.rtk);
            if (this.rtm != null) {
                fQ += f.a.a.a.a(4, this.rtm);
            }
            fQ = ((fQ + f.a.a.a.fQ(5, this.rGN)) + f.a.a.a.fQ(6, this.rGO)) + f.a.a.a.fQ(7, this.rGP);
            if (this.rtn != null) {
                return fQ + f.a.a.a.fS(8, this.rtn.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ace ace = (ace) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ace.rti = aVar3.vHC.rY();
                    return 0;
                case 2:
                    ace.rtj = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ace.rtk = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ace.rtm = aVar3.cJR();
                    return 0;
                case 5:
                    ace.rGN = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ace.rGO = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ace.rGP = aVar3.vHC.rY();
                    return 0;
                case 8:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        ami ami = new ami();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ami.a(aVar4, ami, a.a(aVar4))) {
                        }
                        ace.rtn = ami;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
