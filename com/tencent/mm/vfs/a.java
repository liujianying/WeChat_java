package com.tencent.mm.vfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class a {
    private static final String uRW = (ad.getContext().getCacheDir().getAbsolutePath() + "/fs.bin");
    private static final FileSystem uRX = new RawFileSystem("/");
    private final Object mLock;
    private HashMap<String, FileSystem> uRY;
    private ArrayList<b> uRZ;
    private FileSystem uSa;
    private int uSb;
    private c uSc;

    public final class a {
        public HashMap<String, FileSystem> uRY;
        public FileSystem uSa;
        public TreeMap<String, String> uSf;

        public /* synthetic */ a(a aVar, byte b) {
            this();
        }

        private a() {
            synchronized (a.this.mLock) {
                this.uRY = new HashMap(a.this.uRY);
                this.uSf = new TreeMap();
                Iterator it = a.this.uRZ.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    this.uSf.put(bVar.uSg, bVar.uSh);
                }
                this.uSa = a.this.uSa;
            }
            if (this.uSa == null) {
                this.uSa = a.uRX;
            }
        }

        public final void cBT() {
            if (this.uSa == null) {
                throw new RuntimeException("Committed editor cannot be reused.");
            }
        }
    }

    private static final class b implements Comparable<String> {
        final String uSg;
        final String uSh;
        final FileSystem uSi;
        final boolean uSj;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.uSg.compareTo((String) obj);
        }

        b(String str, String str2, FileSystem fileSystem, boolean z) {
            this.uSg = str;
            this.uSh = str2;
            this.uSi = fileSystem;
            this.uSj = z;
        }
    }

    static final class c {
        final String path;
        public final FileSystem uSi;
        final int uSk;

        /* synthetic */ c(FileSystem fileSystem, String str, int i, byte b) {
            this(fileSystem, str, i);
        }

        private c(FileSystem fileSystem, String str, int i) {
            this.uSi = fileSystem;
            this.path = str;
            this.uSk = i;
        }

        public final boolean valid() {
            return this.uSi != null;
        }
    }

    private static final class d {
        static final a uSl = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static /* synthetic */ void a(a aVar, HashMap hashMap, TreeMap treeMap, FileSystem fileSystem) {
        IOException e;
        Context context;
        Intent intent;
        Throwable th;
        ArrayList a = a(hashMap, treeMap);
        synchronized (aVar.mLock) {
            aVar.uRY = hashMap;
            aVar.uRZ = a;
            aVar.uSa = fileSystem;
            aVar.uSb++;
            aVar.uSc = new c(null, null, aVar.uSb, (byte) 0);
        }
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        for (Entry entry : hashMap.entrySet()) {
            bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        bundle.putBundle("fs", bundle2);
        bundle2 = new Bundle();
        for (Entry entry2 : treeMap.entrySet()) {
            bundle2.putString((String) entry2.getKey(), (String) entry2.getValue());
        }
        bundle.putBundle("mp", bundle2);
        bundle.putParcelable("root", fileSystem);
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(uRW);
            try {
                fileOutputStream.write(marshall);
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    x.e("MicroMsg.FileSystemManager", "Cannot write parcel file: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    context = ad.getContext();
                    intent = new Intent("com.tencent.mm.REFRESH_VFS");
                    intent.putExtras(bundle);
                    intent.putExtra("pid", Process.myPid());
                    context.sendBroadcast(intent);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
            x.e("MicroMsg.FileSystemManager", "Cannot write parcel file: " + e.getMessage());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e42) {
                }
            }
            context = ad.getContext();
            intent = new Intent("com.tencent.mm.REFRESH_VFS");
            intent.putExtras(bundle);
            intent.putExtra("pid", Process.myPid());
            context.sendBroadcast(intent);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e52) {
                }
            }
            throw th;
        }
        context = ad.getContext();
        intent = new Intent("com.tencent.mm.REFRESH_VFS");
        intent.putExtras(bundle);
        intent.putExtra("pid", Process.myPid());
        context.sendBroadcast(intent);
    }

    public static a cBR() {
        return d.uSl;
    }

    private static String abN(String str) {
        File file = new File(str);
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            return file.getAbsolutePath();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final com.tencent.mm.vfs.a.c a(android.net.Uri r12, com.tencent.mm.vfs.a.c r13) {
        /*
        r11 = this;
        r1 = 0;
        r10 = 47;
        r9 = 0;
        r8 = 1;
        r2 = r11.mLock;
        monitor-enter(r2);
        if (r13 == 0) goto L_0x0012;
    L_0x000a:
        r0 = r13.uSk;	 Catch:{ all -> 0x0054 }
        r3 = r11.uSb;	 Catch:{ all -> 0x0054 }
        if (r0 != r3) goto L_0x0012;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
    L_0x0011:
        return r13;
    L_0x0012:
        r0 = r11.uRY;	 Catch:{ all -> 0x0054 }
        r5 = r11.uRZ;	 Catch:{ all -> 0x0054 }
        r4 = r11.uSa;	 Catch:{ all -> 0x0054 }
        r6 = r11.uSb;	 Catch:{ all -> 0x0054 }
        r13 = r11.uSc;	 Catch:{ all -> 0x0054 }
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        r2 = r12.getPath();
        r3 = r12.getScheme();
        if (r3 == 0) goto L_0x0030;
    L_0x0027:
        r7 = "file";
        r7 = r3.equals(r7);
        if (r7 == 0) goto L_0x00ae;
    L_0x0030:
        if (r2 == 0) goto L_0x0011;
    L_0x0032:
        r0 = r2.isEmpty();
        if (r0 != 0) goto L_0x0011;
    L_0x0038:
        r3 = abN(r2);
        r0 = java.util.Collections.binarySearch(r5, r3);
        if (r0 < 0) goto L_0x0057;
    L_0x0042:
        r0 = r5.get(r0);
        r0 = (com.tencent.mm.vfs.a.b) r0;
        r2 = r0.uSi;
        r0 = "";
        r1 = r0;
    L_0x004e:
        r13 = new com.tencent.mm.vfs.a$c;
        r13.<init>(r2, r1, r6, r9);
        goto L_0x0011;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        r0 = -r0;
        r2 = r0 + -2;
        if (r2 < 0) goto L_0x0085;
    L_0x005c:
        r0 = r5.get(r2);
        r0 = (com.tencent.mm.vfs.a.b) r0;
    L_0x0062:
        if (r0 == 0) goto L_0x0089;
    L_0x0064:
        r7 = r0.uSg;
        r7 = r3.startsWith(r7);
        if (r7 == 0) goto L_0x0078;
    L_0x006c:
        r7 = r0.uSg;
        r7 = r7.length();
        r7 = r3.charAt(r7);
        if (r7 == r10) goto L_0x0089;
    L_0x0078:
        r0 = r0.uSj;
        if (r0 == 0) goto L_0x0087;
    L_0x007c:
        r2 = r2 + -1;
        r0 = r5.get(r2);
        r0 = (com.tencent.mm.vfs.a.b) r0;
        goto L_0x0062;
    L_0x0085:
        r0 = r1;
        goto L_0x0062;
    L_0x0087:
        r0 = r1;
        goto L_0x0062;
    L_0x0089:
        if (r0 == 0) goto L_0x009b;
    L_0x008b:
        r2 = r0.uSi;
        r0 = r0.uSg;
        r0 = r0.length();
        r0 = r0 + 1;
        r0 = r3.substring(r0);
        r1 = r0;
        goto L_0x004e;
    L_0x009b:
        r0 = r3.isEmpty();
        if (r0 != 0) goto L_0x00d3;
    L_0x00a1:
        r0 = r3.charAt(r9);
        if (r0 != r10) goto L_0x00d3;
    L_0x00a7:
        r0 = r3.substring(r8);
    L_0x00ab:
        r1 = r0;
        r2 = r4;
        goto L_0x004e;
    L_0x00ae:
        r1 = "wcf";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0011;
    L_0x00b7:
        r1 = r12.getAuthority();
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.vfs.FileSystem) r0;
        if (r2 != 0) goto L_0x00c8;
    L_0x00c3:
        r1 = "";
        r2 = r0;
        goto L_0x004e;
    L_0x00c8:
        r1 = r12.getPath();
        r1 = com.tencent.mm.vfs.d.i(r1, r8, r8);
        r2 = r0;
        goto L_0x004e;
    L_0x00d3:
        r0 = r3;
        goto L_0x00ab;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.a.a(android.net.Uri, com.tencent.mm.vfs.a$c):com.tencent.mm.vfs.a$c");
    }

    static Uri abO(String str) {
        Builder builder = new Builder();
        int indexOf = str.indexOf(58);
        if (indexOf < 0) {
            builder.path(str);
        } else {
            builder.scheme(str.substring(0, indexOf));
            int length = str.length();
            if (length > indexOf + 2 && str.charAt(indexOf + 1) == '/' && str.charAt(indexOf + 2) == '/') {
                int i = indexOf + 3;
                while (i < length) {
                    switch (str.charAt(i)) {
                        case '#':
                        case '/':
                        case '?':
                            break;
                        default:
                            i++;
                    }
                    builder.authority(str.substring(indexOf + 3, i));
                    if (i < length) {
                        builder.path(str.substring(i + 1));
                    }
                }
                builder.authority(str.substring(indexOf + 3, i));
                if (i < length) {
                    builder.path(str.substring(i + 1));
                }
            } else {
                builder.path(str.substring(indexOf + 1));
            }
        }
        return builder.build();
    }

    private a() {
        this.mLock = new Object();
        this.uSb = 0;
        abP(uRW);
        if (this.uRY == null) {
            this.uRY = new HashMap();
        }
        if (this.uRZ == null) {
            this.uRZ = new ArrayList();
        }
        if (this.uSc == null) {
            this.uSc = new c(null, null, this.uSb, (byte) 0);
        }
        ad.getContext().registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, final Intent intent) {
                e.post(new Runnable() {
                    public final void run() {
                        intent.setExtrasClassLoader(FileSystem.class.getClassLoader());
                        a.this.ak(intent.getExtras());
                    }
                }, "Refresh VFS");
            }
        }, new IntentFilter("com.tencent.mm.REFRESH_VFS"), "com.tencent.mm.permission.MM_MESSAGE", null);
    }

    private void abP(String str) {
        Exception e;
        Throwable th;
        FileInputStream fileInputStream = null;
        int i = 0;
        try {
            Bundle bundle;
            long length = new File(str).length();
            if (length > 1048576) {
                x.e("MicroMsg.FileSystemManager", "Invalid parcel file size: " + length);
                bundle = null;
            } else if (length > 0) {
                byte[] bArr = new byte[((int) length)];
                FileInputStream fileInputStream2 = new FileInputStream(str);
                while (((long) i) < length) {
                    try {
                        i += fileInputStream2.read(bArr, i, bArr.length - i);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            x.e("MicroMsg.FileSystemManager", "Cannot load file systems from parcel: " + e.getMessage());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (IOException e3) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e42) {
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, i);
                obtain.setDataPosition(0);
                bundle = obtain.readBundle(FileSystem.class.getClassLoader());
                obtain.recycle();
            } else {
                bundle = null;
            }
            ak(bundle);
        } catch (Exception e5) {
            e = e5;
        }
    }

    private void ak(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getInt("pid") == Process.myPid()) {
            synchronized (this.mLock) {
                if (this.uSa != null) {
                    return;
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("fs");
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            bundle2.setClassLoader(bundle.getClassLoader());
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.getParcelable(str));
            }
        }
        bundle2 = bundle.getBundle("mp");
        TreeMap treeMap = new TreeMap();
        if (bundle2 != null) {
            bundle2.setClassLoader(bundle.getClassLoader());
            for (String str2 : bundle2.keySet()) {
                treeMap.put(str2, bundle2.getString(str2));
            }
        }
        FileSystem fileSystem = (FileSystem) bundle.getParcelable("root");
        if (fileSystem == null) {
            fileSystem = uRX;
        }
        ArrayList a = a(hashMap, treeMap);
        synchronized (this.mLock) {
            this.uRY = hashMap;
            this.uRZ = a;
            this.uSa = fileSystem;
            this.uSb++;
            this.uSc = new c(null, null, this.uSb, (byte) 0);
        }
    }

    private static ArrayList<b> a(HashMap<String, FileSystem> hashMap, TreeMap<String, String> treeMap) {
        ArrayList<b> arrayList = new ArrayList(treeMap.size());
        String str = null;
        Iterator it = treeMap.entrySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return arrayList;
            }
            Entry entry = (Entry) it.next();
            str = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            FileSystem fileSystem = (FileSystem) hashMap.get(str3);
            if (fileSystem == null) {
                throw new IllegalArgumentException("FileSystem '" + str3 + "' for mount point '" + str + "' not exist.");
            }
            boolean z = str2 != null && str.startsWith(str2);
            arrayList.add(new b(str, str3, fileSystem, z));
        }
    }
}
