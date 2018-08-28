package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI extends MMPreference implements e, b {
    protected String bKg = "";
    protected f eOE;
    protected ContactListExpandPreference hLp;
    protected List<String> jzp = new ArrayList();
    protected long noJ;
    protected String obG = "";
    private boolean obH = false;
    protected a obI = new 9(this);
    protected int scene = 0;
    protected p tipDialog = null;

    static /* synthetic */ void a(SnsTagDetailUI snsTagDetailUI) {
        String c = bi.c(snsTagDetailUI.jzp, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(j.address_title_select_contact));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.s(new int[]{s.ukF, 1024}));
        intent.putExtra("always_select_contact", c);
        d.b(snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void bCV() {
        x.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        g.Ek();
        g.Eh().dpP.a(290, this);
        g.Ek();
        g.Eh().dpP.a(291, this);
        g.Ek();
        g.Eh().dpP.a(com.tencent.mm.plugin.appbrand.jsapi.audio.j.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.a(293, this);
        g.Ek();
        ((i) g.l(i.class)).FR().a(this);
        if (af.byu().bBG().size() == 0) {
            g.Ek();
            g.Eh().dpP.a(new v(1), 0);
            this.obH = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bCV();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.noJ = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.noJ == 4) {
            this.obG = getString(j.sns_tag_outsiders);
        } else if (this.noJ == 5) {
            this.obG = getString(j.sns_tag_snsblack);
        } else {
            this.obG = af.byu().fk(this.noJ).field_tagName;
        }
        if (this.noJ == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.obG = bi.aG(getIntent().getStringExtra("k_sns_tag_name"), "");
            ay byc = af.byc();
            String GF = q.GF();
            List<String> F = bi.F(stringExtra.split(","));
            if (F != null) {
                for (String stringExtra2 : F) {
                    if (!(this.jzp.contains(stringExtra2) || !com.tencent.mm.l.a.gd(byc.Yg(stringExtra2).field_type) || GF.equals(stringExtra2))) {
                        this.jzp.add(stringExtra2);
                    }
                }
            }
        } else {
            this.jzp = bCY();
        }
        if (this.obG == null || this.obG.equals("")) {
            this.obG = getString(j.sns_tag_name_unknow);
            this.obG = aj.Mm(getString(j.sns_tag_name_unknow));
        }
        initView();
        bDN();
        updateTitle();
        if (this.noJ < 6) {
            this.eOE.aaa("delete_tag_name");
            this.eOE.aaa("delete_tag_name_category");
            if (this.noJ > 0) {
                this.eOE.aaa("settings_tag_name");
                this.eOE.aaa("settings_tag_name_category");
            }
        }
        if (this.noJ == 4) {
            this.eOE.aaa("black");
            this.eOE.aaa("group");
        } else if (this.noJ == 5) {
            this.eOE.aaa("outside");
            this.eOE.aaa("group");
        } else {
            this.eOE.aaa("black");
            this.eOE.aaa("outside");
        }
        if (this.noJ == 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.bKg = this.obG + " " + bi.c(this.jzp, ",");
    }

    protected void bCW() {
        x.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        g.Ek();
        g.Eh().dpP.b(290, this);
        g.Ek();
        g.Eh().dpP.b(291, this);
        g.Ek();
        g.Eh().dpP.b(com.tencent.mm.plugin.appbrand.jsapi.audio.j.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.b(293, this);
        g.Ek();
        if (g.Eg().Dx()) {
            g.Ek();
            ((i) g.l(i.class)).FR().b(this);
        }
    }

    public void onDestroy() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        bCW();
        super.onDestroy();
    }

    public final void a(int i, m mVar, Object obj) {
    }

    public final int Ys() {
        return com.tencent.mm.plugin.sns.i.m.tag_detail_pref;
    }

    public void onResume() {
        super.onResume();
        bDN();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (str.equals("settings_tag_name") && (this.noJ >= 6 || this.noJ == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", bi.aG(this.obG, " "));
            com.tencent.mm.plugin.sns.c.a.ezn.a(intent, this);
        }
        if (str.equals("delete_tag_name")) {
            h.a(this, j.set_tag_del_cmd, j.app_tip, new 1(this), new 2(this));
        }
        return false;
    }

    protected final void updateTitle() {
        setMMTitle(this.obG + "(" + this.jzp.size() + ")");
    }

    private void bDN() {
        Preference ZZ = this.eOE.ZZ("settings_tag_name");
        if (ZZ != null) {
            if (this.obG.length() > 20) {
                this.obG = this.obG.substring(0, 20);
            }
            ZZ.setSummary(this.obG);
            this.eOE.notifyDataSetChanged();
        }
    }

    protected void bCX() {
        if (this.noJ != 0) {
            g.Ek();
            g.Eh().dpP.a(new com.tencent.mm.plugin.sns.model.x(this.noJ, this.obG), 0);
        }
        getString(j.app_tip);
        this.tipDialog = h.a(this, getString(j.sns_tag_save), true, new 3(this));
    }

    protected final void initView() {
        this.eOE = this.tCL;
        this.hLp = (ContactListExpandPreference) this.eOE.ZZ("roominfo_contact_anchor");
        if (this.hLp != null) {
            this.hLp.a(this.eOE, this.hLp.mKey);
            this.hLp.kG(true).kH(true);
            this.hLp.p(null, this.jzp);
            this.hLp.a(new k.b() {
                public final boolean oe(int i) {
                    boolean Ca;
                    ContactListExpandPreference contactListExpandPreference = SnsTagDetailUI.this.hLp;
                    if (contactListExpandPreference.qJA != null) {
                        Ca = contactListExpandPreference.qJA.qIM.Ca(i);
                    } else {
                        Ca = true;
                    }
                    if (!Ca) {
                        x.d("MicroMsg.SnsTagDetailUI", "onItemLongClick " + i);
                    }
                    return true;
                }
            });
            this.hLp.a(this.obI);
        }
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        setBackBtn(new 5(this));
        a(0, getString(j.app_finish), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsTagDetailUI.this.aZV();
                return true;
            }
        }, com.tencent.mm.ui.s.b.tmX);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!(this.obG + " " + bi.c(this.jzp, ",")).equals(this.bKg) || this.noJ == 0) {
            h.a(this, j.sns_tag_cancel, j.app_tip, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SnsTagDetailUI.this.finish();
                }
            }, null);
        } else {
            finish();
        }
        return true;
    }

    protected void aZV() {
        if ((this.obG + " " + bi.c(this.jzp, ",")).equals(this.bKg) && this.noJ != 0) {
            finish();
        } else if (af.byu().q(this.noJ, this.obG)) {
            h.b(this, getString(j.sns_tag_exist, new Object[]{this.obG}), getString(j.app_tip), true);
        } else {
            final w wVar = new w(3, this.noJ, this.obG, this.jzp.size(), this.jzp, this.scene);
            g.Ek();
            g.Eh().dpP.a(wVar, 0);
            getString(j.app_tip);
            this.tipDialog = h.a(this, getString(j.sns_tag_save), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.Ek();
                    g.Eh().dpP.c(wVar);
                }
            });
        }
    }

    protected List<String> bCY() {
        List<String> linkedList = new LinkedList();
        t fk = af.byu().fk(this.noJ);
        if (fk.field_memberList == null || fk.field_memberList.equals("")) {
            return linkedList;
        }
        return bi.F(fk.field_memberList.split(","));
    }

    protected void yp(String str) {
        if (str != null && !str.equals("")) {
            this.jzp.remove(str);
            if (this.hLp != null) {
                this.hLp.bt(this.jzp);
                this.hLp.notifyChanged();
            }
            if (this.jzp.size() == 0 && this.hLp != null) {
                this.hLp.cdV();
                this.hLp.kG(true).kH(false);
                this.eOE.notifyDataSetChanged();
            } else if (this.hLp != null) {
                this.hLp.kG(true).kH(true);
            }
            updateTitle();
        }
    }

    protected void cr(List<String> list) {
        ay byc = af.byc();
        String GF = q.GF();
        for (String str : list) {
            if (!(this.jzp.contains(str) || !com.tencent.mm.l.a.gd(byc.Yg(str).field_type) || GF.equals(str))) {
                this.jzp.add(str);
            }
        }
        if (this.hLp != null) {
            this.hLp.bt(this.jzp);
            this.hLp.notifyChanged();
        }
        if (this.jzp.size() > 0) {
            this.hLp.kG(true).kH(true);
        } else {
            this.hLp.kG(true).kH(false);
        }
        updateTitle();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent != null) {
                        boolean z;
                        String stringExtra2 = intent.getStringExtra("Select_Contact");
                        if (bi.oV(q.GF()).equals(stringExtra2)) {
                            z = true;
                        } else if (this.jzp == null) {
                            z = false;
                        } else {
                            z = false;
                            for (String stringExtra3 : this.jzp) {
                                boolean z2;
                                if (stringExtra3.equals(stringExtra2)) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                        }
                        if (z) {
                            h.b(this, getString(j.add_room_mem_memberExits, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}), getString(j.app_tip), true);
                            return;
                        }
                        List F = bi.F(stringExtra2.split(","));
                        if (F != null) {
                            cr(F);
                            break;
                        }
                        return;
                    }
                    return;
                case 2:
                    stringExtra3 = intent.getStringExtra("k_sns_tag_name");
                    if (stringExtra3 != null) {
                        this.obG = stringExtra3;
                    }
                    updateTitle();
                    x.d("MicroMsg.SnsTagDetailUI", "updateName " + this.obG);
                    break;
                default:
                    return;
            }
            if (!(this.obG + " " + bi.c(this.jzp, ",")).equals(this.bKg) || this.noJ == 0) {
                enableOptionMenu(true);
            } else {
                enableOptionMenu(false);
            }
        }
    }

    public void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        switch (lVar.getType()) {
            case 290:
                finish();
                return;
            case 291:
                finish();
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.audio.j.CTRL_INDEX /*292*/:
                if (this.hLp != null && this.obH && !(this instanceof SnsBlackDetailUI)) {
                    x.d("MicroMsg.SnsTagDetailUI", "update form net");
                    this.bKg = this.obG + " " + bi.c(((v) lVar).eQ(this.noJ), ",");
                    LinkedList linkedList = new LinkedList();
                    List<String> list = this.jzp;
                    this.jzp = bCY();
                    if (list != null) {
                        for (String str2 : list) {
                            if (!this.jzp.contains(str2)) {
                                this.jzp.add(str2);
                            }
                        }
                    }
                    this.hLp.bt(this.jzp);
                    this.hLp.notifyChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
