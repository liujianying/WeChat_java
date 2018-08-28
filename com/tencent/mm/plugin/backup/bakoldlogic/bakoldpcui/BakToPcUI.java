package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI extends MMWizardActivity implements a {
    private Button eGn;
    private Button haQ;
    private TextView haR;
    private TextView haS;
    private ag handler = new ag(Looper.getMainLooper());
    private int nc = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            initView();
            this.nc = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZR;
            x.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.nc)});
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZL = this;
            atj();
        }
    }

    public final void initView() {
        setMMTitle(R.l.bak_chat_to_pc_title);
        setBackBtn(new 1(this));
        this.eGn = (Button) findViewById(R.h.bak_topc_ok_button);
        this.eGn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (BakToPcUI.this.nc == 0) {
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asP().dBM = 1;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().mO(0);
                    MMWizardActivity.D(BakToPcUI.this, new Intent(BakToPcUI.this, BakWaitingUI.class));
                }
            }
        });
        this.haQ = (Button) findViewById(R.h.bak_topc_cancel_button);
        this.haQ.setOnClickListener(new 3(this));
        this.haR = (TextView) findViewById(R.h.bak_topc_tip_pcname);
        this.haR.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZS);
        this.haS = (TextView) findViewById(R.h.bak_topc_tip_username);
        this.haS.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZT);
    }

    protected final int getLayoutId() {
        return R.i.bak_topc_chat;
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.nc)});
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().gZL = null;
    }

    public final void ata() {
        this.nc = 0;
        this.eGn.setVisibility(0);
        this.haQ.setVisibility(0);
        new ag(Looper.getMainLooper()).post(new 4(this));
    }

    private void atj() {
        if (this.nc == 0) {
            this.eGn.setEnabled(true);
            this.haQ.setEnabled(true);
            return;
        }
        this.eGn.setEnabled(false);
        this.haQ.setEnabled(false);
    }

    public final void onError(int i) {
        this.handler.post(new 5(this, i));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asP().dBM = 3;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asP().IF();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.asN().asO().mO(1);
        DT(1);
        return true;
    }
}
