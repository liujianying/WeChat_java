package com.tencent.mm.plugin.music.cache.ipc;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

final class a$a implements i<IPCVoid, IPCString> {
    private a$a() {
    }

    private static IPCString alc() {
        try {
            x.i("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "ipc getAccPath task");
            return new IPCString(g.Ei().dqp);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.MusicDataSourceCrossProcessImp", e, "ipc getAccPath task", new Object[0]);
            return new IPCString("");
        }
    }
}
