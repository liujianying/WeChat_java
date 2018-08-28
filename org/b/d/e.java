package org.b.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.g.c;

public final class e {
    public final List<d> vKv;

    public e() {
        this.vKv = new ArrayList();
    }

    public e(List<d> list) {
        this.vKv = new ArrayList(list);
    }

    public e(Map<String, String> map) {
        this();
        for (Entry entry : map.entrySet()) {
            this.vKv.add(new d((String) entry.getKey(), (String) entry.getValue()));
        }
    }

    public final String cKz() {
        if (this.vKv.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (d dVar : this.vKv) {
            stringBuilder.append('&').append(c.encode(dVar.aAL).concat("=").concat(c.encode(dVar.value)));
        }
        return stringBuilder.toString().substring(1);
    }

    public final void a(e eVar) {
        this.vKv.addAll(eVar.vKv);
    }

    public final void adU(String str) {
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.vKv.add(new d(c.decode(split2[0]), split2.length > 1 ? c.decode(split2[1]) : ""));
            }
        }
    }
}
