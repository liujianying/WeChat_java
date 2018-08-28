package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public final class m {

    public static class b extends b {
        private a tKy;

        public final boolean bba() {
            return false;
        }

        public final boolean aq(int i, boolean z) {
            if (z || i != 16777265) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_text);
            rVar.setTag(new a().dE(rVar));
            return rVar;
        }

        public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
            g.a J;
            this.tKy = aVar2;
            ((i) aVar2.O(i.class)).aX(bdVar);
            a aVar3 = (a) aVar;
            String str2 = bdVar.field_content;
            if (aVar2.cwr()) {
                int indexOf = bdVar.field_content.indexOf(58);
                if (indexOf != -1) {
                    str2 = bdVar.field_content.substring(indexOf + 1);
                }
            }
            if (str2 != null) {
                J = g.a.J(str2, bdVar.field_reserved);
            } else {
                J = null;
            }
            if (J != null && J.type == 1) {
                f bl = com.tencent.mm.pluginsdk.model.app.g.bl(J.appId, true);
                String str3 = (bl == null || bl.field_appName == null || bl.field_appName.trim().length() <= 0) ? J.appName : bl.field_appName;
                if (J.appId == null || J.appId.length() <= 0 || !com.tencent.mm.pluginsdk.model.app.g.cT(str3)) {
                    aVar3.jet.setVisibility(8);
                } else {
                    aVar3.jet.setText(aVar2.tTq.getMMResources().getString(R.l.chatting_source_from, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(aVar2.tTq.getContext(), bl, str3)}));
                    aVar3.jet.setVisibility(0);
                    a(aVar2, aVar3.jet, J.appId);
                    a(aVar2, aVar3.jet, J.appId);
                }
                if (J.cGB == null || J.cGB.length() <= 0) {
                    aVar3.tZU.setVisibility(8);
                } else {
                    b(aVar2, aVar3.tZU, au.aaI(J.cGB));
                    aVar3.tZU.setVisibility(0);
                }
                aVar3.uby.setClickable(true);
                aVar3.uby.Q(j.a(aVar3.uby.getContext(), J.title, (int) aVar3.uby.getTextSize(), 1));
            }
            aVar3.uby.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
            au.HU();
            if (c.isSDCardAvailable()) {
                aVar3.uby.setOnLongClickListener(c(aVar2));
                if (J != null && J.type == 1) {
                    aVar3.uby.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
                }
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
            int i = ((au) view.getTag()).position;
            contextMenu.add(i, 102, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_copy_msg));
            contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
            if (d.QS("favorite")) {
                contextMenu.add(i, 116, 0, this.tKy.tTq.getMMResources().getString(R.l.plugin_favorite_opt));
            }
            if (bf.l(bdVar)) {
                contextMenu.clear();
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
            switch (menuItem.getItemId()) {
                case 100:
                    com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                    au.HU();
                    c.FQ().b(new e(bdVar.field_talker, bdVar.field_msgSvrId));
                    break;
                case 102:
                    ClipboardManager clipboardManager = (ClipboardManager) aVar.tTq.getContext().getSystemService("clipboard");
                    Object b = com.tencent.mm.model.bd.b(s.fq(aVar.getTalkerUserName()), g.a.gp(com.tencent.mm.model.bd.b(s.fq(aVar.getTalkerUserName()), bdVar.field_content, bdVar.field_isSend)).title, bdVar.field_isSend);
                    clipboardManager.setText(b);
                    int i = com.tencent.mm.plugin.secinforeport.a.a.mOt;
                    com.tencent.mm.plugin.secinforeport.a.a.f(1, bdVar.field_msgSvrId, bi.WK(b));
                    break;
                case 111:
                    Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend));
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                    aVar.startActivity(intent);
                    break;
            }
            return false;
        }

        public final boolean b(View view, a aVar, bd bdVar) {
            return false;
        }
    }
}
