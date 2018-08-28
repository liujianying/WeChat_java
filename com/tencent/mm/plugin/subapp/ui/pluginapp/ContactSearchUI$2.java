package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.bi;

class ContactSearchUI$2 implements OnEditorActionListener {
    final /* synthetic */ ContactSearchUI oty;

    ContactSearchUI$2(ContactSearchUI contactSearchUI) {
        this.oty = contactSearchUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || bi.oW(ContactSearchUI.a(this.oty).getText().toString().trim()))) {
            ContactSearchUI.b(this.oty);
        }
        return false;
    }
}
