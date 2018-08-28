package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class mh extends bhd {
    public int amount;
    public int bVU;
    public String myf;
    public String rqp;
    public String rqs;
    public String rqt;
    public int rqu;
    public String rqv;
    public String rqw;
    public String rqx;
    public String rqy;
    public int rqz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rqs == null) {
                throw new b("Not all required fields were included: receiver_name");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rqs != null) {
                aVar.g(2, this.rqs);
            }
            aVar.fT(3, this.amount);
            if (this.rqt != null) {
                aVar.g(4, this.rqt);
            }
            if (this.myf != null) {
                aVar.g(5, this.myf);
            }
            aVar.fT(6, this.rqu);
            aVar.fT(7, this.bVU);
            if (this.rqv != null) {
                aVar.g(8, this.rqv);
            }
            if (this.rqp != null) {
                aVar.g(9, this.rqp);
            }
            if (this.rqw != null) {
                aVar.g(10, this.rqw);
            }
            if (this.rqx != null) {
                aVar.g(11, this.rqx);
            }
            if (this.rqy != null) {
                aVar.g(12, this.rqy);
            }
            aVar.fT(13, this.rqz);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rqs != null) {
                fS += f.a.a.b.b.a.h(2, this.rqs);
            }
            fS += f.a.a.a.fQ(3, this.amount);
            if (this.rqt != null) {
                fS += f.a.a.b.b.a.h(4, this.rqt);
            }
            if (this.myf != null) {
                fS += f.a.a.b.b.a.h(5, this.myf);
            }
            fS = (fS + f.a.a.a.fQ(6, this.rqu)) + f.a.a.a.fQ(7, this.bVU);
            if (this.rqv != null) {
                fS += f.a.a.b.b.a.h(8, this.rqv);
            }
            if (this.rqp != null) {
                fS += f.a.a.b.b.a.h(9, this.rqp);
            }
            if (this.rqw != null) {
                fS += f.a.a.b.b.a.h(10, this.rqw);
            }
            if (this.rqx != null) {
                fS += f.a.a.b.b.a.h(11, this.rqx);
            }
            if (this.rqy != null) {
                fS += f.a.a.b.b.a.h(12, this.rqy);
            }
            return fS + f.a.a.a.fQ(13, this.rqz);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rqs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: receiver_name");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            mh mhVar = (mh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        mhVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    mhVar.rqs = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mhVar.amount = aVar3.vHC.rY();
                    return 0;
                case 4:
                    mhVar.rqt = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mhVar.myf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    mhVar.rqu = aVar3.vHC.rY();
                    return 0;
                case 7:
                    mhVar.bVU = aVar3.vHC.rY();
                    return 0;
                case 8:
                    mhVar.rqv = aVar3.vHC.readString();
                    return 0;
                case 9:
                    mhVar.rqp = aVar3.vHC.readString();
                    return 0;
                case 10:
                    mhVar.rqw = aVar3.vHC.readString();
                    return 0;
                case 11:
                    mhVar.rqx = aVar3.vHC.readString();
                    return 0;
                case 12:
                    mhVar.rqy = aVar3.vHC.readString();
                    return 0;
                case 13:
                    mhVar.rqz = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
