package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Map.Entry;

public class BindMobileStatusUI extends MMWizardActivity {
    private SharedPreferences duR;
    private ImageView eFS;
    private TextView eGJ;
    private ImageView eGK;
    private ImageView eGL;
    private Boolean eGM = Boolean.valueOf(true);
    private Boolean eGN = Boolean.valueOf(true);
    private RelativeLayout eGO;
    private RelativeLayout eGP;
    private BindWordingContent eGQ;
    private int eGR;
    private boolean eGS;
    private boolean eGT;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> eGU = new HashMap();
    private SparseArray<String> eGV = new SparseArray(3);
    private TextView eGm;
    private Button eGn;
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = q.GJ();
        this.eGV.put(8, "settings_find_me_by_mobile");
        this.eGV.put(7, "settings_recommend_mobilefriends_to_me");
        this.eGV.put(32, "settings_autoadd_mobilefriends");
        a(false, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
        a(false, ab.CTRL_BYTE, 7);
        setMMTitle(a$j.bind_mcontact_title_bind_finish);
        this.eGQ = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.eGR = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.eGS = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.eGT = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        initView();
    }

    protected final int getLayoutId() {
        return g.bind_mobile_status;
    }

    protected void onPause() {
        com.tencent.mm.kernel.g.Ei().DT().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.eGU.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            xt xtVar = new xt();
            xtVar.rDz = intValue;
            xtVar.rDA = intValue2;
            ((i) com.tencent.mm.kernel.g.l(i.class)).FQ().b(new a(23, xtVar));
            x.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.eGU.clear();
        super.onPause();
    }

    private boolean a(boolean z, int i, int i2) {
        x.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.eGU.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        String str = (String) this.eGV.get(i2);
        if (!(this.duR == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i2 == 8 || i2 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.duR.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        return true;
    }

    protected final void initView() {
        boolean z = true;
        this.eFS = (ImageView) findViewById(f.bind_m_contact_status_state_icon);
        this.eGJ = (TextView) findViewById(f.bind_m_contact_status_bind_state_title);
        this.eGm = (TextView) findViewById(f.bind_m_contact_status_bind_state_hint);
        this.eGn = (Button) findViewById(f.bind_m_contact_status_ok_btn);
        this.eGK = (ImageView) findViewById(f.bind_setttings_find_me_by_mobile);
        this.eGL = (ImageView) findViewById(f.bind_settings_recommend_friends_with_contacts);
        this.eGO = (RelativeLayout) findViewById(f.bind_m_contact_status_RL);
        this.eGP = (RelativeLayout) findViewById(f.bind_m_contact_status_RL1);
        switch (this.eGR) {
            case 0:
                boolean z2;
                this.eGO.setVisibility(8);
                this.eGP.setVisibility(8);
                if (this.eGS) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                a(z2, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
                if (this.eGT) {
                    z = false;
                }
                a(z, ab.CTRL_BYTE, 7);
                break;
            case 1:
                this.eGO.setVisibility(0);
                this.eGO.setBackgroundResource(e.bind_preference_one_item);
                this.eGP.setVisibility(8);
                break;
        }
        if (this.eGQ != null) {
            switch (this.eGQ.brl.intValue()) {
                case 2:
                    this.eGm.setVisibility(8);
                    break;
            }
        }
        this.eGn.setVisibility(8);
        addTextOptionMenu(0, getString(a$j.app_finish), new 1(this));
        if (l.XC() == l.a.eKt || l.XC() == l.a.eKu) {
            this.eFS.setImageResource(e.bind_mcontact_success);
            String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(6, null);
            if (str == null || str.equals("")) {
                com.tencent.mm.kernel.g.Ei().DT().get(4097, null);
            }
        } else {
            this.eFS.setImageResource(e.bind_mcontact_error);
            this.eGm.setVisibility(8);
            this.eGJ.setText(getString(a$j.bind_mcontact_bind_error));
        }
        this.eGK.setOnClickListener(new 2(this));
        this.eGL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                BindMobileStatusUI.this.eGN = Boolean.valueOf(!BindMobileStatusUI.this.eGN.booleanValue());
                if (BindMobileStatusUI.this.eGN.booleanValue()) {
                    BindMobileStatusUI.this.eGL.setImageResource(com.tencent.mm.plugin.account.a.i.checkbox_selected);
                } else {
                    BindMobileStatusUI.this.eGL.setImageResource(com.tencent.mm.plugin.account.a.i.checkbox_unselected);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.eGN.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.a(z, ab.CTRL_BYTE, 7);
                if (!BindMobileStatusUI.this.eGN.booleanValue()) {
                    BindMobileStatusUI.this.a(false, 2097152, 32);
                }
            }
        });
        this.eGn.setOnClickListener(new 4(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DT(1);
        return true;
    }

    public static void c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int GJ = q.GJ();
        GJ = z ? GJ | WXMediaMessage.TITLE_LENGTH_LIMIT : GJ & -513;
        com.tencent.mm.kernel.g.Ei().DT().set(7, Integer.valueOf(z2 ? GJ | ab.CTRL_BYTE : GJ & -257));
        xt xtVar = new xt();
        xtVar.rDz = 8;
        if (z2) {
            GJ = 1;
        } else {
            GJ = 2;
        }
        xtVar.rDA = GJ;
        ((i) com.tencent.mm.kernel.g.l(i.class)).FQ().b(new a(23, xtVar));
        xt xtVar2 = new xt();
        xtVar2.rDz = 7;
        if (!z) {
            i = 2;
        }
        xtVar.rDA = i;
        ((i) com.tencent.mm.kernel.g.l(i.class)).FQ().b(new a(23, xtVar2));
        com.tencent.mm.plugin.account.a.a.ezo.vl();
    }
}
