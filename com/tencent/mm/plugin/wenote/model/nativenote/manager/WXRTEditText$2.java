package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WXRTEditText$2 implements TextWatcher {
    final /* synthetic */ WXRTEditText qrh;

    WXRTEditText$2(WXRTEditText wXRTEditText) {
        this.qrh = wXRTEditText;
    }

    public final synchronized void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Object c = WXRTEditText.c(this.qrh) == null ? "" : WXRTEditText.c(this.qrh);
        if (!(WXRTEditText.d(this.qrh) || charSequence.toString().equals(c))) {
            WXRTEditText.a(this.qrh, this.qrh.getSelectionStart());
            WXRTEditText.b(this.qrh, this.qrh.getSelectionEnd());
            WXRTEditText.a(this.qrh, charSequence.toString());
            this.qrh.qqH = WXRTEditText.c(this.qrh);
            WXRTEditText.a(this.qrh, this.qrh.caa());
        }
    }

    public final synchronized void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        WXRTEditText.e(this.qrh);
    }

    public final synchronized void afterTextChanged(Editable editable) {
        x.d("noteeditor.WXRTEditText", "afterTextChanged");
        String obj = editable.toString();
        String str = this.qrh.qqH == null ? "" : this.qrh.qqH;
        if (WXRTEditText.f(this.qrh) != 0) {
            this.qrh.qqH = "";
        }
        if (!WXRTEditText.d(this.qrh) && this.qrh.getSelection().Tw == this.qrh.getSelection().tK && (((!str.endsWith("\n") && (str + "\n").equals(obj)) || (str.endsWith("\n") && !str.endsWith("\n\n") && str.equals(obj))) && ((ParagraphStyle[]) this.qrh.getText().getSpans(str.length(), str.length(), ParagraphStyle.class)).length > 0)) {
            int selectionStart = this.qrh.getSelectionStart();
            WXRTEditText.a(this.qrh, true);
            this.qrh.getText().append("\n");
            WXRTEditText.a(this.qrh, false);
            this.qrh.setSelection(selectionStart);
        }
        if (!(WXRTEditText.g(this.qrh) == null || WXRTEditText.d(this.qrh) || str.equals(obj))) {
            Spannable caa = this.qrh.caa();
            this.qrh.qqH = obj;
            c g = WXRTEditText.g(this.qrh);
            WXRTEditText h = WXRTEditText.h(this.qrh);
            Spannable i = WXRTEditText.i(this.qrh);
            this.qrh.getSelectionStart();
            g.a(h, i, caa, this.qrh.getSelectionEnd());
        }
        WXRTEditText.e(this.qrh);
        WXRTEditText.j(this.qrh);
        WXRTEditText.k(this.qrh);
        WXRTEditText.l(this.qrh);
    }
}
