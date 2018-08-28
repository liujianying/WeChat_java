package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.v;

public final class a {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    public static void a(EditHintPasswdView editHintPasswdView) {
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(1);
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView, boolean z) {
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(z ? -10 : 20);
        }
    }

    public static void b(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.setLogicDelegate(new 1());
        }
    }

    public static void a(MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.setLogicDelegate(new 3());
        b.f(mMActivity, walletFormView);
        walletFormView.setOnInfoIvClickListener(new 4(walletFormView, mMActivity));
    }

    public static void b(final MMActivity mMActivity, final WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.setOnInfoIvClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    walletFormView.getContext();
                    b.a(mMActivity, v.cDp(), i.cvv_tip_title);
                }
            });
        }
    }

    public static void c(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.setLogicDelegate(new a(walletFormView, (byte) 0));
        }
    }

    public static void d(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.setLogicDelegate(new a(walletFormView));
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    }

    public static void e(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.setLogicDelegate(new 6());
        }
    }

    public static void c(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.a(mMActivity, g.wallet_phone_illustration_dialog, i.wallet_card_phone_illustraction);
            }
        });
        walletFormView.setLogicDelegate(new 8());
    }

    public static void d(MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.setOnInfoIvClickListener(new 9(mMActivity));
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    }

    public static void e(MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.setOnInfoIvClickListener(new 10(mMActivity));
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    }

    public static void f(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.setLogicDelegate(new 2());
        }
    }

    public static void g(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.setIsSecretAnswer(true);
        }
    }
}
