package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable.Function1;
import java.util.HashSet;

class Mp4SeekTable$1 implements Function1<HashSet<String>, Boolean> {
    final /* synthetic */ Mp4SeekTable this$0;

    Mp4SeekTable$1(Mp4SeekTable mp4SeekTable) {
        this.this$0 = mp4SeekTable;
    }

    public Boolean call(HashSet<String> hashSet) {
        return Boolean.valueOf(Mp4SeekTable.access$000(hashSet));
    }
}
