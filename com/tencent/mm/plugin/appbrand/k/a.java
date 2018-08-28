package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.k.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLContext;

public final class a {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public int gkB;
    public String gkC = (e.dgj + "appbrand/");
    public SSLContext gkD;
    public final String gkE;
    protected final ArrayList<String> gkF = new ArrayList();
    public final ArrayList<b> gkG = new ArrayList();
    public String mAppId;

    public a(String str, String str2, AppBrandSysConfig appBrandSysConfig) {
        this.mAppId = str;
        this.gkB = appBrandSysConfig.fqV;
        this.gkD = i.uP(this.mAppId);
        this.gkE = str2;
    }

    private void uE(String str) {
        if (str != null) {
            synchronized (this.gkG) {
                Iterator it = this.gkG.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (str.equals(bVar.fEl)) {
                        this.gkG.remove(bVar);
                        break;
                    }
                }
            }
        }
    }

    public final b uF(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.gkG) {
            Iterator it = this.gkG.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (str.equals(bVar.fEl)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.gkF.add(bVar.fEl);
            uE(bVar.fEl);
            bVar.alC();
        }
    }

    public final boolean uG(String str) {
        return this.gkF.contains(str);
    }
}
