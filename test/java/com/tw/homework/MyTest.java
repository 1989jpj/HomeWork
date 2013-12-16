package com.tw.homework;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 1989jpj
 * Date: 13-12-10
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class MyTest {

    MyGuava myguava = new MyGuava();

    @Test
    public void testOfGetOdds(){
        List<Integer> result = myguava.getOdds();
        boolean isAllOdd = true;
        for (int i = 0;i < result.size();i++){
            if (!myguava.isOdd(result.get(i)))
                isAllOdd = false;
        }
        Assert.assertEquals(true,isAllOdd);
    }

    @Test
    public void testOfDoubleEvens(){
        StringBuilder result = new StringBuilder();
        myguava.doubleOfEvents();
        for (int i = 0; i < myguava.list.size();i++){
            result.append(myguava.list.get(i));
        }
        Assert.assertEquals("1438512716920",result.toString());
    }

    @Test
    public void testOfContains(){
        Assert.assertEquals("Hello,4",myguava.contains(4));
        Assert.assertEquals("Hello,10",myguava.contains(10));
        Assert.assertEquals("Not found",myguava.contains(33));
    }
}
