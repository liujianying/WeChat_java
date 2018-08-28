package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI extends MMWizardActivity implements e {
    private int haC;
    private TextView haE;
    private ag handler = new ag(Looper.getMainLooper());

    protected final int getLayoutId() {
        return R.i.bak_topc_finish;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.haC = getIntent().getIntExtra("cmd", -1);
            x.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
            initView();
            a.asN().asO().gZM = this;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.bak_chat_to_pc_title);
        this.haE = (TextView) findViewById(R.h.bak_topc_finish_tip);
        if (6 == this.haC) {
            this.haE.setText(getString(R.l.bak_chat_to_pc_restore_finish));
        } else if (1 == this.haC) {
            this.haE.setText(getString(R.l.bak_chat_to_pc_back_finish));
        }
        setBackBtn(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        a.asN().asO().gZM = null;
        x.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        a.asN().asO().gZU = -1;
        DT(1);
        return true;
    }

    public final void atd() {
        this.handler.post(new 2(this));
    }

    public final void onError(int i) {
        this.handler.post(new 3(this));
    }
}
