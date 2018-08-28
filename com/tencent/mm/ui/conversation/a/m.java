package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class m extends b implements OnClickListener {
    public final int getLayoutId() {
        return R.i.mainframe_banner_header_view;
    }

    public final void onClick(View view) {
        gW((Context) this.qJS.get());
        g.Ek();
        g.Ei().DT().a(a.sYX, Boolean.valueOf(false));
        if (this.view != null) {
            this.view.setVisibility(8);
        }
    }

    private static int czf() {
        if (VERSION.SDK_INT < 23) {
            return 1;
        }
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        try {
            boolean isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(ad.getContext().getPackageName());
            x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:" + isIgnoringBatteryOptimizations);
            x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + powerManager.isDeviceIdleMode());
            return !isIgnoringBatteryOptimizations ? 2 : 3;
        } catch (Exception e) {
            x.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
            return 3;
        }
    }

    public static void gW(Context context) {
        if (context != null) {
            switch (czf()) {
                case 1:
                case 3:
                    int i;
                    String str = Build.BRAND;
                    if (str != null) {
                        if (str.toLowerCase().startsWith("samsung")) {
                            i = R.l.msg_delay_wording_samsung;
                        } else if (!str.toLowerCase().equalsIgnoreCase("huawei")) {
                            i = R.l.msg_delay_wording_other;
                        } else if (VERSION.SDK_INT == 21 || VERSION.SDK_INT == 22 || VERSION.SDK_INT == 23) {
                            i = R.l.msg_delay_wording_huawei_lm;
                        } else if (VERSION.SDK_INT == 24) {
                            i = R.l.msg_delay_wording_huawei_n;
                        }
                        if (i <= 0) {
                            h.a(context, context.getString(i), "", new 1());
                            return;
                        } else {
                            x.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                            return;
                        }
                    }
                    i = R.l.msg_delay_wording_other;
                    if (i <= 0) {
                        x.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                        return;
                    } else {
                        h.a(context, context.getString(i), "", new 1());
                        return;
                    }
                case 2:
                    x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
                    Intent data = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + ad.getContext().getPackageName()));
                    data.setFlags(268435456);
                    context.startActivity(data);
                    return;
                default:
                    return;
            }
        }
    }

    public static void gX(Context context) {
        Exception e;
        String absolutePath;
        bd bdVar;
        long currentTimeMillis;
        Throwable th;
        context.getString(R.l.app_tip);
        p a = h.a(context, context.getString(R.l.app_waiting), true, new 2());
        List<com.tencent.mm.af.a.a> Oa = com.tencent.mm.af.a.Oa();
        StringBuilder stringBuilder = new StringBuilder();
        if (Oa != null) {
            for (com.tencent.mm.af.a.a aVar : Oa) {
                stringBuilder.append(aVar.toString());
                x.i("MicroMsg.MsgDelayTipsBanner", aVar.toString());
            }
        }
        if (a != null) {
            a.dismiss();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        au.HU();
        e.d(new String[]{stringBuilder2.append(c.FL()).append("/delayedMsg").toString()});
        File file = new File(r0, "data.txt");
        String stringBuilder3 = stringBuilder.toString();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                x.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + e2.getMessage());
            }
        }
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                fileOutputStream.write((stringBuilder3 + "\n").getBytes("UTF-8"));
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                    x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e3.getMessage());
                }
            } catch (Exception e4) {
                e3 = e4;
                try {
                    x.i("MicroMsg.MsgDelayTipsBanner", "exception:" + e3.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e32) {
                            x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e32.getMessage());
                        }
                    }
                    Toast.makeText(context, file.getAbsolutePath(), 1).show();
                    absolutePath = file.getAbsolutePath();
                    bdVar = new bd();
                    bdVar.ep("weixin");
                    bdVar.setContent(absolutePath);
                    bdVar.setType(1);
                    bdVar.eX(0);
                    if (bdVar.field_isSend == 1) {
                        bdVar.setStatus(4);
                    } else {
                        bdVar.setStatus(3);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    bdVar.ax(currentTimeMillis);
                    bdVar.ay(currentTimeMillis);
                    ((i) g.l(i.class)).bcY().T(bdVar);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e22) {
                            x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e22.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            fileOutputStream = null;
            x.i("MicroMsg.MsgDelayTipsBanner", "exception:" + e32.getMessage());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e322) {
                    x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e322.getMessage());
                }
            }
            Toast.makeText(context, file.getAbsolutePath(), 1).show();
            absolutePath = file.getAbsolutePath();
            bdVar = new bd();
            bdVar.ep("weixin");
            bdVar.setContent(absolutePath);
            bdVar.setType(1);
            bdVar.eX(0);
            if (bdVar.field_isSend == 1) {
                bdVar.setStatus(3);
            } else {
                bdVar.setStatus(4);
            }
            currentTimeMillis = System.currentTimeMillis();
            bdVar.ax(currentTimeMillis);
            bdVar.ay(currentTimeMillis);
            ((i) g.l(i.class)).bcY().T(bdVar);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e222) {
                    x.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e222.getMessage());
                }
            }
            throw th;
        }
        Toast.makeText(context, file.getAbsolutePath(), 1).show();
        absolutePath = file.getAbsolutePath();
        bdVar = new bd();
        bdVar.ep("weixin");
        bdVar.setContent(absolutePath);
        bdVar.setType(1);
        bdVar.eX(0);
        if (bdVar.field_isSend == 1) {
            bdVar.setStatus(4);
        } else {
            bdVar.setStatus(3);
        }
        currentTimeMillis = System.currentTimeMillis();
        bdVar.ax(currentTimeMillis);
        bdVar.ay(currentTimeMillis);
        ((i) g.l(i.class)).bcY().T(bdVar);
    }

    public final boolean anR() {
        x.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
        g.Ek();
        x.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", new Object[]{Boolean.valueOf(g.Ei().DT().getBoolean(a.sYX, false))});
        if (g.Ei().DT().getBoolean(a.sYX, false)) {
            if (this.view != null) {
                this.view.setVisibility(0);
            }
        } else if (this.view != null) {
            this.view.setVisibility(8);
        }
        return super.anR();
    }

    public final void destroy() {
    }
}
