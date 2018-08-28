package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Set;

public final class b implements e {

    /* renamed from: com.tencent.mm.modelvoiceaddr.b.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Set erN;
        final /* synthetic */ String erO;
        final /* synthetic */ String erP;

        public AnonymousClass1(Set set, String str, String str2) {
            this.erN = set;
            this.erO = str;
            this.erP = str2;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            for (String VO : this.erN) {
                linkedList.add(new bhz().VO(VO));
                x.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", new Object[]{VO});
            }
            bhz VO2 = new bhz().VO(this.erO);
            bhz VO3 = new bhz().VO(this.erP);
            g.DF().a(228, b.this);
            g.DF().a(new a(linkedList.size(), linkedList, VO2, VO3), 0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.DF().b(228, this);
        if (lVar instanceof a) {
            x.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }
}
