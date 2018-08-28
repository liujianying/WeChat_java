package com.google.android.gms.common.server.response;

import com.google.android.gms.c.s;
import com.google.android.gms.c.x;
import com.google.android.gms.c.y;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {
    private Object a(Field field) {
        String py = field.py();
        if (field.pA() != null) {
            field.py();
            w.a(ps() == null, "Concrete field shouldn't be value object: %s", field.py());
            field.px();
            try {
                return getClass().getMethod("get" + Character.toUpperCase(py.charAt(0)) + py.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        field.py();
        return ps();
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return Field.b(field) != null ? field.aPe.convertBack(obj) : obj;
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.pu() == 11) {
            stringBuilder.append(((FastJsonResponse) field.pA().cast(obj)).toString());
        } else if (field.pu() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(x.bs((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map<String, Field<?, ?>> pr();

    protected abstract Object ps();

    protected abstract boolean pt();

    public String toString() {
        Map pr = pr();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : pr.keySet()) {
            Field field = (Field) pr.get(str);
            if (field.pw() != 11) {
                field.py();
                if (pt()) {
                    Object a = a(field, a(field));
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("{");
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\":");
                    if (a != null) {
                        switch (field.pw()) {
                            case 8:
                                stringBuilder.append("\"").append(s.k((byte[]) a)).append("\"");
                                break;
                            case 9:
                                stringBuilder.append("\"").append(s.l((byte[]) a)).append("\"");
                                break;
                            case 10:
                                y.a(stringBuilder, (HashMap) a);
                                break;
                            default:
                                if (!field.pv()) {
                                    a(stringBuilder, field, a);
                                    break;
                                }
                                a(stringBuilder, field, (ArrayList) a);
                                break;
                        }
                    }
                    stringBuilder.append("null");
                }
            } else if (field.px()) {
                field.py();
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            } else {
                field.py();
                throw new UnsupportedOperationException("Concrete types not supported");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
