package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI extends MMPreference implements e {
    private f eOE;
    private boolean nZp = false;
    private ab nZq = null;
    private boolean nZr = false;
    private boolean nZs = false;
    private long nZt = 0;
    private int scene = 0;
    public p tipDialog = null;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Ek();
        g.Eh().dpP.a(291, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.nZp = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.nZt = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        x.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[]{Integer.valueOf(this.scene)});
        g.Ek();
        this.nZq = ((i) g.l(i.class)).FR().Yg(this.userName);
        if (this.nZq == null) {
            x.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[]{this.userName});
            finish();
        }
        this.nZq.setUsername(this.userName);
        initView();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        a.ezo.vl();
        g.Ek();
        g.Eh().dpP.b(291, this);
        if (this.nZt != 0 && this.nZt != -1) {
            pv pvVar = new pv();
            pvVar.caA.caB = this.nZs;
            pvVar.caA.bPm = this.nZt;
            com.tencent.mm.sdk.b.a.sFg.m(pvVar);
        }
    }

    public final int Ys() {
        return m.sns_premission;
    }

    protected final void initView() {
        this.eOE = this.tCL;
        setMMTitle(j.sns_permiss);
        setBackBtn(new 1(this));
        btU();
    }

    private void btU() {
        g.Ek();
        this.nZq = ((i) g.l(i.class)).FR().Yg(this.userName);
        this.nZq.setUsername(this.userName);
        boolean BF = this.nZq.BF();
        boolean Lz = Lz(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("sns_outside_permiss");
        checkBoxPreference.qpJ = BF;
        int i = this.nZq.sex;
        x.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            checkBoxPreference.setTitle(j.sns_outside_permiss_male);
        } else if (i == 2) {
            checkBoxPreference.setTitle(j.sns_outside_permiss_female);
        }
        checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("sns_black_permiss");
        if (i == 1) {
            checkBoxPreference.setTitle(j.sns_black_permiss_male);
        } else if (i == 2) {
            checkBoxPreference.setTitle(j.sns_black_permiss_female);
        }
        checkBoxPreference.qpJ = Lz;
        if (!com.tencent.mm.l.a.gd(this.nZq.field_type)) {
            this.eOE.aaa("sns_black_permiss");
        }
        this.eOE.notifyDataSetChanged();
    }

    private static boolean Lz(String str) {
        t fk = af.byu().fk(5);
        if (bi.oW(fk.field_memberList)) {
            return false;
        }
        return bi.F(fk.field_memberList.split(",")).contains(str);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + lVar.getType());
        if (lVar.getType() == 291) {
            x.d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.tipDialog == null));
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            btU();
            if (this.nZr) {
                this.nZs = true;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        qg qgVar;
        if (str.equals("sns_outside_permiss")) {
            qgVar = new qg();
            qgVar.caP.caR = true;
            qgVar.caP.caQ = false;
            qgVar.caP.username = this.userName;
            com.tencent.mm.sdk.b.a.sFg.m(qgVar);
            if (this.nZq.BF()) {
                s.k(this.nZq);
            } else {
                s.j(this.nZq);
            }
            return true;
        } else if (!str.equals("sns_black_permiss")) {
            return false;
        } else {
            int i;
            qgVar = new qg();
            qgVar.caP.caR = false;
            qgVar.caP.caQ = true;
            qgVar.caP.username = this.userName;
            com.tencent.mm.sdk.b.a.sFg.m(qgVar);
            boolean Lz = Lz(this.userName);
            String str2 = this.userName;
            if (Lz) {
                i = 2;
            } else {
                i = 1;
            }
            if (i == 1 && 5 == 5) {
                this.nZr = true;
                this.nZs = false;
            } else {
                this.nZr = false;
                this.nZs = false;
            }
            List linkedList = new LinkedList();
            linkedList.add(str2);
            w wVar = new w(i, 5, "", linkedList.size(), linkedList, this.scene);
            g.Ek();
            g.Eh().dpP.a(wVar, 0);
            getString(j.app_tip);
            this.tipDialog = h.a(this, getString(j.sns_tag_save), true, new 2(this, wVar));
            return true;
        }
    }
}
