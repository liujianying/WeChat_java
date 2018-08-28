package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.record.ui.b.a.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.n.d;

class a$2$2 implements d {
    final /* synthetic */ 2 mty;

    a$2$2(2 2) {
        this.mty = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                intent = new Intent();
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", 2.d(this.mty));
                String ic = u.ic("fav_");
                u.Hx().v(ic, true).p("prePublishId", "fav_");
                intent.putExtra("reportSessionId", ic);
                com.tencent.mm.bg.d.b(2.c(this.mty), "sns", ".ui.SnsUploadUI", intent);
                return;
            case 2:
                intent = new Intent();
                intent.putExtra("Retr_File_Name", 2.d(this.mty));
                intent.putExtra("Retr_Compress_Type", 0);
                intent.putExtra("Retr_Msg_Type", 0);
                com.tencent.mm.bg.d.e(2.c(this.mty), ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 3:
                if (!r.a(2.d(this.mty), 2.c(this.mty), R.l.cropimage_saved)) {
                    Toast.makeText(2.c(this.mty), 2.c(this.mty).getString(R.l.favorite_save_fail), 1).show();
                    return;
                }
                return;
            case 4:
                mu muVar = (mu) this.mty.mtv.iYQ.get(2.d(this.mty));
                if (muVar != null) {
                    cb cbVar = new cb();
                    cbVar.bJq.activity = (Activity) 2.c(this.mty);
                    cbVar.bJq.bHL = muVar.bXK.result;
                    cbVar.bJq.bJr = muVar.bXK.bJr;
                    cbVar.bJq.bJs = muVar.bXK.bJs;
                    a.sFg.m(cbVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
