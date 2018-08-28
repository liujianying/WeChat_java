package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.ui.GameMessageUI.2;

class GameMessageUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 kbd;

    GameMessageUI$2$1(2 2) {
        this.kbd = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((c) g.l(c.class)).aSj().fV("GameRawMessage", "delete from GameRawMessage");
        GameMessageUI.b(this.kbd.kbc).WS();
        GameMessageUI.b(this.kbd.kbc).notifyDataSetChanged();
    }
}
