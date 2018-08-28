package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class b {
    private static b khw;
    public f<String, WeakReference<d>> khx = new f(10);
    f<String, WeakReference<a>> khy = new f(10, new 1(this));

    public static synchronized b aVQ() {
        b bVar;
        synchronized (b.class) {
            if (khw == null) {
                synchronized (b.class) {
                    if (khw == null) {
                        khw = new b();
                    }
                }
            }
            bVar = khw;
        }
        return bVar;
    }

    public final a EA(String str) {
        if (this.khy.get(str) != null) {
            return (a) ((WeakReference) this.khy.get(str)).get();
        }
        return null;
    }

    public final a dj(String str, String str2) {
        a aVar = null;
        if (this.khy.get(str) != null) {
            aVar = (a) ((WeakReference) this.khy.get(str)).get();
        }
        if (aVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (o.Wg(str2)) {
                aVar = new f(str2);
            } else {
                aVar = new c(str2);
            }
            x.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.khy.put(str, new WeakReference(aVar));
        }
        return aVar;
    }

    public final a q(String str, byte[] bArr) {
        a aVar = null;
        if (bArr != null) {
            if (this.khy.get(str) != null) {
                aVar = (a) ((WeakReference) this.khy.get(str)).get();
            }
            if (aVar == null) {
                if (o.bx(bArr) && ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().aEa()) {
                    aVar = new f(bArr);
                } else {
                    aVar = new c(bArr);
                }
                this.khy.put(str, new WeakReference(aVar));
            }
            if (!aVar.isRunning()) {
                aVar.reset();
            }
        }
        return aVar;
    }
}
