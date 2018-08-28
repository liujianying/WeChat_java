package com.tencent.mm.plugin.appbrand.media.music;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;

final class AppBrandMusicClientService$a implements i<IPCString, IPCBoolean> {
    private AppBrandMusicClientService$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        return new IPCBoolean(a.ghW.uu(((IPCString) obj).value));
    }
}
