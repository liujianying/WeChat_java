package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.ui.ak;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class AppBrandNearbyWebViewUI extends WebViewUI {
    private static Boolean dgC = null;

    public final void onCreate(Bundle bundle) {
        if (getIntent() != null) {
            getIntent().putExtra("forceHideShare", true);
            getIntent().putExtra("disable_bounce_scroll", true);
            getIntent().putExtra("show_long_click_popup_menu", false);
            getIntent().putExtra("key_load_js_without_delay", true);
        }
        super.onCreate(bundle);
        setResult(-1);
    }

    public final void setMMTitle(String str) {
        super.setMMTitle(str);
        nS(-16777216);
    }

    protected final void initView() {
        super.initView();
    }

    protected final void ant() {
        super.ant();
        lF(-855310);
    }

    protected final int anu() {
        if (VERSION.SDK_INT >= 23 && (!h.Ae() || !Af())) {
            ak.g(getWindow());
            return -855310;
        } else if (VERSION.SDK_INT >= 21) {
            return p.feh;
        } else {
            return super.anu();
        }
    }

    public static boolean Af() {
        Throwable th;
        FileInputStream fileInputStream;
        if (dgC == null) {
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream2);
                    dgC = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    try {
                        dgC = Boolean.valueOf(false);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        return dgC.booleanValue();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                fileInputStream2 = null;
                dgC = Boolean.valueOf(false);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e32) {
                    }
                }
                return dgC.booleanValue();
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                throw th;
            }
        }
        return dgC.booleanValue();
    }

    protected final boolean anv() {
        return true;
    }
}
