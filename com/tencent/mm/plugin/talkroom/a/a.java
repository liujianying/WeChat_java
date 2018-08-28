package com.tencent.mm.plugin.talkroom.a;

import com.tencent.mm.protocal.c.bsm;
import f.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    public LinkedList<bsm> bUb = new LinkedList();
    public int sceneType;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.d(2, 8, this.bUb);
            aVar.fT(3, this.sceneType);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            return (h + f.a.a.a.c(2, 8, this.bUb)) + f.a.a.a.fQ(3, this.sceneType);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.bUb.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = com.tencent.mm.bk.a.a(aVar2); h > 0; h = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsm bsm = new bsm();
                        f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bsm.a(aVar5, bsm, com.tencent.mm.bk.a.a(aVar5))) {
                        }
                        aVar4.bUb.add(bsm);
                    }
                    return 0;
                case 3:
                    aVar4.sceneType = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
