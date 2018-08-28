package com.tencent.mm.ui.conversation;

import android.os.Message;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import java.util.LinkedList;

class EnterpriseConversationUI$a$9 extends ag {
    final /* synthetic */ a uqA;

    EnterpriseConversationUI$a$9(a aVar) {
        this.uqA = aVar;
    }

    public final void handleMessage(Message message) {
        if (message != null && message.what == 1 && this.uqA.thisActivity() != null && !this.uqA.thisActivity().isFinishing()) {
            int i;
            int i2;
            int count = a.f(this.uqA).getCount();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i6 < count) {
                ai aiVar = (ai) a.f(this.uqA).getItem(i6);
                if (aiVar != null) {
                    String str = aiVar.field_username;
                    if (str != null) {
                        if (s.he(str) && f.kO(str)) {
                            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
                            boolean Yx = ((i) g.l(i.class)).FW().Yx(str);
                            Object obj = (Yg == null || (Yg.field_type & 2048) == 0) ? null : 1;
                            if (obj != null && !Yx) {
                                ((i) g.l(i.class)).FW().Yv(str);
                            } else if (obj == null && Yx) {
                                ((i) g.l(i.class)).FW().Yw(str);
                            }
                            if (f.kN(str)) {
                                linkedList2.add(str);
                            }
                            if (aiVar.field_unReadCount > 0) {
                                if (s.hT(str)) {
                                    i3++;
                                    i = i5;
                                    i2 = i4;
                                } else {
                                    i2 = i4 + 1;
                                    i = aiVar.field_unReadCount + i5;
                                }
                                i6++;
                                i5 = i;
                                i4 = i2;
                            }
                        } else {
                            x.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[]{str});
                            linkedList.add(str);
                            i = i5;
                            i2 = i4;
                            i6++;
                            i5 = i;
                            i4 = i2;
                        }
                    }
                }
                i = i5;
                i2 = i4;
                i6++;
                i5 = i;
                i4 = i2;
            }
            b kn = z.Nh().kn(a.c(this.uqA));
            int i7 = kn != null ? kn.field_qyUin : 0;
            long j = kn != null ? kn.field_wwCorpId : 0;
            long j2 = kn != null ? kn.field_wwUserVid : 0;
            i6 = 0;
            if (!bi.oW(a.l(this.uqA))) {
                i6 = z.Nh().kp(a.l(this.uqA));
            }
            h.mEJ.h(12892, new Object[]{a.c(this.uqA), Integer.valueOf(a.m(this.uqA)), Integer.valueOf(count), "", Integer.valueOf(a.n(this.uqA)), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(a.o(this.uqA)), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j), Long.valueOf(j2)});
            x.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{a.c(this.uqA), Integer.valueOf(a.m(this.uqA)), Integer.valueOf(count), "", Integer.valueOf(a.n(this.uqA)), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(a.o(this.uqA)), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j), Long.valueOf(j2)});
            if (linkedList.size() > 0) {
                au.HU();
                c.FW().as(linkedList);
                a.f(this.uqA).WT();
            }
            if (z.Nk().km(a.c(this.uqA))) {
                z.Nh();
                com.tencent.mm.ac.c.a(a.c(this.uqA), null);
            }
            z.Nk().km(a.p(this.uqA));
            if (linkedList2.size() > 0) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 < linkedList2.size()) {
                        z.Nk().km((String) linkedList2.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
