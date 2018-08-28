package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class i extends k {
    private String[] jBb = new String[]{"camera", "screenshot", "download"};

    protected final int getType() {
        return 1;
    }

    public final ArrayList<AlbumItem> aRz() {
        return super.aRz();
    }

    public final Uri aRB() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.jBf, k.jBe + ",0) AS " + jBg, k.jBf, k.jBe, "mime_type"};
    }

    public final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    public final String aRD() {
        return k.jBg + " desc,_id desc";
    }

    protected final String aRE() {
        return "bucket_display_name";
    }

    protected final String[] aRC() {
        return new String[]{"_id", "_data", "COALESCE(" + k.jBf, k.jBe + ",0) AS " + jBg, k.jBf, k.jBe, "mime_type"};
    }

    protected final String CT(String str) {
        if (!bi.oW(str)) {
            return "bucket_display_name=\"" + str + "\"";
        }
        x.w("MicroMsg.ImageQuery", "get media item selection, but album name is null, do select all");
        String str2 = "_size>10240";
        for (String str3 : this.jBb) {
            str2 = str2 + " or lower(_data) like '%" + str3 + "%'";
        }
        x.d("MicroMsg.ImageQuery", "where %s", new Object[]{str2});
        return str2;
    }
}
