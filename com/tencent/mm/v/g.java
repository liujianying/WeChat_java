package com.tencent.mm.v;

import android.util.Log;
import com.tencent.mm.bu.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    private static volatile int dpf = 0;
    private static volatile boolean dpg = false;

    public static void initialize() {
        a.post(new Runnable() {
            public final void run() {
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.dnp;
                c fJ = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100295");
                if (fJ == null) {
                    x.i("MicroMsg.JSONFactory", "JSON lib type ABTest item is null.");
                } else if (fJ.isValid()) {
                    try {
                        g.gF(bi.getInt((String) fJ.ckq().get("jsonLibType"), 1));
                        x.i("MicroMsg.JSONFactory", "current jsonLibType is : %d", new Object[]{Integer.valueOf(g.dpf)});
                    } catch (Throwable e) {
                        x.w("MicroMsg.JSONFactory", "parse jsonLibType error : %s", new Object[]{Log.getStackTraceString(e)});
                    }
                } else {
                    g.gF(1);
                }
            }
        });
    }

    public static JSONObject fU(String str) {
        if (!dpg) {
            initialize();
        }
        if (dpf == 1) {
            return new h(str);
        }
        return new JSONObject(str);
    }

    public static c Dc() {
        if (dpf == 1) {
            return new k();
        }
        return new d();
    }

    public static c n(Map map) {
        if (dpf == 1) {
            return new k(map);
        }
        return new d(map);
    }

    public static c fV(String str) {
        if (dpf == 1) {
            return new k(str);
        }
        return new d(str);
    }

    public static a Dd() {
        if (dpf == 1) {
            return new j();
        }
        return new b();
    }

    public static a fW(String str) {
        if (dpf == 1) {
            return new j(str);
        }
        return new b(str);
    }

    public static void gF(int i) {
        dpf = i;
        dpg = true;
    }

    public static int De() {
        return dpf;
    }
}
