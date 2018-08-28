package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int kjf;
    public String kjg;
    public int pCM = 0;

    private a(int i, String str) {
        this.kjf = i;
        this.kjg = str;
    }

    public static a aN(int i, String str) {
        int i2 = 6;
        int i3 = i.wxwallet_result_unknown;
        if (i > -15001) {
            switch (i) {
                case 0:
                    i3 = i.wxwallet_result_success;
                    i2 = i;
                    break;
                case 1:
                    i3 = i.wxwallet_result_user_canceled;
                    i2 = i;
                    break;
                case 3:
                case s$l.AppCompatTheme_radioButtonStyle /*105*/:
                    i2 = 3;
                    str = "Google Play not install";
                    break;
                case 6:
                    return new a(6, str);
                case s$l.AppCompatTheme_checkedTextViewStyle /*103*/:
                case 104:
                case 100000002:
                    i2 = 100000002;
                    i3 = i.wxwallet_result_item_already_owned;
                    break;
                case s$l.AppCompatTheme_ratingBarStyle /*106*/:
                case 100000001:
                    i3 = i.wxwallet_result_unknown;
                    break;
                case s$l.AppCompatTheme_seekBarStyle /*109*/:
                    i3 = i.wxwallet_result_wco_invalid_purchase;
                    i2 = i;
                    break;
                case s$l.AppCompatTheme_spinnerStyle /*110*/:
                    i3 = i.wxwallet_result_wco_invalid_purchase_quota_day;
                    i2 = i;
                    break;
                case s$l.AppCompatTheme_switchStyle /*111*/:
                    i3 = i.wxwallet_result_wco_invalid_purchase_quota_week;
                    i2 = i;
                    break;
                case 112:
                    i3 = i.wxwallet_result_wco_invalid_purchase_freq_limit;
                    i2 = i;
                    break;
                case 113:
                    i3 = i.wxwallet_result_unknown;
                    i2 = i;
                    break;
                default:
                    i3 = i.wxwallet_result_unknown;
                    break;
            }
        }
        i2 = i;
        x.i("MicroMsg.IapResult", "code : " + i + ", errMsg : " + str + ", convert to errCode : " + i2);
        if (bi.oW(str)) {
            return new a(i2, ad.getContext().getString(i3));
        }
        return new a(i2, str);
    }

    public final boolean bRc() {
        return this.kjf == 104 || this.kjf == 100000002;
    }

    public final boolean isFailure() {
        return ((this.kjf == 0) || bRc()) ? false : true;
    }

    public final String toString() {
        return "IapResult: " + this.kjg;
    }
}
