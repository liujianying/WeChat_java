package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public interface f {
    void d(double d, boolean z);

    int getCurrentPosition();

    int getDuration();

    double getLastProgresstime();

    long getLastSurfaceUpdateTime();

    String getVideoPath();

    boolean isPlaying();

    void onDetach();

    void pause();

    boolean q(Context context, boolean z);

    void setLoop(boolean z);

    void setMute(boolean z);

    void setOnInfoCallback(b bVar);

    void setOnSeekCompleteCallback(c cVar);

    void setOnSurfaceCallback(d dVar);

    void setOneTimeVideoTextureUpdateCallback(e eVar);

    void setPlayProgressCallback(boolean z);

    void setThumb(Bitmap bitmap);

    void setVideoCallback(a aVar);

    void setVideoPath(String str);

    boolean start();

    void stop();

    void x(double d);
}
