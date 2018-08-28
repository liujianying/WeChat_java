package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.se;
import java.util.LinkedList;

public final class l extends i {
    View hHH;
    LinearLayout hHI;
    boolean hHJ = false;

    public final void initView() {
    }

    public final void update() {
        if (this.hHH == null) {
            this.hHH = ((ViewStub) findViewById(d.card_detail_table_stub)).inflate();
        }
        se seVar = this.hHF.ayu().awn().rnm;
        ((TextView) this.hHH.findViewById(d.detail_table_title)).setText(seVar.title);
        if (seVar.rvC != null && seVar.rvC.size() > 0) {
            this.hHI = (LinearLayout) this.hHH.findViewById(d.detail_table_rows_view);
            this.hHI.removeAllViews();
            LinkedList linkedList = seVar.rvC;
            LayoutInflater layoutInflater = (LayoutInflater) this.hHF.ayx().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (seVar.rvB >= linkedList.size() || this.hHJ) {
                this.hHH.findViewById(d.detail_table_expand_tv).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(e.card_table_row_item, null, false);
                    textView.setText(((pr) linkedList.get(i)).title);
                    this.hHI.addView(textView);
                }
                this.hHI.invalidate();
                return;
            }
            for (i = 0; i < seVar.rvB; i++) {
                textView = (TextView) layoutInflater.inflate(e.card_table_row_item, null, false);
                textView.setText(((pr) linkedList.get(i)).title);
                this.hHI.addView(textView);
            }
            this.hHI.invalidate();
            this.hHH.findViewById(d.detail_table_expand_tv).setVisibility(0);
            this.hHH.findViewById(d.detail_table_expand_tv).setOnClickListener(new 1(this, seVar, linkedList, layoutInflater));
        }
    }

    public final void azI() {
        if (this.hHH != null) {
            this.hHH.setVisibility(8);
        }
    }
}
