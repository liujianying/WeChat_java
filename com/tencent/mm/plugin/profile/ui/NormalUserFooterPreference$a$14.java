package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.2;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class NormalUserFooterPreference$a$14 implements OnClickListener {
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$14(a aVar) {
        this.lXy = aVar;
    }

    public final void onClick(View view) {
        a aVar = this.lXy;
        st stVar = new st();
        com.tencent.mm.sdk.b.a.sFg.m(stVar);
        if (!NormalUserFooterPreference.a(aVar.lXw).field_username.equals(stVar.cdA.talker) && (stVar.cdA.cdC || stVar.cdA.cdD)) {
            Toast.makeText(NormalUserFooterPreference.b(aVar.lXw).mController.tml, stVar.cdA.cdB ? R.l.cannot_use_voip_bcz_video_talking : R.l.cannot_use_voip_bcz_voice_talking, 0).show();
            x.i("MicroMsg.NormalUserFooterPreference", "voip is running, can't do this");
        } else if (!com.tencent.mm.p.a.bw(NormalUserFooterPreference.b(aVar.lXw))) {
            rn rnVar = new rn();
            rnVar.ccn.ccp = true;
            com.tencent.mm.sdk.b.a.sFg.m(rnVar);
            String str = rnVar.cco.ccr;
            if (bi.oW(str)) {
                aVar.bnD();
                return;
            }
            x.v("MicroMsg.NormalUserFooterPreference", "Talkroom is on: " + str);
            h.a(NormalUserFooterPreference.b(aVar.lXw), NormalUserFooterPreference.b(aVar.lXw).getString(R.l.talk_room_enter_voip_tip), "", NormalUserFooterPreference.b(aVar.lXw).getString(R.l.app_ok), NormalUserFooterPreference.b(aVar.lXw).getString(R.l.app_cancel), new 2(aVar), new 3(aVar));
        }
    }
}
