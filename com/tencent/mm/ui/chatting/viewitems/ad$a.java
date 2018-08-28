package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ad.a$a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.ad.c;
import com.tencent.mm.ui.chatting.viewitems.ah.a;

public class ad$a extends a {
    private com.tencent.mm.ui.chatting.c.a tKy;

    public final boolean aq(int i, boolean z) {
        if (z || (i != 55 && i != 57)) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_qamsg_from);
        rVar.setTag(new c().dG(rVar));
        return rVar;
    }

    public final void a(b$a b_a, int i, com.tencent.mm.ui.chatting.c.a aVar, bd bdVar, String str) {
        this.tKy = aVar;
        c cVar = (c) b_a;
        a$a ln = a$a.ln(bdVar.field_content);
        if (ln != null) {
            String str2 = ln.bSS;
            a(cVar, aVar, bdVar, str2);
            a(cVar, aVar, str2, bdVar);
            j.a(cVar.ucQ.getContext(), com.tencent.mm.ad.a.a(ln), (int) cVar.ucQ.getTextSize(), null, "");
            cVar.ucQ.setTag(new au(bdVar, aVar.cwr(), i, null, 0));
            cVar.ucQ.setOnLongClickListener(c(aVar));
        }
    }

    protected final boolean cxM() {
        return false;
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
