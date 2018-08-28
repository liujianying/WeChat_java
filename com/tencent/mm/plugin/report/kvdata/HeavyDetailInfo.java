package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class HeavyDetailInfo extends a {
    public long chatroom_;
    public long contact_;
    public long conversation_;
    public long dbSize_;
    public long favDbSize_;
    public long flag_;
    public long message_;
    public long sdFileRatio_;
    public long sdFileSize_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.flag_);
            aVar.T(2, this.sdFileSize_);
            aVar.T(3, this.sdFileRatio_);
            aVar.T(4, this.dbSize_);
            aVar.T(5, this.message_);
            aVar.T(6, this.conversation_);
            aVar.T(7, this.contact_);
            aVar.T(8, this.chatroom_);
            aVar.T(9, this.favDbSize_);
            return 0;
        } else if (i == 1) {
            return ((((((((f.a.a.a.S(1, this.flag_) + 0) + f.a.a.a.S(2, this.sdFileSize_)) + f.a.a.a.S(3, this.sdFileRatio_)) + f.a.a.a.S(4, this.dbSize_)) + f.a.a.a.S(5, this.message_)) + f.a.a.a.S(6, this.conversation_)) + f.a.a.a.S(7, this.contact_)) + f.a.a.a.S(8, this.chatroom_)) + f.a.a.a.S(9, this.favDbSize_);
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
                HeavyDetailInfo heavyDetailInfo = (HeavyDetailInfo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        heavyDetailInfo.flag_ = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        heavyDetailInfo.sdFileSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        heavyDetailInfo.sdFileRatio_ = aVar3.vHC.rZ();
                        return 0;
                    case 4:
                        heavyDetailInfo.dbSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 5:
                        heavyDetailInfo.message_ = aVar3.vHC.rZ();
                        return 0;
                    case 6:
                        heavyDetailInfo.conversation_ = aVar3.vHC.rZ();
                        return 0;
                    case 7:
                        heavyDetailInfo.contact_ = aVar3.vHC.rZ();
                        return 0;
                    case 8:
                        heavyDetailInfo.chatroom_ = aVar3.vHC.rZ();
                        return 0;
                    case 9:
                        heavyDetailInfo.favDbSize_ = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
