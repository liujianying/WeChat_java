package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;

public class no {
    private final String a = "marker_default.png";
    private int b = -1;
    private int c = -1;
    private String d = "";
    private String e = "";
    private String f = "";
    private float g = -1.0f;
    private Bitmap h = null;
    private String i = null;

    public no(int i) {
        this.b = i;
    }

    public String a() {
        return this.i;
    }

    private String b(Bitmap bitmap) {
        String obj = bitmap.toString();
        if (obj == null) {
            obj = "";
        }
        obj = obj.replace("android.graphics.Bitmap", "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return (obj + "@" + bitmap.hashCode() + "@" + width + "@" + height + "@" + bitmap.getRowBytes()) + "@" + bitmap.getPixel(width / 2, height / 2);
    }

    public Bitmap a(Context context) {
        if (this.h != null) {
            this.i = b(this.h);
            return this.h;
        } else if (context == null) {
            return null;
        } else {
            switch (this.b) {
                case 1:
                    this.i = "res_" + this.c;
                    if (kh.u != null) {
                        this.h = kh.u.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = kh.a(context, this.c);
                        if (!(kh.u == null || this.h == null)) {
                            kh.u.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 2:
                    this.i = "asset_" + this.d;
                    if (kh.u != null) {
                        this.h = kh.u.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = kh.c(context, this.d);
                        if (this.h == null) {
                            this.h = kh.b(context, this.d);
                            if (this.h != null) {
                                this.h = kh.b(this.h);
                            }
                        }
                        if (!(kh.u == null || this.h == null)) {
                            kh.u.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.i = "file_" + this.e;
                    if (kh.u != null) {
                        this.h = kh.u.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = kh.a(context, this.e);
                        break;
                    }
                    break;
                case 4:
                    this.i = "path_" + this.f;
                    if (kh.u != null) {
                        this.h = kh.u.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = kh.b(this.f);
                        if (!(kh.u == null || this.h == null)) {
                            kh.u.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 5:
                    this.i = "asset_marker_default.png";
                    if (kh.u != null) {
                        this.h = kh.u.a(this.i);
                    }
                    if (this.h == null) {
                        this.h = kh.b(context, "marker_default.png");
                        if (!(kh.u == null || this.h == null)) {
                            kh.u.a(this.i, this.h);
                            break;
                        }
                    }
                    break;
                case 6:
                    String a = a(this.g);
                    if (a != null) {
                        this.i = "asset_" + a;
                        if (kh.u != null) {
                            this.h = kh.u.a(this.i);
                        }
                        if (this.h == null) {
                            this.h = kh.b(context, a);
                            if (!(kh.u == null || this.h == null)) {
                                kh.u.a(this.i, this.h);
                                break;
                            }
                        }
                    }
                    break;
            }
            return this.h;
        }
    }

    private String a(float f) {
        if (f < 30.0f) {
            return "RED.png";
        }
        if (f >= 30.0f && f < 60.0f) {
            return "ORANGE.png";
        }
        if (f >= 60.0f && f < 120.0f) {
            return "YELLOW.png";
        }
        if (f >= 120.0f && f < 180.0f) {
            return "GREEN.png";
        }
        if (f >= 180.0f && f < 210.0f) {
            return "CYAN.png";
        }
        if (f >= 210.0f && f < 240.0f) {
            return "AZURE.png";
        }
        if (f >= 240.0f && f < 270.0f) {
            return "BLUE.png";
        }
        if (f >= 270.0f && f < 300.0f) {
            return "VIOLET.png";
        }
        if (f >= 300.0f && f < 330.0f) {
            return "MAGENTAV.png";
        }
        if (f >= 330.0f) {
            return "ROSE.png";
        }
        return null;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(Bitmap bitmap) {
        this.h = bitmap;
    }
}
