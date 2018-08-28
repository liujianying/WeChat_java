package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$7 implements Runnable {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$7(a aVar) {
        this.ulb = aVar;
    }

    public final void run() {
        x.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
        View findViewById = this.ulb.findViewById(R.h.loading_tips_area);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this.ulb.getContext(), R.a.fast_faded_out));
        }
    }
}
