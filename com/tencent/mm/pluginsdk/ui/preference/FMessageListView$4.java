package com.tencent.mm.pluginsdk.ui.preference;

import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

class FMessageListView$4 implements OnLongClickListener {
    final /* synthetic */ FMessageListView qOF;
    final /* synthetic */ b qOG;

    FMessageListView$4(FMessageListView fMessageListView, b bVar) {
        this.qOF = fMessageListView;
        this.qOG = bVar;
    }

    public final boolean onLongClick(View view) {
        x.d("MicroMsg.FMessageListView", "jacks long click digest");
        h.a(this.qOF.getContext(), null, new String[]{this.qOF.getContext().getString(R.l.chatting_copy)}, new c() {
            public final void ju(int i) {
                switch (i) {
                    case 0:
                        ((ClipboardManager) FMessageListView$4.this.qOF.getContext().getSystemService("clipboard")).setText(FMessageListView$4.this.qOG.dzA);
                        return;
                    default:
                        return;
                }
            }
        });
        return true;
    }
}
