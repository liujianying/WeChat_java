package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.TbsVideoCacheTask;

public class CommonActivityTask extends GameProcessActivityTask {
    public static final Creator<CommonActivityTask> CREATOR = new 3();
    public Bundle jfZ;
    public int type;

    /* synthetic */ CommonActivityTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, a aVar) {
        String string;
        String string2;
        switch (this.type) {
            case 1:
                string = this.jfZ.getString("result");
                if (!bi.oW(string)) {
                    string2 = this.jfZ.getString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                    int i = this.jfZ.getInt("codeType");
                    int i2 = this.jfZ.getInt("codeVersion");
                    Intent intent = new Intent();
                    intent.setClass(context, WebviewScanImageActivity.class);
                    intent.setFlags(603979776);
                    intent.putExtra("key_string_for_scan", string);
                    intent.putExtra("key_string_for_url", string2);
                    intent.putExtra("key_codetype_for_scan", i);
                    intent.putExtra("key_codeversion_for_scan", i2);
                    context.startActivity(intent);
                    aVar.ahz();
                    return;
                }
                return;
            case 2:
                string2 = this.jfZ.getString("img_path");
                if (o.Wf(string2)) {
                    EmojiInfo zi = ((c) g.n(c.class)).getEmojiMgr().zi(com.tencent.mm.a.g.cu(string2));
                    EmojiInfo zi2 = (zi == null || !zi.cnv()) ? ((c) g.n(c.class)).getEmojiMgr().zi(((c) g.n(c.class)).getEmojiMgr().zj(string2)) : zi;
                    boolean cm = zi2 == null ? false : e.cm(zi2.cnF());
                    string = zi2 == null ? string2 : zi2.cnF();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    boolean z = (com.tencent.mm.sdk.platformtools.c.decodeFile(string, options) != null && options.outHeight > b.Az()) || options.outWidth > b.Az();
                    if (cm > b.AA() || z) {
                        h.a(context, context.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", context.getString(R.l.i_know_it), null);
                        h.a(context, context.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", context.getString(R.l.i_know_it), "", false, new 1(this, aVar), new 2(this, aVar));
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", zi2 != null ? zi2.Xh() : "");
                    intent2.putExtra("Retr_Msg_Type", 5);
                    intent2.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.plugin.webview.a.a.ezn.l(intent2, context);
                    aVar.ahz();
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("Retr_File_Name", string2);
                intent3.putExtra("Retr_Compress_Type", 0);
                intent3.putExtra("Retr_Msg_Type", 0);
                intent3.addFlags(268435456);
                com.tencent.mm.plugin.webview.a.a.ezn.l(intent3, context);
                aVar.ahz();
                return;
            default:
                return;
        }
    }

    public final void aaj() {
    }

    public final void g(Parcel parcel) {
        this.type = parcel.readInt();
        this.jfZ = parcel.readBundle(getClass().getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.jfZ);
    }

    public CommonActivityTask(Context context) {
        super(context);
        this.jfZ = new Bundle();
    }

    private CommonActivityTask(Parcel parcel) {
        this.jfZ = new Bundle();
        g(parcel);
    }
}
