package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.tencentmap.mapsdk.a.lo.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ll {
    private static volatile ll a;
    private static String e = "/tencentmapsdk/rastermap/unmainland";
    private static String f = "/tencentmapsdk/rastermap/handdraw";
    private Context b;
    private lo c;
    private ReentrantReadWriteLock d = new ReentrantReadWriteLock();
    private final int g = 128;

    public static ll a(Context context) {
        if (a == null) {
            synchronized (ll.class) {
                if (a == null) {
                    a = new ll(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private ll(Context context) {
        this.b = context;
    }

    public void a(lo loVar) {
        this.c = loVar;
    }

    private String[] a(nc ncVar, boolean z) {
        String b;
        int a = ncVar.a() / 128;
        int b2 = ncVar.b() / 128;
        int i = a / 10;
        int i2 = b2 / 10;
        String[] strArr = new String[2];
        StringBuilder stringBuilder = new StringBuilder();
        if ("taiwanmap".equals(ncVar.d())) {
            b = b();
        } else if ("handdrawmap".equals(ncVar.d())) {
            b = c();
        } else {
            b = a();
        }
        if (b == null) {
            return null;
        }
        stringBuilder.append(b);
        stringBuilder.append("glGrid");
        stringBuilder.append("/");
        stringBuilder.append(ncVar.c());
        stringBuilder.append("/");
        stringBuilder.append(i);
        stringBuilder.append("/");
        stringBuilder.append(i2);
        stringBuilder.append("/");
        if (!z) {
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        stringBuilder.append(ncVar.c());
        stringBuilder.append("_");
        stringBuilder.append(a);
        stringBuilder.append("_");
        stringBuilder.append(b2);
        strArr[0] = stringBuilder.toString() + ".idx";
        strArr[1] = stringBuilder.toString() + ".dat";
        return strArr;
    }

    private byte[] b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((-16777216 & i) >> 24)};
    }

    private void a(byte[] bArr) {
        if (bArr != null && bArr.length == 4) {
            byte b = bArr[0];
            bArr[0] = bArr[3];
            bArr[3] = b;
            b = bArr[1];
            bArr[1] = bArr[2];
            bArr[2] = b;
        }
    }

    private int b(byte[] bArr) {
        return (((bArr[0] & 255) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & -16777216);
    }

    private int a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    public Bitmap a(nc ncVar) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        String[] a = a(ncVar, true);
        if (!(a == null || a.length != 2 || a[0].equals("") || Arrays.equals(a, new String[a.length]))) {
            File file = new File(a[0]);
            if (file.exists() && file.length() != 0) {
                int a2 = a(ncVar.a(), ncVar.b());
                if (a2 >= 0) {
                    byte[] bArr = new byte[4];
                    this.d.readLock().lock();
                    Closeable randomAccessFile;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            randomAccessFile.seek((long) (a2 * 4));
                            randomAccessFile.read(bArr, 0, 4);
                            this.d.readLock().unlock();
                            q.a(randomAccessFile);
                            a(bArr);
                            int b = b(bArr);
                            if (b >= 0) {
                                File file2 = new File(a[1]);
                                if (file2.exists()) {
                                    try {
                                        this.d.readLock().lock();
                                        randomAccessFile = new RandomAccessFile(file2, "r");
                                        try {
                                            randomAccessFile.seek((long) b);
                                            randomAccessFile.read(bArr, 0, 4);
                                            this.d.readLock().unlock();
                                            a(bArr);
                                            int b2 = b(bArr);
                                            if (b2 <= 0) {
                                                q.a(randomAccessFile);
                                            } else {
                                                byte[] bArr2 = new byte[b2];
                                                try {
                                                    randomAccessFile.read(bArr2, 0, b2);
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e) {
                                                    }
                                                    try {
                                                        bitmap = BitmapFactory.decodeByteArray(bArr2, 0, b2);
                                                    } catch (Exception e2) {
                                                    }
                                                    ncVar.a(bitmap);
                                                } catch (IOException e3) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e4) {
                                                    }
                                                } catch (Throwable th2) {
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Exception e5) {
                                                    }
                                                    throw th2;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            try {
                                                q.a(randomAccessFile);
                                                this.d.readLock().unlock();
                                                return bitmap;
                                            } catch (Throwable th22) {
                                                this.d.readLock().unlock();
                                                throw th22;
                                            }
                                        }
                                    } catch (Exception e7) {
                                        randomAccessFile = bitmap;
                                        q.a(randomAccessFile);
                                        this.d.readLock().unlock();
                                        return bitmap;
                                    }
                                }
                            }
                        } catch (Exception e8) {
                            this.d.readLock().unlock();
                            q.a(randomAccessFile);
                            return bitmap;
                        } catch (Throwable th222) {
                            th = th222;
                            closeable = randomAccessFile;
                            this.d.readLock().unlock();
                            q.a(closeable);
                            throw th;
                        }
                    } catch (Exception e9) {
                        randomAccessFile = bitmap;
                        this.d.readLock().unlock();
                        q.a(randomAccessFile);
                        return bitmap;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = bitmap;
                        this.d.readLock().unlock();
                        q.a(closeable);
                        throw th;
                    }
                }
            }
        }
        return bitmap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(byte[] r12, com.tencent.tencentmap.mapsdk.a.nc r13) {
        /*
        r11 = this;
        r6 = 0;
        r1 = 1;
        r4 = 0;
        r0 = 0;
        monitor-enter(r11);
        if (r12 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r11);
        return r0;
    L_0x000a:
        r3 = r12.length;	 Catch:{ all -> 0x00cd }
        if (r3 <= 0) goto L_0x0008;
    L_0x000d:
        r2 = 0;
        r10 = r11.a(r13, r2);	 Catch:{ all -> 0x00cd }
        if (r10 == 0) goto L_0x0008;
    L_0x0014:
        r2 = r10.length;	 Catch:{ all -> 0x00cd }
        r7 = 2;
        if (r2 != r7) goto L_0x0008;
    L_0x0018:
        r2 = 0;
        r2 = r10[r2];	 Catch:{ all -> 0x00cd }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ all -> 0x00cd }
        if (r2 != 0) goto L_0x0008;
    L_0x0024:
        r2 = r10.length;	 Catch:{ all -> 0x00cd }
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x00cd }
        r2 = java.util.Arrays.equals(r10, r2);	 Catch:{ all -> 0x00cd }
        if (r2 != 0) goto L_0x0008;
    L_0x002d:
        r7 = new java.io.File;	 Catch:{ all -> 0x00cd }
        r2 = 1;
        r2 = r10[r2];	 Catch:{ all -> 0x00cd }
        r7.<init>(r2);	 Catch:{ all -> 0x00cd }
        r2 = r7.exists();	 Catch:{ all -> 0x00cd }
        if (r2 != 0) goto L_0x0041;
    L_0x003b:
        r2 = r7.createNewFile();	 Catch:{ Exception -> 0x00d0 }
    L_0x003f:
        if (r2 == 0) goto L_0x0008;
    L_0x0041:
        r2 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x00d4 }
        r8 = "rws";
        r2.<init>(r7, r8);	 Catch:{ Exception -> 0x00d4 }
        r7 = r2;
    L_0x004a:
        if (r7 == 0) goto L_0x0008;
    L_0x004c:
        r8 = r11.b(r3);	 Catch:{ all -> 0x00cd }
        r11.a(r8);	 Catch:{ all -> 0x00cd }
        r2 = r11.d;	 Catch:{ all -> 0x00cd }
        r2 = r2.writeLock();	 Catch:{ all -> 0x00cd }
        r2.lock();	 Catch:{ all -> 0x00cd }
        r2 = r7.length();	 Catch:{ Exception -> 0x00d8, all -> 0x00e8 }
        r7.seek(r2);	 Catch:{ Exception -> 0x015c, all -> 0x00e8 }
        r7.write(r8);	 Catch:{ Exception -> 0x015c, all -> 0x00e8 }
        r7.write(r12);	 Catch:{ Exception -> 0x015c, all -> 0x00e8 }
        com.tencent.tencentmap.mapsdk.a.q.a(r7);	 Catch:{ all -> 0x00cd }
        r7 = r11.d;	 Catch:{ all -> 0x00cd }
        r7 = r7.writeLock();	 Catch:{ all -> 0x00cd }
        r7.unlock();	 Catch:{ all -> 0x00cd }
        r8 = r2;
    L_0x0076:
        r3 = new java.io.File;	 Catch:{ all -> 0x00cd }
        r2 = 0;
        r2 = r10[r2];	 Catch:{ all -> 0x00cd }
        r3.<init>(r2);	 Catch:{ all -> 0x00cd }
        r2 = r3.exists();	 Catch:{ all -> 0x00cd }
        if (r2 != 0) goto L_0x008a;
    L_0x0084:
        r2 = r3.createNewFile();	 Catch:{ Exception -> 0x00f6 }
    L_0x0088:
        if (r2 == 0) goto L_0x0008;
    L_0x008a:
        r2 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0159 }
        r7 = "rws";
        r2.<init>(r3, r7);	 Catch:{ Exception -> 0x0159 }
        r6 = r2;
    L_0x0093:
        if (r6 == 0) goto L_0x0008;
    L_0x0095:
        r2 = r6.length();	 Catch:{ Exception -> 0x00f9 }
    L_0x0099:
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x00ba;
    L_0x009d:
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2 = new byte[r2];	 Catch:{ all -> 0x00cd }
        r3 = -1;
        java.util.Arrays.fill(r2, r3);	 Catch:{ all -> 0x00cd }
        r3 = r11.d;	 Catch:{ all -> 0x00cd }
        r3 = r3.writeLock();	 Catch:{ all -> 0x00cd }
        r3.lock();	 Catch:{ all -> 0x00cd }
        r6.write(r2);	 Catch:{ Exception -> 0x00fc, all -> 0x0107 }
        r2 = r11.d;	 Catch:{ all -> 0x00cd }
        r2 = r2.writeLock();	 Catch:{ all -> 0x00cd }
        r2.unlock();	 Catch:{ all -> 0x00cd }
    L_0x00ba:
        r2 = r13.a();	 Catch:{ all -> 0x00cd }
        r3 = r13.b();	 Catch:{ all -> 0x00cd }
        r2 = r11.a(r2, r3);	 Catch:{ all -> 0x00cd }
        if (r2 >= 0) goto L_0x0112;
    L_0x00c8:
        com.tencent.tencentmap.mapsdk.a.q.a(r6);	 Catch:{ all -> 0x00cd }
        goto L_0x0008;
    L_0x00cd:
        r0 = move-exception;
        monitor-exit(r11);
        throw r0;
    L_0x00d0:
        r2 = move-exception;
        r2 = r0;
        goto L_0x003f;
    L_0x00d4:
        r2 = move-exception;
        r7 = r6;
        goto L_0x004a;
    L_0x00d8:
        r2 = move-exception;
        r2 = r4;
    L_0x00da:
        com.tencent.tencentmap.mapsdk.a.q.a(r7);	 Catch:{ all -> 0x00cd }
        r7 = r11.d;	 Catch:{ all -> 0x00cd }
        r7 = r7.writeLock();	 Catch:{ all -> 0x00cd }
        r7.unlock();	 Catch:{ all -> 0x00cd }
        r8 = r2;
        goto L_0x0076;
    L_0x00e8:
        r0 = move-exception;
        com.tencent.tencentmap.mapsdk.a.q.a(r7);	 Catch:{ all -> 0x00cd }
        r1 = r11.d;	 Catch:{ all -> 0x00cd }
        r1 = r1.writeLock();	 Catch:{ all -> 0x00cd }
        r1.unlock();	 Catch:{ all -> 0x00cd }
        throw r0;	 Catch:{ all -> 0x00cd }
    L_0x00f6:
        r2 = move-exception;
        r2 = r0;
        goto L_0x0088;
    L_0x00f9:
        r2 = move-exception;
        r2 = r4;
        goto L_0x0099;
    L_0x00fc:
        r2 = move-exception;
        r2 = r11.d;	 Catch:{ all -> 0x00cd }
        r2 = r2.writeLock();	 Catch:{ all -> 0x00cd }
        r2.unlock();	 Catch:{ all -> 0x00cd }
        goto L_0x00ba;
    L_0x0107:
        r0 = move-exception;
        r1 = r11.d;	 Catch:{ all -> 0x00cd }
        r1 = r1.writeLock();	 Catch:{ all -> 0x00cd }
        r1.unlock();	 Catch:{ all -> 0x00cd }
        throw r0;	 Catch:{ all -> 0x00cd }
    L_0x0112:
        r0 = r2 * 4;
        r2 = (long) r0;
        r6.seek(r2);	 Catch:{ Exception -> 0x0157 }
    L_0x0118:
        r0 = (int) r8;
        r0 = r11.b(r0);	 Catch:{ all -> 0x00cd }
        r11.a(r0);	 Catch:{ all -> 0x00cd }
        r2 = r11.d;	 Catch:{ all -> 0x00cd }
        r2 = r2.writeLock();	 Catch:{ all -> 0x00cd }
        r2.lock();	 Catch:{ all -> 0x00cd }
        r6.write(r0);	 Catch:{ Exception -> 0x013b, all -> 0x0149 }
        com.tencent.tencentmap.mapsdk.a.q.a(r6);	 Catch:{ all -> 0x00cd }
        r0 = r11.d;	 Catch:{ all -> 0x00cd }
        r0 = r0.writeLock();	 Catch:{ all -> 0x00cd }
        r0.unlock();	 Catch:{ all -> 0x00cd }
    L_0x0138:
        r0 = r1;
        goto L_0x0008;
    L_0x013b:
        r0 = move-exception;
        com.tencent.tencentmap.mapsdk.a.q.a(r6);	 Catch:{ all -> 0x00cd }
        r0 = r11.d;	 Catch:{ all -> 0x00cd }
        r0 = r0.writeLock();	 Catch:{ all -> 0x00cd }
        r0.unlock();	 Catch:{ all -> 0x00cd }
        goto L_0x0138;
    L_0x0149:
        r0 = move-exception;
        com.tencent.tencentmap.mapsdk.a.q.a(r6);	 Catch:{ all -> 0x00cd }
        r1 = r11.d;	 Catch:{ all -> 0x00cd }
        r1 = r1.writeLock();	 Catch:{ all -> 0x00cd }
        r1.unlock();	 Catch:{ all -> 0x00cd }
        throw r0;	 Catch:{ all -> 0x00cd }
    L_0x0157:
        r0 = move-exception;
        goto L_0x0118;
    L_0x0159:
        r2 = move-exception;
        goto L_0x0093;
    L_0x015c:
        r8 = move-exception;
        goto L_0x00da;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.ll.a(byte[], com.tencent.tencentmap.mapsdk.a.nc):boolean");
    }

    public boolean a(int i) {
        String str = null;
        if (i == 0) {
            str = o.b(this.b) + e;
        }
        if (i == 1) {
            str = o.b(this.b) + f;
        }
        if (str == null) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.isDirectory() && a(file)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean a(File file) {
        if (!file.isDirectory()) {
            return file.delete();
        }
        for (File a : file.listFiles()) {
            a(a);
        }
        return file.delete();
    }

    public String a() {
        if (this.c == null) {
            return null;
        }
        a c = this.c.c();
        return o.b(this.b) + e + c.a() + "/" + c.b + "/" + c.a + "/" + c.c + "/";
    }

    public String b() {
        if (this.c == null) {
            return null;
        }
        return o.b(this.b) + e + "taiwanmap/" + this.c.c().c + "/";
    }

    public String c() {
        return o.b(this.b) + "/" + f + "/" + kv.a() + "/";
    }
}
