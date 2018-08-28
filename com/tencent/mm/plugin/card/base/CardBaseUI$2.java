package com.tencent.mm.plugin.card.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class CardBaseUI$2 implements OnItemClickListener {
    final /* synthetic */ CardBaseUI htt;

    CardBaseUI$2(CardBaseUI cardBaseUI) {
        this.htt = cardBaseUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
            this.htt.avI();
            return;
        }
        if (i > 0) {
            i--;
        }
        if (i < this.htt.htl.getCount()) {
            this.htt.b(this.htt.htr.nE(i));
        }
    }
}
