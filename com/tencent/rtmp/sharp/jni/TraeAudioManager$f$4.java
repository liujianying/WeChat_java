package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.f;

class TraeAudioManager$f$4 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ f b;

    TraeAudioManager$f$4(f fVar, int i) {
        this.b = fVar;
        this.a = i;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        intent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
        intent.putExtra("EXTRA_DATA_STREAMTYPE", this.a);
        if (this.b.p._context != null) {
            this.b.p._context.sendBroadcast(intent);
        }
    }
}
