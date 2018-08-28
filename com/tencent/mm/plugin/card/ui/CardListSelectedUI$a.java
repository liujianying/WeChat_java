package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.ui.CardListSelectedUI.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CardListSelectedUI$a extends BaseAdapter {
    final /* synthetic */ CardListSelectedUI hFs;

    CardListSelectedUI$a(CardListSelectedUI cardListSelectedUI) {
        this.hFs = cardListSelectedUI;
    }

    public final int getCount() {
        return this.hFs.hFe.size();
    }

    private a nW(int i) {
        return (a) this.hFs.hFe.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        a nW = nW(i);
        if (view == null) {
            view = View.inflate(this.hFs, e.card_select_card_item, null);
            dVar = new d(this.hFs);
            dVar.hFz = (ImageView) view.findViewById(com.tencent.mm.plugin.card.a.d.logo);
            dVar.eGX = (TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.title);
            dVar.hFv = (TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.sub_title);
            dVar.hFA = (TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.aux_title);
            dVar.hoc = (TextView) view.findViewById(com.tencent.mm.plugin.card.a.d.catalogTV);
            dVar.hFB = view.findViewById(com.tencent.mm.plugin.card.a.d.body_layout);
            dVar.hFC = (ImageView) view.findViewById(com.tencent.mm.plugin.card.a.d.card_select_img);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        if (l.nI(nW.huV)) {
            int i2;
            dVar.eGX.setText(nW.huX);
            if (TextUtils.isEmpty(nW.title)) {
                dVar.hFv.setVisibility(8);
            } else {
                dVar.hFv.setVisibility(0);
                dVar.hFv.setText(nW.title);
            }
            if (TextUtils.isEmpty(nW.huY)) {
                dVar.hFA.setVisibility(8);
            } else {
                dVar.hFA.setVisibility(0);
                dVar.hFA.setText(nW.huY);
            }
            TextView textView = dVar.hoc;
            if (bi.oW(nW.hoj)) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            textView.setVisibility(i2);
            dVar.hoc.setText(nW.hoj);
            CardListSelectedUI.a(dVar.hFz, nW.huW, this.hFs.getBaseContext().getResources().getDimensionPixelSize(b.card_select_list_item_logo_height));
            Boolean bool = (Boolean) this.hFs.hFf.get(Integer.valueOf(i));
            if (bool == null || !bool.booleanValue()) {
                dVar.hFC.setImageResource(c.card_add_unselected_btn_bg);
            } else {
                dVar.hFC.setImageResource(c.card_add_selected_btn_bg);
            }
        } else {
            x.i("MicroMsg.CardListSelectedUI", "not support type");
        }
        return view;
    }
}
