package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$11 implements Runnable {
    final /* synthetic */ a uhE;

    AddressUI$a$11(a aVar) {
        this.uhE = aVar;
    }

    public final void run() {
        x.i("MicroMsg.AddressUI", "post to first init finish");
        View findViewById = this.uhE.findViewById(R.h.loading_tips_area);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this.uhE.getContext(), R.a.fast_faded_out));
        }
    }
}
