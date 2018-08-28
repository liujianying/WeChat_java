package com.tencent.mm.plugin.music.model.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends Handler {
    final /* synthetic */ a lyY;

    a$1(a aVar, Looper looper) {
        this.lyY = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (100 == message.what) {
            long duration = this.lyY.lyN.getDuration();
            long currentPosition = this.lyY.lyN.getCurrentPosition();
            long bufferedPosition = this.lyY.lyN.getBufferedPosition();
            long bufferedPercentage = (long) this.lyY.lyN.getBufferedPercentage();
            x.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[]{Long.valueOf(duration), Long.valueOf(currentPosition), Long.valueOf(bufferedPosition), Long.valueOf(bufferedPercentage)});
            this.lyY.fLN.removeMessages(100);
            if (this.lyY.lxb) {
                this.lyY.fLN.sendEmptyMessageDelayed(100, 5000);
            }
        }
    }
}
