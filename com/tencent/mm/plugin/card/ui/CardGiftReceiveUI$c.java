package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardGiftInfo$AcceptedCardItem;
import com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.d;
import java.util.LinkedList;

class CardGiftReceiveUI$c extends BaseAdapter {
    final /* synthetic */ CardGiftReceiveUI hEd;
    private LinkedList<CardGiftInfo$AcceptedCardItem> hEi;

    CardGiftReceiveUI$c(CardGiftReceiveUI cardGiftReceiveUI, LinkedList<CardGiftInfo$AcceptedCardItem> linkedList) {
        this.hEd = cardGiftReceiveUI;
        this.hEi = linkedList;
    }

    public final int getCount() {
        return this.hEi.size();
    }

    private CardGiftInfo$AcceptedCardItem nV(int i) {
        return (CardGiftInfo$AcceptedCardItem) this.hEi.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        CardGiftInfo$AcceptedCardItem nV = nV(i);
        if (view == null) {
            view = View.inflate(this.hEd, e.card_gift_accepter_card_item, null);
            d dVar2 = new d(this.hEd);
            dVar2.eGX = (TextView) view.findViewById(a.d.tv_card_title);
            dVar2.hEh = (TextView) view.findViewById(a.d.tv_card_price);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        dVar.eGX.setText(nV.hvV);
        dVar.hEh.setText(nV.hvW + this.hEd.mController.tml.getString(g.card_gift_price_rmb_uint));
        return view;
    }
}
