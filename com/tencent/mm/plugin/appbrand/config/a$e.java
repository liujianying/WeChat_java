package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.q.l;
import java.util.ArrayList;
import java.util.Iterator;

public class a$e {
    public ArrayList<f> bUX = new ArrayList();
    public String dxh;
    public String fpa;
    public String fpb;
    public String fpc;
    public String fpd;

    public final boolean rH(String str) {
        Iterator it = this.bUX.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).url.equals(l.vP(str))) {
                return true;
            }
        }
        return false;
    }
}
