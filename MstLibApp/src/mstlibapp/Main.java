/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mstlibapp;

import mst.data.connection.*;
import static java.lang.System.out;
import java.util.Date;
import mst.data.manager.Manager;
import mst.data.querybuilding.QueryBuilder;
import mst.data.querybuilding.QueryTypes;

/**
 *
 * @author Mustafa SACLI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {

        /*
         DbConnection dbConn = new DbConnection(ConnectionType.MSSQL,
         "jdbc:sqlserver://10.0.0.145:1433;databaseName=InCareTest;", 
         ConnProp 
         //"jdbc:sqlserver://10.0.0.145:1433;databaseName=InCareTest;user=incareadmin;password=incareadmin;"
         );
         Object[] objArray = dbConn.executeScalarQuery("Select * From  t_UnitGroups;");
         for (Object obj : objArray) {
         System.out.println(obj);
         }*/

        //localhost ya da 127.0.0.1
        /*
         String[] strS = null;//new String[]{};
         for (String str : strS) {
         out.println(str);
         }
         out.println("******************************");
         strS=new String[]{"ali","veli","ibrahim"};
         for (String str : strS) {
         out.println(str);
         }*/


        Manager dbMan;
        /*
         Properties props = new Properties();
         props.setProperty("user", "root");
         props.setProperty("password", "");

         props.setProperty("user", "postgres");
         props.setProperty("password", "374phjg2346rgy84j67uwye387");
         * */
        dbMan = new Manager(ConnectionTypes.MySQL,
                "jdbc:mysql://localhost:3306/testDB" //"jdbc:postgresql://localhost:5432/template_postgis_20?protocol=3"
                , "root", "123123");
        // query1 için template_postgis_20 veritabanı yerine mydb yazılmalıdır.
       /* String query1 = "Select Count(*) From  IdentityTest;";
         String query2 = "Select * From spatial_ref_sys;";
         Object[] objArray;
         ResultSet rS = null;
         Date date1 = new Date();
         rS = dbCon.getResultSetOfQuery(query2);
         Date date2 = new Date();
         */ /*
         for (Object obj : objArray) {
         System.out.println(obj);
         }*/

        /*     out.println("***********************");
         out.println(date1.toString());
         out.println(date2.toString());
         out.println("***********************");
         out.println(date2.getTime() - date1.getTime());
         */
        Person p = new Person();
        p.setPersonId(1);
        p.setFirstName("Sevim");
        p.setLastName("Uçman");
        p.setSalary(3500.00d);
        Date d1 = new Date();
        int i = dbMan.Update(p);
        Date d2 = new Date();
        System.out.printf("Date 1: %s\n", d1.toString());
        System.out.printf("Date 2: %s\n", d2.toString());
        System.out.println("Sonuc: " + i);
        System.out.printf("Geçen Süre : %d\n", d2.getTime() - d1.getTime());
        QueryBuilder querybuilder;
        querybuilder = new QueryBuilder(p, QueryTypes.InsertAndGetId, ConnectionTypes.MySQL);
        out.println(querybuilder.getQuery());
        Parameter[] params = querybuilder.getParameters();
        if (params == null) {
            out.println("Parameters are null.");
        } else {
            for (Parameter prm : params) {
                out.printf("Index : %d; \nValue : %s;\n***\n", prm.getIndex(), prm.getValue());
            }
        }

    }
}
