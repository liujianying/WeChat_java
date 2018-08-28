package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.x;
import com.tencent.mm.w.a.k;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class a {

    /* renamed from: com.tencent.mm.ui.tools.a$1 */
    static class AnonymousClass1 extends AsyncTask<Integer, Integer, Integer> {
        private String filePath;
        final /* synthetic */ Intent heh;
        final /* synthetic */ int ms;
        private Uri uri;
        private ProgressDialog uvD;
        private boolean uvE;
        final /* synthetic */ x uvF;
        final /* synthetic */ String uvG;
        final /* synthetic */ a uvH = null;
        final /* synthetic */ Intent val$intent;

        public AnonymousClass1(Intent intent, x xVar, String str, Intent intent2) {
            this.heh = intent;
            this.uvF = xVar;
            this.uvG = str;
            this.val$intent = intent2;
            this.ms = 203;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (!(this.uvE || bi.oW(this.filePath))) {
                if (this.uvH != null) {
                    this.val$intent.putExtra("CropImage_OutputPath", this.uvH.NT(this.filePath));
                }
                this.val$intent.putExtra("CropImage_ImgPath", this.filePath);
                this.uvF.startActivityForResult(this.val$intent, this.ms);
            }
            this.uvD.dismiss();
        }

        protected final void onPreExecute() {
            try {
                this.uri = this.heh.getData();
                this.uvE = false;
                Context context = this.uvF.getContext();
                this.uvF.getString(k.app_tip);
                this.uvD = h.a(context, this.uvF.getString(k.app_getting_img), true, new 1(this));
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
        }

        private Integer czA() {
            try {
                if (this.uri != null) {
                    this.filePath = a.v(this.uvG, c.m(this.uri));
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
            return null;
        }
    }

    public interface a {
        String NT(String str);
    }

    public static void a(Activity activity, Intent intent, Intent intent2, String str, int i) {
        b(activity, intent, intent2, str, i, null);
    }

    public static void b(Activity activity, Intent intent, Intent intent2, String str, int i, a aVar) {
        if (intent == null || intent.getData() == null) {
            boolean z;
            String str2 = "MicroMsg.AsyncObtainImage";
            String str3 = "param error, %b";
            Object[] objArr = new Object[1];
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.e(str2, str3, objArr);
        } else if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            final Intent intent3 = intent;
            final Activity activity2 = activity;
            final String str4 = str;
            final a aVar2 = aVar;
            final Intent intent4 = intent2;
            final int i2 = i;
            new AsyncTask<Integer, Integer, Integer>() {
                private String filePath;
                private Uri uri;
                private ProgressDialog uvD;
                private boolean uvE;

                protected final /* synthetic */ void onPostExecute(Object obj) {
                    if (this.uvE || bi.oW(this.filePath)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", new Object[]{this.filePath});
                    } else {
                        if (aVar2 != null) {
                            intent4.putExtra("CropImage_OutputPath", aVar2.NT(this.filePath));
                        }
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        activity2.startActivityForResult(intent4, i2);
                    }
                    this.uvD.dismiss();
                }

                protected final void onPreExecute() {
                    try {
                        this.uri = intent3.getData();
                        this.uvE = false;
                        Context context = activity2;
                        activity2.getString(k.app_tip);
                        this.uvD = h.a(context, activity2.getString(k.app_getting_img), true, new 1(this));
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "onPreExecute", new Object[0]);
                    }
                }

                private Integer czA() {
                    try {
                        if (this.uri != null) {
                            this.filePath = a.v(str4, c.m(this.uri));
                        }
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "doInBackground", new Object[0]);
                    }
                    return null;
                }
            }.execute(new Integer[]{Integer.valueOf(0)});
        } else {
            String e = e(activity, intent, str);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", new Object[]{e});
            if (!bi.oW(e)) {
                if (aVar != null) {
                    intent2.putExtra("CropImage_OutputPath", aVar.NT(e));
                }
                intent2.putExtra("CropImage_ImgPath", e);
                activity.startActivityForResult(intent2, i);
            }
        }
    }

    public static String e(Context context, Intent intent, String str) {
        String str2 = null;
        if (context == null || intent == null || str == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = v(str, c.m(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:" + str2);
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!new File(path).exists()) {
                    path = null;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "photo file from data, path:" + path);
                if (path == null) {
                    path = intent.getData().getHost();
                    if (new File(path).exists()) {
                        str2 = path;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "photo file from data, host:" + str2);
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
            } else {
                str2 = v(str, (Bitmap) intent.getExtras().get("data"));
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", new Object[]{str2});
            }
            if (query != null) {
                query.close();
            }
        }
        return str2;
    }

    public static String v(String str, Bitmap bitmap) {
        try {
            String str2 = str + (g.u(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg");
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AsyncObtainImage", "photo image from data, path:" + str2);
            return str2;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "saveBmp Error.", new Object[0]);
            return null;
        }
    }
}
