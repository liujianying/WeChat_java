package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import java.util.Map;

public class a$a {
    public String dBm;
    public boolean hoW;
    public boolean jbI;
    public Map<Long, g> jbJ;
    public boolean jbQ;
    public c jeo;
    public long lastUpdateTime;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append(10);
        stringBuilder.append("isSearching:").append(this.hoW).append(10);
        stringBuilder.append("search str:").append(this.dBm).append(10);
        return stringBuilder.toString();
    }
}
