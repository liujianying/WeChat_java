package com.tencent.mm.plugin.card.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class CardBaseUI$3 implements OnItemLongClickListener {
    final /* synthetic */ CardBaseUI htt;

    CardBaseUI$3(CardBaseUI cardBaseUI) {
        this.htt = cardBaseUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
        } else {
            if (i > 0) {
                i--;
            }
            if (i < this.htt.htl.getCount()) {
                this.htt.c(this.htt.htr.nE(i));
            }
        }
        return true;
    }
}
