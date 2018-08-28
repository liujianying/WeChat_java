package com.tencent.mm.plugin.subapp.ui.openapi;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI extends MMPreference implements e {
    private f eOE;
    private ServicePreference osP;
    private ServicePreference osQ;
    private PreferenceTitleCategory osR;
    private PreferenceTitleCategory osS;
    private List<com.tencent.mm.pluginsdk.model.app.f> osT = new ArrayList();
    private List<com.tencent.mm.pluginsdk.model.app.f> osU = new ArrayList();
    private OnItemClickListener osV;
    private OnItemClickListener osW;
    private String talker;

    public final int Ys() {
        return R.o.service_app_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        initView();
        if (this.osP != null) {
            this.osP.onResume();
        }
        if (this.osQ != null) {
            this.osQ.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.osP != null) {
            this.osP.onPause();
        }
        if (this.osQ != null) {
            this.osQ.onPause();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.service_app_list);
        this.talker = getIntent().getStringExtra("service_app_talker_user");
        setBackBtn(new 1(this));
        this.osT.clear();
        this.osU.clear();
        Cursor dh = s.fq(this.talker) ? ao.bmf().dh(0, 2) : s.hf(this.talker) ? ao.bmf().dh(0, 4) : ao.bmf().dh(0, 1);
        if (dh != null) {
            if (dh.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                    fVar.d(dh);
                    if (fVar.field_serviceAppType == 1) {
                        this.osT.add(fVar);
                    } else if (fVar.field_serviceAppType == 2) {
                        this.osU.add(fVar);
                    }
                } while (dh.moveToNext());
            }
            dh.close();
        }
        if (this.osV == null) {
            this.osV = new 2(this);
        }
        if (this.osW == null) {
            this.osW = new 3(this);
        }
        this.eOE = this.tCL;
        this.eOE.removeAll();
        if (this.osT.size() > 0) {
            this.osP = new ServicePreference(this);
            this.osP.mSx = this.osT;
            if (this.osV != null) {
                this.osP.osG = this.osV;
            }
            if (this.osR == null) {
                this.osR = new PreferenceTitleCategory(this);
                this.osR.setTitle(R.l.wx_service_app_list);
            }
            this.eOE.a(this.osR);
            this.eOE.a(this.osP);
        }
        if (this.osU.size() > 0) {
            this.osQ = new ServicePreference(this);
            this.osQ.mSx = this.osU;
            if (this.osW != null) {
                this.osQ.osG = this.osW;
            }
            if (this.osS == null) {
                this.osS = new PreferenceTitleCategory(this);
                this.osS.setTitle(R.l.biz_service_app_list);
            }
            this.eOE.a(this.osS);
            this.eOE.a(this.osQ);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
