package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.d.o;

class SnsCommentDetailUI$a extends o {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$a(SnsCommentDetailUI snsCommentDetailUI) {
        this.nUO = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        SnsCommentDetailUI.i(this.nUO).ohv.onClick(view);
    }

    public final void updateDrawState(TextPaint textPaint) {
        int color = this.nUO.getResources().getColor(c.sns_link_bg_color);
        if (this.lmQ) {
            textPaint.bgColor = color;
        } else {
            textPaint.bgColor = 0;
        }
    }
}
