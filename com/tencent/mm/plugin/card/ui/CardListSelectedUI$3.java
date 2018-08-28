package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.x;

class CardListSelectedUI$3 implements OnItemClickListener {
    final /* synthetic */ CardListSelectedUI hFs;

    CardListSelectedUI$3(CardListSelectedUI cardListSelectedUI) {
        this.hFs = cardListSelectedUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view.getAlpha() != 1.0f) {
            x.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            return;
        }
        if (this.hFs.hFd) {
            this.hFs.hFf.put(Integer.valueOf(i), Boolean.valueOf(!((Boolean) this.hFs.hFf.get(Integer.valueOf(i))).booleanValue()));
        } else {
            for (int i2 = 0; i2 < this.hFs.hFe.size(); i2++) {
                this.hFs.hFf.put(Integer.valueOf(i2), Boolean.valueOf(false));
            }
            this.hFs.hFf.put(Integer.valueOf(i), Boolean.valueOf(true));
            CardListSelectedUI.a(this.hFs, (a) this.hFs.hFe.get(i));
        }
        CardListSelectedUI.c(this.hFs).notifyDataSetChanged();
        CardListSelectedUI.d(this.hFs);
    }
}
