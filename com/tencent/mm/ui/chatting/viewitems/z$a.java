package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.b.b.x;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.z.c;
import com.tencent.mm.ui.chatting.viewitems.z.d;

public class z$a extends b {
    private a tKy;
    private c udk;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || (i != 39 && i != 3 && i != 23 && i != 13 && i != 33)) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_from_picture);
        view.setTag(new d().q(view, true));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        ((i) aVar2.O(i.class)).aW(bdVar);
        d dVar = (d) aVar;
        boolean a = o.Pf().a(dVar.ube, bdVar.field_imgPath, com.tencent.mm.bp.a.getDensity(aVar2.tTq.getContext()), bdVar.cGC, bdVar.cGD, R.g.chat_img_template, dVar.udn, R.g.chat_img_default_bg, 1, null);
        dVar.udo.setVisibility(0);
        dVar.mgA.setVisibility(8);
        if (!(a || this.qUB)) {
            dVar.ube.setImageBitmap(BitmapFactory.decodeResource(aVar2.tTq.getMMResources(), R.g.nosdcard_pic));
        }
        String str2 = null;
        if (aVar2.cwr()) {
            str2 = bdVar.field_talker;
        }
        dVar.hrH.setTag(new au(bdVar, aVar2.cwr(), i, str, str2));
        View view = dVar.hrH;
        if (this.udk == null) {
            this.udk = new c(this.tKy, this);
        }
        view.setOnClickListener(this.udk);
        dVar.hrH.setOnLongClickListener(c(aVar2));
        dVar.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
        z.a(bdVar, aVar2, dVar);
    }

    protected final boolean b(a aVar) {
        return aVar.cwr();
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au.HU();
        if (!(!com.tencent.mm.model.c.isSDCardAvailable() || view == null || bdVar == null)) {
            int i = ((au) view.getTag()).position;
            e eVar = null;
            if (bdVar.field_msgId > 0) {
                eVar = o.Pf().br(bdVar.field_msgId);
            }
            if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                eVar = o.Pf().bq(bdVar.field_msgSvrId);
            }
            contextMenu.add(i, a$i.AppCompatTheme_spinnerStyle, 0, view.getContext().getString(R.l.retransmit));
            if (f.MI() && !this.tKy.cws()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.chatting_long_click_brand_service));
            }
            if (com.tencent.mm.bg.d.QS("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            dj djVar = new dj();
            djVar.bLf.bJC = bdVar.field_msgId;
            com.tencent.mm.sdk.b.a.sFg.m(djVar);
            if (djVar.bLg.bKE || com.tencent.mm.pluginsdk.model.app.g.U(this.tKy.tTq.getContext(), bdVar.getType())) {
                contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
            }
            if (!(eVar == null || eVar.status == -1)) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(R.l.chatting_image_long_click_photo_edit));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            if (bf.l(bdVar)) {
                contextMenu.clear();
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_img));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        if (100 == menuItem.getItemId()) {
            z.e(bdVar, aVar);
        } else if (131 == menuItem.getItemId()) {
            z.b(aVar, menuItem, bdVar);
        } else {
            ((x) aVar.O(x.class)).a(menuItem, bdVar);
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }

    public static void a(Context context, b.a aVar, bd bdVar, boolean z) {
        if (true == z) {
            d dVar = (d) aVar;
            o.Pf().a(dVar.ube, bdVar.field_imgPath, com.tencent.mm.bp.a.getDensity(context), bdVar.cGC, bdVar.cGD, R.g.chat_img_template, dVar.udn, R.g.chat_img_from_default_bg, 1, null);
        }
    }
}
