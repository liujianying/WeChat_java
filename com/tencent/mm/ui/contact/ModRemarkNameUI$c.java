package com.tencent.mm.ui.contact;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;

class ModRemarkNameUI$c extends ClickableSpan {
    public String fky;
    final /* synthetic */ ModRemarkNameUI ukX;

    public ModRemarkNameUI$c(ModRemarkNameUI modRemarkNameUI, String str) {
        this.ukX = modRemarkNameUI;
        this.fky = str;
    }

    public final void onClick(View view) {
        ModRemarkNameUI.a(this.ukX).setText(j.a(this.ukX, ai.oV(this.fky), ModRemarkNameUI.a(this.ukX).getTextSize()));
        ModRemarkNameUI.a(this.ukX).setSelection(ModRemarkNameUI.a(this.ukX).getText().length());
        ModRemarkNameUI.l(this.ukX).setVisibility(8);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.ukX.getResources().getColor(R.e.blue_text_color));
        textPaint.setUnderlineText(false);
    }
}
