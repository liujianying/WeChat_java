package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.k.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.Map;

class WebViewUI$37 implements d {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$37(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Throwable e;
        boolean z;
        boolean z2 = false;
        if (WebViewUI.i(menuItem)) {
            b bVar = (b) menuItem.getMenuInfo();
            if (bVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.pZJ.pNV;
                x.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                Map hashMap = new HashMap();
                hashMap.put("key", bVar.aAL);
                hashMap.put("title", bVar.title);
                dVar.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a.a("menu:custom", hashMap, dVar.qhs, dVar.qht) + ")", null);
                return;
            }
            return;
        }
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        ak.d bUz;
        ak.d bUz2;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                stringExtra = this.pZJ.getIntent().getStringExtra("KPublisherId");
                stringExtra2 = this.pZJ.getIntent().getStringExtra("KAppId");
                stringExtra3 = this.pZJ.getIntent().getStringExtra("srcUsername");
                bUz = this.pZJ.pQY.bUz();
                bUz.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                bUz.c(this.pZJ.gcO);
                this.pZJ.pXR = this.pZJ.gcP.bVS().cgi();
                this.pZJ.aTi();
                return;
            case 2:
                int intValue;
                stringExtra = this.pZJ.getIntent().getStringExtra("KPublisherId");
                stringExtra2 = this.pZJ.getIntent().getStringExtra("KAppId");
                stringExtra3 = this.pZJ.getIntent().getStringExtra("srcUsername");
                bUz = this.pZJ.pQY.bUz();
                bUz.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(2), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                bUz.c(this.pZJ.gcO);
                this.pZJ.pXR = this.pZJ.gcP.bVS().cgi();
                if (WebViewUI.N(this.pZJ).containsKey(this.pZJ.mhH.getUrl())) {
                    intValue = ((Integer) WebViewUI.N(this.pZJ).get(this.pZJ.mhH.getUrl())).intValue();
                } else {
                    intValue = 0;
                }
                WebViewUI webViewUI = this.pZJ;
                webViewUI.pNV.bf("shareTimeline", true);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = webViewUI.pNV;
                if (dVar2.qhq) {
                    try {
                        dVar2.gcO.H("urlAttribute", String.valueOf(intValue), dVar2.pUz);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    }
                    dVar2.qhk.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a.a("menu:share:timeline", new HashMap(), dVar2.qhs, dVar2.qht) + ")", null);
                } else {
                    x.e("MicroMsg.JsApiHandler", "onShareTimeline fail, not ready");
                }
                webViewUI.pQY.Qy("mm_share_sns_count");
                return;
            case 3:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(3), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                h.mEJ.a(157, 6, 1, false);
                this.pZJ.pXR = this.pZJ.gcP.bVS().cgi();
                this.pZJ.aTp();
                return;
            case 5:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(4), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                stringExtra = (String) WebViewUI.h(this.pZJ).get(this.pZJ.mhH.getUrl());
                if (stringExtra == null) {
                    stringExtra = this.pZJ.getIntent().getStringExtra("srcUsername");
                }
                WebViewUI.h(this.pZJ, "Contact_Scene");
                WebViewUI.i(this.pZJ, stringExtra);
                return;
            case 6:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(5), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.O(this.pZJ);
                return;
            case 7:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(13), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.P(this.pZJ);
                return;
            case 8:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(15), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.Q(this.pZJ);
                return;
            case 9:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(7), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.R(this.pZJ);
                return;
            case 10:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(11), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                this.pZJ.bWp();
                return;
            case 11:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(8), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                if (WebViewUI.G(this.pZJ).getVisibility() == 8) {
                    WebViewUI.G(this.pZJ).startAnimation(AnimationUtils.loadAnimation(this.pZJ, R.a.font_fade_in));
                    WebViewUI.G(this.pZJ).setVisibility(0);
                    return;
                }
                Animation loadAnimation = AnimationUtils.loadAnimation(this.pZJ, R.a.font_fade_out);
                loadAnimation.setAnimationListener(new 1(this));
                WebViewUI.G(this.pZJ).startAnimation(loadAnimation);
                WebViewUI.G(this.pZJ).setVisibility(8);
                return;
            case 12:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(6), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", this.pZJ.getIntent().getLongExtra("fav_local_id", -1));
                com.tencent.mm.plugin.fav.a.b.a(this.pZJ.mController.tml, ".ui.FavTagEditUI", intent);
                this.pZJ.pQY.Qy("mm_edit_fav_count");
                return;
            case 14:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(9), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                if (WebViewUI.S(this.pZJ)) {
                    WebViewUI.j(this.pZJ, WebViewUI.V(this.pZJ));
                    return;
                } else {
                    WebViewUI.a(this.pZJ, this.pZJ.mhH.getUrl(), this.pZJ.mhH.getSettings().getUserAgentString(), WebViewUI.T(this.pZJ), WebViewUI.U(this.pZJ));
                    return;
                }
            case 15:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(19), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.a(this.pZJ, menuItem);
                return;
            case 16:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(21), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.a(this.pZJ, menuItem);
                return;
            case 17:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(20), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.a(this.pZJ, menuItem);
                return;
            case 18:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(22), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.a(this.pZJ, menuItem);
                return;
            case 19:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(23), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.a(this.pZJ, menuItem);
                return;
            case 20:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(17), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.Y(this.pZJ);
                return;
            case 21:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(18), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.Z(this.pZJ);
                return;
            case 22:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(24), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.aa(this.pZJ);
                return;
            case 23:
                intent = new Intent();
                stringExtra2 = this.pZJ.getIntent().getStringExtra("sns_local_id");
                if (stringExtra2 != null) {
                    intent.putExtra("sns_send_data_ui_activity", true);
                    intent.putExtra("sns_local_id", stringExtra2);
                } else {
                    intent.putExtra("Retr_Msg_Id", Long.valueOf(this.pZJ.getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                }
                com.tencent.mm.bg.d.e(this.pZJ.mController.tml, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                return;
            case 24:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(16), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.ac(this.pZJ);
                return;
            case 25:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(26), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.W(this.pZJ);
                return;
            case 26:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(27), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.X(this.pZJ);
                return;
            case i$l.AppCompatTheme_actionModeStyle /*27*/:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(32), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                if (!this.pZJ.aST()) {
                    this.pZJ.finish();
                    return;
                }
                return;
            case i$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(10), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                if (this.pZJ.mhH != null) {
                    this.pZJ.mhH.reload();
                    return;
                }
                return;
            case i$l.AppCompatTheme_actionModeBackground /*29*/:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(31), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                this.pZJ.aTo();
                return;
            case i$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                h.mEJ.a(480, 1, 1, false);
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(28), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                if (!this.pZJ.pXM.isShown()) {
                    this.pZJ.pXM.reset();
                    this.pZJ.pXM.bYy();
                    this.pZJ.pXM.show();
                    return;
                }
                return;
            case i$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(14), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                WebViewUI.ab(this.pZJ);
                return;
            case i$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                WebViewUI.ad(this.pZJ);
                return;
            case i$l.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(33), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                this.pZJ.pZs.kg(false);
                return;
            case i$l.AppCompatTheme_actionModeShareDrawable /*36*/:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(34), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                this.pZJ.pZs.kg(true);
                return;
            default:
                bUz2 = this.pZJ.pQY.bUz();
                bUz2.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(16), Integer.valueOf(1)};
                bUz2.c(this.pZJ.gcO);
                stringExtra3 = menuItem.getTitle();
                if (!bi.oW(stringExtra3)) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, stringExtra3);
                        bundle = this.pZJ.gcO.g(50, bundle);
                        if (bundle != null) {
                            z = bundle.getInt("key_biz_type") == 2;
                            try {
                                if (bundle.getInt("key_biz_type") == 3) {
                                    z2 = true;
                                }
                            } catch (RemoteException e3) {
                                e2 = e3;
                            }
                        }
                    } catch (RemoteException e4) {
                        e2 = e4;
                        z = false;
                        x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                        z2 = z;
                        if (z2) {
                            WebViewUI.k(this.pZJ, stringExtra3);
                            return;
                        } else {
                            WebViewUI.l(this.pZJ, stringExtra3);
                            return;
                        }
                    }
                    if (z2) {
                        WebViewUI.k(this.pZJ, stringExtra3);
                        return;
                    } else {
                        WebViewUI.l(this.pZJ, stringExtra3);
                        return;
                    }
                }
                return;
        }
    }
}
