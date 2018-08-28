package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class j implements a {
    WeakReference<Context> YC;
    com.tencent.mm.modelgeo.c dMm = null;
    com.tencent.mm.modelgeo.b kHU = null;
    int pSW;
    boolean qkm = false;
    int qkn;
    e qko;
    e qkp;
    String qkq;
    d qkr;
    com.tencent.mm.modelgeo.b.a qks = null;
    com.tencent.mm.modelgeo.b.a qkt = null;
    com.tencent.mm.modelgeo.a.a qku = null;
    final Runnable qkv = new 1(this);

    private static final class b extends f {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.qyL.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.qyL.getPackage();
        }
    }

    private static final class c extends f {
        private c() {
            super((byte) 0);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.qyI.getPackage();
        }
    }

    interface d {
        void Bf(int i);

        void Bg(int i);

        void pT(int i);

        void uX(int i);
    }

    private static final class e {
        double latitude;
        double longitude;
        String qky;

        /* synthetic */ e(double d, double d2, byte b) {
            this(d, d2);
        }

        private e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            this.qky = null;
        }
    }

    public final void b(int i, int i2, Intent intent) {
        Context context = (Context) this.YC.get();
        if (!(this.qkr == null || context == null)) {
            if (!this.qkm) {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[]{Integer.valueOf(i)});
                this.qkr.pT(this.pSW);
            } else if (i2 == 4097 || i2 == 0) {
                this.qkr.Bf(this.pSW);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (bi.oW(stringExtra)) {
                    x.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.qkr.pT(this.pSW);
                } else {
                    f cVar = com.tencent.mm.pluginsdk.model.a.a.qyI.getPackage().equals(stringExtra) ? new c() : com.tencent.mm.pluginsdk.model.a.a.qyK.getPackage().equals(stringExtra) ? new a((byte) 0) : com.tencent.mm.pluginsdk.model.a.a.qyJ.getPackage().equals(stringExtra) ? new g((byte) 0) : com.tencent.mm.pluginsdk.model.a.a.qyL.getPackage().equals(stringExtra) ? new b() : new h((byte) 0);
                    cVar.a(context, this.qko, this.qkp, this.qkq);
                    this.qkr.uX(this.pSW);
                }
            } else {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[]{Integer.valueOf(i2)});
                this.qkr.pT(this.pSW);
            }
        }
        if (this.qkm && this.qkr != null) {
            this.qkr.Bg(this.pSW);
        }
        this.qkm = false;
        this.qkn = com.tencent.mm.pluginsdk.model.a.a.qyH.code;
        this.qko = null;
        this.qkp = null;
        this.YC = null;
        this.qkr = null;
        this.qkq = null;
        this.qks = null;
        this.qkt = null;
        if (!(this.dMm == null || this.qku == null)) {
            this.dMm.c(this.qku);
        }
        this.dMm = null;
        this.qku = null;
        if (this.kHU != null) {
            if (this.qks != null) {
                this.kHU.a(this.qks);
            }
            if (this.qkt != null) {
                this.kHU.a(this.qkt);
            }
        }
        this.kHU = null;
        this.qks = null;
        this.qkt = null;
    }

    j() {
    }

    final void bYu() {
        Context context = null;
        this.qku = null;
        this.qks = null;
        this.qkt = null;
        if (this.YC != null) {
            context = (Context) this.YC.get();
        }
        if (context != null) {
            Intent intent = new Intent(context, AppChooserUI.class);
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.qyH.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.qyI.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.qyJ.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.qyK.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.qyL.getPackage());
            intent.putStringArrayListExtra("targetwhitelist", arrayList);
            Parcelable intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.qkp.latitude), Double.valueOf(this.qkp.longitude)})));
            intent.putExtra("targetintent", intent2);
            Bundle bundle = new Bundle(2);
            bundle.putInt("key_map_app", this.qkn);
            bundle.putParcelable("key_target_intent", intent2);
            intent.putExtra("key_recommend_params", bundle);
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 2);
            intent.putExtra("title", context.getString(R.l.location_info_send_tip));
            ((MMActivity) context).b(this, intent, 33);
        }
    }
}
