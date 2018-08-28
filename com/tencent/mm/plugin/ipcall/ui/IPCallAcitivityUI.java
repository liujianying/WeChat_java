package com.tencent.mm.plugin.ipcall.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout ktq;
    private TextView ktr;
    private TextView kts;
    private Button ktt;
    private CdnImageView ktu;
    private boolean ktv = false;
    private com.tencent.mm.plugin.ipcall.a.g.a ktw;

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.ipcall_activity_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(131072);
        getWindow().setFlags(1024, 1024);
        this.mController.hideTitleView();
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        this.ktq = (FrameLayout) findViewById(R.h.ipcall_activity_close_btn);
        this.ktr = (TextView) findViewById(R.h.ipcall_activity_title_tv);
        this.kts = (TextView) findViewById(R.h.ipcall_activity_desc_tv);
        this.ktt = (Button) findViewById(R.h.ipcall_activity_enter_btn);
        this.ktu = (CdnImageView) findViewById(R.h.ipcall_activity_iv);
        au.HU();
        String str = (String) c.DT().get(aa.a.sRw, "");
        if (bi.oW(str)) {
            x.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
        } else {
            this.ktw = com.tencent.mm.plugin.ipcall.a.g.a.EN(str);
            if (this.ktw == null) {
                x.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
                finish();
            } else {
                this.ktr.setText(this.ktw.bHD);
                this.kts.setText(this.ktw.jOS);
                this.ktt.setText(this.ktw.ksw);
                this.ktu.setUrl(this.ktw.ksv);
            }
        }
        this.ktq.setOnClickListener(new 1(this));
        this.ktt.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
        if (this.ktv) {
            com.tencent.mm.plugin.ipcall.a.e.c.rz(1);
        } else {
            com.tencent.mm.plugin.ipcall.a.e.c.rz(0);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
