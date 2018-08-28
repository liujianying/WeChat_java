package com.tencent.mm.plugin.sight.decode.ui;

import android.view.View.OnClickListener;

public interface a {
    void bvT();

    int getVideoTotalTime();

    void seek(int i);

    void setIplaySeekCallback(b bVar);

    void setIsPlay(boolean z);

    void setOnPlayButtonClickListener(OnClickListener onClickListener);

    void setVideoTotalTime(int i);
}
