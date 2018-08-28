package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat$AudioType;

public interface INativeDataSource {
    AudioFormat$AudioType getAudioType();

    long getNativeInstance();
}
