package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class IMBehaviorChattingOP extends a {
    public int changeNotifyStatus;
    public int changeSaveAddress;
    public int changeTop;
    public int changeUnread;
    public int expose;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.changeUnread);
            aVar.fT(2, this.changeTop);
            aVar.fT(3, this.changeNotifyStatus);
            aVar.fT(4, this.changeSaveAddress);
            aVar.fT(5, this.expose);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.changeUnread) + 0) + f.a.a.a.fQ(2, this.changeTop)) + f.a.a.a.fQ(3, this.changeNotifyStatus)) + f.a.a.a.fQ(4, this.changeSaveAddress)) + f.a.a.a.fQ(5, this.expose);
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
                IMBehaviorChattingOP iMBehaviorChattingOP = (IMBehaviorChattingOP) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        iMBehaviorChattingOP.changeUnread = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        iMBehaviorChattingOP.changeTop = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        iMBehaviorChattingOP.changeNotifyStatus = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        iMBehaviorChattingOP.changeSaveAddress = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        iMBehaviorChattingOP.expose = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
