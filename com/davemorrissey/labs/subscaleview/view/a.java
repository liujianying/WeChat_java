package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a {
    final Integer YT;
    public boolean YU;
    public int YV;
    public int YW;
    public Rect YX;
    boolean YY;
    public final Bitmap bitmap;
    public final Uri uri;

    public a(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.uri = null;
        this.YT = null;
        this.YU = false;
        this.YV = bitmap.getWidth();
        this.YW = bitmap.getHeight();
        this.YY = true;
    }

    private a(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.YT = null;
        this.YU = true;
    }

    a(int i) {
        this.bitmap = null;
        this.uri = null;
        this.YT = Integer.valueOf(i);
        this.YU = true;
    }

    public static a S(String str) {
        if (str == null) {
            throw new NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new a(Uri.parse(str));
    }

    public final a hB() {
        this.YU = true;
        return this;
    }
}
