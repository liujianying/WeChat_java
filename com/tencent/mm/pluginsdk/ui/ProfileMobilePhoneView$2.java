package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;

class ProfileMobilePhoneView$2 implements OnItemClickListener {
    final /* synthetic */ String hGV;
    final /* synthetic */ ProfileMobilePhoneView qGt;
    final /* synthetic */ k qGu;

    ProfileMobilePhoneView$2(ProfileMobilePhoneView profileMobilePhoneView, k kVar, String str) {
        this.qGt = profileMobilePhoneView;
        this.qGu = kVar;
        this.hGV = str;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.qGu != null) {
            this.qGu.dismiss();
        }
        Intent intent;
        if (i == 0) {
            h hVar;
            Integer[] numArr;
            Object[] objArr;
            int i2;
            Integer[] numArr2;
            Integer[] numArr3;
            if (bi.oW(this.qGt.qGi)) {
                hVar = h.mEJ;
                numArr3 = new Object[1];
                numArr = numArr3;
                objArr = numArr3;
            } else {
                hVar = h.mEJ;
                numArr3 = new Object[1];
                Integer[] numArr4;
                if (this.qGt.qGi.equals(this.hGV.trim())) {
                    i2 = 1;
                    numArr2 = numArr3;
                    numArr4 = numArr3;
                    numArr2[0] = Integer.valueOf(i2);
                    hVar.h(12043, objArr);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse("tel:" + this.hGV));
                    this.qGt.getContext().startActivity(intent);
                }
                numArr = numArr3;
                numArr4 = numArr3;
            }
            i2 = 0;
            numArr2 = numArr;
            numArr2[0] = Integer.valueOf(i2);
            hVar.h(12043, objArr);
            intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("tel:" + this.hGV));
            try {
                this.qGt.getContext().startActivity(intent);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
            }
        } else if (1 == i) {
            h.mEJ.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            intent = new Intent();
            intent.putExtra("IPCallTalkUI_phoneNumber", this.hGV);
            d.b(ProfileMobilePhoneView.a(this.qGt), "ipcall", ".ui.IPCallDialUI", intent);
        }
    }
}
