package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bz extends a {
    public int jQd;
    public int lOH;
    public long rcq;
    public int rcr;
    public bhz rcs;
    public int rct;
    public bhz rcu;
    public int rcv;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcs == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.rcu == null) {
                throw new b("Not all required fields were included: DigestContent");
            } else {
                if (this.rcs != null) {
                    aVar.fV(1, this.rcs.boi());
                    this.rcs.a(aVar);
                }
                aVar.T(2, this.rcq);
                aVar.fT(3, this.rcr);
                aVar.fT(4, this.lOH);
                aVar.fT(5, this.rct);
                if (this.rcu != null) {
                    aVar.fV(6, this.rcu.boi());
                    this.rcu.a(aVar);
                }
                aVar.fT(7, this.rcv);
                aVar.fT(8, this.jQd);
                return 0;
            }
        } else if (i == 1) {
            if (this.rcs != null) {
                fS = f.a.a.a.fS(1, this.rcs.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((fS + f.a.a.a.S(2, this.rcq)) + f.a.a.a.fQ(3, this.rcr)) + f.a.a.a.fQ(4, this.lOH)) + f.a.a.a.fQ(5, this.rct);
            if (this.rcu != null) {
                fS += f.a.a.a.fS(6, this.rcu.boi());
            }
            return (fS + f.a.a.a.fQ(7, this.rcv)) + f.a.a.a.fQ(8, this.jQd);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rcs == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.rcu != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DigestContent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bz bzVar = (bz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhz bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bzVar.rcs = bhz;
                    }
                    return 0;
                case 2:
                    bzVar.rcq = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bzVar.rcr = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bzVar.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bzVar.rct = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bzVar.rcu = bhz;
                    }
                    return 0;
                case 7:
                    bzVar.rcv = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bzVar.jQd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
