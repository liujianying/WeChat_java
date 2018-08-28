package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.sdk.platformtools.x;

class m$5 implements OnItemSelectedListener {
    final /* synthetic */ m qNl;

    m$5(m mVar) {
        this.qNl = mVar;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
