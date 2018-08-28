package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class JsApiNavigateBackApplication extends a {
    private static final int CTRL_INDEX = 288;
    private static final String NAME = "navigateBackApplication";

    private static final class NavigateBackAppTask extends MainProcessTask {
        public static final Creator<NavigateBackAppTask> CREATOR = new 1();
        public String appId;
        public String data;

        public NavigateBackAppTask(String str, String str2) {
            this.appId = str;
            this.data = str2;
        }

        public final void aai() {
            f bl = g.bl(this.appId, true);
            if (bl != null) {
                Bundle bundle = new Bundle();
                Resp resp = new Resp(bundle);
                resp.extMsg = this.data;
                resp.openId = bl.field_openId;
                Args args = new Args();
                args.targetPkgName = bl.field_packageName;
                resp.toBundle(bundle);
                args.bundle = bundle;
                p.ae(bundle);
                p.af(bundle);
                MMessageActV2.send(ad.getContext(), args);
            }
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.data);
        }

        public final void g(Parcel parcel) {
            this.appId = parcel.readString();
            this.data = parcel.readString();
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandLaunchReferrer appBrandLaunchReferrer = lVar.fdO.fct.fqA;
        if (bi.oW(appBrandLaunchReferrer.appId) || appBrandLaunchReferrer.fqE != 4) {
            lVar.E(i, f("fail:not from opensdk", null));
            return;
        }
        String str;
        String optString = jSONObject.optString("extraData");
        String str2 = appBrandLaunchReferrer.appId;
        if (optString == null) {
            str = "{}";
        } else {
            str = optString.toString();
        }
        AppBrandMainProcessService.a(new NavigateBackAppTask(str2, str));
        lVar.E(i, f("ok", null));
    }
}
