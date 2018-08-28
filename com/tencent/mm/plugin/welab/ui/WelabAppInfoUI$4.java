package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class WelabAppInfoUI$4 implements OnClickListener {
    final /* synthetic */ WelabAppInfoUI qng;

    WelabAppInfoUI$4(WelabAppInfoUI welabAppInfoUI) {
        this.qng = welabAppInfoUI;
    }

    public final void onClick(View view) {
        try {
            String str = "";
            g.Eg();
            int Df = a.Df();
            String encode = URLEncoder.encode(d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(bi.ciX(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(q.zy(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.qVH, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.qVI, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.qVJ, ProtocolPackage.ServerEncoding);
            g.Eg();
            String str2 = ("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(WelabAppInfoUI.a(this.qng).field_expId + "|" + WelabAppInfoUI.b(this.qng)) + "&version=" + d.qVN + "&lang=" + w.fD(ad.getContext()) + "&" + bi.oV(str) + ("&uin=" + Df + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + URLEncoder.encode(a.DA(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bi.fT(ad.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bi.oW(str) ? 0 : 1))) + "#/comment/4134";
            Intent intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", str2);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, "意见反馈");
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
            com.tencent.mm.bg.d.b(this.qng, "webview", ".ui.tools.WebViewUI", intent);
        } catch (UnsupportedEncodingException e) {
            x.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
        }
    }
}
