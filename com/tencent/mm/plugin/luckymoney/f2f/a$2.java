package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

class a$2 implements OnLoadCompleteListener {
    final /* synthetic */ a kMY;

    public a$2(a aVar) {
        this.kMY = aVar;
    }

    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        if (i2 == 0) {
            this.kMY.kMV.put(Integer.valueOf(i), Boolean.valueOf(true));
        } else {
            this.kMY.kMV.put(Integer.valueOf(i), Boolean.valueOf(false));
        }
    }
}
