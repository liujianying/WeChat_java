package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ay.d;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public class k$b extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != -1879048186) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_location_share);
        rVar.setTag(new k.a().dC(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        String substring;
        String str2;
        String str3;
        Object[] objArr;
        g.a aVar3;
        k.a aVar4 = (k.a) aVar;
        this.tKy = aVar2;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str4 = bdVar.field_content;
        if (aVar2.cwr()) {
            int indexOf = bdVar.field_content.indexOf(58);
            if (indexOf != -1) {
                substring = bdVar.field_content.substring(indexOf + 1);
                if (fI != null || substring == null) {
                    str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
                    str3 = "amessage:%b, %s, %s";
                    objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(fI != null);
                    objArr[1] = substring;
                    objArr[2] = Long.valueOf(bdVar.field_msgId);
                    objArr[3] = str;
                    x.e(str2, str3, objArr);
                    aVar3 = null;
                } else {
                    aVar3 = g.a.J(substring, bdVar.field_reserved);
                }
                if (aVar3 != null) {
                    aVar4.ubq.setText(aVar3.title);
                    aVar4.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
                    aVar4.hrH.setOnClickListener(d(aVar2));
                    if (this.qUB) {
                        aVar4.hrH.setOnLongClickListener(c(aVar2));
                        aVar4.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
                    }
                }
                if (d.elh == null && d.elh.nt(aVar2.getTalkerUserName())) {
                    aVar4.ubq.setTextColor(aVar2.tTq.getContext().getResources().getColor(R.e.normal_text_color));
                    aVar4.hrH.setClickable(true);
                    aVar4.hrH.setEnabled(true);
                    return;
                }
                aVar4.ubq.setTextColor(-8750470);
                aVar4.hrH.setClickable(false);
                aVar4.hrH.setEnabled(false);
            }
        }
        substring = str4;
        if (fI != null) {
        }
        str2 = "MicroMsg.ChattingItemAppMsgLocationShareFrom";
        str3 = "amessage:%b, %s, %s";
        objArr = new Object[4];
        if (fI != null) {
        }
        objArr[0] = Boolean.valueOf(fI != null);
        objArr[1] = substring;
        objArr[2] = Long.valueOf(bdVar.field_msgId);
        objArr[3] = str;
        x.e(str2, str3, objArr);
        aVar3 = null;
        if (aVar3 != null) {
            aVar4.ubq.setText(aVar3.title);
            aVar4.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
            aVar4.hrH.setOnClickListener(d(aVar2));
            if (this.qUB) {
                aVar4.hrH.setOnLongClickListener(c(aVar2));
                aVar4.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            }
        }
        if (d.elh == null) {
        }
        aVar4.ubq.setTextColor(-8750470);
        aVar4.hrH.setClickable(false);
        aVar4.hrH.setEnabled(false);
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
