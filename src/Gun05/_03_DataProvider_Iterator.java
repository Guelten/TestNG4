package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    @Test(dataProvider = "getData")
    void SearchTest(String searchText)
    {
        System.out.println("searchText = " + searchText);
    }

    @DataProvider
    public Iterator<Object> getData()
    {
        List<Object> data = new ArrayList<>();
        data.add("Mac");
        data.add("Samsung");
        data.add("Huawei");

        return data.iterator();
    }

    /****************************************************/


    @Test(dataProvider = "getData2")
    void LoginTest(String userName, String password)
    {
        System.out.println("userName = " + userName+", password = "+password);
    }

    public Iterator<Object[]> getData2(){

        List<Object[]> logins= new ArrayList<>();
        logins.add(new Object[]{"hakan","sdsdsd"});
        logins.add(new Object[]{"mehmet","sdsdds"});
        logins.add(new Object[]{"ali","sdasda"});

        return logins.iterator();

    }
}
