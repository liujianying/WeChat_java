package com.tencent.mm.ui.chatting.viewitems;

import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.ai.c;
import com.tencent.mm.ui.chatting.viewitems.ai.d;

public class ai$a extends b {
    private a tKy;
    private c ueu;

    private c cxR() {
        if (this.ueu == null) {
            this.ueu = new c(this.tKy);
        }
        return this.ueu;
    }

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 43) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_from_video);
        view.setTag(new d().q(view, true));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        d dVar = (d) aVar;
        d.a(dVar, bdVar, true, i, aVar2, R.g.chat_img_template, cxR(), c(aVar2));
        String str2 = bdVar.cGB;
        if (str2 == null || str2.length() == 0) {
            dVar.tZU.setVisibility(8);
            return;
        }
        dVar.tZU.setVisibility(0);
        b(aVar2, dVar.tZU, au.aaI(str2));
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            int i = ((au) view.getTag()).position;
            r nI = o.Ta().nI(bdVar.field_imgPath);
            contextMenu.add(i, 130, 0, view.getContext().getString(R.l.chatting_long_click_menu_mute_play));
            contextMenu.add(i, a$i.AppCompatTheme_ratingBarStyleIndicator, 0, view.getContext().getString(R.l.retransmit));
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            dj djVar = new dj();
            djVar.bLf.bJC = bdVar.field_msgId;
            com.tencent.mm.sdk.b.a.sFg.m(djVar);
            if (djVar.bLg.bKE) {
                contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
            }
            if (nI != null && ((nI.status == 199 || nI.status == 199) && f.MJ() && !this.tKy.cws())) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.chatting_long_click_brand_service));
            }
            if (bf.l(bdVar)) {
                contextMenu.clear();
                contextMenu.add(i, 130, 0, view.getContext().getString(R.l.chatting_long_click_menu_mute_play));
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_video));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        ((af) aVar.O(af.class)).a(menuItem, bdVar);
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        cxR().onClick(view);
        return true;
    }
}
