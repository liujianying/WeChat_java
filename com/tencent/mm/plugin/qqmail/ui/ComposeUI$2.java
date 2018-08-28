package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class ComposeUI$2 implements TextWatcher {
    final /* synthetic */ ComposeUI mfs;
    final /* synthetic */ ImageView mft;

    ComposeUI$2(ComposeUI composeUI, ImageView imageView) {
        this.mfs = composeUI;
        this.mft = imageView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 4;
        if (this.mfs.meW) {
            ImageView imageView = this.mft;
            if (ComposeUI.j(this.mfs).getText().length() > 0) {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            return;
        }
        this.mft.setVisibility(4);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
