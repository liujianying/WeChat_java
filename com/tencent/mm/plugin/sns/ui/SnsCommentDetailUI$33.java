package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.c.a;

class SnsCommentDetailUI$33 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$33(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        try {
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            intent.putExtra("sns_label_sns_info", intValue);
            a.ezn.v(intent, this.nUO);
        } catch (Exception e) {
        }
    }
}
