package com.tencent.mm.plugin.music;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mm.an.f;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.model.f.b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a implements com.tencent.mm.an.a.a {
    public final f mr(String str) {
        f ID = h.bih().ID(str);
        if (ID == null) {
            x.e("MicroMsg.PieceDataSourceImp", "initData pMusic is null!'");
        }
        return ID;
    }

    public final String ms(String str) {
        f fVar;
        b bih = h.bih();
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
            fVar = null;
        } else {
            int i;
            String IE = com.tencent.mm.plugin.music.d.a.IE(str);
            fVar = bih.ID(IE);
            if (fVar == null) {
                fVar = new f();
                i = 0;
            } else {
                i = 1;
            }
            fVar.field_musicId = IE;
            fVar.field_musicUrl = str;
            fVar.field_fileName = com.tencent.mm.plugin.music.d.a.IF(str);
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[]{IE, fVar.field_fileName});
            if (i != 0) {
                x.i("MicroMsg.PieceMusicInfoStorage", "update PieceMusicInfo");
                bih.c(fVar, new String[0]);
            } else {
                x.i("MicroMsg.PieceMusicInfoStorage", "insert PieceMusicInfo");
                bih.b(fVar);
            }
            bih.lzX.put(IE, fVar);
        }
        if (fVar == null) {
            return null;
        }
        List arrayList = new ArrayList(1);
        arrayList.add(fVar.field_musicId);
        new d(arrayList).bhJ();
        return fVar.field_musicId;
    }

    public final void mt(String str) {
        b bih = h.bih();
        int delete = bih.diF.delete("PieceMusicInfo", "musicId=?", new String[]{str});
        x.i("MicroMsg.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[]{Integer.valueOf(delete), str});
        bih.lzX.remove(str);
    }

    public final void k(String str, byte[] bArr) {
        b bih = h.bih();
        ContentValues contentValues = new ContentValues();
        contentValues.put("indexBitData", bArr);
        if (bih.diF.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str}) <= 0) {
            x.i("MicroMsg.PieceMusicInfoStorage", "updateMusicFileIndexBitCache raw=%d musicId=%s", new Object[]{Integer.valueOf(bih.diF.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str})), str});
        }
        f fVar = (f) bih.lzX.get(str);
        if (fVar != null) {
            fVar.field_indexBitData = bArr;
        }
    }

    public final void P(String str, int i) {
        b bih = h.bih();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fileCacheComplete", Integer.valueOf(i));
        int update = bih.diF.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
        x.i("MicroMsg.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        f fVar = (f) bih.lzX.get(str);
        if (fVar != null) {
            fVar.field_fileCacheComplete = i;
        }
    }

    public final void aq(String str, String str2) {
        f ID = h.bih().ID(str);
        if (ID == null) {
            x.e("MicroMsg.PieceDataSourceImp", "setMusicMIMETypeByMusicId pMusic is null!'");
        } else if (TextUtils.isEmpty(ID.field_pieceFileMIMEType) || !ID.field_pieceFileMIMEType.equals(str2)) {
            x.e("MicroMsg.PieceDataSourceImp", "updatePieceFileMIMEType()'");
            b bih = h.bih();
            ContentValues contentValues = new ContentValues();
            contentValues.put("pieceFileMIMEType", str2);
            int update = bih.diF.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", new Object[]{Integer.valueOf(update), str});
            ID = (f) bih.lzX.get(str);
            if (ID != null) {
                ID.field_pieceFileMIMEType = str2;
            }
        } else {
            x.i("MicroMsg.PieceDataSourceImp", "don't need update the piece fle mime type");
        }
    }

    public final String mu(String str) {
        f ID = h.bih().ID(str);
        if (ID == null) {
            x.e("MicroMsg.PieceDataSourceImp", "getMusicMIMETypeByMusicId pMusic is null!'");
            return null;
        }
        x.i("MicroMsg.PieceDataSourceImp", "music field_pieceFileMIMEType:%s", new Object[]{ID.field_pieceFileMIMEType});
        if (!TextUtils.isEmpty(ID.field_pieceFileMIMEType)) {
            return ID.field_pieceFileMIMEType;
        }
        x.e("MicroMsg.PieceDataSourceImp", "field_pieceFileMIMEType is null!'");
        return null;
    }

    public final String mv(String str) {
        return com.tencent.mm.plugin.music.model.a.b.mv(str);
    }
}
