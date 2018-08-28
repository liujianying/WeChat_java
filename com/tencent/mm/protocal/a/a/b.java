package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public int nettype;
    public int qXh;
    public LinkedList<a> qXi = new LinkedList();
    public int uin;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.uin);
            aVar.fT(2, this.qXh);
            aVar.d(3, 8, this.qXi);
            aVar.fT(4, this.nettype);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.uin) + 0) + f.a.a.a.fQ(2, this.qXh)) + f.a.a.a.c(3, 8, this.qXi)) + f.a.a.a.fQ(4, this.nettype);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.qXi.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                b bVar = (b) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bVar.uin = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bVar.qXh = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            a aVar4 = new a();
                            f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                            }
                            bVar.qXi.add(aVar4);
                        }
                        return 0;
                    case 4:
                        bVar.nettype = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
