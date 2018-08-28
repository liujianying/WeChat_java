package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.exdevice.model.f;

class ExdeviceBindDeviceUI$9 extends ClickableSpan {
    final /* synthetic */ ExdeviceBindDeviceUI iBf;

    ExdeviceBindDeviceUI$9(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
        this.iBf = exdeviceBindDeviceUI;
    }

    public final void onClick(View view) {
        f.ae(this.iBf.mController.tml, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
