package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {


    @Test(dataProvider = "getData")  // benim data saglayicim getData fonksiyonudur.
    void SearchTest(String searchText)
    {
        System.out.println("searchText = " + searchText);
    }

    @DataProvider  // bu metoda dataprovider görevi verildi.
    public Object[] getData(){  // DataProvider olarak kullanilcak metodun tipi Object olmak zorunda.

        Object[] data = {"Mac","Samsung","Huawei","Iphone","pc","Xaomi"};

        return data;
    }

    /***************************************************************************/

    @Test(dataProvider = "aranacaklar")  // benim data saglayicim getData fonksiyonudur.
    void SearchTest2(String searchText)
    {
        System.out.println("searchText = " + searchText);
    }

    @DataProvider(name = "aranacaklar")  // bu metoda dataprovider görevi verildi.
    public Object[] getData2(){  // DataProvider olarak kullanilcak metodun tipi Object olmak zorunda.

        Object[] data = {"Mac","Samsung","Huawei","Iphone","pc","Xaomi"};

        return data;
    }
}
