package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI extends MMPreference implements e {
    private static LinkedList<asd> hpN;
    private ProgressDialog eHw;
    protected f gua;
    private String hpM;
    private boolean hpO = false;

    protected final int getLayoutId() {
        return b.e.receive_template_msg_mgr;
    }

    public final int Ys() {
        return i.receive_template_msg;
    }

    public final int auY() {
        return b.e.receive_template_msg_header;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(1031, this);
        g.DF().a(1030, this);
        initView();
    }

    protected void onPause() {
        if (this.hpO) {
            x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.hpO = false;
            g.DF().a(new l(this.hpM, hpN), 0);
        }
        super.onPause();
    }

    protected void onDestroy() {
        g.DF().b(1031, this);
        g.DF().b(1030, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(h.contact_info_receive_tmp_msg_title);
        this.gua = this.tCL;
        this.hpM = getIntent().getStringExtra("enterprise_biz_name");
        if (bi.oW(this.hpM)) {
            x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            return;
        }
        setBackBtn(new 1(this));
        d dVar = new d(this.hpM);
        g.DF().a(dVar, 0);
        getString(h.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(h.receive_template_msg_ui_waiting_get_options), true, new 2(this, dVar));
    }

    public final boolean a(f fVar, Preference preference) {
        if (hpN == null) {
            x.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
        } else {
            String str = preference.mKey;
            if (bi.oW(str)) {
                x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
            } else {
                Iterator it = hpN.iterator();
                while (it.hasNext()) {
                    asd asd = (asd) it.next();
                    if (str.equals(bi.oV(asd.rUx))) {
                        this.hpO = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            asd.rbZ = 0;
                        } else {
                            asd.rbZ = 1;
                        }
                        if (this.hpO) {
                            x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                            ah.i(new 3(this), 4000);
                        }
                    }
                }
                if (this.hpO) {
                    x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                    ah.i(new 3(this), 4000);
                }
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        asf asf = null;
        if (lVar == null) {
            x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        x.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(lVar.getType())});
        if (lVar.getType() == 1031) {
            if (this.eHw != null && this.eHw.isShowing()) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (i == 0 && i2 == 0) {
                d dVar = (d) lVar;
                if (!(dVar.diG == null || dVar.diG.dIE.dIL == null)) {
                    asf = (asf) dVar.diG.dIE.dIL;
                }
                hpN = asf.rUy;
                LinkedList linkedList = hpN;
                this.gua.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    x.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    da(true);
                    return;
                }
                da(false);
                x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[]{Integer.valueOf(linkedList.size())});
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    asd asd = (asd) it.next();
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.tDr = false;
                    checkBoxPreference.setKey(asd.rUx);
                    checkBoxPreference.setTitle(asd.bHD);
                    checkBoxPreference.qpJ = asd.rbZ == 0;
                    this.gua.a(checkBoxPreference);
                }
                this.gua.notifyDataSetChanged();
                x.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                return;
            }
            Toast.makeText(ad.getContext(), ad.getContext().getString(h.receive_template_msg_ui_fail_get_options), 1).show();
            da(true);
        } else if (lVar.getType() != 1030) {
        } else {
            if (i != 0 || i2 != 0) {
                Toast.makeText(ad.getContext(), ad.getContext().getString(h.receive_template_msg_ui_fail_set_options), 0).show();
            }
        }
    }

    private void da(boolean z) {
        View findViewById = findViewById(b.d.receive_template_msg_empty_tips);
        View findViewById2 = findViewById(b.d.receive_template_msg_header_ll);
        if (findViewById == null) {
            return;
        }
        if (z) {
            ((TextView) findViewById).setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
                return;
            }
            return;
        }
        ((TextView) findViewById).setVisibility(8);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
    }
}
