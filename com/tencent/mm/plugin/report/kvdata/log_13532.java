package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class log_13532 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public int type;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.import_ds_);
            aVar.fT(2, this.ds_);
            aVar.T(3, this.uin_);
            aVar.fT(4, this.device_);
            aVar.fT(5, this.clientVersion_);
            aVar.T(6, this.time_stamp_);
            aVar.fT(7, this.type);
            return 0;
        } else if (i == 1) {
            return ((((((f.a.a.a.fQ(1, this.import_ds_) + 0) + f.a.a.a.fQ(2, this.ds_)) + f.a.a.a.S(3, this.uin_)) + f.a.a.a.fQ(4, this.device_)) + f.a.a.a.fQ(5, this.clientVersion_)) + f.a.a.a.S(6, this.time_stamp_)) + f.a.a.a.fQ(7, this.type);
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
                log_13532 log_13532 = (log_13532) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        log_13532.import_ds_ = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        log_13532.ds_ = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        log_13532.uin_ = aVar3.vHC.rZ();
                        return 0;
                    case 4:
                        log_13532.device_ = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        log_13532.clientVersion_ = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        log_13532.time_stamp_ = aVar3.vHC.rZ();
                        return 0;
                    case 7:
                        log_13532.type = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
