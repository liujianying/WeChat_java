package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

class SelectAlbumPreviewFolderUI$b extends t {
    public TextView eCn = ((TextView) this.jEz.findViewById(R.h.folder_name));
    public ImageView jBN = ((ImageView) this.jEz.findViewById(R.h.folder_thumb));
    public TextView jCS = ((TextView) this.jEz.findViewById(R.h.folder_count));
    public ImageView jCT = ((ImageView) this.jEz.findViewById(R.h.folder_selected_iv));
    final /* synthetic */ SelectAlbumPreviewFolderUI jEF;
    public View jEz;
    public ImageView jeF = ((ImageView) this.jEz.findViewById(R.h.video_mask));

    public SelectAlbumPreviewFolderUI$b(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI, View view) {
        this.jEF = selectAlbumPreviewFolderUI;
        super(view);
        this.jEz = view;
    }
}
