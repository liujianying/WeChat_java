package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI.11;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

class RecordMsgFileUI$11$2 implements d {
    final /* synthetic */ 11 mtj;

    RecordMsgFileUI$11$2(11 11) {
        this.mtj = 11;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (RecordMsgFileUI.c(this.mtj.mtg) == 8) {
                    String c = h.c(RecordMsgFileUI.a(this.mtj.mtg), RecordMsgFileUI.b(this.mtj.mtg));
                    if (!e.cn(c)) {
                        x.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                        Toast.makeText(this.mtj.mtg, this.mtj.mtg.getString(R.l.favorite_share_file_not_exists), 1).show();
                        return;
                    } else if (new File(c).length() > 10485760) {
                        x.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                        Toast.makeText(this.mtj.mtg, this.mtj.mtg.getString(R.l.favorite_share_too_large), 1).show();
                        return;
                    }
                }
                RecordMsgFileUI.h(this.mtj.mtg);
                return;
            default:
                return;
        }
    }
}
