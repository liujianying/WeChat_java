package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String dKF;
    private ListView eVT;
    private a hpC;
    private long hpD;
    private OnItemClickListener hpE;
    private int scene;

    static /* synthetic */ void a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i) {
        ix ixVar = (ix) enterpriseBizContactPlainListUI.hpC.getItem(i);
        if (ixVar == null || ixVar.userName == null) {
            x.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            ((h) g.l(h.class)).a(enterpriseBizContactPlainListUI.mController, ixVar.userName, enterpriseBizContactPlainListUI.getString(b.h.retransmit_to_conv_comfirm2), r.gS(ixVar.userName), null, enterpriseBizContactPlainListUI.getString(b.h.app_send), new 4(enterpriseBizContactPlainListUI, ixVar));
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", ixVar.userName);
            a.ezn.d(intent, enterpriseBizContactPlainListUI);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            t.a.qJO.a(enterpriseBizContactPlainListUI.mController, (String) hashMap.get("title"), (String) hashMap.get("img_url"), (String) hashMap.get("desc"), false, enterpriseBizContactPlainListUI.getResources().getString(b.h.app_send), new 5(enterpriseBizContactPlainListUI, ixVar.userName));
        } else if (enterpriseBizContactPlainListUI.scene == 4) {
            d kH = f.kH(ixVar.userName);
            String Mf = kH == null ? null : kH.Mf();
            if (!bi.oW(Mf)) {
                com.tencent.mm.ac.b kn = z.Nh().kn(kH.Mg());
                int i2 = kn != null ? kn.field_qyUin : 0;
                int i3 = kn != null ? kn.field_userUin : 0;
                int kp = z.Nh().kp(kH.field_username);
                com.tencent.mm.plugin.report.service.h.mEJ.h(13419, new Object[]{Integer.valueOf(i2), Integer.valueOf(kp), Integer.valueOf(i3), Integer.valueOf(1)});
                x.d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(kp), Integer.valueOf(i3), Integer.valueOf(1)});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", Mf);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", ixVar.userName);
                intent2.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.dKF);
                intent2.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.hpD);
                com.tencent.mm.bg.d.b(enterpriseBizContactPlainListUI.mController.tml, "webview", ".ui.tools.WebViewUI", intent2, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.dKF = getIntent().getStringExtra("enterprise_biz_name");
        this.hpD = getIntent().getLongExtra("biz_chat_chat_id", -1);
        x.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[]{this.dKF});
        initView();
        z.MY().c(this.hpC);
        ((i) g.l(i.class)).FR().a(this.hpC);
    }

    protected final void initView() {
        this.eVT = (ListView) findViewById(b.d.enterprist_biz_child_lv);
        if (this.hpC == null) {
            this.hpC = new a(this, this);
            this.hpE = new 1(this);
        }
        x.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[]{Integer.valueOf(this.hpC.getCount())});
        ab Yg = ((i) g.l(i.class)).FR().Yg(this.dKF);
        if (this.scene == 2) {
            setMMTitle(b.h.enterprise_disable);
        } else if (Yg != null) {
            setMMTitle(Yg.BK());
        }
        if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type) || this.hpC.getCount() <= 0) {
            this.eVT.setVisibility(8);
            TextView textView = (TextView) findViewById(b.d.enterprist_biz_child_not_found);
            textView.setText(b.h.enterprise_no_sub_biz);
            textView.setVisibility(0);
        } else {
            this.eVT.setVisibility(0);
            this.eVT.setAdapter(this.hpC);
            this.eVT.setOnItemClickListener(this.hpE);
        }
        setBackBtn(new 2(this));
        3 3 = new 3(this);
    }

    protected void onResume() {
        super.onResume();
        if (!s.he(this.dKF)) {
            x.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[]{this.dKF});
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        z.MY().d(this.hpC);
        ((i) g.l(i.class)).FR().b(this.hpC);
        this.hpC.aYc();
        a aVar = this.hpC;
        if (aVar.eKg != null) {
            aVar.eKg.detach();
            aVar.eKg = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return e.enterprise_biz_list_normal;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.scene == 4) {
            finish();
        }
    }
}
