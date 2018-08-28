package com.tencent.mm.ui.chatting.b;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.model.am;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.b.b.q;
import java.util.LinkedList;

class s$10 implements OnClickListener {
    final /* synthetic */ LinearLayout tQA;
    final /* synthetic */ s tQv;

    s$10(s sVar, LinearLayout linearLayout) {
        this.tQv = sVar;
        this.tQA = linearLayout;
    }

    public final void onClick(View view) {
        if (((q) this.tQv.bAG.O(q.class)).cvD()) {
            ((q) this.tQv.bAG.O(q.class)).Fc(s.i(this.tQv));
            return;
        }
        if (((int) this.tQv.bAG.oLT.dhP) == 0) {
            au.HU();
            if (c.FR().U(this.tQv.bAG.oLT) != -1) {
                x.e("MicroMsg.ChattingUI.HeaderComponent", "[insertRetId] successfully! username:%s", new Object[]{this.tQv.bAG.oLT});
            }
        }
        final String str = s.fq(this.tQv.bAG.oLT.field_username) ? this.tQv.bAG.oLT.field_username : "";
        au.HU();
        ab Yg = c.FR().Yg(s.d(this.tQv));
        Object aG = Yg != null ? bi.aG(Yg.cta, "") : "";
        x.i("MicroMsg.ChattingUI.HeaderComponent", "dkverify banner add:%s chat:%s ticket", new Object[]{s.d(this.tQv), str, aG});
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(aG)) {
            a aVar = new a(this.tQv.bAG.tTq.getContext(), new 1(this));
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(3));
            aVar.TC(aG);
            aVar.b(s.d(this.tQv), str, linkedList);
        } else {
            am.a.dBr.a(s.d(this.tQv), str, new b.a() {
                public final void x(String str, boolean z) {
                    a aVar = new a(s$10.this.tQv.bAG.tTq.getContext(), new 1(this));
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(3));
                    au.HU();
                    ab Yg = c.FR().Yg(s.d(s$10.this.tQv));
                    aVar.TC(Yg != null ? bi.aG(Yg.cta, "") : "");
                    aVar.b(s.d(s$10.this.tQv), str, linkedList);
                }
            });
        }
        h.mEJ.h(11004, new Object[]{s.d(this.tQv), Integer.valueOf(3)});
    }
}
