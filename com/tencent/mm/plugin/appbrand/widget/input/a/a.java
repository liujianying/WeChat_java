package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.smtt.utils.TbsLog;

public final class a {
    private final ag H = new 1(this, Looper.getMainLooper());
    public volatile c gKC;

    public final void a(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            Message obtainMessage = this.H.obtainMessage(TbsLog.TBSLOG_CODE_SDK_BASE, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
            this.H.removeMessages(TbsLog.TBSLOG_CODE_SDK_BASE);
            this.H.sendMessageDelayed(obtainMessage, z ? 150 : 0);
        }
    }
}
