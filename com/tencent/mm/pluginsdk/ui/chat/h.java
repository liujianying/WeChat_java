package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

final class h {
    private ContentResolver evN = this.mContext.getContentResolver();
    protected Context mContext;

    protected h(Context context) {
        this.mContext = context;
    }

    private String TP(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            return null;
        }
        try {
            Cursor query = this.evN.query(Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                x.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:" + str);
                return null;
            }
            String string;
            if (query.moveToFirst()) {
                do {
                    string = query.getString(query.getColumnIndexOrThrow("_data"));
                } while (query.moveToNext());
            } else {
                string = null;
            }
            query.close();
            return string;
        } catch (Exception e) {
            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[]{e.toString()});
            return null;
        }
    }

    public final ArrayList<g> ceR() {
        ArrayList<g> arrayList = new ArrayList();
        String str = "date_added desc limit 1";
        String[] strArr = new String[]{"_id", "_data", "date_added"};
        bi.VF();
        try {
            Cursor query = this.evN.query(Media.EXTERNAL_CONTENT_URI, strArr, null, null, str);
            if (query == null) {
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String TP = TP(string);
                    if (bi.oW(string2) || !e.cn(string2)) {
                        x.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(com.tencent.mm.compatible.util.e.dgl)) {
                        x.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        g gVar = new g();
                        gVar.qMM = bi.getLong(string, 0);
                        gVar.jAV = bi.getLong(string3, 0);
                        if (!bi.oW(TP) && e.cn(TP)) {
                            gVar.bOX = TP;
                        }
                        if (!bi.oW(string2) && e.cn(string2)) {
                            gVar.qMN = string2;
                        }
                        if (bi.oW(gVar.qMN) && bi.oW(gVar.qMN)) {
                            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        } else {
                            arrayList.add(gVar);
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[]{e.toString()});
            return null;
        }
    }
}
