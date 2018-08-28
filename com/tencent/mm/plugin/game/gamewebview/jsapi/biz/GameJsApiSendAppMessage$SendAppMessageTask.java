package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class GameJsApiSendAppMessage$SendAppMessageTask extends GameProcessActivityTask {
    public static final Creator<GameJsApiSendAppMessage$SendAppMessageTask> CREATOR = new 2();
    String appId;
    String bZG;
    String cbP;
    String description;
    String extInfo;
    String fYU;
    String gsE;
    String jHt;
    String jHu;
    String jHv;
    Bundle jHw;
    int scene;
    String thumbUrl;
    String title;
    String toUser;
    String verifyAppId;

    /* synthetic */ GameJsApiSendAppMessage$SendAppMessageTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, a aVar) {
        switch (this.scene) {
            case 1:
                x.i("MicroMsg.GameJsApiSendAppMessage", "favoriteUrl");
                ch chVar = new ch();
                c.a aVar2 = new c.a();
                aVar2.url = this.jHu;
                aVar2.thumbUrl = this.thumbUrl;
                aVar2.title = this.title;
                aVar2.desc = this.description;
                aVar2.bPS = this.appId;
                if (this.jHw != null) {
                    String ic = u.ic(bi.oV(this.jHw.getString("KPublisherId")));
                    b v = u.Hx().v(ic, true);
                    v.p("sendAppMsgScene", Integer.valueOf(2));
                    v.p("preChatName", this.jHw.getString("preChatName"));
                    v.p("preMsgIndex", Integer.valueOf(this.jHw.getInt("preMsgIndex")));
                    v.p("prePublishId", this.jHw.getString("prePublishId"));
                    v.p("preUsername", this.jHw.getString("preUsername"));
                    v.p("getA8KeyScene", Integer.valueOf(this.jHw.getInt("getA8KeyScene")));
                    v.p("referUrl", this.jHw.getString("referUrl"));
                    if (!bi.oW(null)) {
                        v.p("adExtStr", null);
                    }
                    chVar.bJF.bJK = ic;
                }
                if (context != null && (context instanceof MMActivity)) {
                    chVar.bJF.activity = (Activity) context;
                    chVar.bJF.bJM = 36;
                    chVar.bJF.scene = 1;
                }
                chVar.bJF.bJO = new 1(this, aVar);
                c.a(chVar, aVar2);
                com.tencent.mm.sdk.b.a.sFg.m(chVar);
                return;
            default:
                x.i("MicroMsg.GameJsApiSendAppMessage", "sendToFriend");
                if (bi.oW(this.toUser)) {
                    x.e("MicroMsg.GameJsApiSendAppMessage", "toUser is null");
                    return;
                }
                o.Pe();
                Bitmap jz = com.tencent.mm.ak.c.jz(this.thumbUrl);
                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = this.jHu;
                wXWebpageObject.extInfo = this.extInfo;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXWebpageObject;
                wXMediaMessage.title = this.title;
                wXMediaMessage.description = this.description;
                if (!(jz == null || jz.isRecycled())) {
                    x.i("MicroMsg.GameJsApiSendAppMessage", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    jz.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                f bl = g.bl(this.appId, true);
                ot otVar = new ot();
                otVar.bZE.bSg = wXMediaMessage;
                otVar.bZE.appId = this.appId;
                otVar.bZE.appName = bl == null ? "" : bl.field_appName;
                otVar.bZE.toUser = this.toUser;
                otVar.bZE.bZF = 2;
                if (bi.oW(this.bZG)) {
                    otVar.bZE.bZI = null;
                } else {
                    otVar.bZE.bZG = this.bZG;
                    otVar.bZE.bZH = this.jHt;
                }
                otVar.bZE.bZJ = this.cbP;
                otVar.bZE.bZM = this.jHv;
                otVar.bZE.bJK = u.ic(this.jHv);
                otVar.bZE.bZK = this.gsE;
                otVar.bZE.bZL = this.verifyAppId;
                com.tencent.mm.sdk.b.a.sFg.m(otVar);
                if (!bi.oW(this.fYU)) {
                    ow owVar = new ow();
                    owVar.bZQ.bZR = this.toUser;
                    owVar.bZQ.content = this.fYU;
                    owVar.bZQ.type = s.hQ(this.toUser);
                    owVar.bZQ.flags = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(owVar);
                }
                aVar.ahz();
                return;
        }
    }

    public final void g(Parcel parcel) {
        this.scene = parcel.readInt();
        this.appId = parcel.readString();
        this.bZG = parcel.readString();
        this.jHt = parcel.readString();
        this.fYU = parcel.readString();
        this.toUser = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.jHu = parcel.readString();
        this.extInfo = parcel.readString();
        this.cbP = parcel.readString();
        this.gsE = parcel.readString();
        this.verifyAppId = parcel.readString();
        this.jHv = parcel.readString();
        this.jHw = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.scene);
        parcel.writeString(this.appId);
        parcel.writeString(this.bZG);
        parcel.writeString(this.jHt);
        parcel.writeString(this.fYU);
        parcel.writeString(this.toUser);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.jHu);
        parcel.writeString(this.cbP);
        parcel.writeString(this.gsE);
        parcel.writeString(this.verifyAppId);
        parcel.writeString(this.jHv);
        parcel.writeString(this.extInfo);
        parcel.writeBundle(this.jHw);
    }

    public GameJsApiSendAppMessage$SendAppMessageTask(Context context) {
        super(context);
    }

    private GameJsApiSendAppMessage$SendAppMessageTask(Parcel parcel) {
        g(parcel);
    }
}
