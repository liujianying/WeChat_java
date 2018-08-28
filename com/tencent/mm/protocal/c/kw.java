package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class kw extends a {
    public String name;
    public String qYo;
    public LinkedList<qj> rmS = new LinkedList();
    public int rmT;
    public String rmU;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rmS);
            if (this.qYo != null) {
                aVar.g(2, this.qYo);
            }
            aVar.fT(3, this.rmT);
            if (this.rmU != null) {
                aVar.g(4, this.rmU);
            }
            if (this.name != null) {
                aVar.g(5, this.name);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.rmS) + 0;
            if (this.qYo != null) {
                c += f.a.a.b.b.a.h(2, this.qYo);
            }
            c += f.a.a.a.fQ(3, this.rmT);
            if (this.rmU != null) {
                c += f.a.a.b.b.a.h(4, this.rmU);
            }
            if (this.name != null) {
                return c + f.a.a.b.b.a.h(5, this.name);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rmS.clear();
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
            kw kwVar = (kw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qj qjVar = new qj();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = qjVar.a(aVar4, qjVar, a.a(aVar4))) {
                        }
                        kwVar.rmS.add(qjVar);
                    }
                    return 0;
                case 2:
                    kwVar.qYo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    kwVar.rmT = aVar3.vHC.rY();
                    return 0;
                case 4:
                    kwVar.rmU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    kwVar.name = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
