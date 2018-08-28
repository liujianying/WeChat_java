package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;

@TargetApi(23)
final class c$b implements OnFrameRenderedListener {
    final /* synthetic */ c aDI;

    /* synthetic */ c$b(c cVar, MediaCodec mediaCodec, byte b) {
        this(cVar, mediaCodec);
    }

    private c$b(c cVar, MediaCodec mediaCodec) {
        this.aDI = cVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this == this.aDI.aDE) {
            this.aDI.mt();
        }
    }
}
