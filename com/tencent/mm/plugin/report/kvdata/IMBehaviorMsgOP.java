package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class IMBehaviorMsgOP extends a {
    public int appMsgInnerType;
    public int count;
    public int msgOpType;
    public int msgType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.msgType);
            aVar.fT(2, this.msgOpType);
            aVar.fT(3, this.appMsgInnerType);
            aVar.fT(4, this.count);
            return 0;
        } else if (i == 1) {
            return (((f.a.a.a.fQ(1, this.msgType) + 0) + f.a.a.a.fQ(2, this.msgOpType)) + f.a.a.a.fQ(3, this.appMsgInnerType)) + f.a.a.a.fQ(4, this.count);
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
                IMBehaviorMsgOP iMBehaviorMsgOP = (IMBehaviorMsgOP) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iMBehaviorMsgOP.msgType = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        iMBehaviorMsgOP.msgOpType = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        iMBehaviorMsgOP.appMsgInnerType = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        iMBehaviorMsgOP.count = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
