package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.or;
import com.tencent.mm.m.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.webwx.a.g.3;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class g$3$1 implements e {
    final /* synthetic */ d qmh;
    final /* synthetic */ or qmi;
    final /* synthetic */ 3 qmj;

    g$3$1(3 3, d dVar, or orVar) {
        this.qmj = 3;
        this.qmh = dVar;
        this.qmi = orVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        Intent intent;
        CharSequence charSequence;
        Object charSequence2;
        Intent intent2;
        au.DF().b(971, this);
        uv uvVar = (uv) this.qmh.dZf.dIE.dIL;
        x.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            if (uvVar.ryf != null) {
                intent = new Intent();
                intent.putExtra("intent.key.login.url", this.qmi.bZC.bZD);
                intent.putExtra("intent.key.type", 0);
                intent.putExtra("intent.key.icon.type", uvVar.ryf.ryb);
                intent.putExtra("intent.key.ok.string", uvVar.ryf.ryp);
                intent.putExtra("intent.key.cancel.string", uvVar.ryf.ryq);
                intent.putExtra("intent.key.title.string", uvVar.ryf.ryc);
                intent.putExtra("intent.key.content.string", uvVar.ryf.ryu);
                intent.putExtra("intent.key.login.client.version", uvVar.ryj);
                intent.putExtra("intent.key.function.control", uvVar.ryk);
                String str2 = uvVar.ryf.ryc;
                StringBuilder stringBuilder = new StringBuilder();
                Cursor cursor = null;
                try {
                    au.HU();
                    cursor = c.FW().a(s.dAN, null, a.dhR, true);
                    if (cursor != null) {
                        int count;
                        if (cursor.getCount() < uvVar.ryf.ryr) {
                            count = cursor.getCount();
                        } else {
                            count = uvVar.ryf.ryr;
                        }
                        int columnIndex = cursor.getColumnIndex("username");
                        for (int i3 = 0; i3 < count; i3++) {
                            if (cursor.moveToPosition(i3)) {
                                stringBuilder.append(cursor.getString(columnIndex));
                                if (i3 < count - 1) {
                                    stringBuilder.append(",");
                                }
                            }
                        }
                    }
                    intent.putExtra("intent.key.ok.session.list", stringBuilder.toString());
                    if (cursor != null) {
                        cursor.close();
                        charSequence2 = str2;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                        charSequence2 = str2;
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                charSequence2 = str2;
            }
            charSequence2 = null;
            intent = null;
        } else if (i2 == -1) {
            if (uvVar.ryg != null) {
                intent2 = new Intent();
                intent2.putExtra("intent.key.login.url", this.qmi.bZC.bZD);
                intent2.putExtra("intent.key.type", -1);
                intent2.putExtra("intent.key.title.string", uvVar.ryg.ryd);
                intent2.putExtra("intent.key.icon.type", uvVar.ryg.ryb);
                intent2.putExtra("intent.key.ok.string", uvVar.ryg.rye);
                intent2.putExtra("intent.key.content.string", uvVar.ryg.ryc);
                charSequence2 = uvVar.ryg.ryc;
                intent = intent2;
            }
            charSequence2 = null;
            intent = null;
        } else {
            if (i2 == -2 && uvVar.ryh != null) {
                intent2 = new Intent();
                intent2.putExtra("intent.key.login.url", this.qmi.bZC.bZD);
                intent2.putExtra("intent.key.type", -2);
                intent2.putExtra("intent.key.title.string", uvVar.ryh.ryd);
                intent2.putExtra("intent.key.icon.type", uvVar.ryh.ryb);
                intent2.putExtra("intent.key.ok.string", uvVar.ryh.rye);
                intent2.putExtra("intent.key.content.string", uvVar.ryh.ryc);
                charSequence2 = uvVar.ryh.ryc;
                intent = intent2;
            }
            charSequence2 = null;
            intent = null;
        }
        if (intent != null) {
            intent.setFlags(268435456);
            intent.setClass(ad.getContext(), ExtDeviceWXLoginUI.class);
            ad.getContext().startActivity(intent);
            intent2 = new Intent(intent);
            intent2.setFlags(67108864);
            if (this.qmi.bZC.type == 1) {
                Notification notification = new Builder(ad.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(ad.getContext().getString(R.l.app_name)).setContentText(charSequence2).setContentIntent(PendingIntent.getActivity(ad.getContext(), 0, intent2, 134217728)).getNotification();
                notification.icon = com.tencent.mm.bf.a.cbg();
                notification.flags |= 16;
                notification.sound = RingtoneManager.getDefaultUri(2);
                au.getNotification().notify(38, notification);
            }
        }
    }
}
