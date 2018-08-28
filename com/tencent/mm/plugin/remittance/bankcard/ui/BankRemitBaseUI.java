package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.reflect.Field;

public abstract class BankRemitBaseUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aWd();
        setBackBtn(new 1(this));
    }

    protected void aWd() {
        x.i("BankRemitBase", "ret: %s", new Object[]{Integer.valueOf(E(this))});
        this.mController.contentView.setFitsSystemWindows(true);
    }

    public static int E(Activity activity) {
        if (VERSION.SDK_INT < 19) {
            return 0;
        }
        if (VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(8192);
            return 3;
        } else if (F(activity)) {
            return 1;
        } else {
            if (e(activity.getWindow())) {
                return 2;
            }
            return 0;
        }
    }

    private static boolean e(Window window) {
        if (window != null) {
            try {
                LayoutParams attributes = window.getAttributes();
                Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
                window.setAttributes(attributes);
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    private static boolean F(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return false;
        }
        Class cls = window.getClass();
        try {
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
            try {
                if (VERSION.SDK_INT < 23) {
                    return true;
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(8192);
                return true;
            } catch (Exception e) {
                return true;
            }
        } catch (Exception e2) {
            return false;
        }
    }
}
