package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class SubDirInfo extends a {
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount;
    public int tag_;
    public long totalSize_;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.tag_);
            aVar.T(2, this.totalSize_);
            aVar.T(3, this.dirCount_);
            aVar.T(4, this.fileCount_);
            aVar.T(5, this.fileLenInvalidCount);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.tag_) + 0) + f.a.a.a.S(2, this.totalSize_)) + f.a.a.a.S(3, this.dirCount_)) + f.a.a.a.S(4, this.fileCount_)) + f.a.a.a.S(5, this.fileLenInvalidCount);
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
                SubDirInfo subDirInfo = (SubDirInfo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        subDirInfo.tag_ = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        subDirInfo.totalSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        subDirInfo.dirCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 4:
                        subDirInfo.fileCount_ = aVar3.vHC.rZ();
                        return 0;
                    case 5:
                        subDirInfo.fileLenInvalidCount = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
