package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class GameWebViewMainProcessService$4 implements ServiceConnection {
    GameWebViewMainProcessService$4() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        GameWebViewMainProcessService.a(a.R(iBinder));
        GameWebViewMainProcessService.aSp();
        GameWebViewMainProcessService.aSq();
        x.i("MicroMsg.GameWebViewMainProcessService", "onServiceConnected(%s)", new Object[]{ad.getProcessName()});
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        GameWebViewMainProcessService.a(null);
        GameWebViewMainProcessService.aSr();
        GameWebViewMainProcessService.ahu();
        x.i("MicroMsg.GameWebViewMainProcessService", "onServiceDisconnected(%s)", new Object[]{ad.getProcessName()});
    }
}
