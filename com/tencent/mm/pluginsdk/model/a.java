package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class a extends r {
    private final a qyD;
    private final Intent qyE;
    private final v qyF = new v();

    /* renamed from: com.tencent.mm.pluginsdk.model.a$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] qyG = new int[a.values().length];

        static {
            try {
                qyG[a.qyH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                qyG[a.qyI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                qyG[a.qyJ.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                qyG[a.qyK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                qyG[a.qyL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public a(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.qyD = a.qyH;
        } else {
            a BB = a.BB(bundle.getInt("key_map_app", a.qyH.code));
            if (a(ad.getContext(), BB, null) == null) {
                this.qyD = a.qyH;
            } else {
                this.qyD = BB;
            }
        }
        if (this.qyD == a.qyH) {
            this.qyE = null;
        } else {
            this.qyE = (Intent) bundle.getParcelable("key_target_intent");
        }
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (bi.cX(queryIntentActivities)) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && aVar.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            }
        }
        return null;
    }

    public final boolean eM(Context context) {
        if (this.qyD == a.qyH) {
            return this.qyF.eM(context);
        }
        return a(context, this.qyD, this.qyE) != null;
    }

    public final boolean SK(String str) {
        return this.qyD.getPackage().equals(str);
    }

    public final String Vw() {
        return this.qyD == a.qyH ? "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client" : null;
    }

    public final String cbq() {
        return this.qyD == a.qyH ? "TencentMap.apk" : null;
    }

    public final com.tencent.mm.pluginsdk.model.s.a cbr() {
        if (this.qyD == a.qyH) {
            return this.qyF.cbr();
        }
        com.tencent.mm.pluginsdk.model.s.a aVar = new com.tencent.mm.pluginsdk.model.s.a();
        aVar.qzs = -1;
        aVar.qzp = -1;
        ResolveInfo a = a(ad.getContext(), this.qyD, this.qyE);
        if (a == null) {
            return aVar;
        }
        aVar.qzt = a(ad.getContext(), a);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        return this.qyF.a(context, resolveInfo);
    }
}
