package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.ui.CardListSelectedUI.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CardListSelectedUI$b extends BaseAdapter {
    final /* synthetic */ CardListSelectedUI hFs;

    CardListSelectedUI$b(CardListSelectedUI cardListSelectedUI) {
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
        c cVar;
        a nW = nW(i);
        if (view == null) {
            view = View.inflate(this.hFs, a$e.card_select_card_invoice_item, null);
            cVar = new c(this.hFs);
            cVar.hFt = (ImageView) view.findViewById(d.card_select_img);
            cVar.hFu = (TextView) view.findViewById(d.invoice_status);
            cVar.eGX = (TextView) view.findViewById(d.title);
            cVar.hFv = (TextView) view.findViewById(d.sub_title);
            cVar.hFw = view.findViewById(d.v_line);
            cVar.hFx = (TextView) view.findViewById(d.invoice_title);
            cVar.hFy = (TextView) view.findViewById(d.invoice_item);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (l.nI(nW.huV)) {
            if (TextUtils.isEmpty(nW.title)) {
                cVar.eGX.setVisibility(8);
            } else {
                cVar.eGX.setVisibility(0);
                cVar.eGX.setText(nW.title);
            }
            if (TextUtils.isEmpty(nW.huX)) {
                cVar.hFv.setVisibility(8);
            } else {
                cVar.hFv.setVisibility(0);
                cVar.hFv.setText(nW.huX);
            }
            if (nW.hvc == 0) {
                view.setAlpha(1.0f);
                cVar.hFt.setVisibility(0);
                cVar.hFu.setVisibility(8);
                Boolean bool = (Boolean) this.hFs.hFf.get(Integer.valueOf(i));
                if (bool == null || !bool.booleanValue()) {
                    cVar.hFt.setImageResource(com.tencent.mm.plugin.card.a.c.card_add_unselected_btn_bg);
                } else {
                    cVar.hFt.setImageResource(com.tencent.mm.plugin.card.a.c.card_add_selected_btn_bg);
                }
            } else if (nW.hvc == 1) {
                view.setAlpha(0.2f);
                cVar.hFt.setVisibility(8);
                if (bi.oW(nW.hvf)) {
                    cVar.hFu.setVisibility(8);
                } else {
                    cVar.hFu.setVisibility(0);
                    cVar.hFu.setText(nW.hvf);
                }
            } else {
                cVar.hFt.setVisibility(8);
                cVar.hFu.setVisibility(8);
            }
            if (bi.oW(nW.hvd)) {
                cVar.hFx.setVisibility(8);
            } else {
                cVar.hFx.setVisibility(0);
                cVar.hFx.setText(nW.hvd);
            }
            if (bi.oW(nW.hve)) {
                cVar.hFy.setVisibility(8);
            } else {
                cVar.hFy.setVisibility(0);
                cVar.hFy.setText(nW.hve);
            }
            if (bi.oW(nW.hvd) && bi.oW(nW.hve)) {
                cVar.hFw.setVisibility(8);
            } else {
                cVar.hFw.setVisibility(0);
            }
        } else {
            x.i("MicroMsg.CardListSelectedUI", "not support type");
        }
        return view;
    }
}
