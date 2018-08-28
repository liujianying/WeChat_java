package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextPaint;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.d.o;

class a$d extends o {
    final /* synthetic */ a oiE;

    a$d(a aVar) {
        this.oiE = aVar;
    }

    public final void onClick(View view) {
        this.oiE.nuc.nUk.ohw.onClick(view);
    }

    public final void updateDrawState(TextPaint textPaint) {
        int color = this.oiE.mActivity.getResources().getColor(c.sns_link_bg_color);
        if (this.lmQ) {
            textPaint.bgColor = color;
        } else {
            textPaint.bgColor = 0;
        }
    }
}
