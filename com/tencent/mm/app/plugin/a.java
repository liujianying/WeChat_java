package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.VoipAddressUI;
import java.util.Iterator;

public final class a implements p {
    public final boolean a(Context context, String str, boolean z) {
        return a(context, str, z, null);
    }

    public final boolean a(Context context, String str, boolean z, s sVar) {
        if (context == null) {
            x.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            return false;
        } else if (str.startsWith("http")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", new Object[]{e.getMessage()});
            }
            return true;
        } else if (b(context, str, z, sVar)) {
            return false;
        } else {
            x.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", new Object[]{str});
            return false;
        }
    }

    public final boolean a(Context context, String str, boolean z, Bundle bundle) {
        return a(context, str, z, null, bundle);
    }

    public final boolean b(Context context, String str, boolean z, s sVar) {
        return a(context, str, z, sVar, null);
    }

    private boolean a(Context context, String str, boolean z, s sVar, Bundle bundle) {
        if (context == null) {
            x.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            return false;
        } else if (str == null) {
            x.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            return c(context, str, new Object[0]);
        } else {
            d vA = d.vA();
            String str2 = "MicroMsg.URISpanHandler";
            String str3 = "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(sVar == null);
            objArr[3] = Integer.valueOf(vA.bAq.size());
            objArr[4] = Integer.valueOf(vA.bAr.size());
            objArr[5] = Integer.valueOf(vA.bAs.size());
            x.d(str2, str3, objArr);
            if (context == null) {
                x.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
                vA.bAp.mContext = null;
                return false;
            }
            vA.mContext = context;
            vA.bAp.mContext = vA.mContext;
            if (bi.oW(str)) {
                x.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
                vA.mContext = null;
                vA.bAp.mContext = null;
                return false;
            }
            Iterator it = vA.bAq.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, sVar, bundle)) {
                    x.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[]{((BaseUriSpanHandler) it.next()).getClass().getName()});
                    vA.mContext = null;
                    vA.bAp.mContext = null;
                    return true;
                }
            }
            it = vA.bAr.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, sVar, bundle)) {
                    x.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[]{((BaseUriSpanHandler) it.next()).getClass().getName()});
                    vA.mContext = null;
                    vA.bAp.mContext = null;
                    return true;
                }
            }
            it = vA.bAs.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, sVar, bundle)) {
                    x.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[]{((BaseUriSpanHandler) it.next()).getClass().getName()});
                    vA.mContext = null;
                    vA.bAp.mContext = null;
                    return true;
                }
            }
            vA.mContext = null;
            vA.bAp.mContext = null;
            x.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
            return false;
        }
    }

    public final boolean c(Context context, String str, Object... objArr) {
        if (str == null) {
            x.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            return false;
        } else if (context == null) {
            x.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            String replace = str.replace("weixin://openSpecificView/", "");
            Bundle bundle = null;
            if (objArr != null && objArr.length > 0) {
                bundle = (Bundle) objArr[0];
            }
            String string;
            if (replace.equalsIgnoreCase("contacts")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 2);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("newfriend")) {
                d.b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                d.b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                d.b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("timeline")) {
                d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                d.b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                d.b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.D(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase("privacy")) {
                d.b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                d.b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.gR(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString("url");
                } else {
                    string = replace;
                }
                intent.putExtra("k_expose_url", string);
                intent.putExtra("k_username", q.GF());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)}));
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (replace.equalsIgnoreCase("shakecard")) {
                replace = "";
                if (bundle != null) {
                    string = bundle.getString("extinfo");
                } else {
                    string = replace;
                }
                intent.putExtra("key_shake_card_from_scene", 3);
                intent.putExtra("shake_card", true);
                intent.putExtra("key_shake_card_ext_info", string);
                d.b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                x.i("MicroMsg.MMURIJumpHandler", "enter to cardhome");
                d.b(context, "card", ".ui.CardHomePageUI", intent);
            } else if (!replace.equalsIgnoreCase("uploadlog")) {
                return false;
            } else {
                int i;
                String str2;
                String str3;
                Object[] objArr2;
                boolean z;
                Intent intent3;
                replace = q.GF();
                if (bi.oW(replace)) {
                    replace = "weixin";
                }
                if (bundle != null) {
                    try {
                        i = bi.getInt(bundle.getString("extinfo"), 0);
                    } catch (Exception e) {
                    }
                    str2 = "MicroMsg.MMURIJumpHandler";
                    str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                    objArr2 = new Object[2];
                    z = au.HX() && !au.Dr();
                    objArr2[0] = Boolean.valueOf(z);
                    objArr2[1] = Integer.valueOf(i);
                    x.i(str2, str3, objArr2);
                    intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                    intent3.putExtra("key_user", replace);
                    intent3.putExtra("key_time", i);
                    context.startActivity(intent3);
                }
                i = 0;
                str2 = "MicroMsg.MMURIJumpHandler";
                str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                objArr2 = new Object[2];
                if (!au.HX()) {
                }
                objArr2[0] = Boolean.valueOf(z);
                objArr2[1] = Integer.valueOf(i);
                x.i(str2, str3, objArr2);
                intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent3.putExtra("key_user", replace);
                intent3.putExtra("key_time", i);
                context.startActivity(intent3);
            }
            return true;
        }
    }
}
