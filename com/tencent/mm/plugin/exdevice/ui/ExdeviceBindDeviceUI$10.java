package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class ExdeviceBindDeviceUI$10 extends ClickableSpan {
    final /* synthetic */ ExdeviceBindDeviceUI iBf;

    ExdeviceBindDeviceUI$10(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
        this.iBf = exdeviceBindDeviceUI;
    }

    public final void onClick(View view) {
        this.iBf.finish();
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
