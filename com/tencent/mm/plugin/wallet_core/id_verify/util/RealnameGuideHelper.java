package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.3;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.4;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.5;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public class RealnameGuideHelper implements Parcelable {
    public static final Creator<RealnameGuideHelper> CREATOR = new 1();
    private int eLd;
    private String kRs;
    private String kRt;
    private String kRu = "";
    private String kRv = "";
    private String kRw = "";
    private SetPwdInfo pkV;
    private boolean pkW = false;

    protected RealnameGuideHelper(Parcel parcel) {
        boolean z;
        this.pkV = (SetPwdInfo) parcel.readParcelable(SetPwdInfo.class.getClassLoader());
        this.kRs = parcel.readString();
        this.kRt = parcel.readString();
        this.kRu = parcel.readString();
        this.kRv = parcel.readString();
        this.kRw = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.pkW = z;
        this.eLd = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.pkV, i);
        parcel.writeString(this.kRs);
        parcel.writeString(this.kRt);
        parcel.writeString(this.kRu);
        parcel.writeString(this.kRv);
        parcel.writeString(this.kRw);
        parcel.writeByte((byte) (this.pkW ? 1 : 0));
        parcel.writeInt(this.eLd);
    }

    public int describeContents() {
        return 0;
    }

    public final void a(String str, SetPwdInfo setPwdInfo, String str2, String str3, String str4, String str5, int i) {
        this.pkV = setPwdInfo;
        this.kRs = str;
        this.kRt = str2;
        this.kRu = str3;
        this.kRv = str4;
        this.kRw = str5;
        this.eLd = i;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i) {
        a(str, null, str2, str3, str4, str5, i);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        x.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[]{this.pkV, Integer.valueOf(this.eLd), this.kRt, this.kRw, this.kRu, this.kRv, Boolean.valueOf(this.pkW), this.kRs});
        if (this.pkW) {
            return false;
        }
        if (this.pkV == null || this.pkV.plg != 1) {
            return false;
        }
        boolean z;
        int i = this.eLd;
        String str = this.pkV.kRt;
        String str2 = this.pkV.kRu;
        String str3 = this.pkV.kRv;
        g.Ek();
        int intValue = ((Integer) g.Ei().DT().get(a.sYy, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[]{Integer.valueOf(intValue)});
        if (intValue >= 3) {
            z = false;
        } else {
            intValue++;
            g.Ek();
            g.Ei().DT().a(a.sYy, Integer.valueOf(intValue));
            if (bi.oW(str2)) {
                str2 = mMActivity.getString(i.app_cancel);
            }
            if (bi.oW(str3)) {
                str3 = mMActivity.getString(i.app_ok);
            }
            c a = h.a((Context) mMActivity, str, "", str3, str2, new 3(bundle, i, mMActivity), onClickListener, com.tencent.mm.plugin.wxpay.a.c.wechat_green);
            if (a != null) {
                a.setOnCancelListener(new 4(mMActivity));
                a.setOnDismissListener(new 5(mMActivity));
            }
            z = true;
        }
        if (!z || this.pkW) {
            return z;
        }
        this.pkW = true;
        return z;
    }

    public final boolean b(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        return a(mMActivity, bundle, onClickListener, false);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener, boolean z) {
        if (this.pkW) {
            return false;
        }
        if ("1".equals(this.kRs)) {
            if (!this.pkW) {
                this.pkW = true;
            }
            return a.a(mMActivity, bundle, this.eLd);
        } else if (!"2".equals(this.kRs) || bi.oW(this.kRw)) {
            return false;
        } else {
            if (!this.pkW) {
                this.pkW = true;
            }
            return a.a(mMActivity, this.kRt, this.kRw, this.kRu, this.kRv, z, onClickListener);
        }
    }
}
