package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g$a;

public final class w extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048185) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_harddevice_msg);
        rVar.setTag(new a(this).dH(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        String str2;
        String str3;
        g$a g_a;
        this.tKy = aVar2;
        a aVar3 = (a) aVar;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str4 = bdVar.field_content;
        if (fI == null || str4 == null) {
            str2 = "MicroMsg.ChattingItemHardDeviceMsg";
            str3 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fI == null);
            objArr[1] = str4;
            objArr[2] = Long.valueOf(bdVar.field_msgId);
            objArr[3] = str;
            x.e(str2, str3, objArr);
            g_a = null;
        } else {
            g_a = g$a.J(str4, bdVar.field_reserved);
        }
        au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) aVar.hrH;
        if (g_a != null && (g_a.showType == 1 || g_a.dxq == 1)) {
            int i2;
            if (ai.oW(g_a.dxl)) {
                str2 = g_a.dxh;
                str4 = g_a.dxi;
                if (bi.oW(str2) || bi.oW(str4)) {
                    x.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[]{str2, str4});
                    str2 = "#ffffff";
                    str4 = "#ffffff";
                }
                Drawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str2)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                g_a.dxl = "#ffffff";
                str2 = g_a.dxj;
                str3 = g_a.dxk;
                int i3 = R.e.white;
                i2 = R.e.white;
                if (!(ai.oW(str2) || ai.oW(str3))) {
                    try {
                        i3 = Color.parseColor(str2);
                        i2 = Color.parseColor(str3);
                    } catch (IllegalArgumentException e) {
                        x.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                Drawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                aVar3.udd.setBackgroundDrawable(stateListDrawable2);
            }
            str4 = g_a.dxl;
            if (aVar3 != null) {
                i2 = R.e.white;
                if (!ai.oW(str4)) {
                    try {
                        i2 = Color.parseColor(str4);
                    } catch (IllegalArgumentException e2) {
                        x.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                aVar3.uda.setTextColor(i2);
                aVar3.udb.setTextColor(i2);
                aVar3.ucY.setTextColor(i2);
                aVar3.ucZ.setTextColor(i2);
                aVar3.udc.setTextColor(i2);
            }
            aVar3.uda.setText(g_a.dxd);
            aVar3.udb.setText(g_a.dxb);
            aVar3.ucY.setText(g_a.dxf);
            aVar3.ucZ.setText(g_a.dxe);
            aVar3.udc.setText(g_a.dxg);
            if (ai.oW(g_a.dxm)) {
                aVar3.ude.setVisibility(8);
            } else {
                aVar3.ude.setVisibility(0);
                b.o(aVar3.ude, g_a.dxm);
            }
        }
        aVar.hrH.setOnLongClickListener(c(aVar2));
        aVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        aVar.hrH.setTag(auVar);
        aVar.hrH.setOnClickListener(d(aVar2));
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        contextMenu.add(((au) view.getTag()).position, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
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

    public final boolean b(View view, a aVar, bd bdVar) {
        boolean z = false;
        String str = bdVar.field_content;
        g$a J = g$a.J(str, bdVar.field_reserved);
        if (J == null) {
            x.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            return false;
        }
        x.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[]{J.url});
        Intent intent;
        if (ai.oW(J.url)) {
            if (!ai.oW(J.dxc)) {
                if (System.currentTimeMillis() - (((long) J.dxs) * 1000) >= 2592000000L) {
                    z = true;
                }
                if (!z) {
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
                    d.b(aVar.tTq.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                    com.tencent.mm.plugin.sport.b.d.kB(28);
                    return true;
                }
            }
            d.A(aVar.tTq.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", J.url);
        d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
