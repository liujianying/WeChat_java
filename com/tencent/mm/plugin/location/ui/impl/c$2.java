package com.tencent.mm.plugin.location.ui.impl;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements OnEditorActionListener {
    final /* synthetic */ c kJf;

    c$2(c cVar) {
        this.kJf = cVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        x.d("MicroMsg.MMPoiMapUI", "keyboard action");
        if (3 == i) {
            c.m(this.kJf);
        }
        return false;
    }
}
