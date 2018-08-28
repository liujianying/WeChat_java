package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.se;
import java.util.LinkedList;

class l$1 implements OnClickListener {
    final /* synthetic */ se hHK;
    final /* synthetic */ LinkedList hHL;
    final /* synthetic */ LayoutInflater hHM;
    final /* synthetic */ l hHN;

    l$1(l lVar, se seVar, LinkedList linkedList, LayoutInflater layoutInflater) {
        this.hHN = lVar;
        this.hHK = seVar;
        this.hHL = linkedList;
        this.hHM = layoutInflater;
    }

    public final void onClick(View view) {
        this.hHN.hHJ = true;
        this.hHN.hHH.findViewById(d.detail_table_expand_tv).setVisibility(8);
        int i = this.hHK.rvB;
        while (true) {
            int i2 = i;
            if (i2 < this.hHL.size()) {
                TextView textView = (TextView) this.hHM.inflate(e.card_table_row_item, null, false);
                textView.setText(((pr) this.hHL.get(i2)).title);
                this.hHN.hHI.addView(textView);
                i = i2 + 1;
            } else {
                this.hHN.hHI.invalidate();
                return;
            }
        }
    }
}
