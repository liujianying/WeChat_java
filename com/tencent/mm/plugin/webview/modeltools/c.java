package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class c {
    private String pTH = null;
    private String pTI = null;
    private ValueCallback<Uri> pTJ = null;
    private ValueCallback<Uri[]> pTK = null;

    public final boolean b(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (i != 1) {
            return false;
        }
        if (this.pTJ == null && this.pTK == null) {
            x.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
        } else {
            Uri uri;
            if (i2 == -1) {
                String str = null;
                if (intent != null) {
                    uri = null;
                    if (intent.getData() == null) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            uri = extras.getParcelable("android.intent.extra.STREAM") != null ? (Uri) extras.getParcelable("android.intent.extra.STREAM") : null;
                        }
                    } else {
                        uri = intent.getData();
                    }
                    str = bi.h(mMActivity, uri);
                    x.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[]{str});
                }
                if (bi.oW(str)) {
                    File file = new File(aj.Qr(this.pTI));
                    if (file.exists()) {
                        uri = Uri.fromFile(file);
                        x.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                        j(uri);
                        bUQ();
                    }
                } else {
                    Object obj;
                    String Ui = s.Ui(str);
                    x.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[]{Ui});
                    if (bi.oW(this.pTH)) {
                        obj = 1;
                    } else {
                        for (String replace : this.pTH.split(",")) {
                            boolean z;
                            String replace2 = replace2.replace(" ", "");
                            if (bi.oW(replace2)) {
                                z = true;
                            } else {
                                if (!bi.oW(Ui)) {
                                    if (replace2.contains("/") && Ui.contains("/")) {
                                        String[] split = replace2.split("/");
                                        String[] split2 = Ui.split("/");
                                        if (bi.oV(split[0]).equals(split2[0])) {
                                            z = bi.oV(split[1]).equals("*") || bi.oV(split[1]).equals(split2[1]);
                                        }
                                    } else {
                                        z = replace2.equals(Ui);
                                    }
                                }
                                z = false;
                            }
                            if (z) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        uri = intent.getData() == null ? Uri.fromFile(new File(str)) : intent.getData();
                        x.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                        j(uri);
                        bUQ();
                    }
                }
            }
            uri = null;
            x.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
            j(uri);
            bUQ();
        }
        return true;
    }

    public final void a(Activity activity, e eVar, ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
        Intent[] intentArr = null;
        x.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[]{eVar, valueCallback, valueCallback2, str, str2});
        bUQ();
        if (eVar == null || eVar.bVR() == null) {
            x.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            j(null);
        } else if (eVar.bVR().gu(56)) {
            int i;
            Parcelable[] parcelableArr;
            Intent intent;
            this.pTJ = valueCallback;
            this.pTK = valueCallback2;
            this.pTI = System.currentTimeMillis();
            this.pTH = str;
            String str3 = this.pTI;
            Object intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            if (bi.oW(str)) {
                intent2.setType("*/*");
            } else {
                intent2.setType(str);
            }
            Object[] parcelableArr2;
            if (bi.oW(str2)) {
                if (d.fS(16)) {
                    x.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                    intentArr = new Intent[]{aj.Qs(str3)};
                    i = 0;
                    parcelableArr2 = intentArr;
                }
                i = 0;
                parcelableArr2 = null;
            } else if ("camera".equalsIgnoreCase(str2)) {
                intentArr = new Intent[]{aj.Qs(str3)};
                i = 0;
                parcelableArr2 = intentArr;
            } else if ("camcorder".equalsIgnoreCase(str2)) {
                i = 0;
                parcelableArr2 = new Intent[]{aj.bUn()};
            } else if ("microphone".equalsIgnoreCase(str2)) {
                i = 0;
                parcelableArr2 = new Intent[]{aj.bUo()};
            } else {
                if ("*".equalsIgnoreCase(str2)) {
                    if (str.equalsIgnoreCase("image/*")) {
                        intentArr = new Intent[]{aj.Qs(str3)};
                    } else if (str.equalsIgnoreCase("audio/*")) {
                        intentArr = new Intent[]{aj.bUo()};
                    } else if (str.equalsIgnoreCase("video/*")) {
                        intentArr = new Intent[]{aj.bUn()};
                    }
                    i = 1;
                    parcelableArr2 = intentArr;
                }
                i = 0;
                parcelableArr2 = null;
            }
            if (i != 0 || parcelableArr2 == null || parcelableArr2.length == 0) {
                intent = new Intent("android.intent.action.CHOOSER");
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", parcelableArr2);
                intent.putExtra("android.intent.extra.TITLE", ad.getContext().getString(R.l.wv_select_file_alert_title));
                intent.putExtra("android.intent.extra.INTENT", intent2);
            } else {
                intent = parcelableArr2[0];
            }
            activity.startActivityForResult(intent, 1);
        } else {
            x.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            j(null);
        }
    }

    private void bUQ() {
        this.pTH = null;
        this.pTJ = null;
        this.pTK = null;
        this.pTI = null;
    }

    private void j(Uri uri) {
        if (this.pTJ != null) {
            this.pTJ.onReceiveValue(uri);
        } else if (this.pTK == null) {
        } else {
            if (uri == null) {
                this.pTK.onReceiveValue(null);
                return;
            }
            this.pTK.onReceiveValue(new Uri[]{uri});
        }
    }
}
