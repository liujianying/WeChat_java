package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.api.i;
import com.tencent.mm.g.c.as;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class EmojiInfo extends as implements Parcelable, i {
    public static final Creator<EmojiInfo> CREATOR = new 1();
    public static int TYPE_TEXT = 4;
    protected static a dhO;
    public static final String ihe = File.separator;
    public static int tcB = 65;
    public static String tcC = ".gif";
    public static int tcD = 17;
    public static int tcE = 32;
    public static int tcF = 49;
    public static int tcG = 50;
    public static int tcH = 81;
    public static int tcI = 1;
    public static int tcJ = 2;
    public static int tcK = 3;
    public static int tcL = 10;
    public static int tcM = 11;
    public static int tcN = 0;
    public static int tcO = 1;
    public static int tcP = 3;
    public static int tcQ = 4;
    public static int tcR = 8;
    public static int tcS = 0;
    public static int tcT = 1;
    public static int tcU = 0;
    public static int tcV = 1;
    public static int tcW = 1;
    public static int tcx = -1;
    public final String mcn;
    public String talker;

    static {
        a aVar = new a();
        aVar.sKy = new Field[33];
        aVar.columns = new String[34];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5";
        aVar.sKA.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.sKz = "md5";
        aVar.columns[1] = "svrid";
        aVar.sKA.put("svrid", "TEXT");
        stringBuilder.append(" svrid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "catalog";
        aVar.sKA.put("catalog", "INTEGER");
        stringBuilder.append(" catalog INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "size";
        aVar.sKA.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "start";
        aVar.sKA.put("start", "INTEGER");
        stringBuilder.append(" start INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "state";
        aVar.sKA.put("state", "INTEGER");
        stringBuilder.append(" state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "name";
        aVar.sKA.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "content";
        aVar.sKA.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.sKA.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.sKA.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.sKA.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.sKA.put("reserved4", "INTEGER");
        stringBuilder.append(" reserved4 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "app_id";
        aVar.sKA.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId";
        aVar.sKA.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastUseTime";
        aVar.sKA.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "framesInfo";
        aVar.sKA.put("framesInfo", "TEXT default '' ");
        stringBuilder.append(" framesInfo TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "idx";
        aVar.sKA.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "temp";
        aVar.sKA.put("temp", "INTEGER default '0' ");
        stringBuilder.append(" temp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "source";
        aVar.sKA.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "needupload";
        aVar.sKA.put("needupload", "INTEGER default '0' ");
        stringBuilder.append(" needupload INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "designerID";
        aVar.sKA.put("designerID", "TEXT");
        stringBuilder.append(" designerID TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "thumbUrl";
        aVar.sKA.put("thumbUrl", "TEXT");
        stringBuilder.append(" thumbUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "cdnUrl";
        aVar.sKA.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "encrypturl";
        aVar.sKA.put("encrypturl", "TEXT");
        stringBuilder.append(" encrypturl TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "aeskey";
        aVar.sKA.put("aeskey", "TEXT");
        stringBuilder.append(" aeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "width";
        aVar.sKA.put("width", "INTEGER default '0' ");
        stringBuilder.append(" width INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[27] = "height";
        aVar.sKA.put("height", "INTEGER default '0' ");
        stringBuilder.append(" height INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "externUrl";
        aVar.sKA.put("externUrl", "TEXT");
        stringBuilder.append(" externUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "externMd5";
        aVar.sKA.put("externMd5", "TEXT");
        stringBuilder.append(" externMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "activityid";
        aVar.sKA.put("activityid", "TEXT");
        stringBuilder.append(" activityid TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tpurl";
        aVar.sKA.put("tpurl", "TEXT");
        stringBuilder.append(" tpurl TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "tpauthkey";
        aVar.sKA.put("tpauthkey", "TEXT");
        stringBuilder.append(" tpauthkey TEXT");
        aVar.columns[33] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    public EmojiInfo() {
        if (((h) g.Ef().DM()).ES()) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            this.mcn = stringBuilder.append(g.Ei().dqp).append("emoji/").toString();
        } else {
            this.mcn = ((c) g.n(c.class)).getProvider().Gq() + "emoji/";
        }
        reset();
    }

    public EmojiInfo(String str) {
        this.mcn = str;
        reset();
    }

    public final void reset() {
        this.field_md5 = "";
        this.field_svrid = "";
        this.field_catalog = tcD;
        this.field_type = tcI;
        this.field_size = 0;
        this.field_start = 0;
        this.field_state = tcN;
        this.field_name = "";
        this.field_content = "";
        this.field_reserved1 = "";
        this.field_reserved2 = "";
        this.field_reserved3 = 0;
        this.field_reserved4 = 0;
        this.field_app_id = "";
        this.field_temp = 0;
    }

    public final byte[] eI(int i, int i2) {
        Throwable e;
        String str;
        if (i < 0 || i2 < 0) {
            return null;
        }
        if (this.field_catalog == tcD || this.field_catalog == tcG || this.field_catalog == tcF) {
            InputStream bt;
            try {
                x.d("MicroMsg.emoji.EmojiInfo", "get name %s", new Object[]{getName()});
                bt = bt(ad.getContext(), getName());
                try {
                    bt.skip((long) i);
                    byte[] bArr = new byte[i2];
                    bt.read(bArr, 0, i2);
                    if (bt == null) {
                        return bArr;
                    }
                    try {
                        bt.close();
                        return bArr;
                    } catch (Throwable e2) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
                        return bArr;
                    }
                } catch (Throwable e3) {
                    e2 = e3;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
                        if (bt != null) {
                            try {
                                bt.close();
                            } catch (Throwable e32) {
                                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e32)});
                            }
                        }
                        str = this.mcn + Xh();
                        if (cnA()) {
                            str = this.mcn + this.field_groupId + File.separator + Xh();
                        }
                        return e.e(str, this.field_start, i2);
                    } catch (Throwable e322) {
                        e2 = e322;
                        if (bt != null) {
                            try {
                                bt.close();
                            } catch (Throwable e3222) {
                                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e3222)});
                            }
                        }
                        throw e2;
                    }
                }
            } catch (IOException e4) {
                e2 = e4;
                bt = null;
                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
                if (bt != null) {
                    try {
                        bt.close();
                    } catch (Throwable e32222) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e32222)});
                    }
                }
                str = this.mcn + Xh();
                if (cnA()) {
                    str = this.mcn + this.field_groupId + File.separator + Xh();
                }
                return e.e(str, this.field_start, i2);
            } catch (Throwable th) {
                e2 = th;
                bt = null;
                if (bt != null) {
                    try {
                        bt.close();
                    } catch (Throwable e322222) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e322222)});
                    }
                }
                throw e2;
            }
        }
        str = this.mcn + Xh();
        if (cnA()) {
            str = this.mcn + this.field_groupId + File.separator + Xh();
        }
        return e.e(str, this.field_start, i2);
    }

    public final boolean cnv() {
        if (this.field_catalog == tcD || this.field_catalog == tcG || this.field_catalog == tcF) {
            return true;
        }
        File file;
        if (bi.oW(this.field_groupId)) {
            file = new File(this.mcn + Xh());
        } else {
            file = new File(this.mcn + this.field_groupId + File.separator + Xh());
        }
        return file.exists() && file.length() > 0;
    }

    public final void cnw() {
        if (this.field_catalog != tcD && this.field_catalog != tcG && this.field_catalog != tcF) {
            File file;
            if (bi.oW(this.field_groupId)) {
                file = new File(this.mcn + Xh());
            } else {
                file = new File(this.mcn + this.field_groupId + File.separator + Xh());
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final boolean cnx() {
        if (this.field_catalog == tcD || this.field_catalog == tcG || this.field_catalog == tcF) {
            return true;
        }
        return new File(this.mcn + this.field_groupId + File.separator + Xh()).exists();
    }

    public static InputStream bt(Context context, String str) {
        InputStream inputStream = null;
        if (context == null || bi.oW(str)) {
            return inputStream;
        }
        try {
            x.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[]{str.split("\\.")[0]});
            return context.getResources().openRawResource(context.getResources().getIdentifier(r1, "drawable", context.getPackageName()));
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[]{e.getMessage()});
            return inputStream;
        }
    }

    public final synchronized Bitmap gi(Context context) {
        return gj(context);
    }

    public final synchronized Bitmap aR(Context context) {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            String name;
            if (this.field_catalog == EmojiGroupInfo.tcz || this.field_catalog == tcG || this.field_catalog == tcF) {
                name = getName();
                if (bi.oW(name)) {
                    x.i("MicroMsg.emoji.EmojiInfo", "name is null");
                    x.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[]{this});
                    bitmap = null;
                } else {
                    if (name.startsWith("jsb")) {
                        name = "jsb";
                    } else if (name.startsWith("dice")) {
                        name = "dice";
                    } else {
                        name = name.replaceAll(".png", "");
                    }
                    bitmap = com.tencent.mm.sdk.platformtools.c.s(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", ad.getPackageName())));
                    x.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[]{Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                }
            } else if (this.field_catalog == EmojiGroupInfo.tcy) {
                name = getName();
                if (bi.oW(name)) {
                    x.i("MicroMsg.emoji.EmojiInfo", "name is null");
                } else {
                    name = (bi.oW(getContent()) ? getName() : getContent()).replaceAll(".png", "");
                }
                x.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", new Object[]{name});
                bitmap = com.tencent.mm.sdk.platformtools.c.s(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", ad.getPackageName())));
                x.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[]{Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            } else {
                name = cnF() + "_cover";
                x.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", new Object[]{name, Boolean.valueOf(e.cn(name))});
                if (e.cn(name)) {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(name, options);
                    if (options.outHeight >= 480 || options.outWidth >= 480) {
                        bitmap = com.tencent.mm.sdk.platformtools.c.ai(name, 480, 480);
                    } else {
                        bitmap = com.tencent.mm.sdk.platformtools.c.ai(name, options.outHeight, options.outWidth);
                    }
                    String str = "MicroMsg.emoji.EmojiInfo";
                    String str2 = "id:%s width:%s height:%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(this.field_catalog);
                    objArr[1] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
                    if (bitmap != null) {
                        i = bitmap.getHeight();
                    }
                    objArr[2] = Integer.valueOf(i);
                    x.i(str, str2, objArr);
                } else {
                    if (e.cn(cnF())) {
                        byte[] a = ((c) g.n(c.class)).getProvider().a(this);
                        if (a == null) {
                            x.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
                            bitmap = null;
                        } else {
                            x.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", new Object[]{Integer.valueOf(a.length)});
                            if (o.bx(a)) {
                                bitmap = com.tencent.mm.plugin.gif.g.ay(a);
                            } else {
                                bitmap = com.tencent.mm.sdk.platformtools.c.decodeByteArray(a, 480, 480);
                            }
                            if (bitmap != null) {
                                x.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", new Object[]{this, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                            }
                        }
                    } else {
                        x.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", new Object[]{cnF(), Boolean.valueOf(e.cn(cnF()))});
                        x.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[]{this});
                        bitmap = null;
                    }
                }
            }
        }
        return bitmap;
    }

    public final synchronized Bitmap gj(Context context) {
        InputStream bt;
        Bitmap decodeStream;
        Throwable e;
        FileInputStream fileInputStream;
        Throwable e2;
        InputStream inputStream = null;
        synchronized (this) {
            com.tencent.mm.bp.a.fromDPToPix(context, 120);
            String name;
            if (this.field_catalog == tcD || this.field_catalog == EmojiGroupInfo.tcz || this.field_catalog == tcG || this.field_catalog == tcF) {
                try {
                    name = getName();
                    if (this.field_type == tcJ) {
                        name = bi.oW(getContent()) ? getName() : getContent();
                    }
                    bt = bt(context, name);
                    try {
                        decodeStream = com.tencent.mm.sdk.platformtools.c.decodeStream(bt);
                        if (bt != null) {
                            try {
                                bt.close();
                            } catch (Throwable e3) {
                                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e3)});
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bt = null;
                } catch (Throwable th) {
                    e = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32) {
                            x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e32)});
                        }
                    }
                    throw e;
                }
            }
            try {
                File file;
                if (cnA()) {
                    String str;
                    name = cnF();
                    if (name == null) {
                        str = this.mcn + this.field_groupId + File.separator + Xh() + "_0";
                    } else {
                        str = name;
                    }
                    file = new File(str);
                } else {
                    file = new File(this.mcn + Xh() + "_thumb");
                }
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        decodeStream = com.tencent.mm.sdk.platformtools.c.decodeStream(fileInputStream);
                    } catch (FileNotFoundException e6) {
                        e2 = e6;
                        decodeStream = null;
                    } catch (Exception e7) {
                        e2 = e7;
                        decodeStream = null;
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
                        x.e("MicroMsg.emoji.EmojiInfo", e2.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e322) {
                                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e322)});
                            }
                        }
                        return decodeStream;
                    }
                }
                if (!cnA()) {
                    fileInputStream = new FileInputStream(this.mcn + Xh());
                    decodeStream = com.tencent.mm.sdk.platformtools.c.decodeStream(fileInputStream);
                } else if (VERSION.SDK_INT < 19) {
                    fileInputStream = new FileInputStream(this.mcn + this.field_groupId + File.separator + Xh());
                    decodeStream = com.tencent.mm.sdk.platformtools.c.decodeStream(fileInputStream);
                } else {
                    fileInputStream = null;
                    decodeStream = null;
                }
                try {
                    if (cnA()) {
                        x.d("MicroMsg.emoji.EmojiInfo", "cpan emojiinfo save cover.");
                        if (!new File(this.mcn + this.field_groupId + File.separator + Xh() + "_cover").exists() && VERSION.SDK_INT < 19) {
                            com.tencent.mm.sdk.platformtools.c.a(decodeStream, 100, CompressFormat.PNG, this.mcn + this.field_groupId + File.separator + Xh() + "_cover", false);
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.c.a(decodeStream, 100, CompressFormat.PNG, this.mcn + Xh() + "_thumb", false);
                    }
                } catch (Throwable e3222) {
                    e2 = e3222;
                } catch (Throwable e32222) {
                    e2 = e32222;
                    x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
                    x.e("MicroMsg.emoji.EmojiInfo", e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e322222) {
                            x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e322222)});
                        }
                    }
                    return decodeStream;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e3222222) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e3222222)});
                    }
                }
            } catch (FileNotFoundException e8) {
                e2 = e8;
                fileInputStream = null;
                decodeStream = null;
            } catch (Exception e9) {
                e2 = e9;
                fileInputStream = null;
                decodeStream = null;
                x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
                x.e("MicroMsg.emoji.EmojiInfo", e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e32222222) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e32222222)});
                    }
                }
                return decodeStream;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e322222222) {
                        x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e322222222)});
                    }
                }
                throw e;
            }
        }
        return decodeStream;
        try {
            x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e2)});
            x.e("MicroMsg.emoji.EmojiInfo", e2.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e3222222222) {
                    x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e3222222222)});
                }
            }
            return decodeStream;
        } catch (Throwable th3) {
            e = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e32222222222) {
                    x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e32222222222)});
                }
            }
            throw e;
        }
        try {
            x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e)});
            if (bt != null) {
                try {
                    bt.close();
                    decodeStream = null;
                } catch (Throwable e10) {
                    x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e10)});
                    decodeStream = null;
                }
            } else {
                decodeStream = null;
            }
            return decodeStream;
        } catch (Throwable th4) {
            e10 = th4;
            inputStream = bt;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e322222222222) {
                    x.e("MicroMsg.emoji.EmojiInfo", "exception:%s", new Object[]{bi.i(e322222222222)});
                }
            }
            throw e10;
        }
    }

    public final boolean aaq() {
        return this.field_catalog == tcG || this.field_catalog == tcF;
    }

    public final boolean cny() {
        return this.field_catalog == tcD || this.field_catalog == tcG || this.field_catalog == tcF;
    }

    public final boolean cnz() {
        return this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    }

    public final boolean isGif() {
        return this.field_type == tcJ || this.field_type == tcL;
    }

    public static boolean Dr(int i) {
        return i == tcG || i == tcF;
    }

    public final boolean cnA() {
        if (!bi.oW(this.field_app_id) || bi.oW(this.field_groupId) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.tcz)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.tcy)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.tcA)) || this.field_groupId.equals(String.valueOf(tcB))) {
            return false;
        }
        return true;
    }

    public final void po(String str) {
        this.field_md5 = str;
    }

    public final String Xh() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    public final boolean cnB() {
        return Xh().length() == 32;
    }

    public final String cnC() {
        return this.field_svrid == null ? "" : this.field_svrid;
    }

    public final void Ds(int i) {
        this.field_catalog = i;
    }

    public final void setType(int i) {
        this.field_type = i;
    }

    public final void setSize(int i) {
        this.field_size = i;
    }

    public final String getName() {
        return this.field_name == null ? "" : this.field_name;
    }

    public final String getContent() {
        return this.field_content == null ? "" : this.field_content;
    }

    public final void cnD() {
        this.field_temp = 1;
    }

    protected final a AX() {
        return dhO;
    }

    public final boolean cnE() {
        if (this.field_catalog == tcD || this.field_catalog == EmojiGroupInfo.tcz || this.field_catalog == tcG || this.field_catalog == tcF) {
            return true;
        }
        File file;
        if (cnA()) {
            String cnF = cnF();
            if (cnF == null) {
                cnF = this.mcn + this.field_groupId + File.separator + Xh();
            }
            file = new File(cnF);
        } else {
            file = new File(this.mcn + Xh());
        }
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public final String cnF() {
        if (bi.oW(this.field_groupId) && bi.oW(this.field_md5)) {
            x.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
            return null;
        } else if (bi.oW(this.field_md5)) {
            return null;
        } else {
            if (bi.oW(this.field_groupId)) {
                return this.mcn + this.field_md5;
            }
            return this.mcn + this.field_groupId + ihe + this.field_md5;
        }
    }

    public boolean equals(Object obj) {
        return cl(obj);
    }

    public final boolean cl(Object obj) {
        if (obj != null && (obj instanceof EmojiInfo) && ((EmojiInfo) obj).Xh().equalsIgnoreCase(this.field_md5)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_md5:").append(this.field_md5).append("\n");
        stringBuilder.append("field_svrid:").append(this.field_svrid).append("\n");
        stringBuilder.append("field_catalog:").append(this.field_catalog).append("\n");
        stringBuilder.append("field_type:").append(this.field_type).append("\n");
        stringBuilder.append("field_size:").append(this.field_size).append("\n");
        stringBuilder.append("field_start:").append(this.field_start).append("\n");
        stringBuilder.append("field_state:").append(this.field_state).append("\n");
        stringBuilder.append("field_name:").append(this.field_name).append("\n");
        stringBuilder.append("field_content:").append(this.field_content).append("\n");
        stringBuilder.append("field_reserved1:").append(this.field_reserved1).append("\n");
        stringBuilder.append("field_reserved2:").append(this.field_reserved2).append("\n");
        stringBuilder.append("field_reserved3:").append(this.field_reserved3).append("\n");
        stringBuilder.append("field_reserved4:").append(this.field_reserved4).append("\n");
        stringBuilder.append("field_app_id:").append(this.field_app_id).append("\n");
        stringBuilder.append("field_groupId:").append(this.field_groupId).append("\n");
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        stringBuilder.append("field_framesInfo:").append(this.field_framesInfo).append("\n");
        stringBuilder.append("field_idx:").append(this.field_idx).append("\n");
        stringBuilder.append("field_temp:").append(this.field_temp).append("\n");
        stringBuilder.append("field_source:").append(this.field_source).append("\n");
        stringBuilder.append("field_needupload:").append(this.field_needupload).append("\n");
        stringBuilder.append("field_designerID:").append(this.field_designerID).append("\n");
        stringBuilder.append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mcn);
        parcel.writeString(this.field_md5);
        parcel.writeString(this.field_svrid);
        parcel.writeInt(this.field_catalog);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_size);
        parcel.writeInt(this.field_start);
        parcel.writeInt(this.field_state);
        parcel.writeString(this.field_name);
        parcel.writeString(this.field_content);
        parcel.writeString(this.field_reserved1);
        parcel.writeString(this.field_reserved2);
        parcel.writeInt(this.field_reserved3);
        parcel.writeInt(this.field_reserved4);
        parcel.writeString(this.field_app_id);
        parcel.writeString(this.field_groupId);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeString(this.field_framesInfo);
        parcel.writeInt(this.field_idx);
        parcel.writeInt(this.field_temp);
        parcel.writeInt(this.field_source);
        parcel.writeInt(this.field_needupload);
        parcel.writeString(this.field_designerID);
        parcel.writeString(this.field_thumbUrl);
        parcel.writeString(this.field_cdnUrl);
        parcel.writeString(this.field_encrypturl);
        parcel.writeString(this.field_aeskey);
        parcel.writeInt(this.field_width);
        parcel.writeInt(this.field_height);
        parcel.writeString(this.field_activityid);
        parcel.writeLong(this.sKx);
    }

    protected EmojiInfo(Parcel parcel) {
        this.mcn = parcel.readString();
        this.field_md5 = parcel.readString();
        this.field_svrid = parcel.readString();
        this.field_catalog = parcel.readInt();
        this.field_type = parcel.readInt();
        this.field_size = parcel.readInt();
        this.field_start = parcel.readInt();
        this.field_state = parcel.readInt();
        this.field_name = parcel.readString();
        this.field_content = parcel.readString();
        this.field_reserved1 = parcel.readString();
        this.field_reserved2 = parcel.readString();
        this.field_reserved3 = parcel.readInt();
        this.field_reserved4 = parcel.readInt();
        this.field_app_id = parcel.readString();
        this.field_groupId = parcel.readString();
        this.field_lastUseTime = parcel.readLong();
        this.field_framesInfo = parcel.readString();
        this.field_idx = parcel.readInt();
        this.field_temp = parcel.readInt();
        this.field_source = parcel.readInt();
        this.field_needupload = parcel.readInt();
        this.field_designerID = parcel.readString();
        this.field_thumbUrl = parcel.readString();
        this.field_cdnUrl = parcel.readString();
        this.field_encrypturl = parcel.readString();
        this.field_aeskey = parcel.readString();
        this.field_width = parcel.readInt();
        this.field_height = parcel.readInt();
        this.field_activityid = parcel.readString();
        this.sKx = parcel.readLong();
    }
}
