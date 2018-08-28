package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.ui.SelectAlbumPreviewFolderUI.b;

class SelectAlbumPreviewFolderUI$a extends a<b> implements OnClickListener {
    final /* synthetic */ SelectAlbumPreviewFolderUI jEF;
    Context mContext;

    public SelectAlbumPreviewFolderUI$a(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, Context context) {
        this.jEF = selectAlbumPreviewFolderUI;
        this.mContext = context;
    }

    public final int getItemCount() {
        return SelectAlbumPreviewFolderUI.a(this.jEF).size() + 1;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.jEF, AlbumPreviewUI.class);
        intent.putExtra("select_folder_name", (AlbumItem) view.getTag());
        intent.setFlags(67108864);
        this.jEF.setResult(-1, intent);
        this.jEF.finish();
    }
}
