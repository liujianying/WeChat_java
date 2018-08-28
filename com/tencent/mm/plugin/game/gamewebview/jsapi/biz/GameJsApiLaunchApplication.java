package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class GameJsApiLaunchApplication extends a {
    public static final int CTRL_BYTE = 260;
    public static final String NAME = "launchApplication";

    private static class LaunchApplicationTask extends GameProcessActivityTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new 3();
        public String appId;
        public Bundle bJx;
        public String extInfo;
        public Runnable fFC;
        public String fGe;
        public int showType;
        public boolean success;

        /* synthetic */ LaunchApplicationTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void a(Context context, GameProcessActivityTask.a aVar) {
            if (g.r(context, this.appId)) {
                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = this.extInfo;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823808;
                wXMediaMessage.messageExt = this.extInfo;
                ir irVar = new ir();
                irVar.bSe.bSg = wXMediaMessage;
                irVar.bSe.appId = this.appId;
                irVar.bSe.showType = this.showType;
                irVar.bSe.context = context;
                irVar.bSe.bJx = this.bJx;
                irVar.bSe.bSh = new 1(this, irVar, aVar);
                com.tencent.mm.sdk.b.a.sFg.m(irVar);
                if (!irVar.bSf.bSi) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.fGe));
                    x.i("MicroMsg.GameJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
                    intent.addFlags(268435456);
                    List B = bi.B(context, intent);
                    if (!(B == null || B.isEmpty())) {
                        Object b;
                        if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
                            b = g.b((ResolveInfo) B.get(0));
                        } else {
                            b = intent.getPackage();
                        }
                        if (!bi.oV(ad.getPackageName()).equals(b)) {
                            g.a(context, intent, null, new 2(this, aVar), this.bJx);
                            return;
                        }
                    }
                    this.success = false;
                    aVar.ahz();
                    return;
                }
                return;
            }
            x.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{this.appId});
            this.success = false;
            aVar.ahz();
        }

        public final void aaj() {
            if (this.fFC != null) {
                this.fFC.run();
            }
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.fGe = parcel.readString();
            this.extInfo = parcel.readString();
            this.bJx = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.fGe);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.bJx);
            parcel.writeByte((byte) (this.success ? 1 : 0));
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            g(parcel);
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiLaunchApplication", "data is null");
            dVar.E(i, a.f("launchApplication:fail", null));
            return;
        }
        GameWebViewUI pageActivity = dVar.getPageActivity();
        String optString = jSONObject.optString("appID");
        String optString2 = jSONObject.optString("schemeUrl");
        String optString3 = jSONObject.optString("parameter");
        int optInt = jSONObject.optInt("alertType");
        x.i("MicroMsg.GameJsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{optString, optString2, jSONObject.optString("extInfo"), optString3});
        if (bi.oW(optString) && bi.oW(optString2)) {
            x.e("MicroMsg.GameJsApiLaunchApplication", "appid and scheme is null or nil");
            dVar.E(i, a.f("launchApplication:fail", null));
            return;
        }
        Object cacheAppId = dVar.getCacheAppId();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("current_page_url", URLEncoder.encode(dVar.getCurrentURL(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        bundle.putString("current_page_appid", cacheAppId);
        if (!bi.oW(optString)) {
            a.a aVar = new a.a(dVar, i);
            b.a aVar2 = new b.a();
            aVar2.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
            aVar2.dIF = 1125;
            aog aog = new aog();
            aog.bPS = cacheAppId;
            aog.rQM = optString;
            aog.scene = dVar.getGetA8KeyScene();
            aog.url = dVar.getCurrentURL();
            aog.rQN = optString2;
            aog.hUp = optInt;
            aog.rQO = 0;
            x.i("MicroMsg.GameJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{cacheAppId, optString, Integer.valueOf(aog.scene), aog.url, aog.rQN, Integer.valueOf(aog.hUp)});
            aVar2.dIG = aog;
            aVar2.dIH = new aoh();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar2.KT(), new 2(this, aVar, optString2, pageActivity, bundle, optString, r8));
        } else if (TextUtils.isEmpty(cacheAppId)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
            intent.addFlags(268435456);
            List B = bi.B(pageActivity, intent);
            if (!(B == null || B.isEmpty())) {
                if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
                    cacheAppId = g.b((ResolveInfo) B.get(0));
                } else {
                    cacheAppId = intent.getPackage();
                }
                if (!bi.oV(ad.getPackageName()).equals(cacheAppId)) {
                    g.a(pageActivity, intent, null, new 1(this, dVar, i), bundle);
                    return;
                }
            }
            dVar.E(i, a.f("launchApplication:fail", null));
        } else {
            dVar.E(i, a.f("launchApplication:fail", null));
        }
    }
}
