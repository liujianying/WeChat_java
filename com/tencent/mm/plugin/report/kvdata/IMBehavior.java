package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public class IMBehavior extends a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.opType);
            if (this.chattingOp != null) {
                aVar.fV(2, this.chattingOp.boi());
                this.chattingOp.a(aVar);
            }
            if (this.msgOp != null) {
                aVar.fV(3, this.msgOp.boi());
                this.msgOp.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.opType) + 0;
            if (this.chattingOp != null) {
                fQ += f.a.a.a.fS(2, this.chattingOp.boi());
            }
            if (this.msgOp != null) {
                return fQ + f.a.a.a.fS(3, this.msgOp.boi());
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
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iMBehavior.opType = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        IMBehaviorChattingOP iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.a(aVar4, iMBehaviorChattingOP, a.a(aVar4))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        IMBehaviorMsgOP iMBehaviorMsgOP = new IMBehaviorMsgOP();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorMsgOP.a(aVar4, iMBehaviorMsgOP, a.a(aVar4))) {
                        }
                        iMBehavior.msgOp = iMBehaviorMsgOP;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
