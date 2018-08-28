package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.mm.R;
import com.tencent.mm.aq.j;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SpecialCheckBoxPreference extends Preference {
    private boolean bSD;
    private String fsV;
    private boolean hEj = false;
    private boolean hLj;
    private ab ipd;
    private Context mContext;
    private ToggleButton qPA;
    private ToggleButton qPB;
    private ToggleButton qPC;
    private OnCheckedChangeListener qPD = new 1(this);

    static /* synthetic */ void a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.ipd != null) {
            au.HU();
            if (c.FW().Yx(specialCheckBoxPreference.ipd.field_username)) {
                s.u(specialCheckBoxPreference.ipd.field_username, true);
            } else {
                s.t(specialCheckBoxPreference.ipd.field_username, true);
            }
        }
    }

    static /* synthetic */ void b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i = 0;
        specialCheckBoxPreference.hEj = !specialCheckBoxPreference.hEj;
        if (specialCheckBoxPreference.bSD) {
            if (!specialCheckBoxPreference.hEj) {
                i = 1;
            }
            au.HU();
            c.FQ().b(new j(specialCheckBoxPreference.fsV, i));
            specialCheckBoxPreference.ipd.eN(i);
            au.HU();
            c.FR().a(specialCheckBoxPreference.fsV, specialCheckBoxPreference.ipd);
        }
        specialCheckBoxPreference.cfh();
    }

    static /* synthetic */ void c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.ipd == null) {
            return;
        }
        if (a.gd(specialCheckBoxPreference.ipd.field_type)) {
            specialCheckBoxPreference.ipd.Bc();
            s.t(specialCheckBoxPreference.ipd);
            h.bA(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.room_remove_from_group_card_ok));
            return;
        }
        s.q(specialCheckBoxPreference.ipd);
        h.bA(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.room_save_to_group_card_ok));
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.qPA = (ToggleButton) view.findViewById(R.h.room_placed_to_the_top);
        this.qPB = (ToggleButton) view.findViewById(R.h.room_notify_new_msg);
        this.qPC = (ToggleButton) view.findViewById(R.h.room_save_to_contact);
        this.fsV = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.bSD = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.hLj = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        au.HU();
        this.ipd = c.FR().Yg(this.fsV);
        if (this.ipd != null) {
            ToggleButton toggleButton = this.qPA;
            au.HU();
            toggleButton.setChecked(c.FW().Yx(this.ipd.field_username));
            this.qPC.setChecked(a.gd(this.ipd.field_type));
            this.qPB.setChecked(cfh());
        }
        this.qPA.setOnCheckedChangeListener(this.qPD);
        this.qPB.setOnCheckedChangeListener(this.qPD);
        this.qPC.setOnCheckedChangeListener(this.qPD);
    }

    private boolean cfh() {
        if (this.bSD) {
            this.hEj = this.ipd.csI == 0;
        } else if (!this.hLj) {
            this.hEj = this.ipd.BD();
        }
        if (!(this.mContext instanceof MMActivity)) {
            return false;
        }
        if (this.hEj) {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(0);
            return true;
        }
        ((MMActivity) this.mContext).setTitleMuteIconVisibility(8);
        return false;
    }
}
