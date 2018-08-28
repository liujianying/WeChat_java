package com.tencent.map.lib.gl;

import com.tencent.map.lib.thread.AsyncTask;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class JNICallback$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ JNICallback c;

    JNICallback$1(JNICallback jNICallback, String str, byte[] bArr) {
        this.c = jNICallback;
        this.a = str;
        this.b = bArr;
    }

    /* renamed from: a */
    protected Void doInBackground(Void... voidArr) {
        Object obj;
        Throwable th;
        FileOutputStream fileOutputStream;
        File file = new File(this.a + ".tmp");
        FileOutputStream fileOutputStream2;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(this.b);
                try {
                    fileOutputStream2.close();
                    obj = 1;
                } catch (IOException e) {
                    int obj2 = 1;
                }
            } catch (FileNotFoundException e2) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        obj2 = null;
                    } catch (IOException e3) {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        file.renameTo(new File(this.a));
                    }
                    return null;
                }
                obj2 = null;
                if (obj2 != null) {
                    file.renameTo(new File(this.a));
                }
                return null;
            } catch (IOException e4) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        obj2 = null;
                    } catch (IOException e5) {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        file.renameTo(new File(this.a));
                    }
                    return null;
                }
                obj2 = null;
                if (obj2 != null) {
                    file.renameTo(new File(this.a));
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    obj2 = null;
                } catch (IOException e32) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    file.renameTo(new File(this.a));
                }
                return null;
            }
            obj2 = null;
            if (obj2 != null) {
                file.renameTo(new File(this.a));
            }
            return null;
        } catch (IOException e8) {
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    obj2 = null;
                } catch (IOException e52) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    file.renameTo(new File(this.a));
                }
                return null;
            }
            obj2 = null;
            if (obj2 != null) {
                file.renameTo(new File(this.a));
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e62) {
                }
            }
            throw th;
        }
        if (obj2 != null) {
            file.renameTo(new File(this.a));
        }
        return null;
    }
}
