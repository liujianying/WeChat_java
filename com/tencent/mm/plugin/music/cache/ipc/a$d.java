package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

final class a$d implements i<IPCInteger, IPCInteger> {
    private a$d() {
    }

    private static IPCInteger b(IPCInteger iPCInteger) {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getRemovePlayingAudioPlayerGroupCount task");
            return new IPCInteger(((Integer) g.Ei().DT().get(a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(iPCInteger.value))).intValue());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getRemovePlayingAudioPlayerGroupCount task", new Object[0]);
            return new IPCInteger(iPCInteger.value);
        }
    }
}
