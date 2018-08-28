package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.game.model.e;
import java.util.LinkedList;

public class GameIndexListView$b extends a<a> {
    final /* synthetic */ GameIndexListView jYS;
    LinkedList<e> jYT = new LinkedList();

    public GameIndexListView$b(GameIndexListView gameIndexListView) {
        this.jYS = gameIndexListView;
    }

    public final int getItemViewType(int i) {
        return ((e) this.jYT.get(i)).type;
    }

    public final int getItemCount() {
        return this.jYT.size();
    }
}
