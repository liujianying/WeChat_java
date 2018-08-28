package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private g[] imj;

    protected final int aFo() {
        return 2;
    }

    protected final int aFm() {
        return 2;
    }

    protected final void initView() {
        setMMTitle(R.l.emoji_paid);
        if (q.GR()) {
            addIconOptionMenu(0, R.g.mm_title_btn_menu, new 1(this));
        }
        super.initView();
        this.gQd.setVisibility(8);
        this.CU.setVisibility(8);
    }

    protected final void aFh() {
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.imj != null && this.imj.length > 0) {
            for (l c : this.imj) {
                au.DF().c(c);
            }
        }
    }

    protected final void a(g gVar) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        aFs();
        CharSequence charSequence = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            x.w("MicroMsg.emoji.EmojiPaidUI", "errCode:" + intExtra);
            charSequence = intent.getStringExtra("key_err_msg");
            x.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:" + charSequence);
        } else {
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, R.l.emoji_restore_failed, 0).show();
        } else if (intent == null || intExtra != 0) {
            Toast.makeText(this, charSequence, 0).show();
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, charSequence, 0).show();
                return;
            }
            this.ikl = null;
            this.iki = -1;
            w(false, false);
            au.HU();
            c.DT().set(208900, Boolean.valueOf(true));
            Toast.makeText(this, R.l.emoji_restore_success, 0).show();
        }
    }

    protected final void a(boolean z, f fVar, boolean z2, boolean z3) {
        if (!(fVar == null || !z || this.ihz == null)) {
            this.ihz.b(fVar);
        }
        if (this.ihz == null || fVar == null || fVar.ihp <= 0) {
            this.gQd.setVisibility(0);
            this.ikg.setText(R.l.emoji_no_play_history);
            this.CU.setVisibility(8);
            return;
        }
        this.gQd.setVisibility(8);
        this.CU.setVisibility(0);
    }

    protected final boolean aFj() {
        return false;
    }

    protected final a aFf() {
        return new d(this.mController.tml);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (str != null && str.equals("event_update_group")) {
            aFD();
            ct(131074, 50);
        }
    }

    protected final int aFd() {
        return 10;
    }

    protected final int aFe() {
        return 6;
    }
}
