package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;

class aw$1 extends ContentObserver {
    private long sIE;
    final /* synthetic */ Context val$context;

    aw$1(Handler handler, Context context) {
        this.val$context = context;
        super(handler);
    }

    public final void onChange(boolean z, Uri uri) {
        Exception e;
        Throwable th;
        x.d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + z + ", uri:" + uri.toString());
        if (aw.ciB() == null || aw.ciB().get() == null) {
            x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", new Object[]{aw.ciB()});
            this.val$context.getContentResolver().unregisterContentObserver(this);
            aw.ciC();
            if (aw.ciB() != null) {
                aw.ciB().clear();
                aw.ciD();
            }
        } else if (uri.toString().matches(aw.ath()) || uri.toString().contains(aw.ath())) {
            String string;
            Cursor query;
            long j;
            try {
                query = this.val$context.getContentResolver().query(uri, aw.bUd(), null, null, "date_added DESC limit 1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            string = query.getString(query.getColumnIndex("_data"));
                            j = query.getLong(query.getColumnIndex("date_added"));
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            x.d("MicroMsg.ScreenShotUtil", "summerscreenshot path: " + string + ", dateAdded: " + j + ", currentTime: " + currentTimeMillis);
                            if (Math.abs(currentTimeMillis - j) <= 10 && currentTimeMillis - this.sIE > 1 && !bi.oW(string) && (string.toLowerCase().contains("screenshot") || string.contains("截屏") || string.contains("截图"))) {
                                try {
                                    this.sIE = currentTimeMillis;
                                    if (query != null) {
                                        query.close();
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        x.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e.getMessage());
                                        if (query != null) {
                                            query.close();
                                        }
                                        if (!bi.oW(string)) {
                                            x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + j);
                                            if (aw.ciB() == null || aw.ciB().get() == null) {
                                                this.val$context.getContentResolver().unregisterContentObserver(this);
                                                aw.ciC();
                                                if (aw.ciB() != null) {
                                                    aw.ciB().clear();
                                                    aw.ciD();
                                                }
                                                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                                            } else {
                                                ((aw$a) aw.ciB().get()).aou();
                                            }
                                        }
                                        super.onChange(z, uri);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (query != null) {
                                            query.close();
                                        }
                                        throw th;
                                    }
                                }
                                if (bi.oW(string)) {
                                    x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + j);
                                    if (aw.ciB() == null || aw.ciB().get() == null) {
                                        this.val$context.getContentResolver().unregisterContentObserver(this);
                                        aw.ciC();
                                        if (aw.ciB() != null) {
                                            aw.ciB().clear();
                                            aw.ciD();
                                        }
                                        x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                                    } else {
                                        ((aw$a) aw.ciB().get()).aou();
                                    }
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        j = 0;
                        string = null;
                        x.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        if (bi.oW(string)) {
                            x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + j);
                            if (aw.ciB() == null || aw.ciB().get() == null) {
                                this.val$context.getContentResolver().unregisterContentObserver(this);
                                aw.ciC();
                                if (aw.ciB() != null) {
                                    aw.ciB().clear();
                                    aw.ciD();
                                }
                                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                            } else {
                                ((aw$a) aw.ciB().get()).aou();
                            }
                        }
                        super.onChange(z, uri);
                    }
                }
                j = 0;
                string = null;
                if (query != null) {
                    query.close();
                }
            } catch (Exception e4) {
                e = e4;
                query = null;
                j = 0;
                string = null;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            if (bi.oW(string)) {
                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + j);
                if (aw.ciB() == null || aw.ciB().get() == null) {
                    this.val$context.getContentResolver().unregisterContentObserver(this);
                    aw.ciC();
                    if (aw.ciB() != null) {
                        aw.ciB().clear();
                        aw.ciD();
                    }
                    x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                } else {
                    ((aw$a) aw.ciB().get()).aou();
                }
            }
        }
        super.onChange(z, uri);
    }
}
