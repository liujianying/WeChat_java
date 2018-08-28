package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager dab;
    public static HashMap<String, a> dac = new HashMap();
    private static HashSet<com.tencent.mm.d.a> dad = new HashSet();
    public String dae;

    /* renamed from: com.tencent.mm.cache.ArtistCacheManager$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] dag = new int[com.tencent.mm.d.a.values().length];

        static {
            try {
                dag[com.tencent.mm.d.a.bBh.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dag[com.tencent.mm.d.a.bBj.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dag[com.tencent.mm.d.a.bBi.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                dag[com.tencent.mm.d.a.bBk.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    class a {
        public HashMap<com.tencent.mm.d.a, d> dah = new HashMap();

        public final void clearAll() {
            for (Entry value : this.dah.entrySet()) {
                ((d) value.getValue()).onDestroy();
            }
        }
    }

    public static ArtistCacheManager yn() {
        if (dab == null) {
            dab = new ArtistCacheManager();
        }
        return dab;
    }

    public final <T extends d> T a(com.tencent.mm.d.a aVar) {
        d dVar = null;
        if (dac.containsKey(this.dae)) {
            a aVar2 = (a) dac.get(this.dae);
            if (!aVar2.dah.containsKey(aVar)) {
                switch (AnonymousClass3.dag[aVar.ordinal()]) {
                    case 1:
                        dVar = new b();
                        break;
                    case 2:
                        dVar = new c();
                        break;
                    case 3:
                        dVar = new g();
                        break;
                    case 4:
                        dVar = new a();
                        break;
                }
                if (dVar != null) {
                    dVar.onCreate();
                }
                if (!(dVar == null || aVar2.dah.containsKey(aVar))) {
                    aVar2.dah.put(aVar, dVar);
                }
            }
            return (d) aVar2.dah.get(aVar);
        }
        x.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[]{this.dae});
        return null;
    }

    @Deprecated
    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear")) {
            x.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
            for (Entry value : dac.entrySet()) {
                ((a) value.getValue()).clearAll();
            }
            dad.clear();
            dab = null;
            e.cjw();
            e.post(new 2(this), "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
    }
}
