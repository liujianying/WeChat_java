package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.3;

class ShakeSayHiListUI$3$1 implements OnClickListener {
    final /* synthetic */ 3 nbr;

    ShakeSayHiListUI$3$1(3 3) {
        this.nbr = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ShakeSayHiListUI.e(this.nbr.nbq).aPm();
        ShakeSayHiListUI.b(this.nbr.nbq).WT();
        TextView textView = (TextView) this.nbr.nbq.findViewById(R.h.empty_msg_tip_tv);
        textView.setText(R.l.say_hi_non);
        textView.setVisibility(0);
        this.nbr.nbq.enableOptionMenu(false);
    }
}
