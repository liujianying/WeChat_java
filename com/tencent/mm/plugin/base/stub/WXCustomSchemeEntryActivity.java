package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> hed;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.hed = new ArrayList();
        this.hed.add("cardpackage");
        this.hed.add("connectToFreeWifi");
        this.hed.add("wap");
        super.onCreate(bundle);
        setTitleVisibility(0);
    }

    protected final int getLayoutId() {
        return R.i.biz_share_check;
    }

    protected final boolean A(Intent intent) {
        Uri data;
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            x.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[]{e.getMessage()});
            data = null;
        }
        if (data != null) {
            if (d.SA(data.toString())) {
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            x.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[]{data.toString(), scheme, host, query});
            if (!bi.oW(host) && this.hed.contains(host)) {
                x.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[]{host});
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[]{scheme});
                    if (!bi.oW(scheme) && scheme.length() < 1024) {
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!bi.oW(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[]{scheme});
                        if (!bi.oW(scheme) && scheme.length() < 1024) {
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    return true;
                }
            }
        }
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        switch (5.hdM[aVar.ordinal()]) {
            case 1:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    x.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[]{e.getMessage()});
                    data = null;
                }
                if (data != null) {
                    Object obj;
                    if (data != null) {
                        Bundle bundle;
                        int i = 2;
                        if (intent != null) {
                            i = s.a(intent, "translate_link_scene", 2);
                        }
                        int a = s.a(intent, "pay_channel", -1);
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(a)});
                        Bundle bundle2 = null;
                        if (a >= 0) {
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", new Object[]{Integer.valueOf(a)});
                            bundle2 = new Bundle();
                            bundle2.putInt("pay_channel", a);
                        }
                        String atC = atC();
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "packageName %s", new Object[]{atC});
                        if (bundle2 == null) {
                            bundle = new Bundle();
                        } else {
                            bundle = bundle2;
                        }
                        bundle.putString("pay_package", atC);
                        String host;
                        if (!d.SA(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            Object query = data.getQuery();
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[]{scheme, host, query});
                            if (!bi.oW(host) && this.hed.contains(host)) {
                                if (host.equals("cardpackage") && !bi.oW(data.getQueryParameter("encrystr"))) {
                                    intent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!bi.oW(query) && query.startsWith("apKey=")) {
                                        scheme = data.getQueryParameter("apKey");
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[]{scheme});
                                        String queryParameter = data.getQueryParameter("ticket");
                                        if (!bi.oW(scheme) && scheme.length() < 1024) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", scheme);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!bi.oW(queryParameter)) {
                                                intent2.putExtra("free_wifi_schema_ticket", queryParameter);
                                            }
                                            if (scheme.startsWith("_") || bi.oW(queryParameter)) {
                                                intent2.addFlags(67108864);
                                                com.tencent.mm.bg.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                gf gfVar = new gf();
                                                gfVar.bPr.intent = intent2;
                                                com.tencent.mm.sdk.b.a.sFg.m(gfVar);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        com.tencent.mm.bg.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY packageNameFrommThird %s", new Object[]{atC});
                                    if (!TextUtils.isEmpty(query)) {
                                        h.a((Context) this, com.tencent.mm.pluginsdk.e.a.SJ(query), false, atC);
                                    }
                                }
                            }
                        } else if (d.k(data)) {
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[]{data.toString(), Boolean.valueOf(d.l(data))});
                            if (d.l(data)) {
                                d.a(this, data.toString(), i, bundle, new 1(this));
                                obj = 1;
                                if (obj != null) {
                                    return;
                                }
                            }
                            d.a(this, data.toString(), i, bundle, new 2(this));
                        } else if (d.SB(data.toString())) {
                            if (i == 1) {
                                b ia = u.Hx().ia("key_data_center_session_id");
                                if (ia == null) {
                                    x.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                                    finish();
                                } else {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[]{ia.getString("key_package_name", ""), ia.getString("key_package_signature", ""), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature")});
                                    u.Hx().ib("key_data_center_session_id");
                                    if (!(ia.getString("key_package_name", "").equals(intent.getStringExtra("key_package_name")) && r0.equals(r6))) {
                                        x.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                                        finish();
                                    }
                                }
                            }
                            d.a(this, data.toString(), i, bundle, new 3(this), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            obj = 1;
                            if (obj != null) {
                                return;
                            }
                        } else {
                            host = q.GF();
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[]{data.toString()});
                            d.a(this, data.toString(), host, 23, data.toString(), new 4(this));
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return;
                    }
                }
                break;
        }
        finish();
    }

    private String atC() {
        if (!com.tencent.mm.compatible.util.d.fT(21)) {
            return "";
        }
        try {
            Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            return (String) declaredField.get(this);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WXCustomSchemeEntryActivity", e, "", new Object[0]);
            return "No referrer";
        }
    }
}
