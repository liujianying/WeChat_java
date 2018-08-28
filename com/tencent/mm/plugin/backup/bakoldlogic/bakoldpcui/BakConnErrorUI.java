package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int haC;

    protected final int getLayoutId() {
        return R.i.bak_topc_error;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.haC = getIntent().getIntExtra("cmd", -1);
            x.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
            initView();
            a.asN().asO().gZU = -1;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.bak_chat_to_pc_title);
        setBackBtn(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        a.asN().asO().gZM = null;
        x.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.haC)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DT(1);
        return true;
    }
}
