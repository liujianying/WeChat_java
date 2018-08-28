package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public interface al extends an {
    int a(Notification notification, boolean z);

    Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    Notification a(Notification notification, int i, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, int i2, String str4, PendingIntent pendingIntent2, int i3, String str5, PendingIntent pendingIntent3, String str6);

    Notification a(PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4);

    void a(int i, Notification notification, boolean z);

    void aR(boolean z);

    void aS(boolean z);

    int b(Notification notification);

    void cancel(int i);

    void cancelNotification(String str);

    void eJ(String str);

    void eK(String str);

    void fp(int i);

    void fq(int i);

    void fr(int i);

    void n(int i, String str);

    void notify(int i, Notification notification);

    void v(String str, int i);

    void vo();

    String xQ();

    void xR();

    boolean xS();

    void xT();

    void xU();
}
