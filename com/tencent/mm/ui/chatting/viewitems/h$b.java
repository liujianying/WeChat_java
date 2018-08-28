package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public class h$b extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || (i != 452984881 && i != 520093745)) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_coupon_card);
        rVar.setTag(new h$a().r(rVar, true));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        this.tKy = aVar2;
        h$a h_a = (h$a) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (!(h_a == null || J == null)) {
            h_a.a(aVar2.tTq.getContext(), J, bdVar.field_imgPath, this.qUB);
        }
        au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
        if (aVar.hrH != null) {
            aVar.hrH.setTag(auVar);
            aVar.hrH.setOnClickListener(d(aVar2));
            if (this.qUB) {
                aVar.hrH.setOnLongClickListener(c(aVar2));
                aVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        if (bdVar.field_content == null) {
            return true;
        }
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (gp == null) {
            return true;
        }
        switch (gp.type) {
            case 16:
                if (gp.dxG == 5 || gp.dxG == 6 || gp.dxG == 2) {
                    if (gp.dxG != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                    return false;
                }
            case 34:
                contextMenu.clear();
                contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                return false;
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        g.a aVar2;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = bdVar.field_content;
                aVar2 = null;
                if (str2 != null) {
                    aVar2 = g.a.gp(str2);
                }
                if (aVar2 != null) {
                    l.fJ(bdVar.field_msgId);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                break;
            case 103:
                str = bdVar.field_content;
                if (str != null) {
                    aVar2 = g.a.gp(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                hz hzVar = new hz();
                                hzVar.bRv.bRw = aVar2.bRw;
                                hzVar.bRv.bIZ = bdVar.field_msgId;
                                hzVar.bRv.bRx = bdVar.field_talker;
                                com.tencent.mm.sdk.b.a.sFg.m(hzVar);
                                break;
                        }
                    }
                }
                break;
            case 111:
                str = com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend);
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", str);
                aVar2 = g.a.gp(str);
                if (aVar2 == null || 16 != aVar2.type) {
                    intent.putExtra("Retr_Msg_Type", 2);
                } else {
                    intent.putExtra("Retr_Msg_Type", 14);
                }
                intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        String str = bdVar.field_content;
        if (str == null) {
            return false;
        }
        g.a gp = g.a.gp(str);
        if (gp == null) {
            return false;
        }
        switch (gp.type) {
            case 16:
                if (bi.oW(gp.bRw)) {
                    return false;
                }
                Intent intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_card_app_msg", gp.bRw);
                intent.putExtra("key_from_scene", gp.dxG);
                d.b(aVar.tTq.getContext(), "card", ".ui.CardDetailUI", intent);
                return true;
            case 34:
                h b = h.b(gp);
                if (1 < b.ver) {
                    String str2;
                    int i;
                    String B = p.B(gp.dwn, "message");
                    PackageInfo packageInfo = b.getPackageInfo(aVar.tTq.getContext(), gp.appId);
                    if (packageInfo == null) {
                        str2 = null;
                    } else {
                        str2 = packageInfo.versionName;
                    }
                    if (packageInfo == null) {
                        i = 0;
                    } else {
                        i = packageInfo.versionCode;
                    }
                    a(aVar, B, B, str2, i, gp.appId, true, bdVar.field_msgId, bdVar.field_msgSvrId, bdVar);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_from_user_name", b(aVar, bdVar));
                    intent2.putExtra("key_biz_uin", b.dxI);
                    intent2.putExtra("key_order_id", b.dxJ);
                    if (!(bdVar.field_talker == null || bdVar.field_talker.equals("") || !bdVar.field_talker.endsWith("@chatroom"))) {
                        intent2.putExtra("key_chatroom_name", bdVar.field_talker);
                    }
                    d.b(aVar.tTq.getContext(), "card", ".ui.CardGiftAcceptUI", intent2);
                }
                return true;
            default:
                return false;
        }
    }
}
