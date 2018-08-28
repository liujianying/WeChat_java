package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Set;

class a$1 implements Runnable {
    final /* synthetic */ Set kMW;
    final /* synthetic */ WeakReference kMX;
    final /* synthetic */ a kMY;

    public a$1(a aVar, Set set, WeakReference weakReference) {
        this.kMY = aVar;
        this.kMW = set;
        this.kMX = weakReference;
    }

    public final void run() {
        try {
            for (String str : this.kMW) {
                if (this.kMX.get() == null || this.kMY.gYf) {
                    x.i("AsyncSoundPool", "context = null or soundPool is stopped");
                    this.kMY.kMT.release();
                    this.kMY.kMU.clear();
                    this.kMY.kMV.clear();
                    return;
                }
                this.kMY.kMU.put(str, Integer.valueOf(this.kMY.kMT.load(((Context) this.kMX.get()).getResources().getAssets().openFd(str), 0)));
            }
        } catch (Exception e) {
            x.e("AsyncSoundPool", "load sound file error:" + e.getMessage());
        }
    }
}
