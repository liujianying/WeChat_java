package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class NetworkDiagnoseAllInOneUI extends MMActivity implements OnClickListener {
    private ImageView bOA;
    private a cXs;
    private Button eGn;
    private al eOf;
    private c kJQ;
    private TextView oDA;
    private TextView oDB;
    private TextView oDC;
    private p oDD;
    private int oDE;
    private String oDF;
    private com.tencent.mm.sdk.b.c<kd> oDG;
    private boolean oDH;
    private boolean oDI;
    private boolean oDJ;
    private int oDy;
    private TextView oDz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
        setMMTitle("");
        getSupportActionBar().hide();
        Intent intent = getIntent();
        this.oDy = intent.getIntExtra("diagnose_state", 0);
        this.oDE = intent.getIntExtra("diagnose_percent", 1);
        this.oDF = intent.getStringExtra("diagnose_kvInfo");
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", new Object[]{Integer.valueOf(this.oDy), Integer.valueOf(this.oDE), this.oDF});
        if (this.oDy == 0) {
            this.oDy = 1;
            x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
            au.DF().a(new bg(new 4(this)), 0);
        }
        this.eGn = (Button) findViewById(R.h.diagnose_okBtn);
        this.oDz = (TextView) findViewById(R.h.diagnose_closeLabel);
        this.oDA = (TextView) findViewById(R.h.diagnose_cancelLabel);
        this.bOA = (ImageView) findViewById(R.h.diagnose_state_img);
        this.oDB = (TextView) findViewById(R.h.diagnose_state_label);
        this.oDC = (TextView) findViewById(R.h.diagnose_descp_label);
        this.oDz.setOnClickListener(this);
        this.eGn.setOnClickListener(this);
        this.oDA.setOnClickListener(this);
        YI();
        this.oDG = new 1(this);
        com.tencent.mm.sdk.b.a.sFg.a(this.oDG);
        this.cXs = new 2(this);
        this.eOf = new al(new 3(this), true);
        if (this.oDy == 0 || this.oDy == 1) {
            this.eOf.J(1000, 1000);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    }

    protected final int getLayoutId() {
        return R.i.network_diagnose_all_in_one;
    }

    private void YI() {
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", new Object[]{Integer.valueOf(this.oDy)});
        switch (this.oDy) {
            case 0:
            case 1:
                this.bOA.setImageResource(R.k.network_diagnose_work);
                this.oDB.setText(getString(R.l.diagnose_state_doing, new Object[]{Integer.valueOf(this.oDE)}));
                this.oDC.setText(R.l.diagnose_descript_doing);
                this.eGn.setVisibility(4);
                this.oDA.setVisibility(4);
                return;
            case 2:
                this.bOA.setImageResource(R.k.network_diagnose_work);
                this.oDB.setText(R.l.diagnose_state_success);
                this.oDC.setText(R.l.diagnose_descript_success);
                this.eGn.setVisibility(0);
                this.oDA.setVisibility(4);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("title", R.l.net_warn_no_network);
                intent.putExtra("rawUrl", getString(R.l.net_warn_detail_doc));
                intent.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                iG(false);
                finish();
                return;
            case 4:
                this.bOA.setImageResource(R.k.network_diagnose_fail);
                this.oDB.setText(R.l.diagnose_state_longlink_fail);
                this.oDC.setText(R.l.diagnose_descript_fail);
                this.eGn.setVisibility(0);
                this.eGn.setText(R.l.diagnose_btn_submit);
                this.oDA.setVisibility(0);
                return;
            case 5:
                this.bOA.setImageResource(R.k.network_diagnose_fail);
                this.oDB.setText(R.l.diagnose_state_fail);
                this.oDC.setText(R.l.diagnose_descript_fail);
                this.eGn.setVisibility(0);
                this.eGn.setText(R.l.diagnose_btn_submit);
                this.oDA.setVisibility(0);
                return;
            case 6:
                this.bOA.setImageResource(R.k.network_diagnose_feedback);
                this.oDB.setText(R.l.diagnose_state_feedback);
                this.oDC.setText(R.l.diagnose_descript_feedback);
                this.eGn.setVisibility(0);
                this.eGn.setText(R.l.diagnose_btn_comfirm);
                this.oDA.setVisibility(4);
                return;
            default:
                return;
        }
    }

    private void iG(boolean z) {
        if (!bi.oW(this.oDF)) {
            x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                h.mEJ.k(14533, "," + this.oDF);
            } else if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", "")) {
                getString(R.l.app_tip);
                this.oDD = com.tencent.mm.ui.base.h.a(this, getString(R.l.diagnose_uploading), true, null);
                this.eGn.setEnabled(false);
                if (this.kJQ == null) {
                    this.kJQ = c.OB();
                }
                this.kJQ.a(this.cXs, true);
            }
            this.oDF = null;
        }
    }

    public void onClick(View view) {
        if ((this.oDy == 5 || this.oDy == 4) && view == this.eGn) {
            iG(true);
            return;
        }
        iG(false);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.oDG);
        if (this.kJQ != null) {
            this.kJQ.c(this.cXs);
            this.kJQ = null;
        }
        if (this.eOf != null) {
            this.eOf.SO();
            this.eOf = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case f$k.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                if (iArr[0] == 0) {
                    iG(true);
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.permission_cancel), false, new 5(this), new 6(this));
                    return;
                }
            default:
                return;
        }
    }
}
