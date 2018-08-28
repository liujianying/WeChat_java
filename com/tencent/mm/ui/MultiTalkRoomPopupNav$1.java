package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ay.d;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class MultiTalkRoomPopupNav$1 implements OnClickListener {
    final /* synthetic */ MultiTalkRoomPopupNav toY;

    MultiTalkRoomPopupNav$1(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        this.toY = multiTalkRoomPopupNav;
    }

    public final void onClick(View view) {
        if (d.elh != null && a.qyi.by(this.toY.getContext())) {
            x.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
        } else if (d.elh == null || !d.elh.SB()) {
            MultiTalkRoomPopupNav.a(this.toY);
        } else {
            Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.in_new_share_location_tip), 0).show();
            x.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
        }
    }
}
