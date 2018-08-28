package com.tencent.mm.plugin.gallery.ui;

import java.util.ArrayList;

class SelectAlbumPreviewFolderUI$2 implements Runnable {
    final /* synthetic */ SelectAlbumPreviewFolderUI jEF;
    final /* synthetic */ ArrayList jEG;

    SelectAlbumPreviewFolderUI$2(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, ArrayList arrayList) {
        this.jEF = selectAlbumPreviewFolderUI;
        this.jEG = arrayList;
    }

    public final void run() {
        SelectAlbumPreviewFolderUI.a(this.jEF).addAll(this.jEG);
        SelectAlbumPreviewFolderUI.b(this.jEF).RR.notifyChanged();
    }
}
