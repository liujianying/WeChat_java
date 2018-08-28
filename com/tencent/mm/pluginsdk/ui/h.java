package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;

public interface h {

    public interface c {
        void bQ(long j);

        void pV(String str);
    }

    void SL();

    void SM();

    boolean ac(float f);

    boolean ajG();

    void ajY();

    void ajZ();

    void c(boolean z, String str, int i);

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getPlayerType();

    int getVideoDurationSec();

    boolean isPlaying();

    boolean kW(int i);

    boolean pause();

    void setCover(Bitmap bitmap);

    void setFullDirection(int i);

    void setIsShowBasicControls(boolean z);

    void setMute(boolean z);

    void setScaleType(d dVar);

    void setVideoFooterView(g gVar);

    void start();

    void stop();

    boolean x(int i, boolean z);
}
