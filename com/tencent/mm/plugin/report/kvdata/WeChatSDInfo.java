package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public class WeChatSDInfo extends a {
    public int depth_;
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount_;
    public LinkedList<SubDirInfo> subDirList_ = new LinkedList();
    public int subDirResultsSize_;
    public long tempAccDirCount_;
    public int tempAccDirResultsSize_;
    public long tempAccFileCount_;
    public long tempAccFileLenInvalidCount_;
    public long tempAccTotalSize_;
    public long totalSize_;
    public long totalTime_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.totalSize_);
            aVar.T(2, this.dirCount_);
            aVar.T(3, this.fileCount_);
            aVar.T(4, this.fileLenInvalidCount_);
            aVar.fT(5, this.subDirResultsSize_);
            aVar.T(6, this.totalTime_);
            aVar.fT(7, this.depth_);
            aVar.T(8, this.tempAccTotalSize_);
            aVar.fT(9, this.tempAccDirResultsSize_);
            aVar.T(10, this.tempAccDirCount_);
            aVar.T(11, this.tempAccFileCount_);
            aVar.T(12, this.tempAccFileLenInvalidCount_);
            aVar.d(13, 8, this.subDirList_);
            return 0;
        } else if (i == 1) {
            return ((((((((((((f.a.a.a.S(1, this.totalSize_) + 0) + f.a.a.a.S(2, this.dirCount_)) + f.a.a.a.S(3, this.fileCount_)) + f.a.a.a.S(4, this.fileLenInvalidCount_)) + f.a.a.a.fQ(5, this.subDirResultsSize_)) + f.a.a.a.S(6, this.totalTime_)) + f.a.a.a.fQ(7, this.depth_)) + f.a.a.a.S(8, this.tempAccTotalSize_)) + f.a.a.a.fQ(9, this.tempAccDirResultsSize_)) + f.a.a.a.S(10, this.tempAccDirCount_)) + f.a.a.a.S(11, this.tempAccFileCount_)) + f.a.a.a.S(12, this.tempAccFileLenInvalidCount_)) + f.a.a.a.c(13, 8, this.subDirList_);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.subDirList_.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
                WeChatSDInfo weChatSDInfo = (WeChatSDInfo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        weChatSDInfo.totalSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        weChatSDInfo.dirCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        weChatSDInfo.fileCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 4:
                        weChatSDInfo.fileLenInvalidCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 5:
                        weChatSDInfo.subDirResultsSize_ = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        weChatSDInfo.totalTime_ = aVar3.vHC.rZ();
                        return 0;
                    case 7:
                        weChatSDInfo.depth_ = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        weChatSDInfo.tempAccTotalSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 9:
                        weChatSDInfo.tempAccDirResultsSize_ = aVar3.vHC.rY();
                        return 0;
                    case 10:
                        weChatSDInfo.tempAccDirCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 11:
                        weChatSDInfo.tempAccFileCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 12:
                        weChatSDInfo.tempAccFileLenInvalidCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 13:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            SubDirInfo subDirInfo = new SubDirInfo();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = subDirInfo.a(aVar4, subDirInfo, a.a(aVar4))) {
                            }
                            weChatSDInfo.subDirList_.add(subDirInfo);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
