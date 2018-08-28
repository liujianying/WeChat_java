package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class ProfileMobilePhoneView$1 implements OnClickListener {
    final /* synthetic */ ProfileMobilePhoneView qGt;

    ProfileMobilePhoneView$1(ProfileMobilePhoneView profileMobilePhoneView) {
        this.qGt = profileMobilePhoneView;
    }

    public final void onClick(View view) {
        ProfileMobilePhoneView.a(this.qGt, ((TextView) view).getText().toString());
    }
}
