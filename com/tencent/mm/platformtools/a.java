package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

public final class a {

    public enum a {
        ;

        public static int[] Vm() {
            return (int[]) evs.clone();
        }

        static {
            evo = 1;
            evp = 2;
            evq = 3;
            evr = 4;
            evs = new int[]{evo, evp, evq, evr};
        }
    }

    public static void b(Context context, String str, int i, boolean z) {
        boolean z2 = false;
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        String str2 = "neverGetA8Key";
        if (!z) {
            z2 = true;
        }
        intent.putExtra(str2, z2);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        if (i > 0) {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent, i);
        } else {
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static boolean F(Context context, String str) {
        if (str.length() > 16) {
            w(context, a.evp);
            return false;
        } else if (bi.WC(str)) {
            h.i(context, a$j.regbyfacebook_reg_setpwd_alert_using_chinese, a$j.regbymobile_reg_setpwd_alert_title);
            return false;
        } else if (bi.WH(str)) {
            return true;
        } else {
            if (str.length() < 8 || str.length() >= 16) {
                w(context, a.evq);
                return false;
            }
            w(context, a.evr);
            return false;
        }
    }

    private static void w(Context context, int i) {
        switch (1.evn[i - 1]) {
            case 1:
                h.i(context, a$j.regbymobile_reg_setpwd_alert_diff, a$j.regbymobile_reg_setpwd_alert_title);
                return;
            case 2:
                h.i(context, a$j.regbymobile_reg_setpwd_alert_more_byte, a$j.regbymobile_reg_setpwd_alert_title);
                return;
            case 3:
                h.i(context, a$j.verify_password_all_num_tip, a$j.app_err_reg_title);
                return;
            case 4:
                h.i(context, a$j.verify_password_tip, a$j.app_err_reg_title);
                return;
            default:
                return;
        }
    }
}
