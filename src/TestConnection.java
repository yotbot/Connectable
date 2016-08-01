/**
 * Created by Sietse on 1-8-2016.
 */
public class TestConnection
{

    public static void main(String[] args) throws Exception
    {
        ConnectLib cn = new ConnectLib();
        System.out.println(cn.connect());
        System.out.println(cn.send("Hello Connectable!"));
        System.out.println(cn.disconnect());

    }

}
