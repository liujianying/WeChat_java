package com.tencent.mm.bg;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.sdk.platformtools.ad;

class d$4 implements a {
    final /* synthetic */ int ms;
    final /* synthetic */ Fragment ok;
    final /* synthetic */ String qVb;
    final /* synthetic */ String qVg;
    final /* synthetic */ Intent val$intent;

    d$4(Intent intent, String str, String str2, Fragment fragment, int i) {
        this.val$intent = intent;
        this.qVb = str;
        this.qVg = str2;
        this.ok = fragment;
        this.ms = i;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ad.getPackageName(), this.qVg.startsWith(".") ? (ad.chX() + ".plugin." + this.qVb) + this.qVg : this.qVg);
        this.ok.startActivityForResult(intent, this.ms);
        d.f(this.ok.getActivity(), this.qVg, this.val$intent);
    }
}
