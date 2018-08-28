package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;

final class AppBrandLaunchErrorAction$a implements Creator<AppBrandLaunchErrorAction> {
    AppBrandLaunchErrorAction$a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AppBrandLaunchErrorAction[i];
    }

    private static AppBrandLaunchErrorAction j(Parcel parcel) {
        String readString = parcel.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(new Class[]{Parcel.class}).newInstance(new Object[]{parcel});
        } catch (Exception e) {
            return null;
        }
    }

    static AppBrandLaunchErrorAction a(String str, int i, t tVar) {
        AppBrandLaunchErrorAction appBrandLaunchErrorAction = null;
        if (!(tVar == null || tVar.field_launchAction == null)) {
            switch (tVar.field_launchAction.qZk) {
                case 2:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", tVar.field_launchAction.rSK);
                    intent.putExtra("forceHideShare", true);
                    appBrandLaunchErrorAction = new AppBrandLaunchErrorActionStartActivity(str, i, "webview", ".ui.tools.WebViewUI", intent);
                    break;
                case 3:
                    appBrandLaunchErrorAction = new AppBrandLaunchErrorActionAlert(str, i, tVar.field_launchAction.rMD, tVar.field_launchAction.rSM);
                    break;
            }
            if (appBrandLaunchErrorAction != null) {
                b.anX();
            }
        }
        return appBrandLaunchErrorAction;
    }
}
