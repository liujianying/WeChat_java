package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.b.a;

class QConversationUI$10 implements OnItemLongClickListener {
    final /* synthetic */ QConversationUI mbV;
    final /* synthetic */ a mbW;

    QConversationUI$10(QConversationUI qConversationUI, a aVar) {
        this.mbV = qConversationUI;
        this.mbW = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < QConversationUI.c(this.mbV).getHeaderViewsCount()) {
            x.w("MicroMsg.QConversationUI", "on header view long click, ignore");
            return true;
        }
        this.mbW.a(view, i, j, this.mbV, QConversationUI.d(this.mbV), 0, 0);
        return true;
    }
}
