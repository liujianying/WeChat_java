package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class mx extends a {
    public int hLg;
    public LinkedList<my> rqV = new LinkedList();
    public int rqW;
    public bhz rqX;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hLg);
            aVar.d(2, 8, this.rqV);
            aVar.fT(3, this.rqW);
            if (this.rqX != null) {
                aVar.fV(4, this.rqX.boi());
                this.rqX.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.hLg) + 0) + f.a.a.a.c(2, 8, this.rqV)) + f.a.a.a.fQ(3, this.rqW);
            if (this.rqX != null) {
                return fQ + f.a.a.a.fS(4, this.rqX.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rqV.clear();
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
            mx mxVar = (mx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            a myVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    mxVar.hLg = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        myVar = new my();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = myVar.a(aVar4, myVar, a.a(aVar4))) {
                        }
                        mxVar.rqV.add(myVar);
                    }
                    return 0;
                case 3:
                    mxVar.rqW = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        myVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = myVar.a(aVar4, myVar, a.a(aVar4))) {
                        }
                        mxVar.rqX = myVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
