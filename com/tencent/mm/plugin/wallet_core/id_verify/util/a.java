package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.c;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class a implements e {
    int fdx = -1;
    private a pkX = null;
    WeakReference<MMActivity> pkY;
    WeakReference<com.tencent.mm.wallet_core.d.e> pkZ;
    private boolean pla = false;
    c plb;

    public final boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar, int i) {
        this.pla = false;
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sTd, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.ui.e.a(5, bi.VE(), i);
            if (currentTimeMillis < longValue) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = " + longValue);
                return false;
            }
            x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = " + longValue);
        }
        if (mMActivity == null) {
            x.e("MicroMsg.RealnameVerifyUtil", "context is null");
        } else if (eVar == null) {
            x.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
        }
        return false;
    }

    private void baV() {
        if (this.pkZ != null && this.pkZ.get() != null) {
            ((com.tencent.mm.wallet_core.d.e) this.pkZ.get()).baV();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            g.Ek();
            g.Eh().dpP.b(385, this);
            baV();
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.model.e eVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.e) lVar;
                boolean equals = eVar.pkH.equals("1");
                if (equals) {
                    x.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    b(0, i2, str, equals);
                    return;
                }
                a((MMActivity) this.pkY.get(), (com.tencent.mm.wallet_core.d.e) this.pkZ.get(), eVar.title, eVar.pkI, eVar.pkJ, eVar.pkK, this.pkX, false, eVar.pkL);
                return;
            }
            b(2, i2, str, false);
        } else if (lVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a) {
            g.Ek();
            g.Eh().dpP.a(385, this);
            baV();
            if (i == 0 && i2 == 0) {
                b(0, i2, str, true);
            } else {
                b(3, i2, str, false);
            }
        }
    }

    public final void a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar, String str, String str2, String str3, String str4, a aVar, boolean z, int i) {
        this.pkY = new WeakReference(mMActivity);
        this.pkZ = new WeakReference(eVar);
        this.pla = z;
        if (this.pkY != null && this.pkY.get() != null) {
            this.pkX = aVar;
            CharSequence charSequence = str + str2;
            h hVar = new h(mMActivity);
            hVar.pvm = new 1(this, i, str3, mMActivity);
            charSequence = j.a(mMActivity, charSequence);
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(hVar, charSequence.length() - str2.length(), charSequence.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) com.tencent.mm.bp.a.ad(mMActivity, d.HintTextSize));
            textView.setTextColor(mMActivity.getResources().getColorStateList(com.tencent.mm.plugin.wxpay.a.c.normal_text_color));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            com.tencent.mm.wallet_core.ui.e.a(0, bi.VE(), i);
            this.plb = com.tencent.mm.ui.base.h.a(mMActivity, "", textView, str4, mMActivity.getString(i.app_cancel), new 6(this, i), new 7(this, i));
        }
    }

    final void b(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.pkX != null) {
            g.Ek();
            g.Ei().DT().a(com.tencent.mm.storage.aa.a.sTe, Integer.valueOf(z ? 0 : 1));
            this.pkX.a(i, i2, str, z);
            if (this.plb != null) {
                this.plb.dismiss();
            }
            this.pla = false;
            if (this.plb != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
                this.plb = null;
            }
            if (this.pkZ != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
                this.pkZ.clear();
                this.pkZ = null;
            }
            if (this.pkY != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
                this.pkY.clear();
                this.pkY = null;
            }
            x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
            this.pkX = null;
        }
    }

    private static JSONObject p(l lVar) {
        if (lVar != null && (lVar instanceof com.tencent.mm.wallet_core.tenpay.model.i)) {
            b bVar = ((com.tencent.mm.wallet_core.tenpay.model.i) lVar).diG;
            if (bVar != null) {
                bsr bsr = (bsr) bVar.dIE.dIL;
                if (bsr.rPv != null) {
                    try {
                        return new JSONObject(ab.b(bsr.rPv));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity, int i, l lVar, Bundle bundle, int i2) {
        if (i != 416) {
            x.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            return false;
        }
        x.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        return b(activity, lVar, bundle, false, i2);
    }

    public static boolean b(Activity activity, l lVar, Bundle bundle, boolean z, int i) {
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject p = p(lVar);
        if (p != null) {
            if (p.has("real_name_info")) {
                p = p.optJSONObject("real_name_info");
            }
            str2 = p.optString("guide_flag", "0");
            str3 = p.optString("guide_wording");
            str4 = p.optString("left_button_wording", activity.getString(i.app_cancel));
            str5 = p.optString("right_button_wording", activity.getString(i.app_ok));
            str6 = p.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        x.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        if ("1".equals(str)) {
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            return a(activity, bundle, i);
        } else if (!"2".equals(str) || bi.oW(str6)) {
            x.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bi.oW(str6));
            return false;
        } else {
            x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            return a(activity, str3, str6, str4, str5, z, null);
        }
    }

    public static boolean a(Activity activity, Bundle bundle, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[]{Integer.valueOf(0)});
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        com.tencent.mm.wallet_core.ui.e.a(19, bi.VE(), i);
        return true;
    }

    public static boolean a(Activity activity, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener 8;
        if (bi.oW(str3)) {
            string = activity.getString(i.app_cancel);
        } else {
            string = str3;
        }
        if (bi.oW(str4)) {
            string2 = activity.getString(i.app_ok);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            8 = new 8(z, activity);
        } else {
            8 = onClickListener;
        }
        c a = com.tencent.mm.ui.base.h.a(activity, str, "", string2, string, new 9(str2, activity, z), 8, com.tencent.mm.plugin.wxpay.a.c.wechat_green);
        if (a != null) {
            a.setOnCancelListener(new 10(z, activity));
            a.setOnDismissListener(new 2(z, activity));
        }
        return true;
    }
}
