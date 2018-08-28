package com.tencent.mm.plugin.webview.ui.tools;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.g.a.j;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.xweb.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class WebViewUI$23 extends a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$23(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final boolean c(int i, Bundle bundle) {
        x.i("MicroMsg.WebViewUI", "callback, actionCode = " + i);
        Map hashMap;
        switch (i) {
            case 13:
                if (bundle != null) {
                    bundle.putString("application_language", this.pZJ.gcO.getLanguage());
                    WebViewUI.a(this.pZJ, d.W(bundle));
                    break;
                }
                break;
            case 15:
                WebViewUI.a(this.pZJ).post(new 11(this, bundle.getString("exdevice_device_id"), bundle.getByteArray("exdevice_broadcast_data"), bundle.getBoolean("exdevice_is_complete"), bundle.getBoolean("exdevice_is_lan_device")));
                break;
            case 16:
                WebViewUI.a(this.pZJ).post(new 13(this, bundle.getString("exdevice_device_id"), bundle.getByteArray("exdevice_data"), bundle.getString("exdevice_brand_name")));
                break;
            case 17:
                WebViewUI.a(this.pZJ).post(new 14(this, bundle.getString("exdevice_device_id"), bundle.getBoolean("exdevice_is_bound")));
                break;
            case 18:
                WebViewUI.a(this.pZJ).post(new 15(this, bundle.getBoolean("exdevice_bt_state")));
                break;
            case 26:
            case 27:
            case f$k.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
            case f$k.AppCompatTheme_actionModeBackground /*29*/:
            case 30:
            case f$k.AppCompatTheme_actionModeCloseDrawable /*31*/:
            case f$k.AppCompatTheme_actionModeCutDrawable /*32*/:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case f$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
            case f$k.AppCompatTheme_dialogTheme /*42*/:
            case f$k.AppCompatTheme_dialogPreferredPadding /*43*/:
            case f$k.AppCompatTheme_listDividerAlertDialog /*44*/:
            case f$k.AppCompatTheme_actionDropDownStyle /*45*/:
            case f$k.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                WebViewUI.bWy();
                break;
            case f$k.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                WebViewUI.a(this.pZJ).post(new 16(this, bundle.getBoolean("exdevice_lan_state")));
                break;
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                String[] stringArray = bundle.getStringArray("msgIds");
                String[] stringArray2 = bundle.getStringArray("contents");
                String[] stringArray3 = bundle.getStringArray("senders");
                int[] intArray = bundle.getIntArray("msgTypes");
                int[] intArray2 = bundle.getIntArray("msgTimes");
                JSONArray jSONArray = new JSONArray();
                int length = stringArray == null ? 0 : stringArray.length;
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("newMsgId", stringArray[i2]);
                        jSONObject.put("content", stringArray2[i2]);
                        jSONObject.put("sender", stringArray3[i2]);
                        jSONObject.put("msgType", intArray[i2]);
                        jSONObject.put("msgTime", intArray2[i2]);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        x.e("MicroMsg.WebViewUI", "GetMsgProofItems exception " + e.getMessage());
                    }
                }
                WebViewUI.a(this.pZJ).post(new 19(this, jSONArray));
                break;
            case f$k.AppCompatTheme_popupMenuStyle /*60*/:
            case f$k.AppCompatTheme_popupWindowStyle /*61*/:
            case f$k.AppCompatTheme_editTextColor /*62*/:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 130:
            case 133:
            case 134:
            case com.tencent.mm.plugin.appbrand.jsapi.f.a.CTRL_INDEX /*135*/:
            case 136:
            case 137:
            case 138:
            case 142:
            case 143:
            case 144:
            case 145:
            case 100001:
            case 100002:
            case 200000:
            case 200001:
            case 200002:
            case 200003:
                this.pZJ.j(i, bundle);
                break;
            case f$k.AppCompatTheme_listPreferredItemHeightSmall /*70*/:
                x.i("MicroMsg.WebViewUI", "on service click, update tid = %s", new Object[]{bundle.getString("service_click_tid")});
                WebViewUI.a(this.pZJ, r0);
                WebViewUI.a(this.pZJ, System.currentTimeMillis());
                WebViewUI.a(this.pZJ).post(new 22(this));
                break;
            case f$k.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                WebViewUI.a(this.pZJ).post(new 21(this, bundle));
                break;
            case 90:
                WebViewUI.a(this.pZJ).post(new 20(this, bundle.getString("webview_network_type")));
                break;
            case 1001:
                if (!this.pZJ.isFinishing()) {
                    this.pZJ.finish();
                    break;
                }
                break;
            case 1002:
                WebViewUI.a(this.pZJ).post(new 1(this, bundle));
                break;
            case 1003:
                WebViewUI.a(this.pZJ).post(new 12(this, bundle));
                break;
            case 1004:
                WebViewUI.a(this.pZJ).post(new 45(this, bundle.getString("exdevice_device_id"), bundle.getInt("exdevice_on_state_change_state"), Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"))));
                break;
            case 1006:
                if (this.pZJ.pNV != null) {
                    WebViewUI.a(this.pZJ).post(new 10(this, bundle));
                    break;
                }
                break;
            case 1007:
                WebViewUI.a(this.pZJ).post(new 34(this, bundle.getString("download_manager_appid", ""), bundle.getLong("download_manager_downloadid"), bundle.getInt("download_manager_progress")));
                break;
            case 1008:
                WebViewUI.a(this.pZJ).post(new 23(this, bundle));
                break;
            case 2002:
                hashMap = new HashMap();
                hashMap.put("err_msg", bundle.getString("playResult"));
                hashMap.put("localId", bundle.getString("localId"));
                WebViewUI.a(this.pZJ).post(new 5(this, hashMap));
                break;
            case 2003:
                WebViewUI.a(this.pZJ).post(new 52(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2004:
                WebViewUI.a(this.pZJ).post(new 54(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2005:
                WebViewUI.a(this.pZJ).post(new 2(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2006:
                WebViewUI.a(this.pZJ).post(new 3(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2007:
                WebViewUI.a(this.pZJ).post(new 7(this));
                break;
            case 2008:
                hashMap = new HashMap();
                hashMap.put("localId", bundle.getString("localId"));
                hashMap.put("err_msg", bundle.getString("recordResult"));
                WebViewUI.a(this.pZJ).post(new 8(this, hashMap));
                break;
            case 2009:
                WebViewUI.a(this.pZJ).post(new 9(this));
                break;
            case 2010:
                WebViewUI.a(this.pZJ).post(new 4(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2011:
                WebViewUI.a(this.pZJ).post(new 51(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case 2100:
                WebViewUI.a(this.pZJ).post(new 53(this, bundle.getString("background_audio_state_player_state"), bundle.getInt("background_audio_state_player_duration"), bundle.getString("background_audio_state_player_src"), bundle.getInt("background_audio_state_player_err_code"), bundle.getString("background_audio_state_player_err_msg"), bundle.getString("background_audio_state_player_src_id")));
                break;
            case 4007:
                WebViewUI.a(this.pZJ).post(new 6(this, bundle.getInt("nfc_key_on_touch_errcode", 0)));
                break;
            case 40001:
                WebViewUI.a(this.pZJ).post(new 17(this, bundle.getString("err_msg")));
                break;
            case 40002:
                WebViewUI.a(this.pZJ).post(new 18(this, bundle.getString("uuid"), bundle.getInt("major"), bundle.getInt("minor"), bundle.getDouble("accuracy"), bundle.getDouble("rssi"), bundle.getFloat("heading")));
                break;
            case 80001:
            case 80002:
                this.pZJ.t(i, bundle);
                break;
            default:
                x.e("MicroMsg.WebViewUI", "undefine action code!!!");
                break;
        }
        return true;
    }

    public final boolean a(final c cVar) {
        if (this.pZJ.pYp.bWL() || this.pZJ.pYq.bWL() || this.pZJ.pYr.bWL() || WebViewUI.b(this.pZJ).bUg()) {
            WebViewUI.a(this.pZJ).post(new Runnable() {
                public final void run() {
                    WebViewUI$23.this.pZJ.b(cVar);
                }
            });
        }
        return true;
    }

    public final boolean As(int i) {
        WebViewUI.a(this.pZJ).post(new 25(this, i));
        return true;
    }

    public final boolean a(String str, String str2, Bundle bundle, boolean z) {
        if (this.pZJ.pNV != null) {
            this.pZJ.runOnUiThread(new 26(this, str, str2, bundle, z));
        }
        return false;
    }

    public final String bVl() {
        return this.pZJ.cbP;
    }

    public final String getCurrentUrl() {
        return this.pZJ.getCurrentURL();
    }

    public final String bVm() {
        return this.pZJ.getIntent().getStringExtra("srcUsername");
    }

    public final void jV(boolean z) {
        x.d("MicroMsg.WebViewUI", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(this.pZJ.getIntent().getBooleanExtra("forceHideShare", false))});
        WebViewUI.a(this.pZJ).post(new 27(this, r0, z));
    }

    public final void jW(boolean z) {
        WebViewUI.a(this.pZJ).post(new 28(this, z));
    }

    public final void bVn() {
        if (this.pZJ.pNV != null) {
            this.pZJ.pNV.bVn();
        }
    }

    public final void P(Bundle bundle) {
        x.i("MicroMsg.WebViewUI", "IUIController, closeWindow");
        if (bundle != null) {
            Intent intent = new Intent();
            intent.putExtra("result_data", bundle);
            this.pZJ.setResult(-1, intent);
        }
        this.pZJ.finish();
    }

    public final void QM(String str) {
        int i = 0;
        try {
            i = bi.getInt(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "setFontSizeCb, ex = " + e.getMessage());
        }
        if (this.pZJ.mhH == null) {
            x.e("MicroMsg.WebViewUI", "setFontSizeCb fail, viewWV is null");
        } else {
            WebViewUI.a(this.pZJ).post(new 29(this, i));
        }
    }

    public final void bVo() {
        if (this.pZJ.pNV != null) {
            this.pZJ.pNV.bVo();
        }
    }

    public final void e(String str, final String str2, int i, int i2) {
        x.d("MicroMsg.WebViewUI", "result: " + str2);
        if (this.pZJ.gcU != null && str != null && str.equals(this.pZJ.gcU.pUp)) {
            if (this.pZJ.gcU != null) {
                this.pZJ.gcU.bVc();
            }
            this.pZJ.gcS = i;
            this.pZJ.gcT = i2;
            if (str2 != null && this.pZJ.gcQ != null) {
                WebViewUI.a(this.pZJ).post(new Runnable() {
                    public final void run() {
                        if (WebViewUI$23.this.pZJ.mhH != null) {
                            WebViewUI$23.this.pZJ.gcR = str2;
                            WebViewUI$23.this.pZJ.gcQ.b(WebViewUI$23.this.pZJ.mhH, new 1(this), null);
                            WebViewUI$23.this.pZJ.gcQ.bEo();
                        }
                    }
                });
            }
        }
    }

    public final void q(int i, Bundle bundle) {
        WebViewUI.a(this.pZJ).post(new 31(this, i, bundle));
    }

    public final void fo(String str, String str2) {
        WebViewUI.a(this.pZJ).post(new 32(this, str));
    }

    public final Bundle g(int i, final Bundle bundle) {
        x.i("MicroMsg.WebViewUI", "invokeAsResult, actionCode = " + i);
        Bundle bundle2 = new Bundle();
        Intent intent;
        int b;
        String string;
        int i2;
        String string2;
        String string3;
        boolean z;
        boolean z2;
        CharSequence mMTitle;
        switch (i) {
            case 11:
                this.pZJ.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (WebViewUI.s(WebViewUI$23.this.pZJ) != null && WebViewUI.s(WebViewUI$23.this.pZJ).isShowing()) {
                            WebViewUI.s(WebViewUI$23.this.pZJ).dismiss();
                        }
                    }
                });
                break;
            case 12:
                this.pZJ.runOnUiThread(new Runnable() {
                    public final void run() {
                        WebViewUI.a(WebViewUI$23.this.pZJ, null);
                    }
                });
                break;
            case 18:
                bundle2.putString("KPublisherId", this.pZJ.bZM);
                intent = this.pZJ.getIntent();
                if (intent != null) {
                    b = WebViewUI.b(this.pZJ, this.pZJ.getIntent().getStringExtra("geta8key_username"));
                    bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                    bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                    bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                    bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                    bundle2.putInt("getA8KeyScene", b);
                    bundle2.putString("referUrl", WebViewUI.i(this.pZJ));
                    break;
                }
                break;
            case 22:
                bundle2.putInt("pay_channel", this.pZJ.getIntent().getIntExtra("pay_channel", -1));
                x.i("MicroMsg.WebViewUI", "key value: pay channel(%d)", new Object[]{Integer.valueOf(this.pZJ.getIntent().getIntExtra("pay_channel", -1))});
                break;
            case 25:
                bundle2.putInt("scene", this.pZJ.getIntent().getIntExtra("scene", -1));
                x.i("MicroMsg.WebViewUI", "Key value: Scene(%d)", new Object[]{Integer.valueOf(this.pZJ.getIntent().getIntExtra("scene", 0))});
                break;
            case 33:
                intent = this.pZJ.getIntent();
                if (intent != null) {
                    bundle2.putString("publishIdPrefix", intent.getStringExtra("publishIdPrefix"));
                    bundle2.putString("reportSessionId", intent.getStringExtra("reportSessionId"));
                    break;
                }
                break;
            case 34:
                this.pZJ.runOnUiThread(new Runnable() {
                    public final void run() {
                        WebViewUI.o(WebViewUI$23.this.pZJ);
                    }
                });
                break;
            case 35:
                this.pZJ.runOnUiThread(new 39(this));
                break;
            case 36:
                this.pZJ.runOnUiThread(new Runnable() {
                    public final void run() {
                        WebViewUI.n(WebViewUI$23.this.pZJ).stopLoading();
                    }
                });
                break;
            case 37:
                this.pZJ.runOnUiThread(new 41(this, bundle.getString("show_kb_placeholder"), bundle.getInt("show_kb_max_length")));
                break;
            case 38:
                if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                    this.pZJ.runOnUiThread(new 35(this));
                    break;
                }
                break;
            case 39:
                this.pZJ.runOnUiThread(new 40(this));
                break;
            case f$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                string = bundle.getString("set_page_title_text");
                String string4 = bundle.getString("set_page_title_color");
                WebViewUI webViewUI = this.pZJ;
                if (com.tencent.mm.compatible.util.d.fR(21) && webViewUI.aUR()) {
                    i2 = -16777216;
                } else {
                    i2 = webViewUI.getResources().getColor(R.e.action_bar_tittle_color);
                }
                d.aO(string4, i2);
                this.pZJ.runOnUiThread(new 43(this, string));
                break;
            case f$k.AppCompatTheme_listDividerAlertDialog /*44*/:
                Bitmap bitmap;
                string2 = bundle.getString("set_navigation_bar_buttons_text");
                string3 = bundle.getString("set_navigation_bar_buttons_icon_data");
                z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                if (bi.oW(string3)) {
                    bitmap = null;
                } else {
                    try {
                        bitmap = d.Rg(string3);
                    } catch (Exception e) {
                        bitmap = null;
                        x.e("MicroMsg.WebViewUI", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[]{e});
                    }
                }
                this.pZJ.runOnUiThread(new 44(this, z, bitmap, string2, d.aO(bundle.getString("set_navigation_bar_buttons_left_text_color"), -1)));
                break;
            case f$k.AppCompatTheme_actionDropDownStyle /*45*/:
                this.pZJ.runOnUiThread(new Runnable() {
                    public final void run() {
                        boolean z = bundle.getBoolean("enable_fullscreen_params_enable", false);
                        if (WebViewUI$23.this.pZJ.getIntent() != null) {
                            WebViewUI$23.this.pZJ.getIntent().removeExtra("show_full_screen");
                        }
                        WebViewUI.b(WebViewUI$23.this.pZJ, z);
                    }
                });
                break;
            case f$k.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                this.pZJ.runOnUiThread(new 38(this));
                break;
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
            case f$k.AppCompatTheme_actionButtonStyle /*49*/:
                break;
            case f$k.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                this.pZJ.runOnUiThread(new Runnable() {
                    public final void run() {
                        WebViewUI$23.this.pZJ.U(bundle);
                    }
                });
                break;
            case f$k.AppCompatTheme_borderlessButtonStyle /*54*/:
                z2 = bundle.getBoolean("add_shortcut_status");
                if (this.pZJ.pNV != null) {
                    this.pZJ.pNV.kk(z2);
                    break;
                }
                break;
            case f$k.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                    bundle2.putString("enterprise_context_biz", this.pZJ.getIntent().getStringExtra("enterprise_biz_name"));
                    bundle2.putLong("enterprise_context_bizchatid", this.pZJ.getIntent().getLongExtra("biz_chat_chat_id", -1));
                    break;
                }
                break;
            case f$k.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                WebViewUI.n(this.pZJ).AH(d.aO(bundle.getString("key_set_bounce_background_color"), this.pZJ.getResources().getColor(R.e.webview_logo_bg_color)));
                break;
            case 73:
                intent = this.pZJ.getIntent();
                if (bundle != null) {
                    switch (bundle.getInt("scene")) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 37:
                        case f$k.AppCompatTheme_actionDropDownStyle /*45*/:
                            bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            break;
                        case 33:
                            bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                            break;
                        case 34:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("<exposecontent>");
                            stringBuilder.append("<weburl>");
                            if (intent.getStringExtra("k_expose_current_url") != null) {
                                stringBuilder.append(intent.getStringExtra("k_expose_current_url"));
                            }
                            stringBuilder.append("</weburl>");
                            stringBuilder.append("<webscence>");
                            stringBuilder.append(WebViewUI.b(this.pZJ, this.pZJ.getIntent().getStringExtra("geta8key_username")));
                            stringBuilder.append("</webscence>");
                            stringBuilder.append("</exposecontent>");
                            bundle2.putString("content", stringBuilder.toString());
                            break;
                        case 35:
                        case 36:
                        case 38:
                        case 39:
                            break;
                        case f$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
                            bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                            bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                            bundle2.putInt("msgType", intent.getIntExtra("k_expose_msg_type", 0));
                            break;
                        default:
                            x.d("MicroMsg.WebViewUI", "unknown expose scene: %d", new Object[]{Integer.valueOf(bundle.getInt("scene"))});
                            return bundle2;
                    }
                    bundle2.putString("username", intent.getStringExtra("k_username"));
                    break;
                }
                break;
            case f$k.AppCompatTheme_textAppearanceListItemSmall /*77*/:
                bundle2.putString("KSessionId", WebViewUI.j(this.pZJ));
                bundle2.putString("KUserAgent", WebViewUI.k(this.pZJ));
                bundle2.putBoolean("KReportPage", this.pZJ.pXR);
                bundle2.putString("KUrl", WebViewUI.l(this.pZJ));
                break;
            case f$k.AppCompatTheme_panelMenuListWidth /*79*/:
                this.pZJ.runOnUiThread(new 42(this, bundle2));
                break;
            case f$k.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                bundle2.putBoolean("from_shortcut", WebViewUI.u(this.pZJ));
                break;
            case f$k.AppCompatTheme_colorAccent /*84*/:
                mMTitle = this.pZJ.mController.getMMTitle();
                string = getCurrentUrl();
                bundle2.putString("webview_current_url", string);
                bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                bundle2.putString("webview_current_desc", string);
                break;
            case 85:
                mMTitle = this.pZJ.mController.getMMTitle();
                string = getCurrentUrl();
                Intent intent2 = this.pZJ.getIntent();
                if (intent2 != null) {
                    bundle2.putString("share_report_pre_msg_url", intent2.getStringExtra("share_report_pre_msg_url"));
                    bundle2.putString("share_report_pre_msg_title", intent2.getStringExtra("share_report_pre_msg_title"));
                    bundle2.putString("share_report_pre_msg_desc", intent2.getStringExtra("share_report_pre_msg_desc"));
                    bundle2.putString("share_report_pre_msg_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                    bundle2.putString("share_report_pre_msg_appid", intent2.getStringExtra("share_report_pre_msg_appid"));
                    bundle2.putInt("share_report_from_scene", intent2.getIntExtra("share_report_from_scene", 0));
                    bundle2.putString("share_report_biz_username", intent2.getStringExtra("share_report_biz_username"));
                }
                bundle2.putString("share_report_current_url", string);
                bundle2.putString("share_report_current_title", mMTitle != null ? mMTitle.toString() : "");
                break;
            case f$k.AppCompatTheme_colorControlActivated /*86*/:
                bundle2.putBoolean("is_from_keep_top", this.pZJ.getIntent().getBooleanExtra("is_from_keep_top", false));
                break;
            case f$k.AppCompatTheme_colorControlHighlight /*87*/:
                if (!WebViewUI.v(this.pZJ)) {
                    bundle2.putString("full_url", bi.oV(this.pZJ.jkH));
                    if (WebViewUI.w(this.pZJ) != null && WebViewUI.w(this.pZJ).size() != 0) {
                        bundle2.putInt("set_cookie", 1);
                        com.tencent.xweb.c.ij(ad.getContext());
                        b cIi = b.cIi();
                        for (String string32 : WebViewUI.w(this.pZJ).keySet()) {
                            cIi.setCookie(bi.Xl(this.pZJ.jkH), string32 + "=" + ((String) WebViewUI.w(this.pZJ).get(string32)));
                        }
                        cIi.setCookie(bi.Xl(this.pZJ.jkH), "httponly");
                        com.tencent.xweb.c.cIk();
                        com.tencent.xweb.c.sync();
                        x.i("MicroMsg.WebViewUI", "cookies:%s", new Object[]{cIi.getCookie(bi.Xl(this.pZJ.jkH))});
                        break;
                    }
                    bundle2.putInt("set_cookie", 0);
                    break;
                }
                bundle2.putString("result", "not_return");
                break;
                break;
            case f$k.AppCompatTheme_textColorAlertDialogListItem /*95*/:
                this.pZJ.setGamePageReportData(bundle);
                break;
            case f$k.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                bundle2.putInt("web_page_count", WebViewUI.bWD());
                break;
            case f$k.AppCompatTheme_autoCompleteTextViewStyle /*99*/:
                bundle2.putInt("geta8key_scene", this.pZJ.getIntent().getIntExtra("geta8key_scene", 0));
                x.i("MicroMsg.WebViewUI", "Key value: getA8KeyScene(%d)", new Object[]{Integer.valueOf(i2)});
                break;
            case 101:
                bundle.setClassLoader(WebViewUI.class.getClassLoader());
                com.tencent.mm.bg.d.b(this.pZJ, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", this.pZJ.bZM));
                break;
            case f.CTRL_INDEX /*146*/:
                string32 = bundle.getString("_url");
                if (!(bi.oW(string32) || this.pZJ.gcP == null || this.pZJ.gcP == null)) {
                    Parcelable Rl = this.pZJ.gcP.Rl(string32);
                    if (Rl != null) {
                        bundle2.putParcelable("_permission_wrapper", Rl);
                        break;
                    }
                }
                break;
            case 1009:
                if (this.pZJ.fYl != null) {
                    this.pZJ.fYl.disable();
                }
                this.pZJ.screenOrientation = bundle.getInt("screen_orientation", -1);
                if (this.pZJ.screenOrientation == 1001) {
                    this.pZJ.screenOrientation = 0;
                    if (this.pZJ.fYl != null) {
                        x.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                        this.pZJ.fYl.enable();
                    }
                } else if (this.pZJ.screenOrientation == 1002) {
                    this.pZJ.screenOrientation = 1;
                    if (this.pZJ.fYl != null) {
                        x.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                        this.pZJ.fYl.enable();
                    }
                }
                this.pZJ.ahy();
                break;
            case 4001:
            case 4002:
            case 4003:
            case 4004:
            case 4005:
            case 4008:
                j jVar = new j();
                jVar.bGo.context = this.pZJ.mController.tml;
                jVar.bGo.actionCode = i;
                if (4003 == i) {
                    jVar.bGo.bGq = bundle.getString("apdu");
                } else if (4004 == i) {
                    string = bundle.getString("apdus");
                    z = bundle.getBoolean("breakIfFail", true);
                    boolean z3 = bundle.getBoolean("breakIfTrue", false);
                    jVar.bGo.bGq = string;
                    jVar.bGo.bGr = z;
                    jVar.bGo.bGs = z3;
                }
                jVar.bJX = new 33(this, bundle2, jVar);
                com.tencent.mm.sdk.b.a.sFg.m(jVar);
                break;
            case 5001:
                if (this.pZJ.gcO.isSDCardAvailable()) {
                    x.i("MicroMsg.WebViewUI", "availableSize = %d", new Object[]{Long.valueOf(ax.ciJ())});
                    if (ax.ciJ() < 524288000) {
                        x.e("MicroMsg.WebViewUI", "available size not enough");
                    } else {
                        File file = new File(com.tencent.mm.plugin.webview.a.pNq);
                        z2 = true;
                        if (!file.exists()) {
                            z2 = file.mkdirs();
                            x.i("MicroMsg.WebViewUI", "create proxy cache path : %s, %b", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z2)});
                        }
                        if (z2) {
                            i2 = FactoryProxyManager.getPlayManager().init(this.pZJ, com.tencent.mm.plugin.webview.a.pNq);
                            FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                        }
                    }
                    i2 = FactoryProxyManager.getPlayManager().init(this.pZJ, null);
                } else {
                    x.i("MicroMsg.WebViewUI", "sdcard not available");
                    i2 = FactoryProxyManager.getPlayManager().init(this.pZJ, null);
                }
                if (i2 == 0) {
                    if (WebViewUI.bWC() == null) {
                        WebViewUI.a(new WebViewUI$y(this.pZJ, (byte) 0));
                        FactoryProxyManager.getPlayManager().setUtilsObject(WebViewUI.bWC());
                    }
                    b = FactoryProxyManager.getPlayManager().getLocalServerPort();
                    x.i("MicroMsg.WebViewUI", "webview video init result = %d, local port = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(b)});
                    ah m = WebViewUI.m(this.pZJ);
                    if (b <= 0 || b > 65535) {
                        x.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[]{Integer.valueOf(b)});
                    }
                    if (!m.pRT.contains(Integer.valueOf(b))) {
                        m.pRT.add(Integer.valueOf(b));
                    }
                }
                bundle2.putInt("webview_video_proxy_init", i2);
                break;
            case 5002:
                i2 = FactoryProxyManager.getPlayManager().startPlay(bundle.getString("webview_video_proxy_cdn_urls"), bundle.getInt("webview_video_proxy_file_type"), bundle.getString("webview_video_proxy_fileId"), (long) bundle.getInt("webview_video_proxy_file_size"), bundle.getInt("webview_video_proxy_file_duration"));
                x.i("MicroMsg.WebViewUI", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[]{string, r3, Integer.valueOf(r8), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(i2), FactoryProxyManager.getPlayManager().buildPlayURLMp4(i2)});
                bundle2.putInt("webview_video_proxy_play_data_id", i2);
                bundle2.putString("webview_video_proxy_local_url", string2);
                break;
            case 5003:
                i2 = bundle.getInt("webview_video_proxy_play_data_id");
                x.i("MicroMsg.WebViewUI", "webview proxy stop play, play id = %d", new Object[]{Integer.valueOf(i2)});
                if (i2 > 0) {
                    FactoryProxyManager.getPlayManager().stopPlay(i2);
                    break;
                }
                break;
            case 5004:
                FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                break;
            case 5005:
                FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                break;
            case 5006:
                FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                break;
            case 5007:
                x.i("MicroMsg.WebViewUI", "playid = %d, duration = %d", new Object[]{Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration"))});
                bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(i2, b));
                break;
            case 6001:
                x.i("MicroMsg.WebViewUI", "includeCookie = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false))});
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent3.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                intent3.putExtra("tools_clean_webview_cache_ignore_cookie", z2);
                this.pZJ.sendBroadcast(intent3);
                break;
            case 90000:
                bundle2.putStringArray("webview_get_route_url_list", WebViewUI.t(this.pZJ).bVe());
                bundle2.putInt("webview_get_route_url_geta8key_scene", WebViewUI.b(this.pZJ, this.pZJ.getIntent().getStringExtra("geta8key_username")));
                bundle2.putString("geta8key_username", this.pZJ.getIntent().getStringExtra("geta8key_username"));
                break;
            case 90001:
                x.i("MicroMsg.WebViewUI", "url = %s, cookie = %s", new Object[]{this.pZJ.getCurrentURL(), b.cIi().getCookie(this.pZJ.getCurrentURL())});
                bundle2.putString("cookie", string);
                break;
            case 90002:
                g.pXv.fr(bundle.getString("traceid"), bundle.getString("username"));
                break;
            default:
                x.e("MicroMsg.WebViewUI", "undefine action code!!!");
                break;
        }
        return bundle2;
    }

    public final void Q(Bundle bundle) {
        x.i("MicroMsg.WebViewUI", "setCustomMenu");
        ArrayList stringArrayList = bundle.getStringArrayList("keys");
        ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
        int size = stringArrayList.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.tencent.mm.k.d.b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
        }
        if (stringArrayList.size() > 0) {
            String url = this.pZJ.mhH.getUrl();
            if (WebViewUI.x(this.pZJ).containsKey(url)) {
                WebViewUI.x(this.pZJ).remove(url);
            }
            WebViewUI.x(this.pZJ).put(url, arrayList);
        }
    }

    public final void jX(boolean z) {
        this.pZJ.kd(z);
    }

    public final void fp(String str, String str2) {
        WebViewUI.a(this.pZJ).post(new 50(this, str, str2));
    }
}
