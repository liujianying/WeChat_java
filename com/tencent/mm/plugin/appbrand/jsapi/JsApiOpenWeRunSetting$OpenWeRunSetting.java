package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class JsApiOpenWeRunSetting$OpenWeRunSetting extends MainProcessTask {
    public static final Creator<JsApiOpenWeRunSetting$OpenWeRunSetting> CREATOR = new 3();
    private boolean ccZ = false;
    private e fFF;
    private l fFa;
    private int fFd;
    private boolean fGw = false;
    private boolean fGx;

    public JsApiOpenWeRunSetting$OpenWeRunSetting(e eVar, l lVar, int i, boolean z) {
        x.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
        this.fGx = z;
    }

    public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        this.fGw = ((b) g.l(b.class)).ei(ad.getContext());
        if (!this.fGx || this.fGw) {
            ahP();
        } else {
            ((a) g.l(a.class)).a(new 1(this));
        }
    }

    private void ahP() {
        if (!this.fGx || this.fGw) {
            this.ccZ = ((b) g.l(b.class)).bFv();
            if (this.fGx && this.ccZ) {
                ((b) g.l(b.class)).bFu();
            }
        }
        a();
    }

    public final void aaj() {
        if (this.fGx && !this.fGw) {
            this.fFa.E(this.fFd, this.fFF.f("fail device not support", null));
            ahB();
        } else if (this.ccZ) {
            this.fFa.E(this.fFd, this.fFF.f("ok", null));
            ahB();
        } else {
            MMActivity c = e.c(this.fFa);
            if (c == null) {
                this.fFa.E(this.fFd, this.fFF.f("fail", null));
                ahB();
                return;
            }
            AppBrandSysConfig appBrandSysConfig = this.fFa.fdO.fcu;
            if (appBrandSysConfig == null || bi.oW(appBrandSysConfig.bKC)) {
                this.fFa.E(this.fFd, this.fFF.f("fail", null));
                ahB();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("OpenWeRunSettingName", appBrandSysConfig.bKC);
            c.geJ = new MMActivity.a() {
                public final void b(int i, int i2, Intent intent) {
                    if (i != (JsApiOpenWeRunSetting$OpenWeRunSetting.this.hashCode() & 65535)) {
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.ahB();
                    } else if (i2 == -1) {
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFa.E(JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFd, JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFF.f("ok", null));
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.ahB();
                    } else if (i2 == 0) {
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFa.E(JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFd, JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFF.f("cancel", null));
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.ahB();
                    } else {
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFa.E(JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFd, JsApiOpenWeRunSetting$OpenWeRunSetting.this.fFF.f("fail", null));
                        JsApiOpenWeRunSetting$OpenWeRunSetting.this.ahB();
                    }
                }
            };
            d.a(c, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", intent, hashCode() & 65535, false);
            ahB();
        }
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fGw = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.ccZ = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.fGx = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        if (this.fGw) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.ccZ) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.fGx) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }
}
