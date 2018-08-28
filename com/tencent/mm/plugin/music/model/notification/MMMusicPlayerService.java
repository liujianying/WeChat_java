package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.tencent.mm.an.a;
import com.tencent.mm.plugin.music.b.a.c;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.notification.a.2;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MMMusicPlayerService extends Service {
    a lzn;
    Runnable lzo = new 1(this);

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
        x.i("MicroMsg.Music.MMMusicPlayerService", "init");
        this.lzn = new a();
        a aVar = this.lzn;
        x.i("MicroMsg.Music.MMMusicNotification", "init");
        aVar.lzf = this;
        aVar.lzg = (NotificationManager) getSystemService("notification");
        aVar.lzi = new 2(aVar);
        registerReceiver(aVar.lzi, new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK"));
        aVar.huc = true;
        refresh();
    }

    final void refresh() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
        a bhR = h.bic().bhR();
        if (bhR == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
        } else if (bi.oW(bhR.field_protocol)) {
            c bhQ = h.bic().bhQ();
            if (bhQ == null) {
                x.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
            } else if (bhQ.PY()) {
                k(bhR);
            } else if (bhQ.bho()) {
                l(bhR);
            }
        } else {
            x.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public final void k(a aVar) {
        x.i("MicroMsg.Music.MMMusicPlayerService", "play");
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            return;
        }
        ah.M(this.lzo);
        a aVar2 = this.lzn;
        if (!aVar2.huc) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
        } else if (aVar2.lzf == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "play");
            ah.M(aVar2.lzh);
            aVar2.lzf.startForeground(291, aVar2.a(aVar2.lzf, aVar, true));
        }
    }

    public final void l(a aVar) {
        x.i("MicroMsg.Music.MMMusicPlayerService", "pause");
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
            return;
        }
        ah.M(this.lzo);
        a aVar2 = this.lzn;
        if (!aVar2.huc) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
        } else if (aVar2.lzf == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "pause");
            ah.M(aVar2.lzh);
            aVar2.lzg.notify(291, aVar2.a(aVar2.lzf, aVar, false));
        }
    }

    public final void stop() {
        x.i("MicroMsg.Music.MMMusicPlayerService", "stop");
        a aVar = this.lzn;
        if (!aVar.huc) {
            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
        } else if (aVar.lzf == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
        } else {
            x.i("MicroMsg.Music.MMMusicNotification", "close");
            ah.M(aVar.lzh);
            ah.i(aVar.lzh, 1000);
        }
        ah.M(this.lzo);
        ah.i(this.lzo, 60000);
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
        a aVar = this.lzn;
        x.i("MicroMsg.Music.MMMusicNotification", "uninit");
        aVar.lzf.unregisterReceiver(aVar.lzi);
        aVar.lzi = null;
        aVar.lzf = null;
        aVar.lzg = null;
        aVar.huc = false;
    }

    public IBinder onBind(Intent intent) {
        return new a(this);
    }
}
