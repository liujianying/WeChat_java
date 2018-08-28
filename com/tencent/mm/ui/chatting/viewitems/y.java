package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g;

public final class y extends b {
    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048176) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_harddevice_push);
        rVar.setTag(new a(this).dJ(rVar));
        return rVar;
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.c.a aVar2, bd bdVar, String str) {
        g.a aVar3;
        a aVar4 = (a) aVar;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str2 = bdVar.field_content;
        if (fI == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsgPush";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fI == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(bdVar.field_msgId);
            objArr[3] = str;
            x.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = g.a.J(str2, bdVar.field_reserved);
        }
        au auVar = new au(bdVar, aVar2.cwr(), i, null, 0);
        if (aVar3 != null && (aVar3.showType == 3 || aVar3.dxq == 3)) {
            aVar4.eKk.setImageResource(R.g.hard_device_rank_icon);
            aVar4.udi.setText(aVar3.dxv);
        }
        aVar.hrH.setOnLongClickListener(c(aVar2));
        aVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        aVar.hrH.setTag(auVar);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        contextMenu.add(((au) view.getTag()).position, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case i$l.AppCompatTheme_buttonStyle /*100*/:
                String str = bdVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.gp(str);
                }
                if (aVar2 != null) {
                    l.fJ(bdVar.field_msgId);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar) {
        return false;
    }
}
