package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.an.a.a;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$b implements i<IPCString, IPCString> {
    private a$b() {
    }

    private static IPCString a(IPCString iPCString) {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getMusicMIMETypeByMusicId Task, musicId:%s", iPCString);
            return new IPCString(((a) g.l(a.class)).mu(iPCString.value));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getMusicMIMETypeByMusicId task", new Object[0]);
            return new IPCString("");
        }
    }
}
