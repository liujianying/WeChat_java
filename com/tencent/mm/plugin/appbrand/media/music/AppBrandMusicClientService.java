package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;

public final class AppBrandMusicClientService {
    public static AppBrandMusicClientService ghS = new AppBrandMusicClientService();
    public HashMap<String, b> ghR = new HashMap();
    public volatile String ghT = "";

    private AppBrandMusicClientService() {
    }

    public final void lf(int i) {
        x.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[]{Integer.valueOf(i)});
        for (Entry entry : this.ghR.entrySet()) {
            if (entry != null) {
                String str = (String) entry.getKey();
                b bVar = (b) entry.getValue();
                if (!TextUtils.isEmpty(this.ghT) && this.ghT.equalsIgnoreCase(str)) {
                    x.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[]{this.ghT});
                    if (bVar != null) {
                        if (i == 10) {
                            bVar.acB();
                        } else if (i == 2) {
                            bVar.onStop();
                        }
                    }
                }
            }
        }
    }

    public static boolean ut(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return ((IPCBoolean) XIPCInvoker.a("com.tencent.mm", new IPCString(str), a.class)).value;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMusicClientService", "isPlayingMusic ? %s, e = %s", new Object[]{str, e});
            return false;
        }
    }
}
