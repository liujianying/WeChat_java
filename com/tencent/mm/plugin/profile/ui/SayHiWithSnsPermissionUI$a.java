package com.tencent.mm.plugin.profile.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;

class SayHiWithSnsPermissionUI$a extends ClickableSpan {
    public String fky;
    final /* synthetic */ SayHiWithSnsPermissionUI lYi;

    public SayHiWithSnsPermissionUI$a(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI, String str) {
        this.lYi = sayHiWithSnsPermissionUI;
        this.fky = str;
    }

    public final void onClick(View view) {
        SayHiWithSnsPermissionUI.b(this.lYi).setText(j.a(this.lYi, bi.oV(this.fky), SayHiWithSnsPermissionUI.b(this.lYi).getTextSize()));
        SayHiWithSnsPermissionUI.b(this.lYi).setSelection(SayHiWithSnsPermissionUI.b(this.lYi).getText().length());
        SayHiWithSnsPermissionUI.m(this.lYi).setVisibility(8);
        SayHiWithSnsPermissionUI.l(this.lYi)[4] = 1;
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.lYi.getResources().getColor(R.e.blue_text_color));
        textPaint.setUnderlineText(false);
    }
}
