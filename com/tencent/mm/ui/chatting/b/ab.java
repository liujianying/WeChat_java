package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ap.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.i.a.b;
import com.tencent.mm.ui.chatting.i.c;
import com.tencent.mm.ui.chatting.i.d;
import com.tencent.mm.ui.tools.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@a(cwo = u.class)
public class ab extends a implements u, b {
    private k contextMenuHelper;
    private com.tencent.mm.ui.chatting.i.b tRc;
    private c tRd;
    private d tRe;

    public final void a(View view, bd bdVar, com.tencent.mm.ap.a aVar, int i) {
        String oV;
        Intent intent;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            oV = bi.oV(eVar.ebG);
            x.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[]{oV, Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur())});
            if (eVar.ebU == null) {
                x.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
                return;
            }
            Object obj = (((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus() || s.fq(this.bAG.getTalkerUserName())) ? 1 : null;
            if (obj == null) {
                x.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
            } else if (oV.equals("invite")) {
                ax(eVar.ebU);
            } else if (oV.equals("qrcode")) {
                a(view, eVar.ebU, eVar.bUu);
            } else if (oV.equals("webview") && !bi.oW(eVar.url)) {
                intent = new Intent();
                intent.putExtra("rawUrl", eVar.url);
                intent.putExtra("geta8key_username", q.GF());
                com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        } else if (aVar instanceof com.tencent.mm.ap.d) {
            com.tencent.mm.ap.d dVar = (com.tencent.mm.ap.d) aVar;
            if (i == 0) {
                String str = dVar.ebR;
                oV = dVar.ebS;
                String str2 = dVar.ebL;
                String str3 = dVar.bLe;
                List list = dVar.ebM;
                List list2 = dVar.ebP;
                List list3 = dVar.ebQ;
                Intent intent2 = new Intent();
                intent2.putExtra("msgLocalId", bdVar.field_msgId);
                intent2.putExtra("invitertitle", this.bAG.tTq.getMMResources().getString(R.l.access_invite_content_title, new Object[]{Integer.valueOf(list.size())}));
                intent2.putExtra("inviterusername", str);
                intent2.putExtra("chatroom", str2);
                intent2.putExtra("invitationreason", oV);
                intent2.putExtra("ticket", str3);
                intent2.putExtra("username", bi.c(list, ","));
                intent2.putExtra("nickname", bi.c(list2, ","));
                intent2.putExtra("headimgurl", bi.c(list3, ","));
                com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "chatroom", ".ui.SeeAccessVerifyInfoUI", intent2);
            }
        } else if (aVar instanceof com.tencent.mm.ap.b) {
            com.tencent.mm.ap.b bVar = (com.tencent.mm.ap.b) aVar;
            List arrayList = new ArrayList();
            arrayList.addAll(bVar.ebM);
            ((com.tencent.mm.ui.chatting.b.b.e) this.bAG.O(com.tencent.mm.ui.chatting.b.b.e.class)).a(arrayList, bVar.bLe, bdVar);
        } else if (aVar instanceof com.tencent.mm.ui.chatting.f.a) {
            au.HU();
            if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sSn, Boolean.valueOf(true))).booleanValue()) {
                h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.invoke_edit_tip), this.bAG.tTq.getMMResources().getString(R.l.tip_title), this.bAG.tTq.getMMResources().getString(R.l.i_know_it), new 1(this, view, aVar));
            } else {
                a(view, (com.tencent.mm.ui.chatting.f.a) aVar);
            }
        } else if (aVar instanceof com.tencent.mm.ap.c) {
            x.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
            if (s.fq(this.bAG.getTalkerUserName())) {
                ((com.tencent.mm.plugin.expt.roomexpt.d) g.l(com.tencent.mm.plugin.expt.roomexpt.d.class)).eB(this.bAG.oLT.csI == 0);
                intent = new Intent();
                intent.putExtra("Chat_User", this.bAG.oLT.field_username);
                intent.putExtra("RoomInfo_Id", this.bAG.getTalkerUserName());
                intent.putExtra("Is_Chatroom", s.fq(this.bAG.getTalkerUserName()));
                intent.putExtra("fromChatting", true);
                intent.putExtra("isShowSetMuteAnimation", true);
                com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "chatroom", ".ui.ChatroomInfoUI", intent);
            }
        }
    }

    private void a(View view, com.tencent.mm.ui.chatting.f.a aVar) {
        au.HU();
        com.tencent.mm.model.c.DT().a(aa.a.sSn, Boolean.valueOf(false));
        bd bdVar = aVar.bXQ;
        if (System.currentTimeMillis() - aVar.tXS >= 300000) {
            x.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
            h.b(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.invoke_message_overtime_tip), this.bAG.tTq.getMMResources().getString(R.l.app_tip), true);
            com.tencent.mm.sdk.f.e.post(new 2(this, bdVar, view), "deleteInvokeMsg");
            return;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(15037, new Object[]{Integer.valueOf(1)});
        m mVar = (m) this.bAG.O(m.class);
        mVar.cvb().setLastText(mVar.cvb().getLastText() + aVar.tXR);
        if (!mVar.cvb().ceK()) {
            mVar.cvb().showVKB();
        }
    }

    private void a(View view, LinkedList<String> linkedList, String str) {
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new k(this.bAG.tTq.getContext());
        }
        this.contextMenuHelper.b(view, new 3(this), new 4(this, linkedList, str));
    }

    private void ax(LinkedList<String> linkedList) {
        if (((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur()) {
            ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).au(linkedList);
        } else {
            ((com.tencent.mm.ui.chatting.b.b.e) this.bAG.O(com.tencent.mm.ui.chatting.b.b.e.class)).aw(linkedList);
        }
    }

    public final void ay(LinkedList<String> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            ax(linkedList);
        }
    }

    public final void a(View view, com.tencent.mm.ui.chatting.i.a.a aVar) {
        if (view != null && aVar != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(aVar.username);
            a(view, linkedList, aVar.egr);
        }
    }

    public final void cpG() {
        super.cpG();
        this.tRe = new d(this);
        this.tRd = new c(this);
        this.tRc = new com.tencent.mm.ui.chatting.i.b(this);
    }

    public final void cpK() {
        if (this.tRc != null) {
            this.tRc.release();
            this.tRc = null;
        }
        if (this.tRd != null) {
            this.tRd.release();
            this.tRd = null;
        }
        if (this.tRe != null) {
            this.tRe.release();
            this.tRe = null;
        }
    }
}
