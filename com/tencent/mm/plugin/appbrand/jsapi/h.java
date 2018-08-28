package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends b {
    private int fFf;
    private g fdO;
    public String mData;

    public final h a(c cVar) {
        if (cVar != null) {
            this.fdO = cVar.getRuntime();
            this.fFf = cVar.hashCode();
        }
        return this;
    }

    public final h aC(String str, int i) {
        this.fdO = a.pY(str);
        this.fFf = i;
        return this;
    }

    public final h x(Map<String, Object> map) {
        c.m(map);
        this.mData = new JSONObject(map).toString();
        return this;
    }

    public final boolean b(c cVar) {
        if (com.tencent.mm.plugin.appbrand.permission.c.u(this.fdO).a(cVar, this, null).code == 1) {
            return true;
        }
        return false;
    }

    public final boolean ahM() {
        boolean z = true;
        if (this.fdO == null || this.fdO.fcy == null || !this.fdO.dti) {
            String str = "MicroMsg.AppBrandJsApiEvent";
            String str2 = "dispatchToService runtime null == %b, running state not valid, skip";
            Object[] objArr = new Object[1];
            if (this.fdO != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return false;
        }
        boolean z2;
        boolean z3;
        b bVar = null;
        if (this.fdO != null) {
            bVar = this.fdO.fcL;
            if (bVar != null) {
                z2 = true;
                if (com.tencent.mm.sdk.a.b.chp() || com.tencent.mm.sdk.a.b.chn()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z2 && !z3) {
                    return false;
                }
                if (bVar.fjj.fjt.get()) {
                    boolean z4 = bVar.fjj.acv() == com.tencent.mm.plugin.appbrand.b.a.fjg;
                    boolean b = b(this.fdO.fcy);
                    if (z4 || b) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (com.tencent.mm.compatible.loader.a.a(o.fFp, getClass())) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[]{Boolean.valueOf(z2), getName(), Integer.valueOf(ahI()), Boolean.valueOf(z4), Boolean.valueOf(b)});
                    }
                    if (!z2) {
                        return false;
                    }
                    this.fdO.fcy.j(getName(), this.mData, this.fFf);
                    return true;
                }
                x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService(%s), runtime stopped, just return", new Object[]{getName()});
                return false;
            }
        }
        z2 = false;
        if (com.tencent.mm.sdk.a.b.chp()) {
        }
        z3 = false;
        if (z2) {
        }
        if (bVar.fjj.fjt.get()) {
            boolean z42 = bVar.fjj.acv() == com.tencent.mm.plugin.appbrand.b.a.fjg;
            boolean b2 = b(this.fdO.fcy);
            if (z42 || b2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (com.tencent.mm.compatible.loader.a.a(o.fFp, getClass())) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[]{Boolean.valueOf(z2), getName(), Integer.valueOf(ahI()), Boolean.valueOf(z42), Boolean.valueOf(b2)});
            }
            if (!z2) {
                return false;
            }
            this.fdO.fcy.j(getName(), this.mData, this.fFf);
            return true;
        }
        x.i("MicroMsg.AppBrandJsApiEvent", "dispatchToService(%s), runtime stopped, just return", new Object[]{getName()});
        return false;
    }

    public final boolean h(int[] iArr) {
        boolean z = true;
        if (this.fdO == null || this.fdO.fcz == null || !this.fdO.dti) {
            String str = "MicroMsg.AppBrandJsApiEvent";
            String str2 = "dispatchToPage runtime null == %b, running state not valid, skip";
            Object[] objArr = new Object[1];
            if (this.fdO != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return false;
        }
        try {
            if (b(this.fdO.fcz.getCurrentPage().getCurrentPageView())) {
                this.fdO.fcz.c(getName(), this.mData, iArr);
                return true;
            }
            x.d("MicroMsg.AppBrandJsApiEvent", "event name = %s, ctrlIndex = %d, perm denied", new Object[]{getName(), Integer.valueOf(ahI())});
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandJsApiEvent", e, "", new Object[0]);
            return false;
        }
    }
}
