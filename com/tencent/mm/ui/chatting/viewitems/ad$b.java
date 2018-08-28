package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ad.a$a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.ah.b;
import com.tencent.mm.ui.chatting.viewitems.ah.e;

public class ad$b extends b {
    private a tKy;

    public final boolean aq(int i, boolean z) {
        if (z && (i == 55 || i == 57)) {
            return true;
        }
        return false;
    }

    public final void a(b$a b_a, int i, a aVar, bd bdVar, String str) {
        this.tKy = aVar;
        e eVar = (e) b_a;
        a$a ln = a$a.ln(bdVar.field_content);
        if (bdVar.field_status >= 2) {
            eVar.mgA.setVisibility(8);
        } else {
            eVar.mgA.setVisibility(0);
        }
        j.a(eVar.ueb.getContext(), com.tencent.mm.ad.a.a(ln), (int) eVar.ueb.getTextSize(), null, "");
        eVar.ueb.setTag(new au(bdVar, aVar.cwr(), i, null, 0));
        eVar.ueb.setOnLongClickListener(c(aVar));
        a(i, eVar, bdVar, aVar.cwp(), aVar.cwr(), aVar, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        if (bdVar.cms()) {
            int i = ((au) view.getTag()).position;
            if (bdVar.field_status == 5) {
                contextMenu.add(i, s$l.AppCompatTheme_checkedTextViewStyle, 0, view.getContext().getString(R.l.chatting_resend_title));
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
            }
        }
        return true;
    }
}
