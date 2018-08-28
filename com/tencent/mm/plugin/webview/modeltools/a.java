package com.tencent.mm.plugin.webview.modeltools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class a {
    public static void d(MMActivity mMActivity, String str) {
        if (mMActivity != null && !mMActivity.isFinishing() && !bi.oW(str)) {
            if (!(str.startsWith("http://") || str.startsWith("https://"))) {
                str = "http://" + str;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            try {
                if (bi.fU(mMActivity)) {
                    mMActivity.startActivity(intent);
                } else {
                    mMActivity.startActivityForResult(a(mMActivity, intent, str), 2);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[]{e.getMessage()});
            }
        }
    }

    public static Intent a(MMActivity mMActivity, Intent intent, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("targeturl", str);
        bundle.putParcelable("targetintent", intent);
        Intent intent2 = new Intent();
        intent2.setClass(mMActivity, AppChooserUI.class);
        intent2.putExtra("scene", 4);
        intent2.putExtra("type", 0);
        intent2.putExtra("title", mMActivity.getString(R.l.choose_browser));
        intent2.putExtra("targetintent", intent);
        intent2.putExtra("transferback", bundle);
        return intent2;
    }

    public static boolean b(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (2 != i) {
            return false;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
            x.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[]{stringExtra});
            s.cbA();
            o oVar = (o) s.v(0, null);
            Intent intent2;
            if (oVar.SK(stringExtra)) {
                if (oVar.eM(mMActivity)) {
                    o.bf(mMActivity, bundleExtra.getString("targeturl"));
                } else {
                    intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                    intent2.setPackage(stringExtra);
                    intent2.addFlags(524288);
                    mMActivity.startActivity(intent2);
                }
                if (booleanExtra) {
                    h.mEJ.h(10998, new Object[]{Integer.valueOf(4), Integer.valueOf(2)});
                } else {
                    h.mEJ.h(10998, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                }
            } else {
                intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                intent2.setPackage(stringExtra);
                intent2.addFlags(524288);
                mMActivity.startActivity(intent2);
                h.mEJ.h(10998, new Object[]{Integer.valueOf(5)});
                if (booleanExtra) {
                    h.mEJ.h(10998, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
                } else {
                    h.mEJ.h(10998, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                }
            }
        }
        return true;
    }
}
