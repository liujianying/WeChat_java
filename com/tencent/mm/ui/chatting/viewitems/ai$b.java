package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.ai.c;

public class ai$b extends b {
    private a tKy;
    private c ueu;

    private c cxR() {
        if (this.ueu == null) {
            this.ueu = new c(this.tKy);
        }
        return this.ueu;
    }

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 43) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_video);
        rVar.setTag(new ai$d().q(rVar, false));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        ai$d ai_d = (ai$d) aVar;
        ai$d.a(ai_d, bdVar, false, i, aVar2, R.g.chat_img_template, cxR(), c(aVar2));
        if (cxN()) {
            r nW = t.nW(bdVar.field_imgPath);
            if (nW != null && nW.status == 199 && a((g) aVar2.O(g.class), bdVar.field_msgId)) {
                if (ai_d.uai != null) {
                    ai_d.uai.setVisibility(0);
                }
            } else if (ai_d.uai != null) {
                ai_d.uai.setVisibility(8);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (view == null) {
                return false;
            }
            int i = ((au) view.getTag()).position;
            r nI = o.Ta().nI(bdVar.field_imgPath);
            MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.chatting_long_click_menu_mute_play));
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            Intent intent = new Intent();
            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
            add.setIntent(intent);
            if (nI != null) {
                int i2 = nI.status;
                if (!(104 == i2 || 103 == i2 || 105 == i2 || f$k.AppCompatTheme_ratingBarStyle == i2)) {
                    contextMenu.add(i, 107, 0, view.getContext().getString(R.l.retransmit));
                }
            }
            if (nI != null && (nI.status == 199 || nI.status == 199)) {
                if (d.QS("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
                }
                dj djVar = new dj();
                djVar.bLf.bJC = bdVar.field_msgId;
                com.tencent.mm.sdk.b.a.sFg.m(djVar);
                if (djVar.bLg.bKE) {
                    contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
                }
                if (!bdVar.cky() && ((bdVar.cmj() || bdVar.cmk()) && a(bdVar, this.tKy) && ((nI.status == 199 || nI.status == 199 || bdVar.cGF == 1) && aaA(bdVar.field_talker)))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
                }
                if (f.MJ() && !this.tKy.cws()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.chatting_long_click_brand_service));
                }
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
