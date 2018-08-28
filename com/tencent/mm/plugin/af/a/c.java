package com.tencent.mm.plugin.af.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.or;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.scanner.a.p;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.yo;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    public static boolean a(a aVar, h hVar, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable, Bundle bundle) {
        if (aVar == null || aVar.getContext() == null) {
            x.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            return false;
        }
        int QN = hVar.QN();
        int i3 = ((yo) hVar.diG.dID.dIL).rrv;
        x.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : %s, codeType : %s", new Object[]{Integer.valueOf(QN), Integer.valueOf(i3)});
        x.i("MicroMsg.scanner.GetA8KeyRedirect", "source=" + i);
        Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        i.Cx(vc(i));
        String QL;
        String string;
        String QL2;
        Intent C;
        switch (QN) {
            case 1:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + hVar.getContent());
                intent.putExtra("data", hVar.getContent());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", vc(i));
                intent.putExtra("geta8key_session_id", hVar.QS());
                b.ezn.j(intent, aVar.getContext());
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 2:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + hVar.QL());
                Context context = aVar.getContext();
                Context context2 = aVar.getContext();
                QN = R.l.qrcode_alert_notmm_tip;
                Object[] objArr = new Object[1];
                if (bi.oW(str)) {
                    str = hVar.QL();
                }
                objArr[0] = str;
                com.tencent.mm.ui.base.h.a(context, context2.getString(QN, objArr), aVar.getContext().getString(R.l.app_tip), new 1(intent, hVar, i2, i, aVar), onClickListener);
                return true;
            case 3:
                QL = hVar.QL();
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: " + QL);
                if (QL == null || QL.length() == 0) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    return false;
                }
                string = aVar.getContext().getString(R.l.qrcode_alert_app_tip);
                if (QL.startsWith("http")) {
                    string = aVar.getContext().getString(R.l.qrcode_alert_notmm_tip, new Object[]{QL});
                }
                Uri parse = Uri.parse(QL);
                if (parse != null) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(268435456);
                    if (bi.k(aVar.getContext(), intent2)) {
                        com.tencent.mm.ui.base.h.a(aVar.getContext(), string, aVar.getContext().getString(R.l.app_tip), false, new 2(aVar, intent2), onClickListener);
                        return true;
                    }
                }
                return false;
            case 4:
                return false;
            case 6:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + hVar.QL());
                intent.putExtra("rawUrl", hVar.QL());
                intent.putExtra("pay_channel", vc(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                intent.putExtra("geta8key_session_id", hVar.QS());
                intent.putExtra("geta8key_cookie", hVar.QT());
                b.ezn.j(intent, aVar.getContext());
                return true;
            case 7:
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: reqUrl : %s,  fullUrl : %s, shareUrl : %s", new Object[]{hVar.QM(), hVar.QL(), hVar.getShareUrl()});
                intent.putExtra("title", hVar.getTitle());
                intent.putExtra("rawUrl", hVar.QL());
                intent.putExtra("k_share_url", hVar.getShareUrl());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + vc(i));
                intent.putExtra("pay_channel", vc(i));
                intent.putExtra("geta8key_session_id", hVar.QS());
                intent.putExtra("geta8key_cookie", hVar.QT());
                List<amu> QR = hVar.QR();
                if (!bi.cX(QR)) {
                    Object obj;
                    for (amu amu : QR) {
                        amu amu2;
                        if (amu2 == null || bi.oW(amu2.riD)) {
                            x.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                String[] strArr = new String[QR.size()];
                                String[] strArr2 = new String[QR.size()];
                                i3 = 0;
                                while (true) {
                                    QN = i3;
                                    if (QN < QR.size()) {
                                        amu2 = (amu) QR.get(QN);
                                        x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(QN), amu2.riD, amu2.mEl});
                                        strArr[QN] = r8;
                                        strArr2[QN] = QL;
                                        i3 = QN + 1;
                                    } else {
                                        intent.putExtra("geta8key_result_http_header_key_list", strArr);
                                        intent.putExtra("geta8key_result_http_header_value_list", strArr2);
                                        intent.putExtra("k_has_http_header", true);
                                    }
                                }
                            }
                        } else if (bi.oW(amu2.mEl)) {
                            x.e("MicroMsg.scanner.GetA8KeyRedirect", "http header has null value");
                            obj = 1;
                            if (obj == null) {
                                String[] strArr3 = new String[QR.size()];
                                String[] strArr22 = new String[QR.size()];
                                i3 = 0;
                                while (true) {
                                    QN = i3;
                                    if (QN < QR.size()) {
                                        amu2 = (amu) QR.get(QN);
                                        x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(QN), amu2.riD, amu2.mEl});
                                        strArr3[QN] = r8;
                                        strArr22[QN] = QL;
                                        i3 = QN + 1;
                                    } else {
                                        intent.putExtra("geta8key_result_http_header_key_list", strArr3);
                                        intent.putExtra("geta8key_result_http_header_value_list", strArr22);
                                        intent.putExtra("k_has_http_header", true);
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        String[] strArr32 = new String[QR.size()];
                        String[] strArr222 = new String[QR.size()];
                        i3 = 0;
                        while (true) {
                            QN = i3;
                            if (QN < QR.size()) {
                                amu2 = (amu) QR.get(QN);
                                x.i("MicroMsg.scanner.GetA8KeyRedirect", "http header index = %d, key = %s, value = %s", new Object[]{Integer.valueOf(QN), amu2.riD, amu2.mEl});
                                strArr32[QN] = r8;
                                strArr222[QN] = QL;
                                i3 = QN + 1;
                            } else {
                                intent.putExtra("geta8key_result_http_header_key_list", strArr32);
                                intent.putExtra("geta8key_result_http_header_value_list", strArr222);
                                intent.putExtra("k_has_http_header", true);
                            }
                        }
                    }
                }
                b.ezn.j(intent, aVar.getContext());
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 8:
                string = hVar.getContent();
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: " + string);
                if (!bi.oW(string)) {
                    try {
                        new p().KH(string);
                        aVar.getContext().startActivity(new Intent(aVar.getContext(), VcardContactUI.class));
                        aVar.hk(false);
                        return true;
                    } catch (Throwable e) {
                        x.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        x.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        x.printErrStackTrace("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                com.tencent.mm.ui.base.h.a(aVar.getContext(), aVar.getContext().getString(R.l.qrcode_not_recognized_tip), aVar.getContext().getString(R.l.app_tip), false, onClickListener);
                return true;
            case 9:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_scene", 5);
                return b.ezn.b(aVar.getContext(), hVar.QL(), bundle2);
            case 10:
            case 11:
                a(aVar, QN, hVar.QL(), vc(i));
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 12:
            case 15:
                a(aVar, QN, hVar.QL(), vc(i));
                return true;
            case 14:
                QL = hVar.QL();
                if (QL != null) {
                    QL = QL.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", QL);
                intent.putExtra("key_product_scene", 7);
                d.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                return true;
            case 16:
                QL2 = hVar.QL();
                intent = new Intent().setClassName(ad.getContext(), "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService");
                C = bi.C(ad.getContext(), intent);
                if (C == null) {
                    C = intent;
                }
                ad.getContext().startService(C.putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, QL2).putExtra("isFromWifi", true));
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                return true;
            case 17:
                Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", hVar.QL());
                string = "free_wifi_mid";
                yp ypVar = (yp) hVar.diG.dIE.dIL;
                if (ypVar == null || ypVar.qYZ == null) {
                    x.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    QL = null;
                } else {
                    QL = ypVar.qYZ;
                }
                intent3.putExtra(string, QL);
                string = "free_wifi_ssid";
                ypVar = (yp) hVar.diG.dIE.dIL;
                if (ypVar == null || ypVar.SSID == null) {
                    x.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    QL = null;
                } else {
                    QL = ypVar.SSID;
                }
                intent3.putExtra(string, QL);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", hVar.QL());
                au.HU();
                if (com.tencent.mm.model.c.DT().get(303104, null) != null) {
                    com.tencent.mm.ui.base.h.a(aVar.getContext(), R.l.free_wifi_dialog_tips, R.l.app_tip, R.l.free_wifi_intro_continue, R.l.app_cancel, new 3(aVar, intent3), onClickListener);
                } else {
                    d.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    aVar.hk(false);
                }
                return true;
            case 18:
                a KT = com.tencent.mm.plugin.scanner.util.p.KT(hVar.QL());
                if (KT == null) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (com.tencent.mm.plugin.scanner.util.p.nI(KT.huV)) {
                    intent = new Intent();
                    intent.putExtra("key_card_id", KT.huU);
                    intent.putExtra("key_card_ext", KT.cad);
                    intent.putExtra("key_from_scene", 0);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    x.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    com.tencent.mm.plugin.scanner.util.p.aG(aVar.getContext(), aVar.getContext().getString(R.l.card_not_support_card_type));
                }
                return false;
            case 20:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + hVar.QL());
                au.DF().a(new u(hVar.QL()), 0);
                return true;
            case 21:
                C = new Intent();
                C.setClass(aVar.getContext(), ProductUI.class);
                C.putExtra("key_ProductUI_getProductInfoScene", 5);
                C.putExtra("key_Qrcode_Url", hVar.QL());
                aVar.getContext().startActivity(C);
                return true;
            case 22:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + hVar.QL());
                com.tencent.mm.pluginsdk.wallet.h.a(aVar.getContext(), 1, hVar.QL(), vc(i), null);
                new ag(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 23:
                QL = hVar.QL();
                if (bi.oW(QL)) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "onStartCommand url is null");
                    return true;
                }
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start url, url:%s", new Object[]{QL});
                com.tencent.mm.g.a.x xVar = new com.tencent.mm.g.a.x();
                xVar.bHf.url = QL;
                com.tencent.mm.sdk.b.a.sFg.m(xVar);
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "publish BackupGetA8keyRedirectEvent");
                return true;
            case 24:
                or orVar = new or();
                orVar.bZC.bZD = str;
                com.tencent.mm.sdk.b.a.sFg.m(orVar);
                return true;
            case 25:
                QL = hVar.QL();
                ArrayList KU = com.tencent.mm.plugin.scanner.util.p.KU(QL);
                if (KU == null || KU.size() == 0) {
                    x.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (com.tencent.mm.plugin.scanner.util.p.L(KU)) {
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 0);
                    intent.putExtra("src_username", "");
                    intent.putExtra("js_url", "");
                    intent.putExtra("key_in_card_list", QL);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    d.b(aVar.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    x.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    com.tencent.mm.plugin.scanner.util.p.aG(aVar.getContext(), aVar.getContext().getString(R.l.card_not_support_card_type));
                }
                return false;
            case 26:
                QL2 = hVar.QL();
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: " + QL2);
                Context context3 = aVar.getContext();
                x.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: " + QL2);
                Uri parse2 = Uri.parse(QL2);
                int i4;
                if (parse2.getQueryParameter("search_query") == null || parse2.getQueryParameter("search_query").length() <= 0) {
                    if (i2 == 2) {
                        i4 = i3 == 22 ? 1048 : 1012;
                    } else if (i2 == 1) {
                        i4 = i3 == 22 ? 1049 : 1013;
                    } else {
                        i4 = i3 == 22 ? 1047 : 1011;
                    }
                    ((e) g.l(e.class)).b(context3, QL2, i4, bundle);
                } else {
                    QL = parse2.getQueryParameter("search_query");
                    String queryParameter = parse2.getQueryParameter("appid");
                    String queryParameter2 = parse2.getQueryParameter("search_extInfo");
                    int i5 = bi.getInt(parse2.getQueryParameter("debug"), 0);
                    i4 = bi.getInt(parse2.getQueryParameter("version"), 0);
                    kx kxVar = new kx();
                    kxVar.bVh.scene = 1;
                    kxVar.bVh.appId = queryParameter;
                    kxVar.bVh.type = i5;
                    kxVar.bVh.version = i4;
                    kxVar.bVh.bVi = QL;
                    kxVar.bVh.url = QL2;
                    kxVar.bVh.bVj = queryParameter2;
                    com.tencent.mm.sdk.b.a.sFg.m(kxVar);
                    intent = com.tencent.mm.plugin.websearch.api.p.adR();
                    intent.putExtra("ftsbizscene", 99999);
                    intent.putExtra("ftsQuery", QL);
                    intent.putExtra("ftsqrcodestring", QL2);
                    Map b = com.tencent.mm.plugin.websearch.api.p.b(300, false, 262144);
                    b.put("query", QL);
                    QL = com.tencent.mm.plugin.websearch.api.p.zK(bi.WU((String) b.get("scene")));
                    b.put("sessionid", QL);
                    intent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.api.p.v(b));
                    intent.putExtra("key_session_id", QL);
                    d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSWebViewUI", intent);
                }
                aVar.hk(false);
                return true;
            default:
                x.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + hVar.QN());
                return false;
        }
    }

    private static void a(a aVar, int i, String str, int i2) {
        x.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(i), str});
        gw gwVar = new gw();
        gwVar.bQd.actionCode = i;
        gwVar.bQd.result = str;
        gwVar.bQd.context = aVar.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        gwVar.bQd.bQf = bundle;
        gwVar.bJX = new 4(aVar, gwVar);
        com.tencent.mm.sdk.b.a.sFg.a(gwVar, Looper.myLooper());
    }

    protected static int vc(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }
}
