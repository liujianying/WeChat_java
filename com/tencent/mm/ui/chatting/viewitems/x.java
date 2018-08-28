package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g$a;

public final class x extends b {
    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048183) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_harddevice_like);
        rVar.setTag(new a(this).dI(rVar));
        return rVar;
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
        g$a g_a;
        a aVar3 = (a) aVar;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str2 = bdVar.field_content;
        if (fI == null || str2 == null) {
            String str3 = "MicrMsg.ChattingItemHardDeviceMsgLike";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fI == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(bdVar.field_msgId);
            objArr[3] = str;
            com.tencent.mm.sdk.platformtools.x.e(str3, str4, objArr);
            g_a = null;
        } else {
            g_a = g$a.J(str2, bdVar.field_reserved);
        }
        au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
        if (g_a != null && (g_a.showType == 2 || g_a.dxq == 2 || g_a.dxq == 4)) {
            b.o(aVar3.eKk, g_a.dxu);
            aVar3.udg.setTextSize(0, aVar2.tTq.getMMResources().getDimension(R.f.NormalTextSize));
            aVar3.udg.setTextColor(Color.parseColor("#BF000000"));
            aVar3.udg.setEllipsize(TruncateAt.END);
            aVar3.udg.setSingleLine(true);
            aVar3.udg.setShouldEllipsize(true);
            aVar3.udg.setText(j.a(aVar2.tTq.getContext(), g_a.dxt));
        }
        aVar.hrH.setOnLongClickListener(c(aVar2));
        aVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        aVar.hrH.setTag(auVar);
        aVar.hrH.setOnClickListener(d(aVar2));
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        contextMenu.add(((au) view.getTag()).position, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = bdVar.field_content;
                g$a g_a = null;
                if (str != null) {
                    g_a = g$a.gp(str);
                }
                if (g_a != null) {
                    l.fJ(bdVar.field_msgId);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (bdVar == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            return false;
        }
        String str = bdVar.field_content;
        g$a J = g$a.J(str, bdVar.field_reserved);
        if (J == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            return false;
        }
        com.tencent.mm.sdk.platformtools.x.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[]{J.url});
        if (ai.oW(J.url)) {
            au.HU();
            Intent intent;
            if (c.FR().Yg(J.dxu).BB()) {
                com.tencent.mm.sdk.platformtools.x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
                return false;
            } else if (J.showType == 2) {
                if (ai.oW(J.dxc)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_is_latest", true);
                    intent2.putExtra("app_username", J.appName);
                    intent2.putExtra("device_type", J.dxr);
                    intent2.putExtra("locate_to_username", J.dxu);
                    d.b(aVar.tTq.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                } else {
                    intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", bdVar.field_reserved);
                    intent.putExtra("key_rank_title", J.dxn);
                    intent.putExtra("key_champion_info", J.dxo);
                    intent.putExtra("key_champion_coverimg", J.dxo);
                    intent.putExtra("rank_id", J.dxc);
                    intent.putExtra("app_username", J.appName);
                    intent.putExtra("device_type", J.dxr);
                    intent.putExtra("key_champioin_username", J.dxm);
                    intent.putExtra("locate_to_username", J.dxu);
                    d.b(aVar.tTq.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                }
                com.tencent.mm.plugin.sport.b.d.kB(30);
                return false;
            } else if (J.showType != 4) {
                return false;
            } else {
                intent = new Intent();
                intent.putExtra("username", J.dxu);
                intent.putExtra("app_username", "gh_43f2581f6fd6");
                d.b(aVar.tTq.getContext(), "exdevice", ".ui.ExdeviceProfileUI", intent);
                com.tencent.mm.plugin.sport.b.d.kB(29);
                return false;
            }
        }
        Intent intent3 = new Intent();
        intent3.putExtra("rawUrl", J.url);
        d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
        return true;
    }
}
