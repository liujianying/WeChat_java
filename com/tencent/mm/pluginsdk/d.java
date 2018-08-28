package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.model.y;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    public static String qya = "";
    private static final Map<String, Long> qyb;

    public interface a {
        void a(int i, int i2, String str, l lVar, boolean z);
    }

    static {
        Map hashMap = new HashMap();
        qyb = hashMap;
        hashMap.put("weixin://", Long.valueOf(0));
        qyb.put("weixin://dl/stickers", Long.valueOf(1));
        qyb.put("weixin://dl/games", Long.valueOf(2));
        qyb.put("weixin://dl/moments", Long.valueOf(4));
        qyb.put("weixin://dl/add", Long.valueOf(8));
        qyb.put("weixin://dl/shopping", Long.valueOf(16));
        qyb.put("weixin://dl/groupchat", Long.valueOf(32));
        qyb.put("weixin://dl/scan", Long.valueOf(64));
        qyb.put("weixin://dl/profile", Long.valueOf(128));
        qyb.put("weixin://dl/settings", Long.valueOf(256));
        qyb.put("weixin://dl/general", Long.valueOf(512));
        qyb.put("weixin://dl/help", Long.valueOf(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS));
        qyb.put("weixin://dl/notifications", Long.valueOf(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLSX));
        qyb.put("weixin://dl/terms", Long.valueOf(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_PDF));
        qyb.put("weixin://dl/chat", Long.valueOf(8192));
        qyb.put("weixin://dl/features", Long.valueOf(16384));
        qyb.put("weixin://dl/clear", Long.valueOf(32768));
        qyb.put("weixin://dl/feedback", Long.valueOf(65536));
        qyb.put("weixin://dl/faq", Long.valueOf(131072));
        qyb.put("weixin://dl/recommendation", Long.valueOf(262144));
        qyb.put("weixin://dl/groups", Long.valueOf(524288));
        qyb.put("weixin://dl/tags", Long.valueOf(1048576));
        qyb.put("weixin://dl/officialaccounts", Long.valueOf(2097152));
        qyb.put("weixin://dl/posts", Long.valueOf(4194304));
        qyb.put("weixin://dl/favorites", Long.valueOf(8388608));
        qyb.put("weixin://dl/privacy", Long.valueOf(16777216));
        qyb.put("weixin://dl/security", Long.valueOf(33554432));
        qyb.put("weixin://dl/wallet", Long.valueOf(67108864));
        qyb.put("weixin://dl/businessPay", Long.valueOf(134217728));
        qyb.put("weixin://dl/businessPay/", Long.valueOf(134217728));
        qyb.put("weixin://dl/wechatout", Long.valueOf(268435456));
        qyb.put("weixin://dl/protection", Long.valueOf(1073741824));
        qyb.put("weixin://dl/card", Long.valueOf(2147483648L));
        qyb.put("weixin://dl/about", Long.valueOf(1125899906842624L));
        qyb.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
        qyb.put("weixin://dl/textsize", Long.valueOf(8589934592L));
        qyb.put("weixin://dl/sight", Long.valueOf(17179869184L));
        qyb.put("weixin://dl/languages", Long.valueOf(34359738368L));
        qyb.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
        qyb.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
        qyb.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
        qyb.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
        qyb.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
        qyb.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
        qyb.put("weixin://dl/setname", Long.valueOf(4398046511104L));
        qyb.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
        qyb.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
        qyb.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
        qyb.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
        qyb.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
        qyb.put("weixin://dl/log", Long.valueOf(281474976710656L));
        qyb.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
        qyb.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
        qyb.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
        qyb.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
        qyb.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
        qyb.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
        qyb.put("weixin://dl/offlinepay/", Long.valueOf(576460752303423490L));
    }

    public static boolean al(String str, long j) {
        if (!bi.oW(str)) {
            long longValue;
            String SE = SE(str);
            if (qyb.containsKey(SE)) {
                longValue = ((Long) qyb.get(SE)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                return true;
            }
        }
        return false;
    }

    public static boolean SA(String str) {
        String SE = SE(str);
        return qyb.containsKey(SE) || SB(SE);
    }

    public static boolean SB(String str) {
        return !bi.oW(str) && str.startsWith("weixin://dl/business");
    }

    public static boolean k(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (bi.oW(uri.getQueryParameter("ticket"))) {
            return l(uri);
        }
        return true;
    }

    public static boolean l(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            return true;
        }
        return false;
    }

    private static boolean SC(String str) {
        if ((!str.equals("weixin://dl/wechatout") && !str.equals("weixin://dl/wechatoutcoupon") && !str.equals("weixin://dl/wechatoutshare")) || Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.aWV()).booleanValue()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        ad.getContext().startActivity(intent);
        return true;
    }

    public static void a(Context context, String str, String str2, int i, String str3, a aVar) {
        String str4 = bi.oW(str) ? str3 : str;
        if (!SC(str4)) {
            h hVar = new h(str4, str2, i, (int) System.currentTimeMillis(), new byte[0]);
            au.DF().a(233, new 1(context, i, str2, str4, aVar));
            au.DF().a(hVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar, String str2, String str3) {
        a(context, str, i, null, aVar, str2, str3);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar, String str2, String str3) {
        LinkedList linkedList = new LinkedList();
        cp cpVar = new cp();
        if (!(bi.oW(str2) || bi.oW(str3))) {
            x.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", new Object[]{str2, str3});
            cpVar.rcN = str2;
            cpVar.signature = str3;
            linkedList.add(cpVar);
        }
        if (!SC(str)) {
            aa aaVar = new aa(str, i, linkedList);
            au.DF().a(1200, new 2(bundle, context, i, str, aVar));
            au.DF().a(aaVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar) {
        a(context, str, i, null, aVar, null, null);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar) {
        a(context, str, i, bundle, aVar, null, null);
    }

    public static boolean SD(String str) {
        return a(null, str, 0, null, (int) System.currentTimeMillis(), new byte[0], null);
    }

    public static boolean a(Context context, int i, byte[] bArr, String str) {
        return a(context, str, 0, null, i, bArr, null);
    }

    public static boolean a(Context context, String str, int i, Bundle bundle, String str2) {
        return a(context, str, i, bundle, (int) System.currentTimeMillis(), new byte[0], str2);
    }

    private static boolean a(Context context, String str, int i, Bundle bundle, int i2, byte[] bArr, String str2) {
        String SE = SE(str);
        if (bi.oW(SE)) {
            return false;
        }
        String substring;
        String encode;
        String encode2;
        Uri parse;
        String queryParameter;
        int i3;
        Intent intent;
        int i4;
        if (qyb.containsKey(SE)) {
            long longValue = ((Long) qyb.get(SE)).longValue();
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", new Object[]{Long.valueOf(longValue)});
            SE = null;
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            String str3;
            int Df;
            String encode3;
            String encode4;
            int f;
            if (longValue == 0) {
                SE = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                SE = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                com.tencent.mm.plugin.report.service.h.mEJ.h(12065, new Object[]{Integer.valueOf(7)});
            } else if (longValue == 2) {
                intent2.putExtra("from_deeplink", true);
                intent2.putExtra("game_report_from_scene", 6);
                SE = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((q.GQ() & 32768) == 0 ? 1 : null) != null) {
                    SE = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                    intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                SE = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                hn hnVar = new hn();
                com.tencent.mm.sdk.b.a.sFg.m(hnVar);
                str3 = hnVar.bQT.url;
                if (!bi.oW(str3)) {
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    SE = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent2.putExtra("titile", ad.getContext().getString(R.l.address_title_launch_chatting));
                intent2.putExtra("list_type", 0);
                intent2.putExtra("list_attr", s.s(new int[]{s.ukG, GLIcon.TOP, 512}));
                SE = "com.tencent.mm.ui.contact.SelectContactUI";
            } else if (longValue == 64) {
                SE = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
                intent2.putExtra("animation_pop_in", true);
            } else if (longValue == 128) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            } else if (longValue == 256) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            } else if (longValue == 512) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                S(ad.getContext(), i2);
            } else if (longValue == ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLSX) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
                intent2.putExtra("title", ad.getContext().getResources().getString(R.l.privacy_tip));
                intent2.putExtra("rawUrl", ad.getContext().getResources().getString(R.l.url_agreement));
                intent2.putExtra("showShare", false);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                SE = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 8192) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            } else if (longValue == 16384) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            } else if (longValue == 32768) {
                SE = "com.tencent.mm.plugin.clean.ui.CleanUI";
            } else if (longValue == 65536) {
                try {
                    str3 = "";
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        substring = str.substring(indexOf + 1);
                    } else {
                        substring = str3;
                    }
                    g.Eg();
                    Df = com.tencent.mm.kernel.a.Df();
                    encode = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf-8");
                    encode2 = URLEncoder.encode(bi.ciX(), "utf-8");
                    encode3 = URLEncoder.encode(com.tencent.mm.compatible.e.q.zy(), "utf-8");
                    String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.qVH, "utf-8");
                    encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.qVI, "utf-8");
                    str3 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.qVN + "&lang=" + w.fD(ad.getContext()) + "&" + bi.oV(substring) + ("&uin=" + Df + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode5 + "&deviceModel=" + encode4 + "&ostype=" + URLEncoder.encode(com.tencent.mm.protocal.d.qVJ, "utf-8") + "&clientSeqID=" + URLEncoder.encode(au.DA(), "utf-8") + "&signature=" + URLEncoder.encode(bi.fT(ad.getContext()), "utf-8") + "&scene=" + (bi.oW(substring) ? 0 : 1));
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("neverGetA8Key", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                    intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                    SE = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e) {
                    x.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
                }
            } else if (longValue == 131072) {
                g.Eg();
                Df = com.tencent.mm.kernel.a.Df();
                au.HU();
                f = bi.f((Integer) c.DT().get(12304, null));
                SE = ad.getContext().getString(R.l.settings_system_notice_url, new Object[]{Integer.valueOf(Df), Integer.valueOf(f)});
                intent2.putExtra("showShare", false);
                intent2.putExtra("rawUrl", SE);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                SE = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 262144) {
                SE = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == 524288) {
                SE = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                SE = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                SE = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bg.d.b(ad.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                return true;
            } else if (longValue == 4194304) {
                au.HU();
                intent2.putExtra("sns_userName", (String) c.DT().get(2, null));
                intent2.addFlags(67108864);
                au.HU();
                f = bi.a((Integer) c.DT().get(68389, null), 0);
                au.HU();
                c.DT().set(68389, Integer.valueOf(f + 1));
                SE = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
            } else if (longValue == 8388608) {
                SE = "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI";
            } else if (longValue == 16777216) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
            } else if (longValue == 33554432) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
            } else if (longValue == 67108864) {
                SE = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
            } else if (longValue == 134217728) {
                if (!(context == null || bi.oW(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            str3 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (bi.oW(str3)) {
                                x.w("MicroMsg.DeepLinkHelper", "reqkey null");
                            } else {
                                PayInfo payInfo = new PayInfo();
                                payInfo.bOd = str3;
                                payInfo.appId = queryParameter;
                                payInfo.bVY = 36;
                                payInfo.jNf = false;
                                intent2 = new Intent();
                                intent2.putExtra("key_pay_info", payInfo);
                                if (q.GS()) {
                                    com.tencent.mm.bg.d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent2, 1);
                                } else {
                                    com.tencent.mm.bg.d.b(context, "wallet", ".pay.ui.WalletPayUI", intent2, 1);
                                }
                            }
                        } else {
                            x.w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent2 = null;
            } else if (longValue == 1073741824) {
                SE = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                x.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
                SE = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (longValue == 4294967296L) {
                intent2.putExtra("filter_type", y.if(ad.getContext().getString(R.l.group_blacklist)).getType());
                intent2.putExtra("titile", ad.getContext().getString(R.l.settings_private_blacklist));
                intent2.putExtra("list_attr", 32768);
                SE = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
            } else if (longValue == 8589934592L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
            } else if (longValue == 17179869184L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 34359738368L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
            } else if (longValue == 68719476736L) {
                SE = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
            } else if (longValue == 137438953472L) {
                intent2.setClassName(ad.getContext(), "com.tencent.mm.ui.bindqq.BindQQUI");
                MMWizardActivity.D(context, intent2);
                return true;
            } else if (longValue == 274877906944L) {
                intent2.setClassName(ad.getContext(), "com.tencent.mm.ui.bindmobile.BindMContactIntroUI");
                MMWizardActivity.D(context, intent2);
                return true;
            } else if (longValue == 549755813888L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                com.tencent.mm.bg.d.b(ad.getContext(), "profile", ".ui.ContactInfoUI", intent2.putExtra("Contact_User", "qqsync"));
                return true;
            } else if (longValue == 2199023255552L) {
                SE = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent2.putExtra("launch_from_webview", false);
                com.tencent.mm.bg.d.c(ad.getContext(), "address", ".ui.WalletSelectAddrUI", intent2);
                return true;
            } else if (longValue == 35184372088832L) {
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.bg.d.b(ad.getContext(), "sns", ".ui.SnsBlackDetailUI", intent2);
                return true;
            } else if (longValue == 70368744177664L) {
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.bg.d.b(ad.getContext(), "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (longValue == 140737488355328L) {
                SE = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                bu buVar = new bu();
                buVar.bJj.bJl = "//uplog";
                buVar.bJj.context = ad.getContext();
                com.tencent.mm.sdk.b.a.sFg.m(buVar);
                return true;
            } else if (longValue == 562949953421312L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bg.d.b(ad.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                com.tencent.mm.bg.d.b(ad.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bg.d.b(ad.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                com.tencent.mm.bg.d.b(ad.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                com.tencent.mm.bg.d.b(ad.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent2);
            } else if (longValue == 576460752303423488L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                intent2.setClassName(ad.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
                ad.getContext().startActivity(intent2);
            } else if (longValue == 1125899906842624L) {
                SE = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent2.putExtra("emoji_tab", 1);
                SE = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                com.tencent.mm.plugin.report.service.h.mEJ.h(12065, new Object[]{Integer.valueOf(7)});
            } else if (longValue == 9007199254740992L) {
                SE = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            } else if (longValue == 576460752303423489L) {
                Uri parse2 = Uri.parse(str);
                encode4 = parse2.getQueryParameter("appid");
                str3 = parse2.getQueryParameter("userName");
                encode3 = parse2.getQueryParameter("path");
                i3 = 0;
                b v = u.Hx().v("key_data_center_session_id", false);
                if (v != null) {
                    i3 = ((Integer) v.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                }
                x.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", new Object[]{encode4, str3, encode3, Integer.valueOf(i), Integer.valueOf(i3)});
                u.Hx().ib("key_data_center_session_id");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.bGG = URLEncoder.encode(str2);
                if (i == 2) {
                    appBrandStatObject.scene = 1065;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode3, appBrandStatObject);
                } else if (i == 1) {
                    appBrandStatObject.scene = 1069;
                    appBrandStatObject.bGG = encode4;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode3, appBrandStatObject, encode4);
                } else if (i == 6) {
                    appBrandStatObject.scene = 1007;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode3, appBrandStatObject);
                } else if (i == 7) {
                    appBrandStatObject.scene = 1008;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, i3, 0, encode3, appBrandStatObject);
                } else {
                    appBrandStatObject.scene = BaseReportManager.MAX_READ_COUNT;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context, str3, null, 0, 0, encode3, appBrandStatObject);
                }
                return true;
            } else if (longValue == 576460752303423490L) {
                str3 = Uri.parse(str).getQueryParameter("appid");
                Intent intent3 = new Intent();
                x.d("MicroMsg.WalletManager", "start offline from sdk: %s", new Object[]{str3});
                intent3.putExtra("key_from_scene", 8);
                intent3.putExtra("key_appid", str3);
                com.tencent.mm.bg.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent3, 0);
            }
            if (bi.oW(SE)) {
                return false;
            }
            intent2.setClassName(ad.getContext(), SE);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e2, "", new Object[]{""});
                }
            } else {
                ad.getContext().startActivity(intent2);
                com.tencent.mm.ui.base.b.E(ad.getContext(), intent2);
            }
            return true;
        } else if (SE.startsWith("weixin://dl/businessTempSession/")) {
            intent = new Intent();
            intent.setFlags(268435456);
            parse = Uri.parse(str);
            if (parse == null) {
                x.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                return false;
            }
            substring = parse.getQueryParameter("sessionFrom");
            encode = parse.getQueryParameter("showtype");
            SE = parse.getQueryParameter("username");
            if (bi.oW(SE)) {
                SE = parse.getQueryParameter("userName");
            }
            if (bi.oW(SE)) {
                x.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                return false;
            }
            i4 = bi.getInt(bi.oV(parse.getQueryParameter("scene")), 0);
            if (i4 != 0 && i == 4) {
                x.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i4);
                i = i4;
            }
            x.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", new Object[]{SE, substring, Integer.valueOf(i), str, encode});
            intent.setClassName(ad.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
            intent.putExtra("Chat_User", SE);
            intent.putExtra("finish_direct", true);
            intent.putExtra("key_is_temp_session", true);
            intent.putExtra("key_temp_session_from", substring);
            intent.putExtra("key_temp_session_scene", i);
            intent.putExtra("key_temp_session_show_type", bi.getInt(encode, 0));
            au.HU();
            ab Yg = c.FR().Yg(SE);
            if (Yg == null || ((int) Yg.dhP) <= 0) {
                com.tencent.mm.model.am.a.dBr.a(SE, "", new 3(intent, context));
            } else {
                context.startActivity(intent);
            }
            return true;
        } else if (SE.startsWith("weixin://dl/businessGame/detail/") || SE.startsWith("weixin://dl/businessGame/detail")) {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
            parse = Uri.parse(str);
            SE = null;
            intent = new Intent();
            if (parse != null) {
                SE = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                intent.putExtra("game_app_id", parse.getQueryParameter("appid"));
                intent.putExtra("game_report_from_scene", 6);
            }
            if (bi.oW(SE)) {
                return false;
            }
            intent.setClassName(ad.getContext(), SE);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e22, "", new Object[]{""});
                }
            } else {
                ad.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.E(ad.getContext(), intent);
            }
            return true;
        } else if (SE.startsWith("weixin://dl/businessGame/library/") || SE.startsWith("weixin://dl/businessGame/library")) {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
            Intent intent4 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (bi.oW(queryParameter)) {
                return false;
            }
            intent4.putExtra("game_report_from_scene", 6);
            intent4.setClassName(ad.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent4);
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e222, "", new Object[]{""});
                }
            } else {
                ad.getContext().startActivity(intent4);
                com.tencent.mm.ui.base.b.E(ad.getContext(), intent4);
            }
            return true;
        } else if (!SE.startsWith("weixin://dl/businessWebview/link/") && !SE.startsWith("weixin://dl/businessWebview/link")) {
            return false;
        } else {
            x.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
            parse = Uri.parse(str);
            intent = new Intent();
            SE = null;
            if (parse != null) {
                substring = parse.getQueryParameter(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                i3 = bi.getInt(parse.getQueryParameter(DownloadSettingTable$Columns.TYPE), 0);
                encode2 = bi.oV(parse.getQueryParameter("appid"));
                i4 = bi.getInt(bi.oV(parse.getQueryParameter("outer")), 0);
                x.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", new Object[]{substring, encode2, Integer.valueOf(i), Integer.valueOf(i4)});
                SE = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                intent.putExtra("rawUrl", substring);
                intent.putExtra("geta8key_session_id", i2);
                intent.putExtra("geta8key_cookie", bArr);
                if (i == 1) {
                    if (i4 == 1) {
                        intent.putExtra("geta8key_open_webview_appid", encode2);
                        intent.putExtra("geta8key_scene", 53);
                    }
                    intent.putExtra("show_openapp_dialog", false);
                    intent.putExtra("pay_channel", 40);
                    i.Cx(39);
                } else if (i == 2) {
                    if (i4 == 1) {
                        intent.putExtra("geta8key_open_webview_appid", encode2);
                        intent.putExtra("geta8key_scene", 52);
                    }
                    intent.putExtra("pay_channel", 39);
                    i.Cx(39);
                }
                if (i3 == 5) {
                    intent.putExtra("webview_invoke_launch_app_when_back", true);
                    intent.putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[]{encode2, Integer.valueOf(i3), Integer.valueOf(-2)}));
                    intent.putExtra("KAppId", encode2);
                }
                intent.putExtra("transaction_for_openapi_openwebview", qya);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
            }
            if (bi.oW(SE)) {
                return false;
            }
            intent.setClassName(ad.getContext(), SE);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e2222, "", new Object[]{""});
                }
            } else {
                ad.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.E(ad.getContext(), intent);
            }
            return true;
        }
    }

    public static void eJ(Context context) {
        S(context, (int) System.currentTimeMillis());
    }

    private static void S(Context context, int i) {
        String string;
        if (!e.sFF && w.chP().equals("zh_CN")) {
            string = context.getString(R.l.wechat_faq_url);
        } else if (w.chP().equals("zh_HK")) {
            string = context.getString(R.l.wechat_faq_url_cht);
        } else if (w.chP().equals("zh_TW")) {
            string = context.getString(R.l.wechat_faq_url_cht_tw);
        } else {
            string = context.getString(R.l.wechat_faq_url_en);
        }
        x.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("geta8key_session_id", i);
        com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    private static String SE(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() + "://" + parse.getHost() + parse.getPath();
    }

    public static void x(Context context, String str, String str2) {
        if (!SC(str2)) {
            p a = com.tencent.mm.ui.base.h.a(context, "", true, null);
            int i = 6;
            if (!bi.oW(str)) {
                if (com.tencent.mm.model.s.fq(str)) {
                    i = 7;
                } else if (com.tencent.mm.model.s.hf(str)) {
                    i = 9;
                }
            }
            a(context, str2, i, new 4(a, context));
        }
    }

    public static void bd(Context context, String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            x.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", new Object[]{parse.getQueryParameter("cc"), parse.getQueryParameter("num")});
            Intent intent = new Intent(context, MobileInputUI.class);
            intent.putExtra("couttry_code", r1);
            intent.putExtra("input_mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            x.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", new Object[]{Uri.parse(str).getQueryParameter("username")});
            Intent intent2 = new Intent(context, LoginUI.class);
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } else {
            x.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", new Object[]{str});
        }
    }
}
