package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;
import com.tencent.mm.ui.MMWizardActivity;

class BackupPcUI$3$9 implements OnClickListener {
    final /* synthetic */ 3 gXm;

    BackupPcUI$3$9(3 3) {
        this.gXm = 3;
    }

    public final void onClick(View view) {
        MMWizardActivity.D(this.gXm.gXl, new Intent(this.gXm.gXl, BackupPcChooseUI.class));
        b.arV().arZ().cancel();
        b.arV().arZ().art();
        b.arV().arZ().dy(false);
    }
}
