package com.tencent.mm.ui.chatting.g;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.a.b;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.gallery.g.a;

class e$10 implements b {
    final /* synthetic */ e tYu;

    e$10(e eVar) {
        this.tYu = eVar;
    }

    public final void a(boolean z, c cVar, int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (!z || a.cwU().tTJ.size() < 9) {
            if (z) {
                a.cwU().bw(cVar.bXQ);
            } else {
                a.cwU().bx(cVar.bXQ);
            }
            e.c(this.tYu).Fj(a.cwU().tTJ.size());
            return;
        }
        Toast.makeText(e.b(this.tYu), e.b(this.tYu).getResources().getString(R.l.gallery_select_limit, new Object[]{Integer.valueOf(9)}), 1).show();
        this.tYu.tYp.bl(i);
    }
}
