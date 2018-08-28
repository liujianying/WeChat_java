package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;

public class a {
    public static void biz() {
        x.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
        AudioPlayerConfigure.setLog(new 1());
        AudioPlayerConfigure.setSoLibraryLoader(new 2());
    }
}
