package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bf extends a {
    public long endTime;
    public int niG;
    public int niH;
    public long rbA;
    public long rbB;
    public float rbv;
    public float rbw;
    public float rbx;
    public long rby;
    public long rbz;
    public long startTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.niG);
            aVar.fT(2, this.niH);
            aVar.l(3, this.rbv);
            aVar.l(4, this.rbw);
            aVar.l(5, this.rbx);
            aVar.T(6, this.startTime);
            aVar.T(7, this.endTime);
            aVar.T(8, this.rby);
            aVar.T(9, this.rbz);
            aVar.T(10, this.rbA);
            aVar.T(11, this.rbB);
            return 0;
        } else if (i == 1) {
            return ((((((((((f.a.a.a.fQ(1, this.niG) + 0) + f.a.a.a.fQ(2, this.niH)) + (f.a.a.b.b.a.ec(3) + 4)) + (f.a.a.b.b.a.ec(4) + 4)) + (f.a.a.b.b.a.ec(5) + 4)) + f.a.a.a.S(6, this.startTime)) + f.a.a.a.S(7, this.endTime)) + f.a.a.a.S(8, this.rby)) + f.a.a.a.S(9, this.rbz)) + f.a.a.a.S(10, this.rbA)) + f.a.a.a.S(11, this.rbB);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
                bf bfVar = (bf) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bfVar.niG = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bfVar.niH = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        bfVar.rbv = aVar3.vHC.readFloat();
                        return 0;
                    case 4:
                        bfVar.rbw = aVar3.vHC.readFloat();
                        return 0;
                    case 5:
                        bfVar.rbx = aVar3.vHC.readFloat();
                        return 0;
                    case 6:
                        bfVar.startTime = aVar3.vHC.rZ();
                        return 0;
                    case 7:
                        bfVar.endTime = aVar3.vHC.rZ();
                        return 0;
                    case 8:
                        bfVar.rby = aVar3.vHC.rZ();
                        return 0;
                    case 9:
                        bfVar.rbz = aVar3.vHC.rZ();
                        return 0;
                    case 10:
                        bfVar.rbA = aVar3.vHC.rZ();
                        return 0;
                    case 11:
                        bfVar.rbB = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
