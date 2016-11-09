package com.risk.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by mcs on 2016/11/9.
 */
public class ArrayUtil {
    public static ArrayList toList(Iterator iterator){
        ArrayList list=new ArrayList();
        while (iterator.hasNext()){
            Object o=iterator.next();
            list.add(o);
        }
        return list;
    }
}
