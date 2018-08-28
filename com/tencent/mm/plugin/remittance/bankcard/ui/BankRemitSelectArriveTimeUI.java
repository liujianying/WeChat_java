package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectArriveTimeUI extends MMPreference {
    private f eOE;
    private List<EnterTimeParcel> mwp;
    private List<Preference> mwq;
    private int mwr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.bank_remit_common_bg)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a$f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.black));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.bank_remit_common_bg));
        }
        BankRemitBaseUI.E(this);
        this.mController.contentView.setFitsSystemWindows(true);
        setMMTitle(i.bank_remit_select_arrive_time_title);
        this.mwp = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
        this.mwr = getIntent().getIntExtra("key_select_arrive_time", -1);
        initView();
        findViewById(16908298).setBackgroundColor(getResources().getColor(c.bank_remit_common_bg));
        setBackBtn(new 1(this), a$h.actionbar_icon_dark_back);
    }

    protected final void initView() {
        this.eOE = this.tCL;
        if (this.mwp != null && this.mwp.size() > 0) {
            this.mwq = new ArrayList();
            for (int i = 0; i < this.mwp.size(); i++) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) this.mwp.get(i);
                x.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", new Object[]{Integer.valueOf(enterTimeParcel.mun)});
                Preference preference = new Preference(this);
                preference.setLayoutResource(a$g.bank_remit_select_arrive_preference);
                preference.tDr = false;
                preference.setKey(enterTimeParcel.mun);
                preference.setTitle(enterTimeParcel.muo);
                if (enterTimeParcel.mun == this.mwr) {
                    preference.setWidgetLayoutResource(a$g.mm_preference_radio_checked);
                } else {
                    preference.setWidgetLayoutResource(a$g.mm_preference_radio_unchecked);
                }
                if (enterTimeParcel.muq == 0) {
                    if (!bi.oW(enterTimeParcel.mup)) {
                        preference.setSummary(enterTimeParcel.mup);
                    }
                    preference.setEnabled(false);
                }
                preference.getExtras().putParcelable("arrive_time", enterTimeParcel);
                this.eOE.a(preference);
                this.mwq.add(preference);
            }
        }
    }

    public final int Ys() {
        return a$g.bank_remit_select_arrive_time_ui;
    }

    public final boolean a(f fVar, Preference preference) {
        for (Preference preference2 : this.mwq) {
            if (preference2 == preference) {
                preference2.setWidgetLayoutResource(a$g.mm_preference_radio_checked);
            } else {
                preference2.setWidgetLayoutResource(a$g.mm_preference_radio_unchecked);
            }
        }
        this.eOE.notifyDataSetChanged();
        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) preference.getExtras().getParcelable("arrive_time");
        if (enterTimeParcel == null) {
            x.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_enter_time_scene", enterTimeParcel.mun);
            setResult(-1, intent);
            finish();
        }
        return false;
    }
}
