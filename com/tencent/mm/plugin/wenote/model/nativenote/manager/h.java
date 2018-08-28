package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class h {
    private static volatile h qqx = null;
    private p qqy = null;

    private h() {
    }

    public static h bZX() {
        if (qqx == null) {
            synchronized (h.class) {
                if (qqx == null) {
                    qqx = new h();
                }
            }
        }
        return qqx;
    }

    public final p bZY() {
        if (this.qqy != null) {
            return this.qqy;
        }
        au.HU();
        String str = (String) c.DT().get(a.sXk, "");
        x.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", new Object[]{str});
        if (bi.oW(str)) {
            return null;
        }
        byte[] WP = bi.WP(str);
        if (WP.length <= 0) {
            return null;
        }
        this.qqy = bf(WP);
        String str2 = "WNNoteKeepTopManager";
        String str3 = "getCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.qqy != null ? this.qqy.bZi() : "null";
        x.d(str2, str3, objArr);
        return this.qqy;
    }

    public final void a(p pVar) {
        this.qqy = pVar;
        byte[] b = b(this.qqy);
        String str = "";
        if (b != null && b.length > 0) {
            str = bi.bE(b);
        }
        String str2 = "WNNoteKeepTopManager";
        String str3 = "setCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.qqy != null ? this.qqy.bZi() : "null";
        x.i(str2, str3, objArr);
        x.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", new Object[]{str});
        au.HU();
        c.DT().a(a.sXk, bi.oV(str));
    }

    private static p bf(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Exception e;
        Throwable th;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
                try {
                    x.e("WNNoteKeepTopManager", "toObject exception:%s", new Object[]{e});
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e3) {
                            x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e3});
                            return null;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e4) {
                            x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e4});
                            throw th;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e42) {
                        x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e42});
                        throw th;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
            try {
                p pVar = (p) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pVar;
                } catch (Exception e422) {
                    x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e422});
                    return pVar;
                }
            } catch (Exception e5) {
                e3 = e5;
                x.e("WNNoteKeepTopManager", "toObject exception:%s", new Object[]{e3});
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e32) {
                        x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e32});
                        return null;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e32 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            x.e("WNNoteKeepTopManager", "toObject exception:%s", new Object[]{e32});
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception e322) {
                    x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e322});
                    return null;
                }
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception e4222) {
                    x.e("WNNoteKeepTopManager", "toObject close exception:%s", new Object[]{e4222});
                    throw th;
                }
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    private static byte[] b(p pVar) {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        if (pVar != null) {
            ByteArrayOutputStream byteArrayOutputStream;
            ObjectOutputStream objectOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(pVar);
                        objectOutputStream.flush();
                        bArr = byteArrayOutputStream.toByteArray();
                        try {
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e2});
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    objectOutputStream = bArr;
                    try {
                        x.e("WNNoteKeepTopManager", "toByteArray exception:%s", new Object[]{e2});
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e22) {
                                x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e22});
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e5) {
                                x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e5});
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream = bArr;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e52) {
                            x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e52});
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e22 = e6;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                x.e("WNNoteKeepTopManager", "toByteArray exception:%s", new Object[]{e22});
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e222) {
                        x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e222});
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e522) {
                        x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", new Object[]{e522});
                        throw th;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return bArr;
    }
}
