package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class c {
    Context _context;
    TreeMap<Long, WloginAllSigInfo> vHY = new TreeMap();

    public c(Context context) {
        this._context = context;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int i;
        WloginAllSigInfo wloginAllSigInfo;
        Object obj;
        WloginAllSigInfo wloginAllSigInfo2 = (WloginAllSigInfo) this.vHY.get(new Long(j));
        if (wloginAllSigInfo2 == null) {
            wloginAllSigInfo = new WloginAllSigInfo();
        } else {
            wloginAllSigInfo = wloginAllSigInfo2;
        }
        Object obj2 = new byte[0];
        WloginSigInfo wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
        if (wloginSigInfo == null || wloginSigInfo._en_A1 == null) {
            obj = obj2;
        } else {
            obj = (byte[]) wloginSigInfo._en_A1.clone();
        }
        wloginAllSigInfo._useInfo = new WloginSimpleInfo(j, bArr, bArr2, bArr3, bArr4);
        int put_siginfo = wloginAllSigInfo.put_siginfo(j2, j3, j4, j5, j6, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        util.adN("before put_siginfo, ret=" + put_siginfo);
        if (this._context != null) {
            TreeMap bT = bT(this._context, "tk_file");
            if (bT == null) {
                bT = new TreeMap();
            }
            util.adN("after loadTKTreeMap");
            bT.put(new Long(j), wloginAllSigInfo.get_clone());
            put_siginfo = a(bT, "tk_file");
            util.adN("after refreshTKTreeMap, ret=" + put_siginfo);
        }
        i = put_siginfo;
        if (i != 0) {
            wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
            if (wloginSigInfo != null) {
                wloginSigInfo._en_A1 = (byte[]) obj.clone();
            }
        }
        this.vHY.put(new Long(j), wloginAllSigInfo);
        return i;
    }

    private synchronized WloginAllSigInfo hi(long j) {
        WloginAllSigInfo wloginAllSigInfo;
        util.gz("get_all_siginfo", "uin=" + j);
        wloginAllSigInfo = (WloginAllSigInfo) this.vHY.get(new Long(j));
        if (wloginAllSigInfo == null) {
            if (this._context == null) {
                wloginAllSigInfo = null;
            } else {
                TreeMap bT = bT(this._context, "tk_file");
                if (bT == null) {
                    wloginAllSigInfo = null;
                } else {
                    wloginAllSigInfo = (WloginAllSigInfo) bT.get(new Long(j));
                    if (wloginAllSigInfo == null) {
                        util.gz("get_all_siginfo", "null");
                        wloginAllSigInfo = null;
                    } else {
                        this.vHY.put(new Long(j), wloginAllSigInfo);
                        wloginAllSigInfo = wloginAllSigInfo.get_clone();
                    }
                }
            }
        }
        return wloginAllSigInfo;
    }

    public final synchronized WloginSigInfo hj(long j) {
        WloginSigInfo wloginSigInfo;
        util.gz("get_siginfo", "uin=" + j + "appid=522017402");
        WloginAllSigInfo hi = hi(j);
        if (hi == null) {
            wloginSigInfo = null;
        } else {
            wloginSigInfo = (WloginSigInfo) hi._tk_map.get(new Long(522017402));
            if (wloginSigInfo == null) {
                wloginSigInfo = null;
            }
        }
        return wloginSigInfo;
    }

    public final synchronized void i(Long l) {
        this.vHY.remove(l);
        if (this._context != null) {
            TreeMap bT = bT(this._context, "tk_file");
            if (bT != null) {
                bT.remove(l);
                a(bT, "tk_file");
            }
        }
    }

    private synchronized int a(TreeMap treeMap, String str) {
        int i;
        i = 0;
        if (str == "tk_file") {
            i = b(treeMap, str);
        }
        return i;
    }

    private synchronized int b(TreeMap treeMap, String str) {
        int a;
        try {
            Key secretKeySpec = new SecretKeySpec(i.vIA, "DESede");
            Cipher instance = Cipher.getInstance("DESede");
            instance.init(1, secretKeySpec);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new CipherOutputStream(byteArrayOutputStream, instance));
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.close();
            a = a(this._context, str, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            util.gA("exception", stringWriter.toString());
            a = -1022;
        }
        return a;
    }

    private static TreeMap bT(Context context, String str) {
        Exception exception;
        TreeMap treeMap;
        TreeMap treeMap2;
        byte[] bU = bU(context, str);
        if (bU == null) {
            return null;
        }
        Key secretKeySpec;
        Cipher instance;
        ObjectInputStream objectInputStream;
        TreeMap treeMap3;
        byte[] is;
        Key secretKeySpec2;
        Cipher instance2;
        try {
            secretKeySpec = new SecretKeySpec(i.vIA, "DESede");
            instance = Cipher.getInstance("DESede");
            instance.init(2, secretKeySpec);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance));
            treeMap3 = (TreeMap) objectInputStream.readObject();
            if (treeMap3 != null) {
                try {
                    objectInputStream.close();
                    return treeMap3;
                } catch (Exception e) {
                    exception = e;
                    treeMap = treeMap3;
                }
            } else {
                treeMap2 = treeMap3;
                try {
                    is = util.is(context);
                    if (is != null && is.length > 0) {
                        secretKeySpec2 = new SecretKeySpec(is, "DESede");
                        instance2 = Cipher.getInstance("DESede");
                        instance2.init(2, secretKeySpec2);
                        objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance2));
                        treeMap3 = (TreeMap) objectInputStream.readObject();
                        if (treeMap3 != null) {
                            try {
                                objectInputStream.close();
                                return treeMap3;
                            } catch (Exception e2) {
                            }
                        }
                        treeMap2 = treeMap3;
                    }
                } catch (Exception e3) {
                    treeMap3 = treeMap2;
                }
                try {
                    is = util.ir(context);
                    if (is != null && is.length > 0) {
                        secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.ce(is), "DESede");
                        instance2 = Cipher.getInstance("DESede");
                        instance2.init(2, secretKeySpec2);
                        objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance2));
                        treeMap3 = (TreeMap) objectInputStream.readObject();
                        if (treeMap3 != null) {
                            try {
                                objectInputStream.close();
                                return treeMap3;
                            } catch (Exception e4) {
                            }
                        }
                        treeMap2 = treeMap3;
                    }
                } catch (Exception e5) {
                    treeMap3 = treeMap2;
                }
                try {
                    is = util.iq(context);
                    if (is != null && is.length > 0) {
                        secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.ce(is), "DESede");
                        instance2 = Cipher.getInstance("DESede");
                        instance2.init(2, secretKeySpec2);
                        objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance2));
                        treeMap3 = (TreeMap) objectInputStream.readObject();
                        if (treeMap3 != null) {
                            try {
                                objectInputStream.close();
                                return treeMap3;
                            } catch (Exception e6) {
                            }
                        }
                        treeMap2 = treeMap3;
                    }
                } catch (Exception e7) {
                    treeMap3 = treeMap2;
                }
                try {
                    secretKeySpec = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance));
                    treeMap3 = (TreeMap) objectInputStream.readObject();
                    if (treeMap3 != null) {
                        return treeMap3;
                    }
                    try {
                        objectInputStream.close();
                        return treeMap3;
                    } catch (Exception e8) {
                        return treeMap3;
                    }
                } catch (Exception e9) {
                    return treeMap2;
                }
            }
        } catch (Exception e10) {
            exception = e10;
            treeMap = null;
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            exception.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            util.gA("exception", stringWriter.toString());
            treeMap2 = treeMap;
            is = util.is(context);
            secretKeySpec2 = new SecretKeySpec(is, "DESede");
            instance2 = Cipher.getInstance("DESede");
            instance2.init(2, secretKeySpec2);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance2));
            treeMap3 = (TreeMap) objectInputStream.readObject();
            if (treeMap3 != null) {
                try {
                    objectInputStream.close();
                    return treeMap3;
                } catch (Exception e22) {
                }
            }
            treeMap2 = treeMap3;
            is = util.ir(context);
            secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.ce(is), "DESede");
            instance2 = Cipher.getInstance("DESede");
            instance2.init(2, secretKeySpec2);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance2));
            treeMap3 = (TreeMap) objectInputStream.readObject();
            if (treeMap3 != null) {
                try {
                    objectInputStream.close();
                    return treeMap3;
                } catch (Exception e42) {
                }
            }
            treeMap2 = treeMap3;
            is = util.iq(context);
            secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.ce(is), "DESede");
            instance2 = Cipher.getInstance("DESede");
            instance2.init(2, secretKeySpec2);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance2));
            treeMap3 = (TreeMap) objectInputStream.readObject();
            if (treeMap3 != null) {
                try {
                    objectInputStream.close();
                    return treeMap3;
                } catch (Exception e62) {
                }
            }
            treeMap2 = treeMap3;
            secretKeySpec = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
            instance = Cipher.getInstance("DESede");
            instance.init(2, secretKeySpec);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bU), instance));
            treeMap3 = (TreeMap) objectInputStream.readObject();
            if (treeMap3 != null) {
                return treeMap3;
            }
            try {
                objectInputStream.close();
                return treeMap3;
            } catch (Exception e82) {
                return treeMap3;
            }
        }
    }

    private static int a(Context context, String str, byte[] bArr) {
        Exception e;
        a aVar = null;
        try {
            a aVar2 = new a(context, str);
            try {
                SQLiteDatabase writableDatabase = aVar2.getWritableDatabase();
                try {
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                    try {
                        String str2 = str;
                        Cursor query = writableDatabase.query(str2, new String[]{"ID"}, "ID=0", null, null, null, null);
                        if (query.getCount() == 0) {
                            try {
                                writableDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new Object[]{Integer.valueOf(0), new byte[1]});
                            } catch (Exception e2) {
                                util.l(e2);
                                query.close();
                                aVar2.close();
                                return -1022;
                            }
                        }
                        try {
                            writableDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new Object[]{bArr});
                            query.close();
                            aVar2.close();
                            return 0;
                        } catch (Exception e22) {
                            util.l(e22);
                            query.close();
                            aVar2.close();
                            return -1022;
                        }
                    } catch (Exception e222) {
                        util.l(e222);
                        aVar2.close();
                        return -1022;
                    }
                } catch (Exception e2222) {
                    util.l(e2222);
                    aVar2.close();
                    return -1022;
                }
            } catch (Exception e3) {
                e2222 = e3;
                aVar = aVar2;
            }
        } catch (Exception e4) {
            e2222 = e4;
            util.l(e2222);
            if (aVar != null) {
                aVar.close();
            }
            return -1022;
        }
    }

    private static byte[] bU(Context context, String str) {
        Exception e;
        a aVar;
        Boolean valueOf = Boolean.valueOf(false);
        try {
            a aVar2 = new a(context, str);
            try {
                SQLiteDatabase readableDatabase = aVar2.getReadableDatabase();
                Cursor query;
                try {
                    Cursor rawQuery = readableDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str + "' ", null);
                    try {
                        if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                            valueOf = Boolean.valueOf(true);
                        }
                        if (!(rawQuery == null || rawQuery.isClosed())) {
                            rawQuery.close();
                        }
                        if (valueOf.booleanValue()) {
                            String str2 = str;
                            query = readableDatabase.query(str2, new String[]{str}, "ID=0", null, null, null, null);
                            if (query.getCount() == 0) {
                                query.close();
                                aVar2.close();
                                return null;
                            }
                            query.moveToFirst();
                            byte[] blob = query.getBlob(0);
                            query.close();
                            aVar2.close();
                            return blob;
                        }
                        aVar2.close();
                        return null;
                    } catch (SQLException e2) {
                        e = e2;
                        query = rawQuery;
                        util.l(e);
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        aVar2.close();
                        return null;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    query = null;
                }
            } catch (Exception e4) {
                e = e4;
                aVar = aVar2;
            }
        } catch (Exception e5) {
            e = e5;
            aVar = null;
            util.l(e);
            if (aVar != null) {
                aVar.close();
            }
            return null;
        }
    }
}
