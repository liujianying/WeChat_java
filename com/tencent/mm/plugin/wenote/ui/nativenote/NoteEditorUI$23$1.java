package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class NoteEditorUI$23$1 implements c {
    final /* synthetic */ 23 quz;

    NoteEditorUI$23$1(23 23) {
        this.quz = 23;
    }

    public final void a(l lVar) {
        if (NoteEditorUI.d(this.quz.qur) == 1) {
            lVar.e(4, this.quz.qur.getString(R.l.favorite_share_with_friend));
            NoteEditorUI.a(this.quz.qur, lVar);
            lVar.e(3, this.quz.qur.getString(R.l.plugin_favorite_opt));
        } else if (NoteEditorUI.d(this.quz.qur) == 2) {
            int i;
            lVar.e(0, this.quz.qur.getString(R.l.favorite_share_with_friend));
            if (a.caO()) {
                lVar.e(7, this.quz.qur.mController.tml.getString(R.l.favorite_post_to_sns));
            }
            String str = (String) com.tencent.mm.model.c.c.Jx().fJ("100353").ckq().get("Close");
            if (bi.oW(str)) {
                i = 0;
            } else {
                i = bi.getInt(str, 0);
            }
            if ((i == 0 ? 1 : 0) != 0) {
                lVar.e(8, this.quz.qur.mController.tml.getString(R.l.note_share_with_longpic));
            }
            NoteEditorUI.a(this.quz.qur, lVar);
            lVar.e(1, this.quz.qur.getString(R.l.favorite_edit_tag_tips));
            lVar.e(2, this.quz.qur.mController.tml.getString(R.l.app_delete));
        } else if (NoteEditorUI.d(this.quz.qur) == 4) {
            lVar.e(9, this.quz.qur.getString(R.l.favorite_share_with_friend));
            if (a.caO()) {
                lVar.e(12, this.quz.qur.mController.tml.getString(R.l.favorite_post_to_sns));
            }
            lVar.e(10, this.quz.qur.getString(R.l.plugin_favorite_opt));
        }
    }
}
