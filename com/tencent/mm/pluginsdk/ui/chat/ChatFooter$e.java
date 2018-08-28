package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;

public class ChatFooter$e implements TextWatcher {
    TextWatcher qME;
    private boolean qMF = false;
    private boolean qMG = d.fS(11);
    final /* synthetic */ ChatFooter qMv;

    public ChatFooter$e(ChatFooter chatFooter, TextWatcher textWatcher) {
        this.qMv = chatFooter;
        this.qME = textWatcher;
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = true;
        if (ChatFooter.h(this.qMv) && this.qMF && editable.length() > 0) {
            this.qMF = false;
            ChatFooter.a(this.qMv).setText(editable.subSequence(0, editable.length() - 1));
            if (ChatFooter.a(this.qMv).length() > 0) {
                ChatFooter.i(this.qMv).performClick();
            }
            x.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
            return;
        }
        this.qME.afterTextChanged(editable);
        if (ChatFooter.p(this.qMv) != null) {
            if (ChatFooter.a(this.qMv).getLineCount() > 1) {
                ChatFooter.p(this.qMv).setVisibility(0);
                ChatFooter.p(this.qMv).setText(editable.length() + "/140");
            } else {
                ChatFooter.p(this.qMv).setVisibility(8);
            }
        }
        if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
            z = false;
        }
        ChatFooter.b(this.qMv, z);
        if (ChatFooter.n(this.qMv) != null) {
            ChatFooter.n(this.qMv).setSendButtonEnable(z);
        }
        x.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.qME.beforeTextChanged(charSequence, i, i2, i3);
        x.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (ChatFooter.h(this.qMv) && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == 10) {
            this.qMF = true;
        } else {
            this.qME.onTextChanged(charSequence, i, i2, i3);
        }
    }
}
