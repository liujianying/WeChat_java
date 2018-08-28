package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class e {

    /* renamed from: com.tencent.mm.plugin.account.ui.e$1 */
    static class AnonymousClass1 implements c {
        final /* synthetic */ int eQw;
        final /* synthetic */ Context val$context;

        AnonymousClass1(int i, Context context) {
            this.eQw = i;
            this.val$context = context;
        }

        public final void a(l lVar) {
            if ((this.eQw & 1) != 0) {
                lVar.e(1, this.val$context.getString(j.reg_forgetpwd_byqq));
            }
            if ((this.eQw & 2) != 0) {
                lVar.e(2, this.val$context.getString(j.reg_forgetpwd_weixin));
            }
            if ((this.eQw & 4) != 0) {
                lVar.e(4, this.val$context.getString(j.reg_forgetpwd_bymobile));
            }
            if ((this.eQw & 8) > 0) {
                lVar.e(8, this.val$context.getString(j.wechat_safe_center));
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.e$2 */
    static class AnonymousClass2 implements d {
        final /* synthetic */ String eQx = null;
        final /* synthetic */ String eQy = null;
        final /* synthetic */ String eQz = null;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            StringBuilder stringBuilder;
            String str;
            switch (menuItem.getItemId()) {
                case 1:
                    a.pU("F100_100_QQ");
                    stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_QQ,");
                    g.Eg();
                    a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("F100_100_QQ")).append(",1").toString());
                    e.O(this.val$context, this.val$context.getString(j.url_getqqpassword));
                    return;
                case 2:
                    a.pU("F100_100_Email");
                    stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.val$context.getClass().getName()).append(",F100_100_Email,");
                    g.Eg();
                    a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("F100_100_Email")).append(",1").toString());
                    e.O(this.val$context, this.val$context.getString(j.login_forget_password_help) + w.chP());
                    return;
                case 4:
                    Context context = this.val$context;
                    String str2 = this.eQx;
                    str = this.eQy;
                    String str3 = this.eQz;
                    a.pU("F100_100_phone");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    g.Eg();
                    stringBuilder2 = stringBuilder2.append(com.tencent.mm.kernel.a.DA()).append(",").append(context.getClass().getName()).append(",F100_100_phone,");
                    g.Eg();
                    a.d(true, stringBuilder2.append(com.tencent.mm.kernel.a.gd("F100_100_phone")).append(",1").toString());
                    if (com.tencent.mm.protocal.d.qVQ) {
                        Toast.makeText(context, context.getString(j.alpha_version_tip_login), 0).show();
                        return;
                    }
                    Intent intent = new Intent(context, MobileInputUI.class);
                    if (str != null) {
                        int indexOf = str.indexOf("+");
                        if (indexOf != -1 && str.length() > 0) {
                            str = str.substring(indexOf + 1);
                        }
                        intent.putExtra("couttry_code", str);
                    }
                    if (str2 != null) {
                        intent.putExtra("country_name", str2);
                    }
                    if (str3 != null) {
                        intent.putExtra("bindmcontact_shortmobile", str3);
                    }
                    intent.putExtra("mobile_input_purpose", 1);
                    context.startActivity(intent);
                    return;
                case 8:
                    str = this.val$context.getString(j.wechat_securiy_center_path);
                    if (w.chP().equals("zh_CN")) {
                        str = str + "zh_CN";
                    } else {
                        str = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                    }
                    e.O(this.val$context, str);
                    return;
                default:
                    return;
            }
        }
    }

    public static void O(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        intent.putExtra("KFromLoginHistory", false);
        com.tencent.mm.bg.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
