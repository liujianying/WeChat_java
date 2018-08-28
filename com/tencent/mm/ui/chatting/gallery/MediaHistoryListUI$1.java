package com.tencent.mm.ui.chatting.gallery;

class MediaHistoryListUI$1 implements Runnable {
    final /* synthetic */ MediaHistoryListUI tXJ;

    MediaHistoryListUI$1(MediaHistoryListUI mediaHistoryListUI) {
        this.tXJ = mediaHistoryListUI;
    }

    public final void run() {
        MediaHistoryListUI.a(this.tXJ).clearFocus();
    }
}
