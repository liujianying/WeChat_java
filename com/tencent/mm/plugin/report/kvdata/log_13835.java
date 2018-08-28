package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public class log_13835 extends a {
    public int clientVersion_;
    public String currChatName_;
    public int device_;
    public int ds_;
    public int import_ds_;
    public LinkedList<IMBehavior> oplist_ = new LinkedList();
    public long time_stamp_;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.currChatName_ == null) {
                throw new b("Not all required fields were included: currChatName_");
            }
            aVar.fT(1, this.import_ds_);
            aVar.fT(2, this.ds_);
            aVar.T(3, this.uin_);
            aVar.fT(4, this.device_);
            aVar.fT(5, this.clientVersion_);
            aVar.T(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                aVar.g(7, this.currChatName_);
            }
            aVar.d(8, 8, this.oplist_);
            return 0;
        } else if (i == 1) {
            fQ = (((((f.a.a.a.fQ(1, this.import_ds_) + 0) + f.a.a.a.fQ(2, this.ds_)) + f.a.a.a.S(3, this.uin_)) + f.a.a.a.fQ(4, this.device_)) + f.a.a.a.fQ(5, this.clientVersion_)) + f.a.a.a.S(6, this.time_stamp_);
            if (this.currChatName_ != null) {
                fQ += f.a.a.b.b.a.h(7, this.currChatName_);
            }
            return fQ + f.a.a.a.c(8, 8, this.oplist_);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.oplist_.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.currChatName_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: currChatName_");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            log_13835 log_13835 = (log_13835) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    log_13835.import_ds_ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    log_13835.ds_ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    log_13835.uin_ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    log_13835.device_ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    log_13835.clientVersion_ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    log_13835.time_stamp_ = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    log_13835.currChatName_ = aVar3.vHC.readString();
                    return 0;
                case 8:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        IMBehavior iMBehavior = new IMBehavior();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = iMBehavior.a(aVar4, iMBehavior, a.a(aVar4))) {
                        }
                        log_13835.oplist_.add(iMBehavior);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
