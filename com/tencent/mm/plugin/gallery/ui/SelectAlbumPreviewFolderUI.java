package com.tencent.mm.plugin.gallery.ui;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(19)
public class SelectAlbumPreviewFolderUI extends MMActivity implements g.a {
    ArrayList<AlbumItem> jCO = new ArrayList(0);
    private a jEB;
    private RecyclerView jEC;
    AlbumItem jED;
    private String jEE;

    static /* synthetic */ String d(SelectAlbumPreviewFolderUI selectAlbumPreviewFolderUI) {
        if (c.aRf().aRJ() == 1) {
            return selectAlbumPreviewFolderUI.getString(R.l.gallery_all_pic);
        }
        return c.aRf().aRJ() == 3 ? selectAlbumPreviewFolderUI.getString(R.l.gallery_all_pic_and_video) : selectAlbumPreviewFolderUI.getString(R.l.gallery_all_video);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.aRf().b(this);
        c.aRf().a(this);
        c.aRf().aRK();
        this.jEC = (RecyclerView) findViewById(R.h.folder_recycler_view);
        this.jEB = new a(this, this);
        this.jEC.setLayoutManager(new LinearLayoutManager());
        this.jEC.setAdapter(this.jEB);
        this.jEE = getIntent().getStringExtra("select_folder_name");
        this.jED = new AlbumItem("", 0);
        this.jED.jAR = new ImageMediaItem();
        setMMTitle(bi.oV(getString(R.l.app_field_new_pic)));
        setBackBtn(new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        c.aRf().b(this);
    }

    protected final int getLayoutId() {
        return R.i.select_image_folder_ui;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public final void w(ArrayList<AlbumItem> arrayList) {
        new ag(Looper.getMainLooper()).post(new 2(this, arrayList));
    }
}
