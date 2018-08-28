package com.tencent.mm.plugin.music.model.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.an.a;
import com.tencent.mm.plugin.music.b.a.c;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends BroadcastReceiver {
    final /* synthetic */ a lzj;

    a$2(a aVar) {
        this.lzj = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && !bi.oW(intent.getAction())) {
            String stringExtra = intent.getStringExtra("mm_music_notification_action_key");
            if (bi.oW(stringExtra)) {
                x.e("MicroMsg.Music.MMMusicNotification", "action is null, err, return");
                return;
            }
            x.i("MicroMsg.Music.MMMusicNotification", "action:%s", new Object[]{stringExtra});
            c bhQ = h.bic().bhQ();
            if (bhQ == null) {
                x.e("MicroMsg.Music.MMMusicNotification", "musicPlayer is null, return");
                return;
            }
            a bhR = h.bic().bhR();
            if (bhR == null) {
                x.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            } else if (stringExtra.equals("mm_music_notification_action_play")) {
                bhQ.resume();
                f.a(2, bhR);
            } else if (stringExtra.equals("mm_music_notification_action_pause")) {
                bhQ.bhn();
                h.big().bhO();
                f.a(3, bhR);
            } else if (stringExtra.equals("mm_music_notification_action_pre")) {
                if (bhR.field_musicType == 11) {
                    h.bic().bhV();
                } else if (h.bic().mode == 2) {
                    e bic = h.bic();
                    if (bic.mode != 1) {
                        bic.lya = (bic.lya + bic.lyb.size()) - 1;
                        bic.lya %= bic.lyb.size();
                        bic.bhV();
                        bic.e(null);
                    }
                } else {
                    bhQ.if(0);
                    bhQ.resume();
                }
                a.a(bhR, 13, bhQ.bhp());
                f.a(1, bhR);
            } else if (stringExtra.equals("mm_music_notification_action_next")) {
                if (bhR.field_musicType == 11) {
                    h.bic().bhV();
                } else if (h.bic().mode == 2) {
                    h.bic().bhU();
                } else {
                    bhQ.if(0);
                    bhQ.resume();
                }
                a.a(bhR, 14, bhQ.bhp());
                f.a(4, bhR);
            } else if (stringExtra.equals("mm_music_notification_action_close")) {
                ah.A(this.lzj.lzh);
                bhQ.stopPlay();
                f.a(5, bhR);
            }
        }
    }
}
