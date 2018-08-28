package com.tencent.mm.platformtools;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import com.tencent.mm.bg.a;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.k.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e$f;

public final class z {

    /* renamed from: com.tencent.mm.platformtools.z$1 */
    static class AnonymousClass1 implements a {
        final /* synthetic */ Bundle bAE;
        final /* synthetic */ String dEt;
        final /* synthetic */ String efo;
        final /* synthetic */ String ewq;
        final /* synthetic */ int ewr;
        final /* synthetic */ String val$jumpUrl;

        public AnonymousClass1(String str, String str2, Bundle bundle, String str3, String str4, int i) {
            this.val$jumpUrl = str;
            this.ewq = str2;
            this.bAE = bundle;
            this.dEt = str3;
            this.efo = str4;
            this.ewr = i;
        }

        public final void onDone() {
            Time time = new Time();
            time.setToNow();
            if (com.tencent.mm.k.a.aQ(time.hour, time.minute)) {
                try {
                    Context context = ad.getContext();
                    boolean Ao = f.Ao();
                    boolean Am = f.Am();
                    x.d("MiroMsg.NotificationUtil", "shake " + Ao + "sound " + Am);
                    if (Ao) {
                        x.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                        bi.t(context, true);
                    }
                    if (Am) {
                        String An = f.An();
                        Uri defaultUri = An == e$f.dgL ? RingtoneManager.getDefaultUri(2) : Uri.parse(An);
                        MediaPlayer jVar = new j();
                        try {
                            jVar.setDataSource(context, defaultUri);
                            jVar.setOnCompletionListener(new 3());
                            if (au.HV().getStreamVolume(5) != 0) {
                                if (au.HV().yK()) {
                                    int streamVolume = au.HV().getStreamVolume(8);
                                    int streamMaxVolume = au.HV().getStreamMaxVolume(8);
                                    int streamVolume2 = au.HV().getStreamVolume(5);
                                    if (streamVolume2 <= streamMaxVolume) {
                                        streamMaxVolume = streamVolume2;
                                    }
                                    au.HV().aP(8, streamMaxVolume);
                                    jVar.setAudioStreamType(8);
                                    jVar.setLooping(true);
                                    jVar.prepare();
                                    jVar.setLooping(false);
                                    jVar.start();
                                    au.HV().aP(8, streamVolume);
                                    x.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", new Object[]{Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume)});
                                } else {
                                    jVar.setAudioStreamType(5);
                                    jVar.setLooping(true);
                                    jVar.prepare();
                                    jVar.setLooping(false);
                                    jVar.start();
                                }
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MiroMsg.NotificationUtil", e, "", new Object[0]);
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MiroMsg.NotificationUtil", e2, "", new Object[0]);
                }
            } else {
                x.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
            }
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$jumpUrl);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.setFlags(872415232);
            x.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", new Object[]{this.ewq, this.bAE});
            if (!(this.ewq == null || this.bAE == null)) {
                intent.putExtra("bizofstartfrom", this.ewq);
                intent.putExtra("startwebviewparams", this.bAE);
            }
            Notification notification = new Builder(ad.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.dEt).setContentText(this.efo).setContentIntent(PendingIntent.getActivity(ad.getContext(), 0, intent, 134217728)).getNotification();
            notification.icon = com.tencent.mm.bf.a.cbg();
            notification.flags |= 16;
            ((NotificationManager) ad.getContext().getSystemService("notification")).notify(this.ewr, notification);
        }
    }
}
