package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.c;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;

public class ab$a extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == 35) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = layoutInflater.inflate(R.i.chatting_item_from_mail, null);
        ab$b ab_b = new ab$b();
        ab_b.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        ab_b.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        ab_b.ube = (ImageView) view.findViewById(R.h.chatting_mail_attach_iv);
        ab_b.uds = (TextView) view.findViewById(R.h.chatting_title_itv);
        ab_b.ucQ = (TextView) view.findViewById(R.h.chatting_content_itv);
        ab_b.hrH = view.findViewById(R.h.chatting_click_area);
        view.setTag(ab_b);
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        ab$b ab_b = (ab$b) aVar;
        au.HU();
        c GP = com.tencent.mm.model.c.FT().GP(bdVar.field_content);
        ab_b.uds.setText(GP.title);
        ab_b.ucQ.setText(GP.content);
        a(ab_b, GP.eeZ);
        ab_b.ube.setVisibility(GP.jff ? 0 : 8);
        ab_b.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        ab_b.hrH.setOnClickListener(d(aVar2));
        ab_b.hrH.setOnLongClickListener(c(aVar2));
        ab_b.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
    }

    protected final boolean cxM() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        au.HU();
        c GP = com.tencent.mm.model.c.FT().GP(auVar.bXQ.field_content);
        if (ai.oV(GP.mcf).length() > 0) {
            d.b(aVar.tTq.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", auVar.bXQ.field_msgId));
        } else if (ai.oV(GP.tbQ).length() > 0) {
            d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(GP.tbQ)));
        }
        return true;
    }
}
