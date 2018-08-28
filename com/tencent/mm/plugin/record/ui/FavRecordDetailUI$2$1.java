package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class FavRecordDetailUI$2$1 implements c {
    final /* synthetic */ 2 msI;

    FavRecordDetailUI$2$1(2 2) {
        this.msI = 2;
    }

    public final void a(l lVar) {
        x.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[]{Integer.valueOf(FavRecordDetailUI.b(this.msI.msF).field_id), Integer.valueOf(FavRecordDetailUI.b(this.msI.msF).field_itemStatus)});
        if (FavRecordDetailUI.b(this.msI.msF).field_id > 0 && !FavRecordDetailUI.b(this.msI.msF).aLf() && !FavRecordDetailUI.b(this.msI.msF).aLg() && FavRecordDetailUI.c(this.msI.msF)) {
            lVar.e(0, this.msI.msF.getString(R.l.favorite_share_with_friend));
        }
        lVar.e(3, this.msI.msF.getString(R.l.favorite_edit_tag_tips));
        lVar.e(2, this.msI.msF.getString(R.l.app_delete));
    }
}
