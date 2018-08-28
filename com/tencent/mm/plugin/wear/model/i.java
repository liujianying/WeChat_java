package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.mm.ab.g.a;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class i {
    private a bNl = new 1(this);
    private b bNm = new 2(this);
    AudioManager daT = ((AudioManager) ad.getContext().getSystemService("audio"));
    a pJF;
    BroadcastReceiver pJG = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                i.this.bSs();
            }
        }
    };

    public i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        ad.getContext().registerReceiver(this.pJG, intentFilter);
    }

    public final void bSs() {
        a(this.pJF);
    }

    private static a a(a aVar) {
        if (aVar != null) {
            aVar.iWF.stop();
            aVar.iWF.a(null);
            aVar.iWF.a(null);
            aVar.pJI.clear();
        }
        return null;
    }

    final void b(a aVar) {
        while (aVar != null) {
            if (aVar.pJI.size() > 0) {
                bd bdVar = (bd) aVar.pJI.getLast();
                aVar.pJI.removeLast();
                q.H(bdVar);
                x.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[]{Long.valueOf(bdVar.field_msgId), q.getFullPath(bdVar.field_imgPath)});
                if (aVar.iWF.a(q.getFullPath(bdVar.field_imgPath), true, true, -1)) {
                    aVar.iWF.a(this.bNl);
                    aVar.iWF.a(this.bNm);
                    return;
                }
            }
            a(aVar);
            return;
        }
    }
}
