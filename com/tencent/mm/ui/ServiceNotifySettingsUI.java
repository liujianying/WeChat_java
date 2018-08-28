package com.tencent.mm.ui;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.protocal.c.bll;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements e {
    private ListView CU;
    private int mMode;
    private String mSceneId;
    private MMSwitchBtn pfU;
    private a tpZ;
    private p tqa;
    private DataSetObserver yY;

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bll bll = (bll) it.next();
            a aVar = new a((byte) 0);
            aVar.username = bll.username;
            aVar.title = bll.nickname;
            aVar.url = bll.skt;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.tpZ;
        aVar2.tqh.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.tqh.addAll(linkedList2);
        }
        serviceNotifySettingsUI.tpZ.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.service_notify_settings_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.mSceneId = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.mSceneId);
        Object stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            setMMTitle(R.l.notify_message_settings_title);
        } else {
            setMMTitle(stringExtra);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ServiceNotifySettingsUI.this.finish();
                return false;
            }
        });
        this.pfU = (MMSwitchBtn) findViewById(R.h.checkbox);
        this.CU = (ListView) findViewById(R.h.listview);
        ((TextView) findViewById(R.h.listTitleTv)).setText(this.mMode == 1 ? R.l.notify_message_settings_ban_wxa_custom_session_notify : R.l.notify_message_settings_ban_app_brand_notify);
        ((TextView) findViewById(R.h.tips_view)).setText(this.mMode == 1 ? R.l.notify_message_settings_close_custom_session_push_tips : R.l.notify_message_settings_close_push_tips);
        this.tpZ = new a(this, getLayoutInflater(), this.mMode, this.mSceneId);
        this.CU.setAdapter(this.tpZ);
        getString(R.l.app_tip);
        this.tqa = h.a(this, getString(R.l.app_waiting), true, new 2(this));
        this.yY = new 3(this);
        this.tpZ.registerDataSetObserver(this.yY);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        au.DF().a(1145, this);
        au.DF().a(new n(i), 0);
        this.pfU.setCheck(cqS());
    }

    protected void onDestroy() {
        int i;
        int i2 = 3;
        au.DF().b(1145, this);
        boolean cqS = cqS();
        boolean z = this.pfU.uGQ != cqS;
        LinkedList linkedList = new LinkedList();
        if (z) {
            int i3;
            boolean z2;
            bsa bsa = new bsa();
            if (this.pfU.uGQ) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            bsa.spH = i3;
            if (this.mMode == 1) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            bsa.hcE = i3;
            linkedList.add(bsa);
            if (cqS) {
                z2 = false;
            } else {
                z2 = true;
            }
            a aVar = a.sUk;
            if (this.mMode == 1) {
                aVar = a.sUl;
            }
            au.HU();
            c.DT().a(aVar, Boolean.valueOf(z2));
            com.tencent.mm.sdk.b.a.sFg.m(new na());
            if (this.mMode == 1) {
                if (bsa.spH == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                x.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(i3), this.mSceneId});
                com.tencent.mm.plugin.report.service.h.mEJ.h(13798, new Object[]{Integer.valueOf(i3), "", Integer.valueOf(0), this.mSceneId, Long.valueOf(bi.VE())});
            } else {
                i3 = bsa.spH == 1 ? 11 : 10;
                com.tencent.mm.plugin.report.service.h.mEJ.h(13796, new Object[]{Integer.valueOf(i3), "", "", Integer.valueOf(0), Long.valueOf(bi.VE())});
            }
        }
        if (this.mMode == 1) {
            i = 2;
        } else {
            i = 1;
        }
        LinkedList linkedList2 = this.tpZ.tqi;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            if (this.mMode != 1) {
                i2 = 1;
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                bsa bsa2 = new bsa();
                bsa2.spI = aVar2.username;
                bsa2.hcE = i2;
                bsa2.spH = 1;
                linkedList.add(bsa2);
                sl slVar = new sl();
                slVar.cdl.bGy = aVar2.username;
                slVar.cdl.action = 2;
                slVar.cdl.cdn = i;
                com.tencent.mm.sdk.b.a.sFg.m(slVar);
            }
        }
        if (!linkedList.isEmpty()) {
            au.DF().a(1176, new 4(this, z, cqS, linkedList, i));
            au.DF().a(new m(linkedList), 0);
        }
        this.tpZ.unregisterDataSetObserver(this.yY);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.tqa != null) {
            this.tqa.dismiss();
        }
        x.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            final ahp JR = ((n) lVar).JR();
            if (this.mMode == 1) {
                this.pfU.setCheck(JR.rKP);
            } else {
                this.pfU.setCheck(JR.rgU);
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (ServiceNotifySettingsUI.this.mMode == 1) {
                        ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, JR.rKQ);
                    } else {
                        ServiceNotifySettingsUI.a(ServiceNotifySettingsUI.this, JR.rgV);
                    }
                }
            });
            return;
        }
        s.makeText(this, R.l.notify_message_settings_get_data_failed, 0).show();
    }

    private boolean cqS() {
        a aVar = a.sUk;
        if (this.mMode == 1) {
            aVar = a.sUl;
        }
        au.HU();
        return c.DT().getBoolean(aVar, true);
    }
}
