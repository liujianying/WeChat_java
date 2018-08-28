package android.support.v4.app;

import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;

final class aa {
    public static void a(Builder builder, ac$a ac_a) {
        Action.Builder builder2 = new Action.Builder(ac_a.getIcon(), ac_a.getTitle(), ac_a.getActionIntent());
        if (ac_a.bz() != null) {
            for (RemoteInput addRemoteInput : ai.a(ac_a.bz())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (ac_a.getExtras() != null) {
            builder2.addExtras(ac_a.getExtras());
        }
        builder.addAction(builder2.build());
    }
}
