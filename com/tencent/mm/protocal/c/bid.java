package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bid extends a {
    public LinkedList<arp> siQ = new LinkedList();
    public boolean siR;
    public boolean siS;
    public boolean siT;
    public boolean siU;
    public boolean siV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.siQ);
            aVar.av(2, this.siR);
            aVar.av(3, this.siS);
            aVar.av(4, this.siT);
            aVar.av(5, this.siU);
            aVar.av(6, this.siV);
            return 0;
        } else if (i == 1) {
            return (((((f.a.a.a.c(1, 8, this.siQ) + 0) + (f.a.a.b.b.a.ec(2) + 1)) + (f.a.a.b.b.a.ec(3) + 1)) + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1)) + (f.a.a.b.b.a.ec(6) + 1);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.siQ.clear();
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
                bid bid = (bid) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            arp arp = new arp();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = arp.a(aVar4, arp, a.a(aVar4))) {
                            }
                            bid.siQ.add(arp);
                        }
                        return 0;
                    case 2:
                        bid.siR = aVar3.cJQ();
                        return 0;
                    case 3:
                        bid.siS = aVar3.cJQ();
                        return 0;
                    case 4:
                        bid.siT = aVar3.cJQ();
                        return 0;
                    case 5:
                        bid.siU = aVar3.cJQ();
                        return 0;
                    case 6:
                        bid.siV = aVar3.cJQ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
