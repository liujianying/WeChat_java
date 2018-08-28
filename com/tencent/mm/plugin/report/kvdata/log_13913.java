package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class log_13913 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public String error_;
    public int import_ds_;
    public int scene_;
    public long time_stamp_;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.import_ds_);
            aVar.fT(2, this.ds_);
            aVar.T(3, this.uin_);
            aVar.fT(4, this.device_);
            aVar.fT(5, this.clientVersion_);
            aVar.T(6, this.time_stamp_);
            aVar.fT(7, this.scene_);
            if (this.error_ != null) {
                aVar.g(8, this.error_);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((((((f.a.a.a.fQ(1, this.import_ds_) + 0) + f.a.a.a.fQ(2, this.ds_)) + f.a.a.a.S(3, this.uin_)) + f.a.a.a.fQ(4, this.device_)) + f.a.a.a.fQ(5, this.clientVersion_)) + f.a.a.a.S(6, this.time_stamp_)) + f.a.a.a.fQ(7, this.scene_);
            if (this.error_ != null) {
                return fQ + f.a.a.b.b.a.h(8, this.error_);
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
            log_13913 log_13913 = (log_13913) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    log_13913.import_ds_ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    log_13913.ds_ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    log_13913.uin_ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    log_13913.device_ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    log_13913.clientVersion_ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    log_13913.time_stamp_ = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    log_13913.scene_ = aVar3.vHC.rY();
                    return 0;
                case 8:
                    log_13913.error_ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
