package com.tencent.mm.plugin.backup.backupui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a gYT;

    a$1(a aVar) {
        this.gYT = aVar;
    }

    public final void onClick(View view) {
        x.i(a.bP(), "backupbanner onclick, backupMode[%d]", new Object[]{Integer.valueOf(d.aqS())});
        switch (d.aqS()) {
            case 1:
                x.i(a.bP(), "backupbanner onclick, backupPcState[%d]", new Object[]{Integer.valueOf(b.arV().aqP().gRC)});
                switch (b.arV().aqP().gRC) {
                    case -4:
                    case 4:
                    case 5:
                    case 12:
                    case 14:
                    case 15:
                    case 22:
                    case 23:
                        x.i(a.bP(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[]{Integer.valueOf(b.arV().aqP().gRC)});
                        a.a(this.gYT, false);
                        return;
                    case 24:
                    case 25:
                        x.i(a.bP(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[]{Integer.valueOf(b.arV().aqP().gRC)});
                        a.a(this.gYT, true);
                        return;
                    default:
                        x.i(a.bP(), "click backup banner, BackupPcState[%d]", new Object[]{Integer.valueOf(b.arV().aqP().gRC)});
                        return;
                }
            case 22:
                x.i(a.bP(), "backupbanner onclick, backupMoveState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.c.b.arv().aqP().gRC)});
                switch (com.tencent.mm.plugin.backup.c.b.arv().aqP().gRC) {
                    case -4:
                    case 4:
                    case 5:
                    case 12:
                    case 22:
                    case 23:
                    case f$k.AppCompatTheme_selectableItemBackground /*52*/:
                        x.i(a.bP(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                        a.b(this.gYT, false);
                        return;
                    case 24:
                    case 25:
                        x.i(a.bP(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                        a.b(this.gYT, true);
                        return;
                    default:
                        x.i(a.bP(), "click backup banner,backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                        return;
                }
            default:
                return;
        }
    }
}
