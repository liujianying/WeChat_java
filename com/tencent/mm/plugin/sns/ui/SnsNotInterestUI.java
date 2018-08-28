package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.HashMap;

public class SnsNotInterestUI extends MMPreference implements e {
    private static final String[] nYI = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] nYJ = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] nYN = new int[]{i$j.sns_expose_reason_not_fav, i$j.sns_expose_reason_too_freq_him, i$j.sns_expose_reason_too_many_same_content, i$j.sns_expose_reason_marketing, i$j.sns_expose_reason_content_sexy, i$j.sns_expose_reason_rumour, i$j.sns_expose_reason_other};
    private p fUo = null;
    private f gua;
    private String mbI = null;
    private HashMap<String, Boolean> nYK = new HashMap(nYI.length);
    private HashMap<Integer, Boolean> nYL = new HashMap(nYJ.length);
    private HashMap<String, Integer> nYM = new HashMap(nYJ.length);
    private TextView nYO;
    private EditText nYP;
    private ListView nYQ;
    private LinearLayout nYR;
    private int nYS;
    private int nYT;
    private long nYU;
    private boolean nYV = false;
    private boolean nYW = false;
    r nYX = null;

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        snsNotInterestUI.nYT = 0;
        for (Integer intValue : snsNotInterestUI.nYL.keySet()) {
            int intValue2 = intValue.intValue();
            if (((Boolean) snsNotInterestUI.nYL.get(Integer.valueOf(intValue2))).booleanValue()) {
                if (snsNotInterestUI.nYT == 0) {
                    snsNotInterestUI.nYT = intValue2;
                } else {
                    snsNotInterestUI.nYT |= intValue2;
                }
            }
        }
        if (snsNotInterestUI.nYU != 0 && snsNotInterestUI.nYS != 0) {
            ActionBarActivity actionBarActivity = snsNotInterestUI.mController.tml;
            snsNotInterestUI.getString(i$j.app_tip);
            snsNotInterestUI.fUo = h.a(actionBarActivity, snsNotInterestUI.getString(i$j.app_waiting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.Ek();
                    g.Eh().dpP.c(SnsNotInterestUI.this.nYX);
                }
            });
            x.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", new Object[]{Long.valueOf(snsNotInterestUI.nYU), Integer.valueOf(snsNotInterestUI.nYS), Integer.valueOf(snsNotInterestUI.nYT), Boolean.valueOf(snsNotInterestUI.nYW)});
            snsNotInterestUI.nYX = new r(snsNotInterestUI.nYU, snsNotInterestUI.nYS, snsNotInterestUI.nYT, snsNotInterestUI.nYW ? snsNotInterestUI.nYP.getText().toString() : null);
            g.Ek();
            g.Eh().dpP.a(snsNotInterestUI.nYX, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nYS = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.nYU = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.nYU != 0) {
            String str = af.byo().fi(this.nYU).field_userName;
            if (str != null) {
                g.Ek();
                ab Yf = ((i) g.l(i.class)).FR().Yf(str);
                if (Yf.sex == 2) {
                    nYN[1] = i$j.sns_expose_reason_too_freq_her;
                } else if (Yf.sex == 1) {
                    nYN[1] = i$j.sns_expose_reason_too_freq_him;
                }
            }
        }
        g.Ek();
        g.Eh().dpP.a(218, this);
        bDE();
        initView();
    }

    private void bDE() {
        int i = 0;
        for (Object put : nYI) {
            this.nYK.put(put, Boolean.valueOf(false));
        }
        for (int valueOf : nYJ) {
            this.nYL.put(Integer.valueOf(valueOf), Boolean.valueOf(false));
        }
        while (i < nYJ.length) {
            this.nYM.put(nYI[i], Integer.valueOf(nYJ[i]));
            i++;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        bDE();
        g.Ek();
        g.Eh().dpP.b(218, this);
        gc gcVar = new gc();
        gcVar.bPk.bPl = this.nYV;
        gcVar.bPk.bPm = this.nYU;
        a.sFg.m(gcVar);
    }

    protected final void initView() {
        super.initView();
        setMMTitle(i$j.sns_expose_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.this.finish();
                return true;
            }
        });
        this.nYO = (TextView) findViewById(i$f.sns_expose_input_hint);
        this.nYP = (EditText) findViewById(i$f.sns_expose_other_input);
        this.nYQ = (ListView) findViewById(16908298);
        this.nYR = (LinearLayout) findViewById(i$f.expose_layout);
        this.nYR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsNotInterestUI.this.nYR.requestFocus();
                SnsNotInterestUI.this.YC();
            }
        });
        this.nYP.setVisibility(8);
        this.nYO.setVisibility(8);
        this.gua = this.tCL;
        if (this.gua == null) {
            x.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
        } else {
            if (this.gua.ZZ("sns_expose_desc") == null) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(i$j.sns_expose_desc);
                preferenceTitleCategory.setKey("sns_expose_desc");
                this.gua.a(preferenceTitleCategory);
            }
            for (int i = 0; i < nYI.length; i++) {
                String str = nYI[i];
                int i2 = nYN[i];
                if (this.gua.ZZ(str) == null) {
                    Preference preference = new Preference(this);
                    preference.setTitle(i2);
                    preference.setKey(str);
                    preference.setLayoutResource(i$g.mm_preference);
                    preference.setWidgetLayoutResource(i$g.mm_preference_checkbox_unchecked);
                    this.gua.a(preference);
                }
            }
        }
        a(0, getString(i$j.biz_report_send), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.b(SnsNotInterestUI.this);
                return true;
            }
        }, b.tmX);
        enableOptionMenu(0, false);
    }

    protected final int getLayoutId() {
        return i$g.sns_expose_ui;
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference == null) {
            return false;
        }
        String str = preference.mKey;
        if (!this.nYK.containsKey(str)) {
            return false;
        }
        boolean z;
        boolean booleanValue = ((Boolean) this.nYK.get(str)).booleanValue();
        if (booleanValue) {
            preference.setWidgetLayoutResource(i$g.mm_preference_checkbox_unchecked);
        } else {
            preference.setWidgetLayoutResource(i$g.mm_preference_checkbox_checked);
        }
        fVar.notifyDataSetChanged();
        if (booleanValue) {
            z = false;
        } else {
            z = true;
        }
        this.nYK.put(str, Boolean.valueOf(z));
        this.nYL.put(Integer.valueOf(((Integer) this.nYM.get(str)).intValue()), Boolean.valueOf(z));
        x.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[]{str, Integer.valueOf(r0), Boolean.valueOf(z)});
        for (Boolean booleanValue2 : this.nYK.values()) {
            if (booleanValue2.booleanValue()) {
                booleanValue = true;
                break;
            }
        }
        booleanValue = false;
        if (booleanValue) {
            enableOptionMenu(0, true);
        } else {
            enableOptionMenu(0, false);
        }
        if (z && str.equals("sns_expose_reason_other")) {
            this.nYP.setVisibility(0);
            this.nYO.setVisibility(0);
            this.nYP.requestFocus();
            this.nYW = true;
            showVKB();
        } else if (((Boolean) this.nYK.get("sns_expose_reason_other")).booleanValue()) {
            this.nYQ.requestFocus();
            YC();
        } else {
            this.nYP.setVisibility(8);
            this.nYO.setVisibility(8);
            this.nYQ.requestFocus();
            this.nYW = false;
            YC();
        }
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (lVar.getType() == 218) {
            this.fUo.dismiss();
            this.fUo = null;
            if (((r) lVar).type != 9) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.nYV = true;
                Toast.makeText(this, i$j.sns_expose_success, 1).show();
                finish();
                return;
            }
            this.nYV = false;
            Toast.makeText(this, i$j.sns_expose_failed, 1).show();
        }
    }
}
