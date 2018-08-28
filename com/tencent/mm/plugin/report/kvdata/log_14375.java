package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public class log_14375 extends a {
    public int clientVersion_;
    public BDStatusInfo dbStatusInfo_;
    public int device_;
    public int ds_;
    public HeavyDetailInfo heavyDetailInfo_;
    public int import_ds_;
    public SDStatusInfo sdStatusInfo_;
    public long time_stamp_;
    public int type_;
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
            aVar.fT(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                aVar.fV(8, this.dbStatusInfo_.boi());
                this.dbStatusInfo_.a(aVar);
            }
            if (this.sdStatusInfo_ != null) {
                aVar.fV(9, this.sdStatusInfo_.boi());
                this.sdStatusInfo_.a(aVar);
            }
            if (this.heavyDetailInfo_ != null) {
                aVar.fV(10, this.heavyDetailInfo_.boi());
                this.heavyDetailInfo_.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((((((f.a.a.a.fQ(1, this.import_ds_) + 0) + f.a.a.a.fQ(2, this.ds_)) + f.a.a.a.S(3, this.uin_)) + f.a.a.a.fQ(4, this.device_)) + f.a.a.a.fQ(5, this.clientVersion_)) + f.a.a.a.S(6, this.time_stamp_)) + f.a.a.a.fQ(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                fQ += f.a.a.a.fS(8, this.dbStatusInfo_.boi());
            }
            if (this.sdStatusInfo_ != null) {
                fQ += f.a.a.a.fS(9, this.sdStatusInfo_.boi());
            }
            if (this.heavyDetailInfo_ != null) {
                return fQ + f.a.a.a.fS(10, this.heavyDetailInfo_.boi());
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
            log_14375 log_14375 = (log_14375) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    log_14375.import_ds_ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    log_14375.ds_ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    log_14375.uin_ = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    log_14375.device_ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    log_14375.clientVersion_ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    log_14375.time_stamp_ = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    log_14375.type_ = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.a(aVar4, bDStatusInfo, a.a(aVar4))) {
                        }
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        SDStatusInfo sDStatusInfo = new SDStatusInfo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sDStatusInfo.a(aVar4, sDStatusInfo, a.a(aVar4))) {
                        }
                        log_14375.sdStatusInfo_ = sDStatusInfo;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = heavyDetailInfo.a(aVar4, heavyDetailInfo, a.a(aVar4))) {
                        }
                        log_14375.heavyDetailInfo_ = heavyDetailInfo;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
