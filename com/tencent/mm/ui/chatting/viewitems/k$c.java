package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ay.d;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public class k$c extends b {
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == -1879048186) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg_location_share);
        rVar.setTag(new k.a().dC(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        k.a aVar3 = (k.a) aVar;
        this.tKy = aVar2;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            aVar3.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
            aVar3.hrH.setOnClickListener(d(aVar2));
            if (this.qUB) {
                aVar3.hrH.setOnLongClickListener(c(aVar2));
                aVar3.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            }
            aVar3.ubq.setText(J.title);
        }
        if (d.elh == null || !d.elh.nt(aVar2.getTalkerUserName())) {
            aVar3.ubq.setTextColor(-8750470);
            aVar3.hrH.setClickable(false);
            aVar3.hrH.setEnabled(false);
            return;
        }
        aVar3.ubq.setTextColor(aVar2.tTq.getContext().getResources().getColor(R.e.normal_text_color));
        aVar3.hrH.setClickable(true);
        aVar3.hrH.setEnabled(true);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        l.SY(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
        if (com.tencent.mm.bg.d.QS("favorite") && (bl == null || !bl.aaq())) {
            switch (gp.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 20:
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
                    break;
            }
        }
        if (!bdVar.cky() && bdVar.aQo() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = bdVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.gp(str);
                }
                if (aVar2 != null) {
                    l.fJ(bdVar.field_msgId);
                    com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                    f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar2.appId, false);
                    if (bl != null && bl.aaq()) {
                        a(aVar, aVar2, bdVar, bl);
                        break;
                    }
                }
                break;
            case f$k.AppCompatTheme_switchStyle /*111*/:
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
        ac acVar = (ac) aVar.O(ac.class);
        aVar.getTalkerUserName();
        acVar.by("fromMessage", true);
        return true;
    }
}
