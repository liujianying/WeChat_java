package com.tencent.mm.pluginsdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ProfileEditPhoneNumberView$1 implements OnClickListener {
    final /* synthetic */ MMPhoneNumberEditText qGo;
    final /* synthetic */ ProfileEditPhoneNumberView qGp;

    ProfileEditPhoneNumberView$1(ProfileEditPhoneNumberView profileEditPhoneNumberView, MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.qGp = profileEditPhoneNumberView;
        this.qGo = mMPhoneNumberEditText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.qGp.qGi = "";
        this.qGp.qGn.cds();
        ProfileEditPhoneNumberView.a(this.qGp, this.qGo);
        if (!ProfileEditPhoneNumberView.a(this.qGp)) {
            ProfileEditPhoneNumberView.b(this.qGp);
        }
    }
}
