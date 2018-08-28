package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.b;

class NoteEditorUI$a extends b {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$a(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void caW() {
        NoteEditorUI.X(this.qur);
    }

    public final void caX() {
        NoteEditorUI.X(this.qur);
    }

    public final void caY() {
        NoteEditorUI.Y(this.qur).iVS = true;
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (recyclerView.getLayoutManager() != null) {
            View childAt = ((LinearLayoutManager) NoteEditorUI.K(this.qur).getLayoutManager()).getChildAt(0);
            if (childAt != null) {
                NoteEditorUI.b(this.qur, childAt.getTop());
                NoteEditorUI.a(this.qur, LinearLayoutManager.bd(childAt));
            }
        }
    }
}
