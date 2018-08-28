package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.au;

public class t$c implements OnLongClickListener {
    private a tKy;

    public t$c(a aVar) {
        this.tKy = aVar;
    }

    public final boolean onLongClick(View view) {
        if (((m) this.tKy.O(m.class)).cvb().ceH()) {
            x.w("changelcai", "ChattingUI isScrolling!!!");
        } else {
            au auVar = (au) view.getTag();
            int selectionStart = ((m) this.tKy.O(m.class)).cvb().getSelectionStart();
            if (!auVar.userName.equals(q.GF())) {
                if (((m) this.tKy.O(m.class)).cvb().getIsVoiceInputPanleShow()) {
                    x.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
                } else {
                    c cVar = (c) this.tKy.O(c.class);
                    String a;
                    if (s.fq(this.tKy.getTalkerUserName()) || cVar.cus()) {
                        String gT;
                        h.mEJ.h(10976, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                        com.tencent.mm.model.au.HU();
                        u ih = com.tencent.mm.model.c.Ga().ih(auVar.chatroomName);
                        if (cVar.cus()) {
                            gT = ((e) this.tKy.O(e.class)).gT(auVar.userName);
                        } else {
                            a = AtSomeoneUI.a(ih, auVar.userName);
                            if (ai.oW(a)) {
                                gT = r.gR(auVar.userName);
                            } else {
                                gT = a;
                            }
                        }
                        m mVar = (m) this.tKy.O(m.class);
                        StringBuffer stringBuffer = new StringBuffer(mVar.cvb().getLastText());
                        stringBuffer.insert(selectionStart, "@" + gT + 8197);
                        mVar.cvb().o(stringBuffer.toString(), (selectionStart + gT.length()) + 2, true);
                        mVar.cvb().am(auVar.chatroomName, auVar.userName, gT);
                        mVar.cvb().setMode(1);
                        view.postDelayed(new Runnable() {
                            public final void run() {
                            }
                        }, 2000);
                    } else if (s.he(this.tKy.getTalkerUserName()) && !this.tKy.getTalkerUserName().contains("@")) {
                        h.mEJ.h(10976, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
                        if (!cVar.cur() || cVar.cus()) {
                            a = r.gR(auVar.userName);
                        } else {
                            a = ((e) this.tKy.O(e.class)).gT(auVar.userName);
                        }
                        m mVar2 = (m) this.tKy.O(m.class);
                        StringBuffer stringBuffer2 = new StringBuffer(mVar2.cvb().getLastText());
                        stringBuffer2.insert(selectionStart, a);
                        mVar2.cvb().o(stringBuffer2.toString(), a.length() + selectionStart, true);
                        mVar2.cvb().setMode(1);
                        view.postDelayed(new 2(this), 2000);
                    }
                }
            }
        }
        return true;
    }
}
