package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class hv$b {
    final /* synthetic */ hv a;
    private List<MapLanguageChangeListener> b = new CopyOnWriteArrayList();

    public hv$b(hv hvVar) {
        this.a = hvVar;
    }

    public MapLanguage a() {
        if (hv.a(this.a) == null) {
            return MapLanguage.LAN_CHINESE;
        }
        if (hv.a(this.a).B() == 1) {
            return MapLanguage.LAN_ENGLISH;
        }
        return MapLanguage.LAN_CHINESE;
    }

    public void a(MapLanguageChangeListener mapLanguageChangeListener) {
        if (mapLanguageChangeListener != null) {
            synchronized (this.b) {
                if (!this.b.contains(mapLanguageChangeListener)) {
                    this.b.add(mapLanguageChangeListener);
                }
            }
        }
    }

    public void b(MapLanguageChangeListener mapLanguageChangeListener) {
        if (mapLanguageChangeListener != null) {
            synchronized (this.b) {
                if (this.b.contains(mapLanguageChangeListener)) {
                    this.b.remove(mapLanguageChangeListener);
                }
            }
        }
    }
}
