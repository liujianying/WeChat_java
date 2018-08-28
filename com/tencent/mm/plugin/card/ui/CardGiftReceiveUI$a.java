package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.m;

class CardGiftReceiveUI$a extends BaseAdapter {
    final /* synthetic */ CardGiftReceiveUI hEd;

    CardGiftReceiveUI$a(CardGiftReceiveUI cardGiftReceiveUI) {
        this.hEd = cardGiftReceiveUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return (AccepterItem) CardGiftReceiveUI.b(this.hEd).hvQ.get(i);
    }

    public final int getCount() {
        return CardGiftReceiveUI.b(this.hEd).hvQ.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CardGiftReceiveUI$b cardGiftReceiveUI$b;
        AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.b(this.hEd).hvQ.get(i);
        if (view == null) {
            view = View.inflate(this.hEd, e.card_gift_accepter_item, null);
            CardGiftReceiveUI$b cardGiftReceiveUI$b2 = new CardGiftReceiveUI$b(this.hEd);
            cardGiftReceiveUI$b2.hEf = (ImageView) view.findViewById(d.img_accepter_headimg);
            cardGiftReceiveUI$b2.hEg = (TextView) view.findViewById(d.tv_accepter_nickName);
            cardGiftReceiveUI$b2.eGX = (TextView) view.findViewById(d.tv_accepter_title);
            cardGiftReceiveUI$b2.hEh = (TextView) view.findViewById(d.tv_accepter_price);
            view.setTag(cardGiftReceiveUI$b2);
            cardGiftReceiveUI$b = cardGiftReceiveUI$b2;
        } else {
            cardGiftReceiveUI$b = (CardGiftReceiveUI$b) view.getTag();
        }
        if (accepterItem != null) {
            if (accepterItem.hvY != null) {
                ImageView imageView = cardGiftReceiveUI$b.hEf;
                String str = accepterItem.hvY;
                int i2 = c.my_card_package_defaultlogo;
                if (!(imageView == null || TextUtils.isEmpty(str))) {
                    if (TextUtils.isEmpty(str)) {
                        imageView.setImageResource(i2);
                    } else {
                        a aVar = new a();
                        aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                        o.Pk();
                        aVar.dXU = null;
                        aVar.dXA = m.xr(str);
                        aVar.dXy = true;
                        aVar.dXW = true;
                        aVar.dXX = 3.0f;
                        aVar.dXw = true;
                        aVar.dXF = 34;
                        aVar.dXE = 34;
                        aVar.dXN = i2;
                        o.Pj().a(str, imageView, aVar.Pt());
                    }
                }
            }
            cardGiftReceiveUI$b.hEg.setText(accepterItem.hvX);
            cardGiftReceiveUI$b.eGX.setText(accepterItem.hvV);
            cardGiftReceiveUI$b.hEh.setText(accepterItem.hvW + this.hEd.mController.tml.getString(g.card_gift_price_rmb_uint));
        }
        return view;
    }
}
