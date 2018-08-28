package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.util.List;

class hv$c implements MapLanguageChangeListener {
    final /* synthetic */ hv a;
    private List<MapRouteSectionWithName> b;
    private List<GeoPoint> c;

    public hv$c(hv hvVar) {
        this.a = hvVar;
        hvVar.a(this);
    }

    public void a() {
        this.a.b(this);
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        this.b = list;
        this.c = list2;
        hv.a(this.a).a(list, list2);
    }

    public void b() {
        hv.a(this.a).A();
        this.b = null;
        this.c = null;
    }

    public void onLanguageChange(MapLanguage mapLanguage) {
        if (mapLanguage != MapLanguage.LAN_CHINESE) {
            hv.a(this.a).A();
        } else if (this.b != null && this.c != null) {
            hv.a(this.a).a(this.b, this.c);
        }
    }
}
