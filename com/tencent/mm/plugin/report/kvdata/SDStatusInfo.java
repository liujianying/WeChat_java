package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo extends a {
    public long eAvailableBlockCount_;
    public int eAvailablePer_;
    public long eAvailableSize_;
    public long eBlockCount_;
    public long eBlockSize_;
    public String ePath_;
    public long eTotalSize_;
    public String fSystem_;
    public int hasUnRemovable_;
    public int ratioHeavy_;
    public String root_;
    public long sAvailableBlockCount_;
    public int sAvailablePer_;
    public long sAvailableSize_;
    public long sBlockCount_;
    public long sBlockSize_;
    public long sTotalSize_;
    public int sizeHeavy_;
    public int useExternal_;
    public int weChatPer_;
    public WeChatSDInfo weChatSDInfo_;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.weChatSDInfo_ == null) {
                throw new b("Not all required fields were included: weChatSDInfo_");
            }
            if (this.weChatSDInfo_ != null) {
                aVar.fV(1, this.weChatSDInfo_.boi());
                this.weChatSDInfo_.a(aVar);
            }
            aVar.fT(2, this.weChatPer_);
            aVar.fT(3, this.sizeHeavy_);
            aVar.fT(4, this.ratioHeavy_);
            aVar.fT(5, this.useExternal_);
            aVar.fT(6, this.hasUnRemovable_);
            aVar.T(7, this.sBlockSize_);
            aVar.T(8, this.sBlockCount_);
            aVar.T(9, this.sTotalSize_);
            aVar.T(10, this.sAvailableBlockCount_);
            aVar.T(11, this.sAvailableSize_);
            aVar.fT(12, this.sAvailablePer_);
            aVar.T(13, this.eBlockSize_);
            aVar.T(14, this.eBlockCount_);
            aVar.T(15, this.eTotalSize_);
            aVar.T(16, this.eAvailableBlockCount_);
            aVar.T(17, this.eAvailableSize_);
            aVar.fT(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                aVar.g(19, this.ePath_);
            }
            if (this.root_ != null) {
                aVar.g(20, this.root_);
            }
            if (this.fSystem_ == null) {
                return 0;
            }
            aVar.g(21, this.fSystem_);
            return 0;
        } else if (i == 1) {
            if (this.weChatSDInfo_ != null) {
                fS = f.a.a.a.fS(1, this.weChatSDInfo_.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((((((((((((((fS + f.a.a.a.fQ(2, this.weChatPer_)) + f.a.a.a.fQ(3, this.sizeHeavy_)) + f.a.a.a.fQ(4, this.ratioHeavy_)) + f.a.a.a.fQ(5, this.useExternal_)) + f.a.a.a.fQ(6, this.hasUnRemovable_)) + f.a.a.a.S(7, this.sBlockSize_)) + f.a.a.a.S(8, this.sBlockCount_)) + f.a.a.a.S(9, this.sTotalSize_)) + f.a.a.a.S(10, this.sAvailableBlockCount_)) + f.a.a.a.S(11, this.sAvailableSize_)) + f.a.a.a.fQ(12, this.sAvailablePer_)) + f.a.a.a.S(13, this.eBlockSize_)) + f.a.a.a.S(14, this.eBlockCount_)) + f.a.a.a.S(15, this.eTotalSize_)) + f.a.a.a.S(16, this.eAvailableBlockCount_)) + f.a.a.a.S(17, this.eAvailableSize_)) + f.a.a.a.fQ(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                fS += f.a.a.b.b.a.h(19, this.ePath_);
            }
            if (this.root_ != null) {
                fS += f.a.a.b.b.a.h(20, this.root_);
            }
            if (this.fSystem_ != null) {
                fS += f.a.a.b.b.a.h(21, this.fSystem_);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.weChatSDInfo_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: weChatSDInfo_");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            SDStatusInfo sDStatusInfo = (SDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = weChatSDInfo.a(aVar4, weChatSDInfo, a.a(aVar4))) {
                        }
                        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                    }
                    return 0;
                case 2:
                    sDStatusInfo.weChatPer_ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    sDStatusInfo.sizeHeavy_ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    sDStatusInfo.ratioHeavy_ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    sDStatusInfo.useExternal_ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    sDStatusInfo.hasUnRemovable_ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    sDStatusInfo.sBlockSize_ = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    sDStatusInfo.sBlockCount_ = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    sDStatusInfo.sTotalSize_ = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    sDStatusInfo.sAvailableBlockCount_ = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    sDStatusInfo.sAvailableSize_ = aVar3.vHC.rZ();
                    return 0;
                case 12:
                    sDStatusInfo.sAvailablePer_ = aVar3.vHC.rY();
                    return 0;
                case 13:
                    sDStatusInfo.eBlockSize_ = aVar3.vHC.rZ();
                    return 0;
                case 14:
                    sDStatusInfo.eBlockCount_ = aVar3.vHC.rZ();
                    return 0;
                case 15:
                    sDStatusInfo.eTotalSize_ = aVar3.vHC.rZ();
                    return 0;
                case 16:
                    sDStatusInfo.eAvailableBlockCount_ = aVar3.vHC.rZ();
                    return 0;
                case 17:
                    sDStatusInfo.eAvailableSize_ = aVar3.vHC.rZ();
                    return 0;
                case 18:
                    sDStatusInfo.eAvailablePer_ = aVar3.vHC.rY();
                    return 0;
                case 19:
                    sDStatusInfo.ePath_ = aVar3.vHC.readString();
                    return 0;
                case 20:
                    sDStatusInfo.root_ = aVar3.vHC.readString();
                    return 0;
                case 21:
                    sDStatusInfo.fSystem_ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
