package com.tencent.mm.plugin.gallery.ui;

class ImageFolderMgrView$4 implements Runnable {
    final /* synthetic */ ImageFolderMgrView jDn;

    ImageFolderMgrView$4(ImageFolderMgrView imageFolderMgrView) {
        this.jDn = imageFolderMgrView;
    }

    public final void run() {
        ImageFolderMgrView.d(this.jDn).notifyDataSetChanged();
    }

    public final String toString() {
        return super.toString() + "|onQueryAlbumFinished";
    }
}
