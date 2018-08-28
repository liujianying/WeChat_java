package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public class log_13905 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public long time_stamp_;
    public long uin_;
    public VoiceInputBehavior viOp_;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.viOp_ == null) {
                throw new b("Not all required fields were included: viOp_");
            }
            aVar.fT(1, this.import_ds_);
            aVar.fT(2, this.ds_);
            aVar.T(3, this.uin_);
            aVar.fT(4, this.device_);
            aVar.fT(5, this.clientVersion_);
            aVar.T(6, this.time_stamp_);
            if (this.viOp_ != null) {
                aVar.fV(7, this.viOp_.boi());
                this.viOp_.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (((((f.a.a.a.fQ(1, this.import_ds_) + 0) + f.a.a.a.fQ(2, this.ds_)) + f.a.a.a.S(3, this.uin_)) + f.a.a.a.fQ(4, this.device_)) + f.a.a.a.fQ(5, this.clientVersion_)) + f.a.a.a.S(6, this.time_stamp_);
            if (this.viOp_ != null) {
                return fQ + f.a.a.a.fS(7, this.viOp_.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.viOp_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: viOp_");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            log_13905 log_13905 = (log_13905) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_13905.import_ds_ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    log_13905.ds_ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    log_13905.uin_ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    log_13905.device_ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    log_13905.clientVersion_ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    log_13905.time_stamp_ = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = voiceInputBehavior.a(aVar4, voiceInputBehavior, a.a(aVar4))) {
                        }
                        log_13905.viOp_ = voiceInputBehavior;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
