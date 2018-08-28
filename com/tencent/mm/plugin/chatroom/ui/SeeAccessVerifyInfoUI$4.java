package com.tencent.mm.plugin.chatroom.ui;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;

class SeeAccessVerifyInfoUI$4 implements Runnable {
    final /* synthetic */ SeeAccessVerifyInfoUI hOz;

    SeeAccessVerifyInfoUI$4(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.hOz = seeAccessVerifyInfoUI;
    }

    public final void run() {
        int i = 0;
        if (SeeAccessVerifyInfoUI.d(this.hOz) != null) {
            i = (int) ((((float) SeeAccessVerifyInfoUI.d(this.hOz).getHeight()) + this.hOz.getResources().getDimension(R.f.BigPadding)) + this.hOz.getResources().getDimension(R.f.NormalAvatarSize));
        }
        if (SeeAccessVerifyInfoUI.e(this.hOz).getCount() / 4 > 0) {
            i *= (SeeAccessVerifyInfoUI.e(this.hOz).getCount() / 4) + 1;
        }
        SeeAccessVerifyInfoUI.f(this.hOz).setLayoutParams(new LayoutParams(SeeAccessVerifyInfoUI.f(this.hOz).getWidth(), i));
    }
}
