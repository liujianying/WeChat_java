package com.tencent.mm.plugin.traceroute.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseUI extends MMActivity {
    private ag handler = new 2(this);
    private TextView jej;
    private int lod = 0;
    private final int oDZ = 100;
    private int oEa = 0;
    private a oEb;
    private MMProgressBar oEc;
    private al oEd = new al(new 1(this), true);

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        networkDiagnoseUI.oEd.SO();
        if (networkDiagnoseUI.oEb != null) {
            networkDiagnoseUI.oEb.stop();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.jej = (TextView) findViewById(R.h.report_status_tv);
        this.oEc = (MMProgressBar) findViewById(R.h.diagnose_progress);
        this.oEc.setOnProgressChangedListener(new MMProgressBar.a() {
            public final void yl(int i) {
                if (i < 5) {
                    NetworkDiagnoseUI.this.jej.setText(NetworkDiagnoseUI.this.getString(R.l.connecting_server));
                } else if (i < 5 || i >= 95) {
                    NetworkDiagnoseUI.this.jej.setText(NetworkDiagnoseUI.this.getString(R.l.uploading_report));
                } else {
                    NetworkDiagnoseUI.this.jej.setText(NetworkDiagnoseUI.this.getString(R.l.getting_route_path));
                }
            }
        });
        setMMTitle("");
        setBackBtn(new 4(this));
        new ag().postDelayed(new 5(this), 200);
    }

    protected final int getLayoutId() {
        return R.i.network_diagnose_run;
    }

    protected void onPause() {
        this.oEc.setAutoProgress(false);
        super.onPause();
    }

    protected void onResume() {
        au.HU();
        if (c.isSDCardAvailable()) {
            this.oEc.setAutoProgress(true);
            super.onResume();
            return;
        }
        s.gH(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bIQ();
        return true;
    }

    private void bIQ() {
        h.a(this, R.l.confirm_cancel_diagnose, R.l.diagnose_cancel_confirm_title, R.l.app_yes, R.l.app_no, new 7(this), new 8(this));
    }
}
