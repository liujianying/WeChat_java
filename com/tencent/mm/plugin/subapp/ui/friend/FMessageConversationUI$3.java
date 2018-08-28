package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class FMessageConversationUI$3 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ FMessageConversationUI ose;

    FMessageConversationUI$3(FMessageConversationUI fMessageConversationUI, k kVar) {
        this.ose = fMessageConversationUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < FMessageConversationUI.b(this.ose).getHeaderViewsCount()) {
            x.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
        } else {
            View view2 = view;
            this.hle.a(view2, i - FMessageConversationUI.b(this.ose).getHeaderViewsCount(), j, this.ose, FMessageConversationUI.c(this.ose));
        }
        return true;
    }
}
