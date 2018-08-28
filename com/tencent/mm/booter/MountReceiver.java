package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.s;
import java.io.File;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MountReceiver extends BroadcastReceiver {
    private String action = "";
    private ag cWS = new 1(this, Looper.getMainLooper());
    private Context context = null;

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !ai.oW(intent.getAction())) {
            this.context = context;
            this.action = intent.getAction();
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            x.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", new Object[]{this.action, Boolean.valueOf(au.HX()), e.bnC, absolutePath});
            boolean equals = this.action.equals("android.intent.action.MEDIA_MOUNTED");
            if (equals || this.action.equals("android.intent.action.MEDIA_EJECT") || this.action.equals("android.intent.action.MEDIA_SHARED")) {
                Object obj = !e.bnC.equalsIgnoreCase("/dev/null") ? 1 : null;
                if (obj != null) {
                    try {
                        StatFs statFs = new StatFs(e.bnC);
                        x.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[]{e.bnC, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks())});
                    } catch (Exception e) {
                        x.e("MicroMsg.MountReceiver", "CheckSD failed :%s", new Object[]{e.getMessage()});
                        obj = null;
                    }
                }
                Uri data = intent.getData();
                if (data != null) {
                    String path = data.getPath();
                    if (!e.bnC.equalsIgnoreCase(path)) {
                        if (equals && obj == null) {
                            h.mEJ.a(340, e.bnC.equalsIgnoreCase("/dev/null") ? 9 : 12, 1, false);
                            if (!ai.oW(absolutePath) && absolutePath.equalsIgnoreCase(path)) {
                                if (new File(aa.duN + "SdcardInfo.cfg").exists()) {
                                    w wVar = new w(aa.duN + "SdcardInfo.cfg");
                                    String str = (String) wVar.get(1, "");
                                    int intValue = ((Integer) wVar.get(2, Integer.valueOf(0))).intValue();
                                    int i = VERSION.SDK_INT;
                                    String str2 = e.bnC;
                                    wVar.set(1, absolutePath);
                                    wVar.set(2, Integer.valueOf(i));
                                    e.ff(absolutePath);
                                    x.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", new Object[]{Integer.valueOf(intValue), str, Integer.valueOf(i), absolutePath, str2, e.bnC});
                                } else {
                                    x.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", new Object[]{e.bnC, absolutePath, Integer.valueOf(VERSION.SDK_INT)});
                                    e.bnC = absolutePath;
                                    e.ff(absolutePath);
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
                h.mEJ.a(340, equals ? 13 : 14, 1, false);
                if (equals) {
                    au.Em().H(new 2(this));
                    return;
                }
                s.gH(context);
                au.Em().H(new 3(this));
            }
        }
    }
}
