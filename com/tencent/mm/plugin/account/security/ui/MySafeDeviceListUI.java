package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$k;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.b;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements e, com.tencent.mm.sdk.e.j.a {
    private ProgressDialog eHw = null;
    private f eOE;
    private int eOF = -2;
    private List<SafeDeviceListPreference> eOG;
    private a eOH;
    private List<d> eOI;
    private OnMenuItemClickListener eOJ = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            MySafeDeviceListUI.a(MySafeDeviceListUI.this);
            return true;
        }
    };
    private ag handler = new 3(this);

    private class a implements com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.a, b {
        private a() {
        }

        /* synthetic */ a(MySafeDeviceListUI mySafeDeviceListUI, byte b) {
            this();
        }

        public final void pH(String str) {
            MySafeDeviceListUI.this.eOE.aaa(str);
            MySafeDeviceListUI.this.handler.sendEmptyMessage(0);
            MySafeDeviceListUI.this.addTextOptionMenu(0, MySafeDeviceListUI.this.getString(j.safe_device_edit), MySafeDeviceListUI.this.eOJ);
            MySafeDeviceListUI.this.eOF = MySafeDeviceListUI.this.eOF ^ -1;
            MySafeDeviceListUI.this.Yt();
        }

        public final void pI(String str) {
            x.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed" + str);
        }
    }

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        if (mySafeDeviceListUI.eOG != null && mySafeDeviceListUI.eOG.size() > 0) {
            mySafeDeviceListUI.eOF ^= -1;
            for (SafeDeviceListPreference safeDeviceListPreference : mySafeDeviceListUI.eOG) {
                safeDeviceListPreference.mode = mySafeDeviceListUI.eOF;
                safeDeviceListPreference.initView();
            }
            mySafeDeviceListUI.eOE.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.eOF == 1) {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(j.app_finish), mySafeDeviceListUI.eOJ);
        } else {
            mySafeDeviceListUI.addTextOptionMenu(0, mySafeDeviceListUI.getString(j.safe_device_edit), mySafeDeviceListUI.eOJ);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(850, this);
        g.DF().a(361, this);
        com.tencent.mm.plugin.account.security.a.g.Yq().c(this);
        initView();
        com.tencent.mm.plugin.account.security.a.b bVar = new com.tencent.mm.plugin.account.security.a.b();
        g.DF().a(bVar, 0);
        getString(j.app_tip);
        this.eHw = h.a(this, getString(j.app_waiting), true, new 2(this, bVar));
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(850, this);
        g.DF().b(361, this);
        com.tencent.mm.plugin.account.security.a.g.Yq().d(this);
    }

    protected void onResume() {
        super.onResume();
        Yt();
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (bi.oW(str)) {
            x.e("MicroMsg.MySafeDeviceListUI", "null key");
            return false;
        }
        if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                d dVar = safeDeviceListPreference.eOO;
                h.a(this.mController.tml, getString(j.safe_device_edit_title), dVar.field_name, getString(j.safe_device_mod_name_hint), -1, new 4(this, dVar));
            }
        }
        return true;
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MySafeDeviceListUI.this.finish();
                return true;
            }
        });
        this.eOE = this.tCL;
        this.eOG = new LinkedList();
        this.eOH = new a(this, (byte) 0);
        addTextOptionMenu(0, getString(j.safe_device_edit), this.eOJ);
        setMMTitle(j.settings_manage_login_device);
    }

    private void Yt() {
        this.eOG.clear();
        this.eOI = com.tencent.mm.plugin.account.security.a.g.Yq().Yn();
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(a$k.safe_device_list_pref);
        if (this.eOI.size() == 0) {
            this.eOE.aaa("my_safe_device_list_tip");
            showOptionMenu(false);
            return;
        }
        if (this.eOF == 1) {
            addTextOptionMenu(0, getString(j.safe_device_edit), this.eOJ);
            this.eOF ^= -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        for (d dVar : this.eOI) {
            SafeDeviceListPreference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + dVar.field_uid);
            safeDeviceListPreference.setTitle(com.tencent.mm.pluginsdk.ui.d.j.a(this, dVar.field_name));
            safeDeviceListPreference.setSummary(simpleDateFormat.format(new Date(dVar.field_createtime * 1000)));
            safeDeviceListPreference.eOR = this.eOH;
            safeDeviceListPreference.eOS = this.eOH;
            safeDeviceListPreference.eOO = dVar;
            this.eOE.a(safeDeviceListPreference, -1);
            this.eOG.add(safeDeviceListPreference);
        }
        showOptionMenu(true);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.MySafeDeviceListUI", "notify " + str);
        this.handler.post(new Runnable() {
            public final void run() {
                MySafeDeviceListUI.this.Yt();
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        List list = null;
        x.i("MicroMsg.MySafeDeviceListUI", "errorCode %d, errorMsg %s, scene %s", new Object[]{Integer.valueOf(i2), str, lVar});
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() == 850) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.account.security.a.b bVar = (com.tencent.mm.plugin.account.security.a.b) lVar;
                if (!(bVar.eOo == null || bVar.eOo.rKK == null || bVar.eOo.rKK.siQ == null)) {
                    list = bVar.eOo.rKK.siQ;
                }
                if (list != null && list != null) {
                    com.tencent.mm.plugin.account.security.a.g.Yq().fV("SafeDeviceInfo", "delete from SafeDeviceInfo");
                    for (arp dVar : list) {
                        com.tencent.mm.plugin.account.security.a.g.Yq().a(new d(dVar));
                    }
                }
            }
        } else if (lVar.getType() != 361) {
        } else {
            if (i == 0 && i2 == 0) {
                c cVar = (c) lVar;
                d dVar2 = new d();
                dVar2.field_devicetype = cVar.bKv;
                dVar2.field_name = cVar.deviceName;
                dVar2.field_uid = cVar.byN;
                dVar2.field_createtime = 0;
                com.tencent.mm.plugin.account.security.a.g.Yq().c(dVar2, new String[0]);
                h.bA(this, com.tencent.mm.bp.a.af(this, j.safe_device_mod_name_ok));
            } else if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
            }
        }
    }
}
