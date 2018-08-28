package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public enum i implements e {
    ;
    
    private ProgressDialog eHw;
    private boolean ivo;
    public a ivp;

    private i(String str) {
        this.ivo = false;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        if (sharedPreferences.getLong(stringBuilder.append(c.Df()).toString(), 0) != 0) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[]{Long.valueOf(sharedPreferences.getLong(stringBuilder.append(c.Df()).toString(), 0))});
            return;
        }
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    }

    public final void a(Context context, a aVar) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.ivo) {
            if (this.ivp == null) {
                this.ivp = aVar;
            }
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            return;
        }
        o oVar = new o();
        if (!(context == null || !(context instanceof Activity) || ((Activity) context).isFinishing())) {
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
            }
            context.getString(R.l.app_tip);
            this.eHw = h.b(context, context.getString(R.l.scan_loading_tip), new 1(this, oVar, aVar));
        }
        this.ivp = aVar;
        au.DF().a(oVar, 0);
    }

    public final boolean ex(boolean z) {
        if (this.ivo) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        long j = sharedPreferences.getLong(stringBuilder.append(c.Df()).toString(), 0);
        if (z || currentTimeMillis - j >= 86400000) {
            return true;
        }
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        return false;
    }

    public static void cH(long j) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[]{Long.valueOf(j)});
        Editor edit = ad.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        edit.putLong(stringBuilder.append(c.Df()).toString(), j).commit();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        this.ivo = false;
        if (lVar != null && i2 == 0 && i == 0) {
            x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            if (lVar.getType() == 539) {
                if (i == 0 && i2 == 0) {
                    o oVar = (o) lVar;
                    aba aba = (oVar.diG == null || oVar.diG.dIE.dIL == null) ? null : (aba) oVar.diG.dIE.dIL;
                    if (aba == null || aba.rGg == null) {
                        if (this.ivp != null) {
                            this.ivp.ew(false);
                        }
                        if (this.eHw != null && this.eHw.isShowing()) {
                            this.eHw.dismiss();
                            return;
                        }
                        return;
                    }
                    au.Em().H(new 2(this, aba));
                    if (this.ivp != null) {
                        this.ivp.ew(true);
                    }
                } else {
                    x.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                    if (this.ivp != null) {
                        this.ivp.ew(false);
                    }
                    if (this.eHw != null && this.eHw.isShowing()) {
                        this.eHw.dismiss();
                        return;
                    }
                    return;
                }
            }
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
                return;
            }
            return;
        }
        x.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }
}
