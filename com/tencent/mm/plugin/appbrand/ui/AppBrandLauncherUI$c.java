package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.r.k.a;
import java.util.List;

public abstract class AppBrandLauncherUI$c<T> extends a {
    public final List<T> guO;
    public final List<T> guP;

    public AppBrandLauncherUI$c(List<T> list, List<T> list2) {
        this.guO = list;
        this.guP = list2;
    }

    public final int anr() {
        return this.guO == null ? 0 : this.guO.size();
    }

    public final int ans() {
        return this.guP == null ? 0 : this.guP.size();
    }
}
