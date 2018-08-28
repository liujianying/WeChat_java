package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserServiceCompat.g;
import android.support.v4.media.MediaBrowserServiceCompat.g.1;
import android.support.v4.media.MediaBrowserServiceCompat.g.2;
import android.support.v4.media.MediaBrowserServiceCompat.g.3;
import android.support.v4.media.MediaBrowserServiceCompat.g.4;
import android.support.v4.media.MediaBrowserServiceCompat.g.5;
import android.support.v4.media.MediaBrowserServiceCompat.g.6;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;

final class MediaBrowserServiceCompat$f extends Handler {
    final /* synthetic */ MediaBrowserServiceCompat rR;
    private final g se;

    private MediaBrowserServiceCompat$f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.rR = mediaBrowserServiceCompat;
        this.se = new g(this.rR, (byte) 0);
    }

    /* synthetic */ MediaBrowserServiceCompat$f(MediaBrowserServiceCompat mediaBrowserServiceCompat, byte b) {
        this(mediaBrowserServiceCompat);
    }

    public final void handleMessage(Message message) {
        Bundle data = message.getData();
        g gVar;
        g gVar2;
        String string;
        switch (message.what) {
            case 1:
                gVar = this.se;
                String string2 = data.getString("data_package_name");
                int i = data.getInt("data_calling_uid");
                Bundle bundle = data.getBundle("data_root_hints");
                MediaBrowserServiceCompat$e mediaBrowserServiceCompat$e = new MediaBrowserServiceCompat$e(this.rR, message.replyTo);
                if (MediaBrowserServiceCompat.a(gVar.rR, string2, i)) {
                    MediaBrowserServiceCompat.a(gVar.rR).c(new 1(gVar, mediaBrowserServiceCompat$e, string2, bundle, i));
                    return;
                }
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + string2);
            case 2:
                gVar2 = this.se;
                MediaBrowserServiceCompat.a(gVar2.rR).c(new 2(gVar2, new MediaBrowserServiceCompat$e(this.rR, message.replyTo)));
                return;
            case 3:
                gVar = this.se;
                string = data.getString("data_media_item_id");
                data = data.getBundle("data_options");
                MediaBrowserServiceCompat.a(gVar.rR).c(new 3(gVar, new MediaBrowserServiceCompat$e(this.rR, message.replyTo), string, data));
                return;
            case 4:
                gVar = this.se;
                string = data.getString("data_media_item_id");
                data = data.getBundle("data_options");
                MediaBrowserServiceCompat.a(gVar.rR).c(new 4(gVar, new MediaBrowserServiceCompat$e(this.rR, message.replyTo), string, data));
                return;
            case 5:
                gVar = this.se;
                Object string3 = data.getString("data_media_item_id");
                ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                if (!TextUtils.isEmpty(string3) && resultReceiver != null) {
                    MediaBrowserServiceCompat.a(gVar.rR).c(new 5(gVar, string3, resultReceiver));
                    return;
                }
                return;
            case 6:
                gVar2 = this.se;
                MediaBrowserServiceCompat.a(gVar2.rR).c(new 6(gVar2, new MediaBrowserServiceCompat$e(this.rR, message.replyTo)));
                return;
            case 7:
                gVar2 = this.se;
                MediaBrowserServiceCompat.a(gVar2.rR).c(new MediaBrowserServiceCompat$g$7(gVar2, new MediaBrowserServiceCompat$e(this.rR, message.replyTo)));
                return;
            default:
                new StringBuilder("Unhandled message: ").append(message).append("\n  Service version: 1\n  Client version: ").append(message.arg1);
                return;
        }
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        Bundle data = message.getData();
        data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
        data.putInt("data_calling_uid", Binder.getCallingUid());
        return super.sendMessageAtTime(message, j);
    }

    private void c(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
