package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class bhl extends a {
    public String jPK;
    public int ruE;
    public b rwb;
    public String rwt;
    public int sir;
    public int sis;
    public LinkedList<bns> sit = new LinkedList();
    public String siu;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwt == null) {
                throw new f.a.a.b("Not all required fields were included: MD5");
            } else if (this.jPK == null) {
                throw new f.a.a.b("Not all required fields were included: Url");
            } else if (this.siu == null) {
                throw new f.a.a.b("Not all required fields were included: OriginalMD5");
            } else {
                if (this.rwt != null) {
                    aVar.g(1, this.rwt);
                }
                aVar.fT(2, this.sir);
                if (this.jPK != null) {
                    aVar.g(3, this.jPK);
                }
                aVar.fT(4, this.sis);
                aVar.d(5, 8, this.sit);
                if (this.rwb != null) {
                    aVar.b(6, this.rwb);
                }
                if (this.siu != null) {
                    aVar.g(7, this.siu);
                }
                aVar.fT(8, this.ruE);
                return 0;
            }
        } else if (i == 1) {
            if (this.rwt != null) {
                h = f.a.a.b.b.a.h(1, this.rwt) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.sir);
            if (this.jPK != null) {
                h += f.a.a.b.b.a.h(3, this.jPK);
            }
            h = (h + f.a.a.a.fQ(4, this.sis)) + f.a.a.a.c(5, 8, this.sit);
            if (this.rwb != null) {
                h += f.a.a.a.a(6, this.rwb);
            }
            if (this.siu != null) {
                h += f.a.a.b.b.a.h(7, this.siu);
            }
            return h + f.a.a.a.fQ(8, this.ruE);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sit.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rwt == null) {
                throw new f.a.a.b("Not all required fields were included: MD5");
            } else if (this.jPK == null) {
                throw new f.a.a.b("Not all required fields were included: Url");
            } else if (this.siu != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: OriginalMD5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bhl bhl = (bhl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bhl.rwt = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bhl.sir = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bhl.jPK = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bhl.sis = aVar3.vHC.rY();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bns bns = new bns();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bns.a(aVar4, bns, a.a(aVar4))) {
                        }
                        bhl.sit.add(bns);
                    }
                    return 0;
                case 6:
                    bhl.rwb = aVar3.cJR();
                    return 0;
                case 7:
                    bhl.siu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bhl.ruE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
