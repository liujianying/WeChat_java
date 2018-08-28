package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
    public static final Creator<JsApiLaunchApplication$LaunchApplicationTask> CREATOR = new 2();
    public String appId;
    public Bundle bJx;
    public String extInfo;
    public Runnable fFC;
    public String fGe;
    public int showType;
    public boolean success;

    /* synthetic */ JsApiLaunchApplication$LaunchApplicationTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, a aVar) {
        boolean a;
        JsApiLaunchApplication$a jsApiLaunchApplication$a = new JsApiLaunchApplication$a(new 1(this, aVar));
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
        irVar.bSe.bSh = jsApiLaunchApplication$a;
        com.tencent.mm.sdk.b.a.sFg.m(irVar);
        boolean z = irVar.bSf.bSi;
        if (!z) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.fGe));
            x.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
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
                    jsApiLaunchApplication$a.dJP = false;
                    jsApiLaunchApplication$a.fGh = false;
                    jsApiLaunchApplication$a.fGi = false;
                    jsApiLaunchApplication$a.bSi = false;
                    a = g.a(context, intent, null, jsApiLaunchApplication$a, this.bJx);
                    jsApiLaunchApplication$a.cJ(a);
                }
            }
        }
        a = z;
        jsApiLaunchApplication$a.cJ(a);
    }

    public final void aaj() {
        x.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
        if (this.fFC != null) {
            x.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
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

    public JsApiLaunchApplication$LaunchApplicationTask(MMActivity mMActivity) {
        super(mMActivity);
    }

    private JsApiLaunchApplication$LaunchApplicationTask(Parcel parcel) {
        g(parcel);
    }
}
