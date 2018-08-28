package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.5;

class NearbySayHiListUI$5$1 implements OnClickListener {
    final /* synthetic */ 5 lCC;

    NearbySayHiListUI$5$1(5 5) {
        this.lCC = 5;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        NearbySayHiListUI.e(this.lCC.lCB).aPm();
        NearbySayHiListUI.b(this.lCC.lCB).WT();
        TextView textView = (TextView) this.lCC.lCB.findViewById(R.h.empty_msg_tip_tv);
        textView.setText(R.l.say_hi_non);
        textView.setVisibility(0);
        this.lCC.lCB.enableOptionMenu(false);
    }
}
