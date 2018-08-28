package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.la;

class CardShopUI$a extends BaseAdapter {
    final /* synthetic */ CardShopUI hGu;

    class a {
        public TextView hGv;
        public TextView hGw;
        public TextView hGx;
        public ImageView hGy;
        public View hGz;

        a() {
        }
    }

    /* synthetic */ CardShopUI$a(CardShopUI cardShopUI, byte b) {
        this(cardShopUI);
    }

    private CardShopUI$a(CardShopUI cardShopUI) {
        this.hGu = cardShopUI;
    }

    public final int getCount() {
        return CardShopUI.a(this.hGu).size();
    }

    private la nX(int i) {
        return (la) CardShopUI.a(this.hGu).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.hGu.mController.tml, e.card_shop_item, null);
            a aVar2 = new a();
            aVar2.hGv = (TextView) view.findViewById(d.shop_name_tv);
            aVar2.hGw = (TextView) view.findViewById(d.shop_distance_tv);
            aVar2.hGx = (TextView) view.findViewById(d.shop_address_tv);
            aVar2.hGy = (ImageView) view.findViewById(d.shop_poi);
            aVar2.hGz = view.findViewById(d.shop_poi_layout);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        la nX = nX(i);
        if (nX == null) {
            aVar.hGv.setText("");
            aVar.hGw.setText("");
            aVar.hGx.setText("");
        } else {
            aVar.hGv.setText(nX.name);
            if (nX.rnu <= 0.0f) {
                aVar.hGw.setVisibility(8);
            } else {
                aVar.hGw.setText(l.f(this.hGu.getBaseContext(), nX.rnu));
                aVar.hGw.setVisibility(0);
            }
            aVar.hGx.setText(nX.csK + nX.csL + nX.dRH);
            aVar.hGz.setOnClickListener(CardShopUI.f(this.hGu));
            aVar.hGz.setTag(nX);
        }
        return view;
    }
}
