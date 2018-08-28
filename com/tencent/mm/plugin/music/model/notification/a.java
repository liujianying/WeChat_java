package com.tencent.mm.plugin.music.model.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.app.z.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.b;
import com.tencent.mm.plugin.music.b$a;
import com.tencent.mm.plugin.music.ui.MusicMainUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a {
    boolean huc = false;
    MMMusicPlayerService lzf;
    NotificationManager lzg;
    Runnable lzh = new 1(this);
    BroadcastReceiver lzi;

    public static void a(com.tencent.mm.an.a aVar, int i, boolean z) {
        x.i("MicroMsg.Music.MMMusicNotification", "sendMusicPlayerEvent action:%d", new Object[]{Integer.valueOf(i)});
        jt jtVar = new jt();
        jtVar.bTE.action = i;
        jtVar.bTE.state = "";
        jtVar.bTE.bTy = aVar.PV();
        jtVar.bTE.appId = "not from app brand appid";
        jtVar.bTE.bTG = z;
        com.tencent.mm.sdk.b.a.sFg.a(jtVar, Looper.getMainLooper());
    }

    final Notification a(Context context, com.tencent.mm.an.a aVar, boolean z) {
        CharSequence charSequence;
        Bitmap bitmap;
        int i;
        Intent intent = new Intent(context, MusicMainUI.class);
        intent.putExtra("key_scene", 5);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        d dVar = new d(context);
        dVar.pu = activity;
        d Y = dVar.Y(com.tencent.mm.bf.a.cbg());
        CharSequence charSequence2 = aVar.field_songName;
        String str = aVar.field_songSinger;
        if (bi.oW(aVar.field_songAlbum)) {
            Object charSequence3 = str;
        } else {
            charSequence3 = str + aVar.field_songAlbum;
        }
        if (aVar == null) {
            x.e("MicroMsg.Music.MMMusicNotification", "music is null, return");
            bitmap = null;
        } else {
            bitmap = null;
            x.i("MicroMsg.Music.MMMusicNotification", "music.field_musicType %d", new Object[]{Integer.valueOf(aVar.field_musicType)});
            switch (aVar.field_musicType) {
                case 0:
                case 5:
                case 7:
                case 10:
                case 11:
                    bitmap = o.Pf().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bp.a.getDensity(this.lzf), true);
                    break;
                case 1:
                case 8:
                case 9:
                    ate ate = new ate();
                    ate.ksA = aVar.field_songMediaId;
                    ate.rVE = aVar.field_songAlbumUrl;
                    ate.rVF = aVar.field_songAlbumType;
                    ate.jPK = ate.rVE;
                    if (n.nkx != null) {
                        bitmap = n.nkx.b(ate);
                        break;
                    }
                    break;
                case 6:
                    bitmap = o.Pf().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bp.a.getDensity(this.lzf), true);
                    break;
            }
            if (bitmap == null) {
                bitmap = o.Pj().ma(aVar.field_songAlbumUrl);
                if (bitmap == null) {
                    String h = com.tencent.mm.plugin.music.d.a.h(aVar, false);
                    com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
                    aVar2.dXA = com.tencent.mm.plugin.music.d.a.h(aVar, false);
                    aVar2.dXy = true;
                    aVar2.bg(com.tencent.mm.bp.a.ad(this.lzf, b$a.notification_large_icon_width), com.tencent.mm.bp.a.ad(this.lzf, b$a.notification_large_icon_height));
                    aVar2.dXw = true;
                    o.Pj().a(aVar.field_songAlbumUrl, aVar2.Pt(), new 3(this, aVar, h));
                }
            }
            bitmap = c.a(bitmap, false, 12.0f, false);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), b.d.remote_music_notification);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(b.c.music_notification_album, bitmap);
        } else {
            remoteViews.setImageViewResource(b.c.music_notification_album, b.b.default_icon_music);
        }
        if (bi.oW(charSequence2)) {
            remoteViews.setViewVisibility(b.c.music_notification_title, 8);
        } else {
            remoteViews.setViewVisibility(b.c.music_notification_title, 0);
            remoteViews.setTextViewText(b.c.music_notification_title, charSequence2);
        }
        if (bi.oW(charSequence3)) {
            remoteViews.setViewVisibility(b.c.music_notification_desc, 8);
        } else {
            remoteViews.setViewVisibility(b.c.music_notification_desc, 0);
            remoteViews.setTextViewText(b.c.music_notification_desc, charSequence3);
        }
        MMMusicPlayerService mMMusicPlayerService = this.lzf;
        RemoteViews remoteViews2 = new d(mMMusicPlayerService).build().contentView;
        if (remoteViews2 == null) {
            i = -16777216;
        } else {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(mMMusicPlayerService).inflate(remoteViews2.getLayoutId(), null);
            TextView textView = (TextView) viewGroup.findViewById(16908310);
            i = textView != null ? textView.getCurrentTextColor() : j(viewGroup);
        }
        i |= -16777216;
        int red = Color.red(-16777216) - Color.red(i);
        int green = Color.green(-16777216) - Color.green(i);
        i = Color.blue(-16777216) - Color.blue(i);
        Object obj = Math.sqrt((double) ((i * i) + ((red * red) + (green * green)))) < 180.0d ? 1 : null;
        Intent intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pre");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 134217728);
        remoteViews.setImageViewResource(b.c.music_notification_pre, obj != null ? b.b.remote_notification_pre_dark : b.b.remote_notification_pre_light);
        remoteViews.setOnClickPendingIntent(b.c.music_notification_pre, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        if (z) {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_pause");
        } else {
            intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_play");
        }
        broadcast = PendingIntent.getBroadcast(context, 1, intent2, 134217728);
        int i2 = b.c.music_notification_pause;
        red = z ? obj != null ? b.b.remote_notification_pause_dark : b.b.remote_notification_pause_light : obj != null ? b.b.remote_notification_play_dark : b.b.remote_notification_play_light;
        remoteViews.setImageViewResource(i2, red);
        remoteViews.setOnClickPendingIntent(b.c.music_notification_pause, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_next");
        broadcast = PendingIntent.getBroadcast(context, 2, intent2, 134217728);
        remoteViews.setImageViewResource(b.c.music_notification_next, obj != null ? b.b.remote_notification_next_dark : b.b.remote_notification_next_light);
        remoteViews.setOnClickPendingIntent(b.c.music_notification_next, broadcast);
        intent2 = new Intent("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
        intent2.putExtra("mm_music_notification_action_key", "mm_music_notification_action_close");
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 3, intent2, 134217728);
        remoteViews.setImageViewResource(b.c.music_notification_close, obj != null ? b.b.remote_notification_close_dark : b.b.remote_notification_close_light);
        remoteViews.setOnClickPendingIntent(b.c.music_notification_close, broadcast2);
        Y.pQ.contentView = remoteViews;
        return Y.build();
    }

    private static int j(ViewGroup viewGroup) {
        List<TextView> arrayList = new ArrayList();
        a(viewGroup, arrayList);
        TextView textView = null;
        for (TextView textView2 : arrayList) {
            TextView textView22;
            if (textView22.getTextSize() <= -1.0f) {
                textView22 = textView;
            }
            textView = textView22;
        }
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -16777216;
    }

    private static void a(View view, List<TextView> list) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), list);
            }
        } else if (view instanceof TextView) {
            list.add((TextView) view);
        }
    }
}
