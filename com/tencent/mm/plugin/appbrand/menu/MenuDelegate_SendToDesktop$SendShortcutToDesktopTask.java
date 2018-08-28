package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class MenuDelegate_SendToDesktop$SendShortcutToDesktopTask extends MainProcessTask {
    public static final Creator<MenuDelegate_SendToDesktop$SendShortcutToDesktopTask> CREATOR = new 2();
    private int bPh;
    private boolean gjq;
    private String mAppId;
    private Context mContext;
    private String username;

    public MenuDelegate_SendToDesktop$SendShortcutToDesktopTask(Context context, String str, String str2, int i) {
        this.mContext = context;
        this.username = str;
        this.mAppId = str2;
        this.bPh = i;
    }

    public MenuDelegate_SendToDesktop$SendShortcutToDesktopTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        Context context = ad.getContext();
        String str = this.username;
        int i = this.bPh;
        if (context == null || str == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
        } else {
            bs bsVar = new bs();
            bsVar.bJc.username = str;
            a.sFg.m(bsVar);
            if (bsVar.bJd.bJe == null) {
                x.e("MicroMsg.AppBrandShortcutManager", "no such user");
            } else {
                Intent a = m.a(context, bsVar, i, m.a(context, m.a(bsVar), i), false);
                if (a == null) {
                    x.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                } else {
                    b.p(context, a);
                    x.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[]{str});
                }
            }
        }
        ah.i(new 1(this, context), 1000);
    }

    public final void aaj() {
        if (this.mContext != null && this.gjq) {
            AppBrandSysConfig qa = com.tencent.mm.plugin.appbrand.a.qa(this.mAppId);
            if (qa != null) {
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(this.mContext, "pref_appbrand_" + qa.uin, 4);
                if (!sharedPreferences.contains("has_show_send_to_desktop_tips")) {
                    if (com.tencent.mm.plugin.appbrand.a.pY(this.mAppId) != null) {
                        Context context = this.mContext;
                        h.b(context, context.getString(j.app_brand_first_time_send_to_desktop_tips), context.getString(j.app_tip), false);
                    }
                    sharedPreferences.edit().putBoolean("has_show_send_to_desktop_tips", true).commit();
                }
            }
        }
    }

    public final void g(Parcel parcel) {
        this.username = parcel.readString();
        this.bPh = parcel.readInt();
        this.gjq = parcel.readInt() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.bPh);
        parcel.writeInt(this.gjq ? 1 : 0);
    }
}
